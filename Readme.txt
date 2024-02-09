COEN 280 - Project MasterRobot - Sales management System


Entity Relationship model:


The process of translating the ER model to a relational model is shown by designing a new diagram document named ‘Final entity design implementation.pdf’ which shows all the attributes in an entity with the constraints on each attribute. 


Object-Oriented approach was used to create relations of sub-classes.


Functional Dependencies-
1. Store_items relation:
   1. Item_id -> price, no_of_copies
2. Comic_books relation:
   1. Item_id -> title, published_date
3. Comic_movies relation:
   1. Item_id -> title, studio_name, description
4. Customer relation:
   1. Cust_id -> cust_type, name, phone, address, date_joined
5. Gold_customer relation:
   1. Cust_id -> date_joined, coupons
6. Cust_order relation:
   1. Order_id -> cust_id, date_of_order, shipped_date, shipping_fee, no_of_orderLineItems
7. Order_line_items relation:
   1. Line_id, order_id -> item_id, quantity
8. Payment_details relation:
   1. Payment_id -> order_id, tax, discount, total, grand_total, shipping_fee


Constraints implemented:


1. The custType of a customer can be of only one of the two values, namely, ‘regular’, or ’gold’.
2. Phone (or email) must be unique and not null.
3. The no.of copies of a comicBook or a cartoon movie cannot be < 0.
4. The no. of copies of any book (or movie) ordered cannot be more than the available no. of copies of that item.
5. The shippedDate cannot be less than the OrderedDate.
6. When a regular customer orders books (and/or movies) , the shipping fee is $10. Before the items are shipped (ie. the shippedDate is null), if the custType of that customer changes to ‘gold’, then the shipping fee must be changed to 0 on all her/his orders that are not shipped yet.


Assumptions about the implemented design:


1. If attributes are imported from superclass to subclass then these attributes are not mentioned in the subclass ER diagram but have been included during the creation of subclass tables.
2. Attributes from weak entities are not mentioned in the ER diagram but are included during the creation of the table. 
3. Address is stored as a single string. This is why it is not normalized further. 
4. Sign up is not implemented on the frontend. The project assumes that the customer has already signed up. 
5. The cartoon movie has the same title as the comic book it is based on. 
6. Comic books do not have any description and studio name but comic movies do. 
7. Comic movies do not have any published date.
8. Customers can see the grand total of the selected items and place orders but the payment gateway has not been implemented.


Working of the project:


1. The customer requires User Id to login. 
2. The customer selects the items and the quantity that are available from the store.
3. Items are added to the cart.
4. Customer goes to the cart and places an order.