package us.hawtrey.preconditions;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

@SuppressWarnings({"ConstantConditions", "AssertEqualsBetweenInconvertibleTypes"})
public class AssureTest {

    private ArrayList<String> inputArrayList;

    @Before
    public void setUp() throws Exception {
        inputArrayList = new ArrayList<>();
        inputArrayList.add("happy");
        inputArrayList.add("happy");
        inputArrayList.add("fun");
        inputArrayList.add("fun");
    }

    @Test
    public void assureNotNullWithDefaults() throws Exception {
        int iVal = Assure.notNull(null, 0);
        assertEquals(0, iVal);

        boolean bVal = Assure.notNull(null, true);
        assertTrue(bVal);

        FakeClass fake = Assure.notNull(null, new FakeClass());
        assertNotNull(fake);
    }

    @Test
    public void assureNotNullCollection() throws Exception {
        ArrayList<String> foo = Assure.notNull(inputArrayList);
        assertEquals(inputArrayList, foo);
        assertTrue(inputArrayList == foo);

        TreeSet<String> barInput = new TreeSet<>();
        Set<String> bar = Assure.notNull(barInput);
        assertTrue(bar instanceof TreeSet);
        assertTrue(barInput == bar);

        TreeSet<String> input = null;
        Set<String> baz = Assure.notNull(input);
        assertTrue(baz instanceof HashSet);
    }

    @Test
    public void assureNotNullMap() throws Exception {
        Map<String, Object> foo = null;
        foo = Assure.notNull(foo);
        assertNotNull(foo);
        assertTrue(foo instanceof HashMap);

        foo.put("foo", "bar");
        Map<String, Object> bar = Assure.notNull(foo);
        assertEquals(foo, bar);
        assertTrue(foo == bar);

    }

    @Test
    public void assureNotNullWithDefaultClass() throws Exception {
        FakeClass foo = Assure.notNull(null, FakeClass.class);
        assertNotNull(foo);

        try {
            Assure.notNull(null, Integer.class);
            fail("should fail due to Integer not having a zero parameter constructor");
        } catch (Exception e) {
            // success
        }

    }

    @Test
    public void assureArrayList() throws Exception {
        List<String> baz = Assure.arrayList(null);
        assertNotNull(baz);
        baz.add("fun times");

        HashSet<String> input = new HashSet<>();
        input.add("foo");
        input.add("bar");
        List<String> out = Assure.arrayList(input);
        assertNotNull(out);
        assertFalse(input == out);
        assertTrue(out instanceof ArrayList);
        assertEquals(input.size(), out.size());
    }

    @Test
    public void assureLinkedList() throws Exception {
        LinkedList<String> linkedListOut = Assure.linkedList(inputArrayList);
        assertNotNull(linkedListOut);
        assertEquals(inputArrayList, linkedListOut);
        assertEquals("happy", linkedListOut.peekFirst());
        assertEquals("fun", linkedListOut.peekLast());
    }

    @Test
    public void assureHashSet() throws Exception {
        HashSet<String> hashSetOut = Assure.hashSet(inputArrayList);
        assertNotNull(hashSetOut);
        assertEquals(2, hashSetOut.size());
    }

    @Test
    public void assureHashMap() throws Exception {
        Map<String, List<Map<String, Object>>> json = Assure.hashMap(null);
        assertNotNull(json);
    }

    @Test
    public void assureUpperLowers() throws Exception {
        String input = "Foo Bar Baz";
        assertEquals(input.trim(), Assure.trimmedOrEmpty(input));
        assertEquals(input.trim().toLowerCase(), Assure.trimmedLowerOrEmpty(input));
        assertEquals(input.trim().toUpperCase(), Assure.trimmedUpperOrEmpty(input));

        assertEquals(input.trim(), Assure.trimmedOrNull(input));
        assertEquals(input.trim().toLowerCase(), Assure.trimmedLowerOrNull(input));
        assertEquals(input.trim().toUpperCase(), Assure.trimmedUpperOrNull(input));

        assertEquals("", Assure.trimmedOrEmpty(null));
        assertEquals("", Assure.trimmedLowerOrEmpty(null));
        assertEquals("", Assure.trimmedUpperOrEmpty(null));

        assertNull(Assure.trimmedOrNull(null));
        assertNull(Assure.trimmedLowerOrNull(null));
        assertNull(Assure.trimmedUpperOrNull(null));
    }

    @Test
    public void assureNumbers() throws Exception {
        assertEquals(123, Assure.intValue("123"));
        assertEquals(123, Assure.intValue("+123"));
        assertEquals(123L, Assure.longValue("  123  "));
        assertEquals(12.3D, Assure.doubleValue("12.3"), 0D);
        assertEquals(0.1234D, Assure.doubleValue(".1234"), 0D);
        assertEquals(-123F, Assure.floatValue("-123"), 0D);

        assertNull(Assure.integerOrNull("abc"));
        assertNull(Assure.longOrNull("1.2.3"));
        assertNull(Assure.doubleOrNull("1-2"));
        assertNull(Assure.floatOrNull("1 2"));

        assertEquals(0, Assure.intValue("abc"));
        assertEquals(0L, Assure.longValue("1.2.3"));
        assertEquals(0D, Assure.doubleValue("1-2"), 0D);
        assertEquals(0F, Assure.floatValue("1 2"), 0D);

        assertEquals(1, Assure.intValue("abc", 1));
        assertEquals(2L, Assure.longValue("1.2.3", 2L));
        assertEquals(3.4D, Assure.doubleValue("1-2", 3.4), 0D);
        assertEquals(5.67F, Assure.floatValue("1 2", 5.67F), 0D);

        assertNull(Assure.doubleOrNull(null));
        assertNull(Assure.doubleOrNull(""));
        assertNull(Assure.doubleOrNull("  "));
        assertNull(Assure.doubleOrNull("-"));
        assertNull(Assure.doubleOrNull("."));
        assertNull(Assure.doubleOrNull("-."));
    }
}