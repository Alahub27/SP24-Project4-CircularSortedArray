import org.example.CircularArraySortedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CircularArrayTest {
    private CircularArraySortedList list;

    @BeforeEach
    void setUp() {
        list = new CircularArraySortedList(5);
    }

    @Test
    void testAddAndToString() {
        list.add(3);
        list.add(1);
        list.add(5);
        assertEquals("Items should be sorted as 1 3 5", "1 3 5", list.toString());

        list.add(2);
        assertEquals("Items should be sorted as 1 2 3 5", "1 2 3 5", list.toString());
    }

    @Test
    void testRemoveFirst() {
        list.add(3);
        list.add(1);
        list.add(5);

        int removedItem = list.removeFirst();
        assertEquals("The first item should be 1", 1 , removedItem);
        assertEquals("After removing first, list should be 3 5", "3 5", list.toString());
    }

    @Test
    void testRemoveLast() {
        list.add(3);
        list.add(5);
        list.add(1);

        int removedItem = list.removeLast();
        assertEquals("Expected 5 but got: "+ removedItem, 5, removedItem);
        assertEquals("After removing last, list should be 1 3", "1 3",list.toString());
    }

    @Test
    void testRemoveFromEmptyList() {
        assertThrows(IllegalStateException.class, () -> list.removeFirst(), "Removing from an empty list should throw IllegalStateException");
        assertThrows(IllegalStateException.class, () -> list.removeLast(), "Removing from an empty list should throw IllegalStateException");
    }

    @Test
    void testCircularityWrapRight() {
        list.add(50);
        list.add(10);
        list.add(30);
        list.add(40);

        list.removeFirst();
        int rmFirst = list.removeFirst();
        assertEquals("Expected 30 but got: "+ rmFirst, 30, rmFirst);
        list.add(45);
        list.add(60);
        list.add(47);
        rmFirst = list.removeFirst();
        assertEquals("List is supposed to have being circulated. Expected 40 but got: "+ rmFirst, 40, rmFirst);
        assertEquals("The real array size is supposed to be 5", 5, list.array.length);

    }
    @Test
    void testCircularityWrapAndEdge() {
        list.add(2);
        list.add(3);
        list.add(5);
        list.add(10);

        list.removeFirst();
        int rmFirst = list.removeFirst();
        assertEquals("Expected 3 but got: "+ rmFirst, 3, rmFirst);
        list.add(15);
        list.add(13);
        list.add(1);
        rmFirst = list.removeFirst();
        int rmLast = list.removeLast();
        assertEquals("List is supposed to have being circulated. Expected 1 but got: "+ rmFirst, 1, rmFirst);
        assertEquals("List is supposed to have being circulated. Expected 1 but got: "+ rmLast, 15, rmLast);
        assertEquals("The real array size is supposed to be 5", 5, list.array.length);

    }
    @Test
    void testExistence() {
        list.add(5);
        list.add(3);
        list.add(2);
        list.add(10);

        list.removeFirst();
        boolean elementExist = list.exists(2);
        assertEquals("Element 2 was removed but seems to still exist, \nfunction might be checking underlying array ", false, elementExist);
        list.add(15);
        list.removeLast();
        list.add(13);
        list.add(6);
        elementExist = list.exists(15);
        assertEquals("Element 15 was expected NOT to exist but, \n", false, elementExist);
        elementExist = list.exists(6);
        assertEquals("Element 6 was expected to exist but, \n", true, elementExist);

    }
}

