package hu.gov.allamkincstar.webshop.test;

import hu.gov.allamkincstar.webshop.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class TestWarehouse {

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

        assertEquals(6, warehouse.getProductList().size());

        exception = assertThrows(RuntimeException.class, () -> warehouse.addWarehouse(new Product("05", "RADIR01", "Gumi radír", "yy Kft.", 5)));
        assertEquals("Már létezik termék a megadott cikkszámmal.", exception.getMessage());

    }

}

