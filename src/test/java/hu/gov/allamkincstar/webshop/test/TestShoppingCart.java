package hu.gov.allamkincstar.webshop.test;

import hu.gov.allamkincstar.webshop.*;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestShoppingCart {

    Exception exception;
    Warehouse warehouse = new Warehouse(new ArrayList<>());

    @Test
    public void test1() {

        warehouse.addWarehouse(new Product("01","TABLET01", "HP TABLET x", "HP", 100));
        warehouse.addWarehouse(new Product("02","TABLET01", "HP TABLET x", "HP", 100));
        warehouse.addWarehouse(new Product("03","PHONE01", "SAMSUNG PHONE A7", "SAMSUNG", 80));
        warehouse.addWarehouse(new Product("04","TABLET02", "HP TABLET y", "HP", 150));
        warehouse.addWarehouse(new Product("05","PHONE02", "SAMSUNG PHONE A71 y", "SAMSUNG", 90));

        ShoppingCart shoppingCart = new ShoppingCart(new ArrayList<>());
        shoppingCart.addShoppingCart("PHONE01", warehouse);
        shoppingCart.addShoppingCart("PHONE02", warehouse);

        assertEquals(2, shoppingCart.getProductList().size());
        exception = assertThrows(RuntimeException.class, ()-> shoppingCart.addShoppingCart("PHONE01", warehouse));
        assertEquals("A megadott cikkszámú termék elfogyott!", exception.getMessage());

        shoppingCart.removeShoppingCart("PHONE01");
        assertEquals(1, shoppingCart.getProductList().size());


    }

}
