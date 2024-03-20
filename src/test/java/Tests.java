import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Tests {
    
    @Test
    public void testIsEmpty() {
        LinkedList ll = new LinkedList();
        assertTrue(ll.isEmpty());

        ll.addFirst(1);
        assertFalse(ll.isEmpty());
        ll.addFirst(2);
        assertFalse(ll.isEmpty());
        ll.addFirst(3);
        ll.removeFirst();
        assertFalse(ll.isEmpty());
        ll.removeFirst();
        assertFalse(ll.isEmpty());
        ll.removeFirst();
        assertTrue(ll.isEmpty());
    }

    @Test
    public void testLastIndexOf() {
        LinkedList ll = new LinkedList();
        assertEquals(-1, ll.lastIndexOf(1));
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);

        assertEquals(2, ll.lastIndexOf(3));
        assertEquals(1, ll.lastIndexOf(2));
        assertEquals(0, ll.lastIndexOf(1));

        // com apenas elementos duplicados
        ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(1);
        ll.addLast(1);

        assertEquals(2, ll.lastIndexOf(1));

        // ll com apenas um elemento duplicado
        ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(3);

        assertEquals(4, ll.lastIndexOf(3));
    }

    @Test
    public void testToString() {
        LinkedList list = new LinkedList();

        assertEquals("", list.toString());
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        
        assertEquals("1, 2, 3, 4, 5", list.toString());

        list.removeFirst();
        list.removeFirst();

        assertEquals("3, 4, 5", list.toString());

        list.addLast(10);
        list.addLast(11);

        assertEquals("3, 4, 5, 10, 11", list.toString());
    }

    @Test
    public void testListGet() {
        LinkedList list = new LinkedList();
        // Limite inferior ao permitido
        try {
            list.get(0);
            fail("Esta linha não pode ser executada");
        } catch (Exception e) {}

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));

        list.removeFirst();
        list.addLast(60);
        assertEquals(60, list.get(4));

        try {
            list.get(-1);
            fail("Esta linha não pode ser executada");
        } catch (Exception e) {}

        // Limite superior ao permitido
        try {
            list.get(5);
            fail("Esta linha não pode ser executada");
        } catch (Exception e) {}

    }

    @Test
    public void testListGetFirst() {
        LinkedList ll = new LinkedList();

        try {
            ll.getFirst();
            fail("Esta linha não pode ser executada");
        } catch (Exception e) {}

        ll.addLast(10);
        assertEquals(10, ll.getFirst());
        ll.addLast(20);
        assertEquals(10, ll.getFirst());

        ll.addFirst(30);
        assertEquals(30, ll.getFirst());
    }

    @Test
    public void testListGetLast() {
        LinkedList ll = new LinkedList();

        try {
            ll.getLast();
            fail("Esta linha não pode ser executada");
        } catch (Exception e) {}

        ll.addLast(10);
        assertEquals(10, ll.getLast());
        ll.addLast(20);
        assertEquals(20, ll.getLast());

        ll.addFirst(30);
        assertEquals(20, ll.getLast());
    }

    @Test
    public void testListIndexOf() {
        LinkedList ll = new LinkedList();
        assertEquals(-1, ll.indexOf(10));
        ll.addLast(10);
        assertEquals(0, ll.indexOf(10));
        ll.addLast(20);
        assertEquals(1, ll.indexOf(20));
        assertEquals(0, ll.indexOf(10));

        ll.addLast(10);
        ll.addLast(10);
        assertEquals(0, ll.indexOf(10));
    }

    @Test
    public void testListRemoveFirst() {
        LinkedList ll = new LinkedList();
        try {
            ll.removeFirst();
            fail("Esta linha não pode ser executada.");
        } catch (Exception e) {}

        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);

        assertEquals(1, ll.getFirst());
        assertEquals(1, ll.removeFirst());
        assertEquals(2, ll.getFirst());
        assertEquals(2, ll.removeFirst());
        assertEquals(3, ll.getFirst());
        assertEquals(3, ll.removeFirst());
        assertEquals(4, ll.getFirst());
        assertEquals(4, ll.removeFirst());
        assertTrue(ll.isEmpty());
    }

    @Test
    public void testListRemoveLast() {
        LinkedList ll = new LinkedList();
        try {
            ll.removeLast();
            fail("Esta linha não pode ser executada.");
        } catch (Exception e) {}

        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);

        assertEquals(4, ll.getLast());
        ll.removeLast();
        assertEquals(3, ll.getLast());
        ll.removeLast();
        assertEquals(2, ll.getLast());
        ll.removeLast();
        assertEquals(1, ll.getLast());
        ll.removeLast();
        assertTrue(ll.isEmpty());
    }

    @Test
    public void testListRemove() {
        LinkedList ll = new LinkedList();
        try {
            ll.remove(-1);
            fail("Esta linha não pode ser executada.");
        } catch (Exception e) {}

        try {
            ll.remove(6);
            fail("Esta linha não pode ser executada.");
        } catch (Exception e) {}

        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(2);

        assertEquals(1, ll.indexOf(2));
        ll.remove(1);
        assertEquals(3, ll.indexOf(2));
        assertEquals(0, ll.indexOf(1));
        ll.remove(0);
        assertEquals(-1, ll.indexOf(1));
        assertEquals(0, ll.indexOf(3));
        ll.remove(0);
        assertEquals(-1, ll.indexOf(3));
        assertEquals(0, ll.indexOf(4));
        ll.remove(0);
        assertEquals(-1, ll.indexOf(4));
        assertEquals(0, ll.indexOf(2));
        ll.remove(0);
        assertEquals(-1, ll.indexOf(2));
        assertTrue(ll.isEmpty());
    }

    @Test
    public void testListRemoveByValue() {
        LinkedList ll = new LinkedList();

        assertFalse(ll.removeByValue(5));

        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(2);

        assertTrue(ll.removeByValue(1));
        assertFalse(ll.removeByValue(1));
        assertEquals(2, ll.getFirst());
        assertEquals(0, ll.indexOf(2));
        ll.removeByValue(2);
        assertEquals(2, ll.indexOf(2));
        ll.removeByValue(3);
        ll.removeByValue(4);
        assertEquals(2, ll.getFirst());
        ll.removeByValue(2);
        assertTrue(ll.isEmpty());
    }

   @Test
    public void testLLAddLast(){
        LinkedList ll = new LinkedList();
        assertTrue(ll.isEmpty());
        assertEquals(0, ll.size());

        ll.addLast(12);
        assertFalse(ll.isEmpty());
        assertEquals(12, ll.getFirst());
        assertEquals(12, ll.getLast());
        assertEquals(1, ll.size());

        ll.addLast(20);
        assertFalse(ll.isEmpty());
        assertEquals(12, ll.getFirst());
        assertEquals(20, ll.getLast());
        assertEquals(2, ll.size());

        ll.addLast(30);
        ll.addLast(40);
        assertFalse(ll.isEmpty());
        assertEquals(12, ll.getFirst());
        assertEquals(40, ll.getLast());
        assertEquals(4, ll.size());

        ll.addLast(50);
        assertFalse(ll.isEmpty());
        assertEquals(12, ll.getFirst());
        assertEquals(50, ll.getLast());
        assertEquals(5, ll.size());

        ll.addLast(60);
        assertFalse(ll.isEmpty());
        assertEquals(12, ll.getFirst());
        assertEquals(60, ll.getLast());
        assertEquals(6, ll.size());

    }

    @Test
    public void testListAddFirst(){
        LinkedList ll = new LinkedList();
        assertTrue(ll.isEmpty());
        assertEquals(0, ll.size());

        ll.addFirst(50);
        assertFalse(ll.isEmpty());
        assertEquals(50, ll.getFirst());
        assertEquals(1, ll.size());

        ll.addFirst(40);
        ll.addFirst(30);
        assertFalse(ll.isEmpty());
        assertEquals(30, ll.getFirst());
        assertEquals(3, ll.size());

        ll.addFirst(20);
        assertFalse(ll.isEmpty());
        assertEquals(20, ll.getFirst());
        assertEquals(4, ll.size());

        ll.addFirst(10);
        assertFalse(ll.isEmpty());
        assertEquals(10, ll.getFirst());
        assertEquals(5, ll.size());

        ll.addFirst(5);
        assertFalse(ll.isEmpty());
        assertEquals(5, ll.getFirst());
        assertEquals(6, ll.size());

    }

    @Test
    public void testLinkedListAdd(){
        LinkedList ll = new LinkedList();
        assertTrue(ll.isEmpty());
        assertEquals(0, ll.size());

        //addIndex < 0
        try {
            ll.add(-1, 12);
            fail("Esta linha não pode ser executada.");
        } catch (Exception e) {}

        //addIndex > 0
        try {
            ll.add(7, 12);
            fail("Esta linha não pode ser executada.");
        } catch (Exception e) {}

        //addAtIndex0Empty
        ll.add(0, 12);
        assertFalse(ll.isEmpty());
        assertEquals(12, ll.getFirst());
        assertEquals(1, ll.size());

        ll.add(1, 20);
        assertFalse(ll.isEmpty());
        assertEquals(12, ll.getFirst());
        assertEquals(20, ll.getLast());
        assertEquals(2, ll.size());

        ll.add(2, 30);
        assertFalse(ll.isEmpty());
        assertEquals(12, ll.getFirst());
        assertEquals(30, ll.getLast());
        assertEquals(3, ll.size());

        ll.add(2, 25);
        assertFalse(ll.isEmpty());
        assertEquals(12, ll.getFirst());
        assertEquals(25, ll.get(2));
        assertEquals(30, ll.getLast());
        assertEquals(4, ll.size());

        ll.add(0, 5);
        assertFalse(ll.isEmpty());
        assertEquals(5, ll.getFirst());
        assertEquals(30, ll.getLast());
        assertEquals(5, ll.size());
        
        ll.add(2, 15);
        assertFalse(ll.isEmpty());
        assertEquals(5, ll.getFirst());
        assertEquals(30, ll.getLast());
        assertEquals(6, ll.size());
    }

}
