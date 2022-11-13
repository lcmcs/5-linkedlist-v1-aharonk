package edu.touro.cs.mcon364;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MyLinkedListTest {
    static MyLinkedList mll = new MyLinkedList();

    @Test
    @Order(0)
    void add() {
        assertTrue(mll.add("a"));
    }

    @Test
    @Order(1)
    void size() {
        assertEquals(1, mll.size());
        mll.add("b");
        assertEquals(2, mll.size());
    }

    @Test
    @Order(2)
    void get() {
        assertEquals("a", mll.get(0));
        assertEquals("b", mll.get(1));
    }

    @Test
    @Order(2)
    void getFail() {
        assertThrows(IndexOutOfBoundsException.class, () -> mll.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> mll.get(2));
        assertThrows(IndexOutOfBoundsException.class, () -> mll.get(5));
    }

    @Test
    @Order(3)
    void set() {
        assertEquals("a", mll.set(0, "z"));
        assertEquals("z", mll.get(0));
        assertEquals("b", mll.set(1, "y"));
        assertEquals("y", mll.get(1));
    }

    @Test
    @Order(3)
    void setFail() {
        assertThrows(IndexOutOfBoundsException.class, () -> mll.set(-1, "q"));
        assertThrows(IndexOutOfBoundsException.class, () -> mll.set(2, "x"));
        assertThrows(IndexOutOfBoundsException.class, () -> mll.set(5, "j"));
    }

    @Test
    @Order(4)
    void remove() {
        assertFalse(mll.remove("a"));

        mll.add("x");
        mll.add("w");

        assertTrue(mll.remove("y"));
        assertEquals(3, mll.size());
        assertEquals("x", mll.get(1));

        assertTrue(mll.remove("w"));
        assertEquals(2, mll.size());

        assertTrue(mll.remove("z"));
        assertEquals(1, mll.size());
        assertEquals("x", mll.get(0));
    }

    @Test
    @Order(5)
    void clear() {
        mll.clear();
        assertEquals(0, mll.size());
        assertThrows(IndexOutOfBoundsException.class, () -> mll.get(0));
    }
}
