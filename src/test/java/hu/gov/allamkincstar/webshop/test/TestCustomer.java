package hu.gov.allamkincstar.webshop.test;

import hu.gov.allamkincstar.webshop.Customer;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestCustomer {
    Exception exception;

    @Test
    public void test1() {

        exception = assertThrows(RuntimeException.class, () -> new Customer("", "Teszt3 Vevő", "Teszt3 lakcím", "76/382-133", "teszt3vevo@gmail.com"));
        assertEquals("A vásárló egyedi azonosítója üres!", exception.getMessage());

    }
}