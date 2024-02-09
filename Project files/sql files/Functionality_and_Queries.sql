-- Q 2 B
CREATE OR REPLACE FUNCTION createCustOrder
	RETURN cust_order.order_id%type
	IS
		newOrderId cust_order.order_id%type;
		BEGIN
			newOrderId := orderId_seq.NEXTVAL;
		RETURN newOrderId;
END;
/

SELECT createCustOrder FROM dual;

--Q 2 C
CREATE OR REPLACE PROCEDURE createOrderLineItem(custOrderId IN cust_order.order_id%type, itemId IN store_items.item_id%type, customerId IN customer.cust_id%type, dateOrdered IN cust_order.date_of_order%type, noOrdered IN order_line_items.quantity%type, shippedDate IN cust_order.shipped_date%type)
AS
	noOfCopies store_items.number_of_copies%type;
	invalidQuantityException EXCEPTION;
	custType customer.cust_type%type;
	shippingFee cust_order.shipping_fee%type;

BEGIN
	noOfCopies:=0;
	SELECT number_of_copies INTO noOfCopies FROM store_items WHERE item_id = itemId;
	IF noOrdered>noOfCopies THEN
		RAISE invalidQuantityException;
	END IF;
	SELECT cust_type INTO custType FROM customer WHERE cust_id = customerId;
	IF custType = 'gold' THEN
		UPDATE cust_order SET shipping_fee=0 WHERE order_Id = custOrderId;
	ElSIF custType = 'regular' THEN
		UPDATE cust_order SET shipping_fee=10 WHERE order_Id = custOrderId;
	END IF;
	INSERT INTO order_line_items(line_id, item_id, order_id, quantity) VALUES (lineId_seq.NEXTVAL, itemId, custOrderId, noOrdered);
	noOfCopies := noOfCopies - noOrdered;
	UPDATE store_items SET number_of_copies=noOfCopies WHERE item_id=itemId;

	EXCEPTION
		WHEN invalidQuantityException THEN
		     dbms_output.put_line('Invalid quantity'); 
END;
/

exec createOrderLineItem(4999, 22, 1008, date '2020-10-11', 2, date '2020-10-12');

-- Q2 D
select * from cust_order WHERE cust_id = 1008;

CREATE OR REPLACE TRIGGER custType_after_update
    AFTER UPDATE
    ON customer
    FOR EACH ROW
    WHEN (NEW.cust_type='gold' AND OLD.cust_type!='gold')
    BEGIN
        UPDATE cust_order SET shipping_fee=0 WHERE cust_id=:new.cust_id;
	END;
/

UPDATE customer SET cust_type='gold' WHERE cust_id=1008;

select * from cust_order WHERE cust_id = 1008;

-- Q2 E
select * from cust_order where order_id = 4997;

CREATE OR REPLACE PROCEDURE setShippingDate(orderId IN cust_order.order_id%type, shippedDate IN cust_order.shipped_date%type)
IS
	BEGIN
		UPDATE cust_order SET shipped_date = shippedDate WHERE order_id = orderId;
	END;
/

exec setShippingDate(4997, date '2022-12-07');

-- Q2 F
CREATE OR REPLACE FUNCTION computeTotal(orderId IN cust_order.order_id%type)
	RETURN number
AS
	pragma autonomous_transaction;
	total payment_details.total%type;
	grandTotal payment_details.grand_total%type;
	tax payment_details.tax%type;
	itemPrice store_items.price%type;
	shippingFee cust_order.shipping_fee%type;
	custId cust_order.cust_id%type;
	custType customer.cust_type%type;
	discount payment_details.discount%type;
	CURSOR c_orderLineItems IS
	SELECT item_id, quantity FROM order_line_items WHERE order_id=orderId;
	BEGIN
		grandTotal:=0;
		total:=0;
			FOR c_orderLineItem in c_orderLineitems 
		LOOP
			SELECT price INTO itemPrice FROM store_items WHERE   item_id=c_orderLineItem.item_id;
			total := total+(itemPrice*c_orderLineItem.quantity);
		END LOOP;
		tax:= 0.05*total;
		SELECT cust_id INTO custId FROM cust_order WHERE order_id=orderId;
		SELECT cust_type INTO custType FROM customer WHERE cust_id=custId;
		discount:=0;
		IF custType='gold' THEN
			IF total>100 THEN
				discount:=0.1*total;
			END IF;
		END IF;
		SELECT shipping_fee INTO shippingFee FROM cust_order 
		WHERE order_id=orderId;
		grandTotal := total + shippingFee+tax-discount;
		INSERT INTO payment_details VALUES (payment_id_sequence.NEXTVAL, tax, discount, total, grandTotal, shippingFee, orderId);
		commit;
	RETURN grandTotal;
END;
/

SELECT computeTotal(4998) FROM dual;

-- -- Q2 H
-- extra credit
-- CREATE OR REPLACE PROCEDURE showItemOrdersAfter(customerId IN 
-- customer.cust_id%type, inputDate date)
-- AS

-- BEGIN

