package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SinglLinkedListTest {
    private SinglLinkedList list;

    @BeforeEach
    public void setUp() {
        list = new SinglLinkedList();
    }

    @Test
    public void testAdd() {
        list.add(10);
        list.add(20);
        list.add(30);

        assertTrue(list.search(10));
        assertTrue(list.search(20));
        assertTrue(list.search(30));
        assertFalse(list.search(40));
    }

    @Test
    public void testRemoveExistingElement() {
        list.add(10);
        list.add(20);
        list.add(30);

        list.remove(20);

        assertFalse(list.search(20));
        assertTrue(list.search(10));
        assertTrue(list.search(30));
    }

    @Test
    public void testRemoveNonExistingElement() {
        list.add(10);
        list.add(30);

        list.remove(20);

        assertTrue(list.search(10));
        assertTrue(list.search(30));
    }

    @Test
    public void testRemoveFromEmptyList(){
        assertDoesNotThrow(() -> list.remove(10));
    }

    @Test
    public void testSearchInEmptyList() {
        assertFalse(list.search(10));
    }

    @Test
    public void testLength() {
        assertEquals(0, list.length());

        list.add(10);
        list.add(20);
        list.add(30);

        assertEquals(3, list.length());

        list.remove(20);

        assertEquals(2, list.length());
    }

    @Test
    public void testLengthOfEmptyList() {
        assertEquals(0, list.length());
    }

    @Test
    public void testDisplayEmptyList() {
        assertDoesNotThrow(() -> list.display());
    }

    @Test
    public void testDisplayNonEmptyList() {
        list.add(10);
        list.add(20);
        list.add(30);

        assertDoesNotThrow(() -> list.display());
    }
}