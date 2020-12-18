package hu.gov.allamkincstar.webshop.test;

import hu.gov.allamkincstar.webshop.*;
import hu.gov.allamkincstar.webshop.Order;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestOrder {

    Exception exception;
    Warehouse warehouse = new Warehouse(new ArrayList<>());

    @Test
    public void test1() {

        warehouse.addWarehouse(new Product("01", "CERUZA01", "Grafit", "xx GMBH", 10));
        warehouse.addWarehouse(new Product("02", "TOLL01", "Kék toll", "xx GMBH", 20));
        warehouse.addWarehouse(new Product("03", "RADIR01", "Gumi radír", "yy Kft.", 5));
        warehouse.addWarehouse(new Product("04", "CERUZA01", "Grafit", "xx GMBH", 10));
        warehouse.addWarehouse(new Product("05", "CERUZA02", "piros ceruza", "xx GMBH", 10));
        warehouse.addWarehouse(new Product("06", "CERUZA03", "Zöld ceruza", "xx GMBH", 10));

        ShoppingCart shoppingCart = new ShoppingCart(new ArrayList<>());
        shoppingCart.addShoppingCart("CERUZA01", warehouse);
        shoppingCart.addShoppingCart("RADIR01", warehouse);
        Order order = new Order(
                new Customer("ID01", "Teszt1 Vevő", "Teszt1 lakcím", "76/382-113", "teszt1vevo@gmail.com"),
                shoppingCart, DeliveryType.IN_SHOP, PaymentType.CASH);
        assertEquals("Teszt1 Vevő", order.getCustomer().getName());
        assertEquals(2, order.getShoppingCart().getProductList().size());
        assertEquals(DeliveryType.IN_SHOP, order.getDeliveryType());
        assertEquals(PaymentType.CASH, order.getPaymentType());
        assertEquals(15, order.getSumPrice());
        assertEquals(ProductStatus.OUT_OF_STOCK, order.getShoppingCart().getProductList().get(0).getProductStatus());
        assertEquals(ProductStatus.OUT_OF_STOCK, order.getShoppingCart().getProductList().get(1).getProductStatus());


    }

    @Test
    public void test2() {

        warehouse.addWarehouse(new Product("01", "CERUZA01", "Grafit", "xx GMBH", 10));
        warehouse.addWarehouse(new Product("02", "TOLL01", "Kék toll", "xx GMBH", 20));
        warehouse.addWarehouse(new Product("03", "RADIR01", "Gumi radír", "yy Kft.", 5));
        warehouse.addWarehouse(new Product("04", "CERUZA01", "Grafit", "xx GMBH", 10));
        warehouse.addWarehouse(new Product("05", "CERUZA02", "piros ceruza", "xx GMBH", 10));
        warehouse.addWarehouse(new Product("06", "CERUZA03", "Zöld ceruza", "xx GMBH", 10));

        ShoppingCart shoppingCart = new ShoppingCart(new ArrayList<>());
        shoppingCart.addShoppingCart("CERUZA03", warehouse);
        shoppingCart.addShoppingCart("TOLL01", warehouse);
        Order order = new Order(
                new Customer("ID02", "Teszt2 Vevő", "Teszt2 lakcím", "76/382-130", "teszt2vevo@gmail.com"),
                shoppingCart, DeliveryType.DELIVERY, PaymentType.CASH
        );
        assertEquals(DeliveryType.DELIVERY, order.getDeliveryType());
        assertEquals(OrderStatus.BOOKED, order.getOrderStatus());
        assertEquals(ProductStatus.UNDER_ORDERS, order.getShoppingCart().getProductList().get(0).getProductStatus());
        assertEquals(ProductStatus.UNDER_ORDERS, order.getShoppingCart().getProductList().get(1).getProductStatus());

        exception = assertThrows(RuntimeException.class, () -> order.courierDelivered());
        assertEquals("Kiszállítás alatti termék adható át a megrendelőnek!", exception.getMessage());

        order.handOverToCourier();
        assertEquals(OrderStatus.IN_PROGRESS, order.getOrderStatus());

        order.courierDelivered();
        assertEquals(OrderStatus.DELIVERED, order.getOrderStatus());
        assertEquals(ProductStatus.OUT_OF_STOCK, order.getShoppingCart().getProductList().get(0).getProductStatus());
        assertEquals(ProductStatus.OUT_OF_STOCK, order.getShoppingCart().getProductList().get(1).getProductStatus());

    }

}

