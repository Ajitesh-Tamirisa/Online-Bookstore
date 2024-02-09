package com.example.masterRobot.controller;

import com.example.masterRobot.entity.*;
import com.example.masterRobot.repository.storeItemRepository;
import com.example.masterRobot.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameterValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

@Controller
public class appController {
    @Autowired
    storeItemRepository repo;
    @Autowired
    storeItemsService service;
    @Autowired
    ComicBooksService comicBooksService;
    @Autowired
    CartoonMoviesService cartoonMoviesService;
    @Autowired
    CartItemService  cartItemService;
    @Autowired
    CustOrderService custOrderService;
    @Autowired
    JdbcTemplate template;

    long loggedInCustomerId=0;

    CurrentCustomer currentCustomer=new CurrentCustomer();
//    @GetMapping("/")
//    public String display(){
//        store_items store_item = new store_items(11, 1000, 2);
//
//        repo.save(store_item);
//        System.out.println(repo.findAll());
//        System.out.println();
//        return repo.findAll().stream().findFirst().toString();
//    }


    class ItemDetails{
        public store_items storeItem;
        public ComicBooks comicBook;
        public CartoonMovies cartoonMovie;



        public ItemDetails(store_items storeItem, CartoonMovies cartoonMovie) {
            this.storeItem = storeItem;
            this.cartoonMovie = cartoonMovie;
            this.comicBook = new ComicBooks();
        }
        public ItemDetails(store_items storeItem, ComicBooks comicBook) {
            this.storeItem = storeItem;
            this.comicBook = comicBook;
            this.cartoonMovie = new CartoonMovies();
        }
    }
    @RequestMapping("/")
    public ModelAndView viewLoginPage(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("currentCustomer", currentCustomer);
        mav.setViewName("login");
        return mav;
    }
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("currentCustomer") CurrentCustomer currentCustomer){
        System.out.println("cust id"+currentCustomer.getCust_id());
        loggedInCustomerId = currentCustomer.getCust_id();
        this.currentCustomer.setCust_id(loggedInCustomerId);
        return "redirect:home";
    }
    @RequestMapping(value="/home", method = RequestMethod.GET)
    public ModelAndView viewHomePage() {
        if(loggedInCustomerId==0){
            ModelAndView mav = new ModelAndView();
            mav.setViewName("login");
            mav.addObject("currentCustomer", currentCustomer);
            return mav;
        }
        CartItem cartItem = new CartItem();
        List<store_items> listItems = service.list();
        List<ComicBooks> listBooks = comicBooksService.listBooks();
        List<CartoonMovies> listMovies = cartoonMoviesService.listMovies();
        int i=0,j=0,k=0;
        List<ItemDetails> itemDetailsList = new ArrayList<ItemDetails>();
        for(; i<listItems.size() && j<listBooks.size() && k<listMovies.size(); i++){
            for(ComicBooks book:listBooks){
                if(book.getItem_id()==listItems.get(i).getItem_id())
                    itemDetailsList.add(new ItemDetails(listItems.get(i), book));
            }
            for(CartoonMovies movie: listMovies){
                if(movie.getItemId()==listItems.get(i).getItem_id())
                    itemDetailsList.add(new ItemDetails(listItems.get(i), movie));
                System.out.println(movie.getStudioName());
            }

        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("cartItem", cartItem);
        modelAndView.addObject("itemDetailsList", itemDetailsList);
        modelAndView.addObject("currentCustomer", currentCustomer);
        System.out.println("loggedInCustomerId-"+loggedInCustomerId);
        System.out.println("itemdetailslist - "+itemDetailsList.get(0));


        return modelAndView;
    }
    @RequestMapping("/addToCart/{item_id}")
    public String checkout(@ModelAttribute("cartItem") CartItem cartItem, @PathVariable long item_id) {
        System.out.println(cartItem.getItem_id());
        cartItem.setItem_id(item_id);
        cartItem.setCust_id(loggedInCustomerId);
        System.out.println("loggedInCustomerId - "+loggedInCustomerId+" cartItem.getCust_id() - "+cartItem.getCust_id());
        store_items s = service.get(item_id);
        cartItem.setPrice(s.getPrice());
        long price = s.getPrice();
        cartItem.setTax(0.05*(price* cartItem.getQuantity()));
        cartItem.setTotal((price* cartItem.getQuantity())+ cartItem.getTax());
        cartItemService.saveCartItem(cartItem);
        return "redirect:/home";

    }
    @RequestMapping("/cart/{cust_id}")
    public ModelAndView displayCart(@PathVariable long cust_id) {
        if(loggedInCustomerId==0){
            ModelAndView mav = new ModelAndView();
            mav.setViewName("login");
            mav.addObject("currentCustomer", currentCustomer);
            return mav;
        }
        System.out.println(cust_id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cart");
        List<CartItem> cartItemList = cartItemService.listByCustId(cust_id);
        modelAndView.addObject("cartItemsList",cartItemList);
        String custType = service.findCustomerType(cust_id);long shippingFee=10;

        double totalWithTax = cartItemService.getTotalByCustId(cust_id);
        double totalTax=0;
        for(CartItem cartItem:cartItemList){
            totalTax += cartItem.getTax();
        }
        double discount=0;
        if(custType.equalsIgnoreCase("gold")){
            shippingFee = 0;
            if(totalWithTax-totalTax>100)
                discount=0.1*(totalWithTax-totalTax);
        }
        double total = totalWithTax-totalTax;
        double grandTotal = totalWithTax+shippingFee-discount;
        modelAndView.addObject("total", total);
        modelAndView.addObject("discount", discount);
        modelAndView.addObject("grandTotal", grandTotal);
        modelAndView.addObject("totalTax", totalTax);
        modelAndView.addObject("shippingFee", shippingFee);
        modelAndView.addObject("currentCustomer", currentCustomer);

        return modelAndView;
    }

    @RequestMapping("/checkout/{cust_id}")
    public String checkout(@PathVariable long cust_id){
        System.out.println("In checkout");
        //add to cust order and orderlineitems
        //add to payment details
        List<CartItem> cartItemsList = cartItemService.listByCustId(cust_id);
        //create custorder - createCustOrder
        long orderId = service.createCustomerOrder();
        String custType = service.findCustomerType(cust_id);
        System.out.println(orderId);
        Date dateOrdered = new java.util.Date();
        long shippingFee=10;
        if(custType.equalsIgnoreCase("gold")){
            shippingFee = 0;
        }
        CustOrder custOrder = new CustOrder(orderId, cust_id, dateOrdered, dateOrdered, shippingFee, cartItemsList.size());
        custOrderService.save(custOrder);
//        //create orderlineitems - createOrderLineItems(custOrderId, itemid, customerId, dateordered, noOrdered, shippedDate)
        for(CartItem cartItem : cartItemsList){
            System.out.println(cartItem.getQuantity());
            System.out.println(orderId+" ---- "+ cartItem.getItem_id()+" ---- "+ cust_id+" ---- "+ dateOrdered+" ---- "+ cartItem.getQuantity()+" ---- "+ dateOrdered);
            long noOfCopies = service.findNumberOfCopies(cartItem.getItem_id());
            //service.createOrderLineItem(orderId, cartItem.getCart_item_id(), cust_id, dateOrdered, cartItem.getQuantity(), dateOrdered, noOfCopies);
            long updatedNoOfCopies = noOfCopies-cartItem.getQuantity();
            System.out.println("updatedNoOfCopies-"+updatedNoOfCopies);
            service.insertOrderLineItem(orderId, cartItem.getItem_id(), cartItemsList.indexOf(cartItem), cartItem.getQuantity());
            service.updateNumberOfCopies(updatedNoOfCopies, cartItem.getItem_id());
            System.out.println("Payment details - ");
            System.out.println("Back to controller checkout");
        }

        service.computeTotal(orderId);
//        long x = 5003;
//        service.createOrderLineItem(x, 44, 1002, new Date(), 1, new Date());
//        service.setShippingDate(5000, dateOrdered);
        //compute total

        //double total = cartItemService.getTotalByCustId(cust_id);


        return "orderPlaced";
    }

        //RequestMappingappi
//    public ModelAndView viewHomePage(Model model) {
//        CustOrder custOrder = new CustOrder();
//        List<ComicBooks> listBooks = comicBooksService.listBooks();
//        System.out.println(listBooks);
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("index");
//        modelAndView.addObject("listBooks",listBooks);
//        return modelAndView;
//    }

}
