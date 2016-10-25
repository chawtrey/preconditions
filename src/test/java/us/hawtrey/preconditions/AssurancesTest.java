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
public class AssurancesTest {

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
        int iVal = Assurances.assureNotNull(null, 0);
        assertEquals(0, iVal);

        boolean bVal = Assurances.assureNotNull(null, true);
        assertTrue(bVal);

        FakeClass fake = Assurances.assureNotNull(null, new FakeClass());
        assertNotNull(fake);
    }

    @Test
    public void assureNotNullCollection() throws Exception {
        ArrayList<String> foo = Assurances.assureNotNull(inputArrayList);
        assertEquals(inputArrayList, foo);
        assertTrue(inputArrayList == foo);

        TreeSet<String> barInput = new TreeSet<>();
        Set<String> bar = Assurances.assureNotNull(barInput);
        assertTrue(bar instanceof TreeSet);
        assertTrue(barInput == bar);

        TreeSet<String> input = null;
        Set<String> baz = Assurances.assureNotNull(input);
        assertTrue(baz instanceof HashSet);
    }

    @Test
    public void assureNotNullMap() throws Exception {
        Map<String, Object> foo = null;
        foo = Assurances.assureNotNull(foo);
        assertNotNull(foo);
        assertTrue(foo instanceof HashMap);

        foo.put("foo", "bar");
        Map<String, Object> bar = Assurances.assureNotNull(foo);
        assertEquals(foo, bar);
        assertTrue(foo == bar);

    }

    @Test
    public void assureNotNullWithDefaultClass() throws Exception {
        FakeClass foo = Assurances.assureNotNull(null, FakeClass.class);
        assertNotNull(foo);

        try {
            Assurances.assureNotNull(null, Integer.class);
            fail("should fail due to Integer not having a zero parameter constructor");
        } catch (Exception e) {
            // success
        }

    }

    @Test
    public void assureArrayList() throws Exception {
        List<String> baz = Assurances.assureArrayList(null);
        assertNotNull(baz);
        baz.add("fun times");

        HashSet<String> input = new HashSet<>();
        input.add("foo");
        input.add("bar");
        List<String> out = Assurances.assureArrayList(input);
        assertNotNull(out);
        assertFalse(input == out);
        assertTrue(out instanceof ArrayList);
        assertEquals(input.size(), out.size());
    }

    @Test
    public void assureLinkedList() throws Exception {
        LinkedList<String> linkedListOut = Assurances.assureLinkedList(inputArrayList);
        assertNotNull(linkedListOut);
        assertEquals(inputArrayList, linkedListOut);
        assertEquals("happy", linkedListOut.peekFirst());
        assertEquals("fun", linkedListOut.peekLast());
    }

    @Test
    public void assureHashSet() throws Exception {
        HashSet<String> hashSetOut = Assurances.assureHashSet(inputArrayList);
        assertNotNull(hashSetOut);
        assertEquals(2, hashSetOut.size());
    }

    @Test
    public void assureHashMap() throws Exception {
        Map<String, List<Map<String, Object>>> json = Assurances.assureHashMap(null);
        assertNotNull(json);
    }

    @Test
    public void assureUpperLowers() throws Exception {
        String input = "Foo Bar Baz";
        assertEquals(input.trim(), Assurances.assureTrimOrEmpty(input));
        assertEquals(input.trim().toLowerCase(), Assurances.assureTrimLowerOrEmpty(input));
        assertEquals(input.trim().toUpperCase(), Assurances.assureTrimUpperOrEmpty(input));

        assertEquals(input.trim(), Assurances.assureTrimOrNull(input));
        assertEquals(input.trim().toLowerCase(), Assurances.assureTrimLowerOrNull(input));
        assertEquals(input.trim().toUpperCase(), Assurances.assureTrimUpperOrNull(input));

        assertEquals("", Assurances.assureTrimOrEmpty(null));
        assertEquals("", Assurances.assureTrimLowerOrEmpty(null));
        assertEquals("", Assurances.assureTrimUpperOrEmpty(null));

        assertNull(Assurances.assureTrimOrNull(null));
        assertNull(Assurances.assureTrimLowerOrNull(null));
        assertNull(Assurances.assureTrimUpperOrNull(null));
    }

    @Test
    public void assureNumbers() throws Exception {
        assertEquals(123, Assurances.assureInt("123"));
        assertEquals(123, Assurances.assureInt("+123"));
        assertEquals(123L, Assurances.assureLong("  123  "));
        assertEquals(12.3D, Assurances.assureDouble("12.3"), 0D);
        assertEquals(0.1234D, Assurances.assureDouble(".1234"), 0D);
        assertEquals(-123F, Assurances.assureFloat("-123"), 0D);

        assertNull(Assurances.assureIntegerOrNull("abc"));
        assertNull(Assurances.assureLongOrNull("1.2.3"));
        assertNull(Assurances.assureDoubleOrNull("1-2"));
        assertNull(Assurances.assureFloatOrNull("1 2"));

        assertEquals(0, Assurances.assureInt("abc"));
        assertEquals(0L, Assurances.assureLong("1.2.3"));
        assertEquals(0D, Assurances.assureDouble("1-2"), 0D);
        assertEquals(0F, Assurances.assureFloat("1 2"), 0D);

        assertEquals(1, Assurances.assureInt("abc", 1));
        assertEquals(2L, Assurances.assureLong("1.2.3", 2L));
        assertEquals(3.4D, Assurances.assureDouble("1-2", 3.4), 0D);
        assertEquals(5.67F, Assurances.assureFloat("1 2", 5.67F), 0D);

        assertNull(Assurances.assureDoubleOrNull(null));
        assertNull(Assurances.assureDoubleOrNull(""));
        assertNull(Assurances.assureDoubleOrNull("  "));
        assertNull(Assurances.assureDoubleOrNull("-"));
        assertNull(Assurances.assureDoubleOrNull("."));
        assertNull(Assurances.assureDoubleOrNull("-."));
    }
}