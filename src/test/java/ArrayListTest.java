import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ArrayListTest {
    @Test
    public void testIsEmpty() {
        ArrayList array = new ArrayList(3);
        assertTrue(array.isEmpty());

        array.addFirst(1);
        assertFalse(array.isEmpty());
        array.addFirst(2);
        assertFalse(array.isEmpty());
        array.addFirst(3);
        array.removeFirst();
        assertFalse(array.isEmpty());
        array.removeFirst();
        assertFalse(array.isEmpty());
        array.removeFirst();
        assertTrue(array.isEmpty());


        ArrayList arrayWithNoCapacity = new ArrayList(0);
        assertTrue(arrayWithNoCapacity.isEmpty());

        ArrayList arrayWithALotOfCapacity = new ArrayList(30);
        assertTrue(arrayWithALotOfCapacity.isEmpty());
    }

    @Test
    public void testLastIndexOf() {
        ArrayList emptyArray = new ArrayList(5);
        assertEquals(-1, emptyArray.lastIndexOf(1));

        ArrayList array = new ArrayList(3);
        array.addLast(1);
        array.addLast(2);
        array.addLast(3);

        assertEquals(2, array.lastIndexOf(3));
        assertEquals(1, array.lastIndexOf(2));
        assertEquals(0, array.lastIndexOf(1));

        // ArrayList com apenas elementos duplicados
        ArrayList dupli = new ArrayList(4);
        dupli.addLast(1);
        dupli.addLast(1);
        dupli.addLast(1);

        assertEquals(2, dupli.lastIndexOf(1));

        // ArrayList com apenas um elemento duplicado
        ArrayList list = new ArrayList(5);
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(3);

        assertEquals(4, list.lastIndexOf(3));
    }

    @Test
    public void testToString() {
        ArrayList list = new ArrayList(5);

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

        // As duas adições a seguir fazem com que
        // os dois valores adicionados circulem na fila
        list.addLast(10);
        list.addLast(11);

        assertEquals("3, 4, 5, 10, 11", list.toString());
    }

    @Test
    public void testArrayListGet() {
        ArrayList arrayList = new ArrayList(5);
        // Limite inferior ao permitido
        try {
            arrayList.get(0);
            fail("Esta linha não pode ser executada");
        } catch (Exception e) {}

        arrayList.addLast(10);
        arrayList.addLast(20);
        arrayList.addLast(30);
        arrayList.addLast(40);
        arrayList.addLast(50);
        assertEquals(10, arrayList.get(0));
        assertEquals(20, arrayList.get(1));

        arrayList.removeFirst();
        arrayList.addLast(60);
        assertEquals(60, arrayList.get(4));

        try {
            arrayList.get(-1);
            fail("Esta linha não pode ser executada");
        } catch (Exception e) {}

        // Limite superior ao permitido
        try {
            arrayList.get(5);
            fail("Esta linha não pode ser executada");
        } catch (Exception e) {}

    }

    @Test
    public void testArrayListGetFirst() {
        ArrayList arrayList = new ArrayList(5);

        try {
            arrayList.getFirst();
            fail("Esta linha não pode ser executada");
        } catch (Exception e) {}

        arrayList.addLast(10);
        assertEquals(10, arrayList.getFirst());
        arrayList.addLast(20);
        assertEquals(10, arrayList.getFirst());

        arrayList.addFirst(30);
        assertEquals(30, arrayList.getFirst());
    }

    @Test
    public void testArrayListGetLast() {
        ArrayList arrayList = new ArrayList(5);

        try {
            arrayList.getLast();
            fail("Esta linha não pode ser executada");
        } catch (Exception e) {}

        arrayList.addLast(10);
        assertEquals(10, arrayList.getLast());
        arrayList.addLast(20);
        assertEquals(20, arrayList.getLast());

        arrayList.addFirst(30);
        assertEquals(20, arrayList.getLast());
    }

    @Test
    public void testArrayListIndexOf() {
        ArrayList arrayList = new ArrayList(5);
        assertEquals(-1, arrayList.indexOf(10));
        arrayList.addLast(10);
        assertEquals(0, arrayList.indexOf(10));
        arrayList.addLast(20);
        assertEquals(1, arrayList.indexOf(20));
        assertEquals(0, arrayList.indexOf(10));

        arrayList.addLast(10);
        arrayList.addLast(10);
        assertEquals(0, arrayList.indexOf(10));
    }

    @Test
    public void testArrayListRemoveFirst() {
        ArrayList arrayList = new ArrayList(5);

        try {
            arrayList.removeFirst();
            fail("Esta linha não pode ser executada.");
        } catch (Exception e) {}

        arrayList.addLast(1);
        arrayList.addLast(2);
        arrayList.addLast(3);
        arrayList.addLast(4);

        assertEquals(1, arrayList.getFirst());
        assertEquals(1, arrayList.removeFirst());
        assertEquals(2, arrayList.getFirst());
        assertEquals(2, arrayList.removeFirst());
        assertEquals(3, arrayList.getFirst());
        assertEquals(3, arrayList.removeFirst());
        assertEquals(4, arrayList.getFirst());
        assertEquals(4, arrayList.removeFirst());
        assertTrue(arrayList.isEmpty());
    }

    @Test
    public void testArrayListRemoveLast() {
        ArrayList arrayList = new ArrayList(5);

        try {
            arrayList.removeLast();
            fail("Esta linha não pode ser executada.");
        } catch (Exception e) {}

        arrayList.addLast(1);
        arrayList.addLast(2);
        arrayList.addLast(3);
        arrayList.addLast(4);

        assertEquals(4, arrayList.getLast());
        arrayList.removeLast();
        assertEquals(3, arrayList.getLast());
        arrayList.removeLast();
        assertEquals(2, arrayList.getLast());
        arrayList.removeLast();
        assertEquals(1, arrayList.getLast());
        arrayList.removeLast();
        assertTrue(arrayList.isEmpty());
    }

    @Test
    public void testArrayListRemove() {
        ArrayList arrayList = new ArrayList(5);

        try {
            arrayList.remove(-1);
            fail("Esta linha não pode ser executada.");
        } catch (Exception e) {}

        try {
            arrayList.remove(6);
            fail("Esta linha não pode ser executada.");
        } catch (Exception e) {}

        arrayList.addLast(1);
        arrayList.addLast(2);
        arrayList.addLast(3);
        arrayList.addLast(4);
        arrayList.addLast(2);

        assertEquals(1, arrayList.indexOf(2));
        arrayList.remove(1);
        assertEquals(3, arrayList.indexOf(2));
        assertEquals(0, arrayList.indexOf(1));
        arrayList.remove(0);
        assertEquals(-1, arrayList.indexOf(1));
        assertEquals(0, arrayList.indexOf(3));
        arrayList.remove(0);
        assertEquals(-1, arrayList.indexOf(3));
        assertEquals(0, arrayList.indexOf(4));
        arrayList.remove(0);
        assertEquals(-1, arrayList.indexOf(4));
        assertEquals(0, arrayList.indexOf(2));
        arrayList.remove(0);
        assertEquals(-1, arrayList.indexOf(2));
        assertTrue(arrayList.isEmpty());
    }

    @Test
    public void testArrayListRemoveByValue() {
        ArrayList arrayList = new ArrayList(5);

        arrayList.removeByValue(5);

        arrayList.addLast(1);
        arrayList.addLast(2);
        arrayList.addLast(3);
        arrayList.addLast(4);
        arrayList.addLast(2);

        assertEquals(1, arrayList.getFirst());
        arrayList.removeByValue(1);
        arrayList.removeByValue(1);
        assertEquals(2, arrayList.getFirst());
        assertEquals(0, arrayList.indexOf(2));
        arrayList.removeByValue(2);
        assertEquals(2, arrayList.indexOf(2));
        arrayList.removeByValue(3);
        arrayList.removeByValue(4);
        assertEquals(2, arrayList.getFirst());
        arrayList.removeByValue(2);
        assertTrue(arrayList.isEmpty());
    }

   @Test
    public void testArrayListAddLast(){
        ArrayList arrayList = new ArrayList(5);
        assertTrue(arrayList.isEmpty());
        assertEquals(0, arrayList.size());

        arrayList.addLast(12);
        assertFalse(arrayList.isEmpty());
        assertEquals(12, arrayList.getFirst());
        assertEquals(12, arrayList.getLast());
        assertEquals(1, arrayList.size());

        arrayList.addLast(20);
        assertFalse(arrayList.isEmpty());
        assertEquals(12, arrayList.getFirst());
        assertEquals(20, arrayList.getLast());
        assertEquals(2, arrayList.size());

        arrayList.addLast(30);
        arrayList.addLast(40);
        assertFalse(arrayList.isEmpty());
        assertEquals(12, arrayList.getFirst());
        assertEquals(40, arrayList.getLast());
        assertEquals(4, arrayList.size());

        arrayList.addLast(50);
        assertFalse(arrayList.isEmpty());
        assertEquals(12, arrayList.getFirst());
        assertEquals(50, arrayList.getLast());
        assertEquals(5, arrayList.size());

        arrayList.addLast(60);
        assertFalse(arrayList.isEmpty());
        assertEquals(12, arrayList.getFirst());
        assertEquals(60, arrayList.getLast());
        assertEquals(6, arrayList.size());

    }

    @Test
    public void testArrayListAddFirst(){
        ArrayList arrayList = new ArrayList(5);       
        assertTrue(arrayList.isEmpty());
        assertEquals(0, arrayList.size());

        arrayList.addFirst(50);
        assertFalse(arrayList.isEmpty());
        assertEquals(50, arrayList.getFirst());
        assertEquals(1, arrayList.size());

        arrayList.addFirst(40);
        arrayList.addFirst(30);
        assertFalse(arrayList.isEmpty());
        assertEquals(30, arrayList.getFirst());
        assertEquals(3, arrayList.size());

        arrayList.addFirst(20);
        assertFalse(arrayList.isEmpty());
        assertEquals(20, arrayList.getFirst());
        assertEquals(4, arrayList.size());

        arrayList.addFirst(10);
        assertFalse(arrayList.isEmpty());
        assertEquals(10, arrayList.getFirst());
        assertEquals(5, arrayList.size());

        arrayList.addFirst(5);
        assertFalse(arrayList.isEmpty());
        assertEquals(5, arrayList.getFirst());
        assertEquals(6, arrayList.size());

    }

    @Test
    public void testArrayListAdd(){
        ArrayList arrayList = new ArrayList(5);
        assertTrue(arrayList.isEmpty());
        assertEquals(0, arrayList.size());

        //addIndex < 0
        try {
            arrayList.add(-1, 12);
            fail("Esta linha não pode ser executada.");
        } catch (Exception e) {}

        //addIndex > 0
        try {
            arrayList.add(7, 12);
            fail("Esta linha não pode ser executada.");
        } catch (Exception e) {}

        //addAtIndex0Empty
        arrayList.add(0, 12);
        assertFalse(arrayList.isEmpty());
        assertEquals(12, arrayList.getFirst());
        assertEquals(1, arrayList.size());

        arrayList.add(1, 20);
        assertFalse(arrayList.isEmpty());
        assertEquals(12, arrayList.getFirst());
        assertEquals(20, arrayList.getLast());
        assertEquals(2, arrayList.size());

        arrayList.add(2, 30);
        assertFalse(arrayList.isEmpty());
        assertEquals(12, arrayList.getFirst());
        assertEquals(30, arrayList.getLast());
        assertEquals(3, arrayList.size());

        arrayList.add(2, 25);
        assertFalse(arrayList.isEmpty());
        assertEquals(12, arrayList.getFirst());
        assertEquals(25, arrayList.get(2));
        assertEquals(30, arrayList.getLast());
        assertEquals(4, arrayList.size());

        arrayList.add(0, 5);
        assertFalse(arrayList.isEmpty());
        assertEquals(5, arrayList.getFirst());
        assertEquals(30, arrayList.getLast());
        assertEquals(5, arrayList.size());
        
        arrayList.add(2, 15);
        assertFalse(arrayList.isEmpty());
        assertEquals(5, arrayList.getFirst());
        assertEquals(30, arrayList.getLast());
        assertEquals(6, arrayList.size());
    }

    @Test
    public void testArrayListSize(){
        ArrayList arrayList = new ArrayList(5);
        assertTrue(arrayList.isEmpty());
        assertEquals(0, arrayList.size());

        arrayList.addFirst(5);
        assertEquals(1, arrayList.size());

        arrayList.removeFirst();
        assertEquals(0, arrayList.size());

        arrayList.addFirst(4);
        arrayList.addFirst(3);
        arrayList.addFirst(2);
        arrayList.addFirst(1);
        assertEquals(4, arrayList.size());

        arrayList.addFirst(0);
        assertEquals(5, arrayList.size());
    }

}
