package hu.gov.allamkincstar.webshop.test;

import hu.gov.allamkincstar.webshop.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestProduct {
    Exception exception;

    @Test
    public void test1() {

        exception = assertThrows(RuntimeException.class, () -> new Product("","TABLET01", "HP TABLET x", "HP", 100));
        assertEquals("A termék egyedi azonosítója üres!", exception.getMessage());

    }
}
