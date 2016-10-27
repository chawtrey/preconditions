package us.hawtrey.preconditions;

import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@SuppressWarnings("ConstantConditions")
public class ValidateTest {

    @Test
    public void checkNotNull() throws Exception {
        assertEquals("abc", Validate.notNull("abc", "valid"));
        assertEquals("", Validate.notNull("", "valid blank"));
        assertEquals("  ", Validate.notNull("  ", "valid whitespace"));

        try {
            Validate.notNull(null, "invalid");
            fail("notNull");
        } catch (NullPointerException e) {
            // success
        }
    }

    @Test
    public void checkNotBlank() throws Exception {
        assertEquals("abc", Validate.notBlank("abc", "valid"));

        try {
            Validate.notBlank("", "invalid blank");
            fail("notBlank blank");
        } catch (IllegalArgumentException e) {
            // success
        }

        try {
            Validate.notBlank("   ", "invalid whitespace");
            fail("notBlank whitespace");
        } catch (IllegalArgumentException e) {
            // success
        }

        try {
            Validate.notBlank(null, "invalid null");
            fail("notBlank null");
        } catch (NullPointerException e) {
            // success
        }
    }

    @Test
    public void checkArgument() throws Exception {
        assertEquals("abc", Validate.argument("abc", true, "valid"));

        try {
            Validate.argument("abc", false, "invalid");
            fail("argument");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    @Test
    public void checkNotEmpty() throws Exception {
        HashMap<String, String> map = new HashMap<>();

        try {
            Validate.notEmpty(map, "empty map");
            fail("map is empty");
        } catch (Exception e) {
            // success
        }

        map.put("foo", "bar");
        Validate.notEmpty(map, "non-empty map");

        ArrayList<String> list = new ArrayList<>();

        try {
            Validate.notEmpty(list, "empty list");
            fail("list is empty");
        } catch (Exception e) {
            // success
        }

        list.add("foo");
        Validate.notEmpty(list, "non-empty list");
    }

    @Test
    public void checkElementIndexMap() throws Exception {
        HashMap<String, Object> input = new HashMap<>();
        input.put("foo", "bar");

        assertEquals(input, Validate.elementIndex(input, 0, "valid"));

        try {
            Validate.elementIndex(input, 1, "invalid");
            fail("invalid index");
        } catch (IndexOutOfBoundsException e) {
            // success
        }

        try {
            Validate.elementIndex(input, -1, "invalid");
            fail("negative index");
        } catch (IllegalArgumentException e) {
            // success
        }

        try {
            input = null;
            Validate.elementIndex(input, 0, "invalid");
            fail("null input");
        } catch (NullPointerException e) {
            // success
        }
    }

    @Test
    public void checkElementIndexList() throws Exception {
        ArrayList<String> input = null;
        try {
            Validate.elementIndex(input, 0, "NULL ArrayList");
            fail("Should fail since list is null");
        } catch (NullPointerException e) {
            // success
        }

        input = new ArrayList<>();
        input.add("foo");

        Validate.elementIndex(input, 0, "Success ArrayList");

        try {
            Validate.elementIndex(input, 1, "ArrayList");
            fail("Should fail since list only has 1 entry");
        } catch (IndexOutOfBoundsException e) {
            // success
        }

        try {
            Validate.elementIndex(input, -1, "ArrayList");
            fail("Should fail since -1 is invalid index");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    @Test
    public void checkElementIndexString() throws Exception {
        Validate.elementIndex("a", 0, "Success String");

        try {
            Validate.elementIndex("a", 1, "String");
            fail("Should fail since String is only 1 character long");
        } catch (IndexOutOfBoundsException e) {
            // success
        }

        try {
            Validate.elementIndex("", 0, "String");
            fail("Should fail since String is empty");
        } catch (IndexOutOfBoundsException e) {
            // success
        }

        try {
            Validate.elementIndex("a", -1, "String");
            fail("Should fail since -1 is invalid index");
        } catch (IllegalArgumentException e) {
            // success
        }

        try {
            String input = null;
            Validate.elementIndex(input, 0, "NULL ArrayList");
            fail("Should fail since String is null");
        } catch (NullPointerException e) {
            // success
        }
    }

    @Test
    public void checkPositionIndexMap() throws Exception {
        HashMap<String, Object> input = new HashMap<>();
        input.put("foo", "bar");

        assertEquals(input, Validate.positionIndex(input, 0, "valid"));
        assertEquals(input, Validate.positionIndex(input, 1, "valid"));

        try {
            Validate.positionIndex(input, 2, "invalid");
            fail("invalid index");
        } catch (IndexOutOfBoundsException e) {
            // success
        }

        try {
            Validate.positionIndex(input, -1, "invalid");
            fail("negative index");
        } catch (IllegalArgumentException e) {
            // success
        }

        try {
            input = null;
            Validate.positionIndex(input, 0, "invalid");
            fail("null input");
        } catch (NullPointerException e) {
            // success
        }
    }

    @Test
    public void checkPositionIndexList() throws Exception {
        ArrayList<String> input = new ArrayList<>();
        input.add("foo");

        Validate.positionIndex(input, 0, "Success ArrayList");
        Validate.positionIndex(input, 1, "Success ArrayList");

        try {
            Validate.positionIndex(input, 2, "ArrayList");
            fail("Should fail since list only has 1 entry");
        } catch (IndexOutOfBoundsException e) {
            // success
        }

        try {
            Validate.positionIndex(input, -1, "ArrayList");
            fail("Should fail since -1 is invalid index");
        } catch (IllegalArgumentException e) {
            // success
        }

        try {
            input = null;
            Validate.positionIndex(input, 0, "NULL ArrayList");
            fail("Should fail since list is null");
        } catch (NullPointerException e) {
            // success
        }

    }

    @Test
    public void checkPositionIndexString() throws Exception {
        String input = "";
        Validate.positionIndex(input, 0, "Success String");

        input = "a";
        Validate.positionIndex(input, 0, "Success String");
        Validate.positionIndex(input, 1, "Success String");

        try {
            Validate.positionIndex(input, 2, "String");
            fail("Should fail since String is only 1 character long");
        } catch (IndexOutOfBoundsException e) {
            // success
        }

        try {
            Validate.positionIndex(input, -1, "String");
            fail("Should fail since -1 is invalid index");
        } catch (IllegalArgumentException e) {
            // success
        }

        try {
            input = null;
            Validate.positionIndex(input, 0, "NULL ArrayList");
            fail("Should fail since String is NULL");
        } catch (NullPointerException e) {
            // success
        }
    }

    @Test
    public void checkRange() throws Exception {
        Integer i = 5;
        assertEquals(i, Validate.inRange(i, 0, 10, "Integer"));

        Validate.inRange(1.234, 0.0, 10.0, "Double");

        Validate.inRange(2.321F, 2F, 3F, "Float");

        Validate.inRange(0.000000000001, 0D, 1D, "Double 1");
        Validate.inRange(0.999999999999, 0D, 1D, "Double 2");

        Validate.inRange(2, 2, 2, "all values equal");

        try {
            Validate.inRange(1.000000000001, 0D, 1D, "Double");
            fail("out of range");
        } catch (IllegalArgumentException e) {
            // success
        }

        try {
            Validate.inRange(1.000000000001, null, 1D, "Double");
            fail("null start");
        } catch (IllegalArgumentException e) {
            // success
        }

        try {
            Validate.inRange(1.000000000001, 0D, null, "Double");
            fail("null end");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    @Test
    public void checkPositive() throws Exception {
        Validate.positive(1, "integer");
        Validate.positive(1L, "long");
        Validate.positive(0.000000000000001, "double");
        Validate.positive(0.000000000000001F, "float");
        Validate.positive(new BigInteger("1"), "big integer");
        try {
            Validate.positive(0, "zero");
            fail("Should fail since value is zero");
        } catch (IllegalArgumentException e) {
            // success
        }
        try {
            Validate.positive(-0.000000000000001D, "double");
            fail("Should fail since value is not positive");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    @Test
    public void checkPositiveOrZero() throws Exception {
        Validate.positiveOrZero(1, "integer");
        Validate.positiveOrZero(1L, "long");
        Validate.positiveOrZero(0.000000000000001, "double");
        Validate.positiveOrZero(0.000000000000001F, "float");
        Validate.positiveOrZero(new BigInteger("1"), "big integer");
        Validate.positiveOrZero(0, "zero");
        try {
            Validate.positiveOrZero(-0.000000000000001D, "double");
            fail("Should fail since value is not positive");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    @Test
    public void checkNegative() throws Exception {
        Validate.negative(-1, "int");
        Validate.negative(-10000L, "long");
        Validate.negative(-0.00000000001D, "double");
        try {
            Validate.negative(0, "zero");
            fail("Should fail since value zero");
        } catch (IllegalArgumentException e) {
            // success
        }
        try {
            Validate.negative(0.000000000000001D, "double");
            fail("Should fail since value is not negative");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    @Test
    public void checkNegativeOrZero() throws Exception {
        Validate.negativeOrZero(-10000L, "long");
        Validate.negativeOrZero(-0.00000000001D, "double");
        Validate.negativeOrZero(0, "zero");
        try {
            Validate.negativeOrZero(0.000000000000001D, "double");
            fail("Should fail since value is not negative");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    @Test
    public void checkNumber() throws Exception {
        Double d = Validate.doubleValue("1.23", "Double 1.23");
        assertEquals(new Double("1.23"), d);

        double d2 = Validate.doubleValue("123", "Double 123");
        assertEquals(123D, d2, 0D);

        Validate.doubleValue("  1233  ", "Untrimmed");

        Validate.doubleValue("-3.21", "Negative");

        Long l1 = Validate.longValue("123", "Long 123");
        assertEquals(new Long(123), l1);

        long l2 = Validate.longValue("12.3", "decimal to Long");
        assertEquals(12L, l2);

        int i1 = Validate.intValue("12", "to Integer");
        assertEquals(12, i1);

        Integer i2 = Validate.intValue("12.3", "decimal to Integer");
        assertEquals(new Integer(12), i2);

        float f1 = Validate.floatValue("12.0003", "to Float");
        assertEquals(12.0003F, f1, 0F);

        Float f2 = Validate.floatValue("123", "non-decimal to Float");
        assertEquals(123F, f2, 0F);

        try {
            Validate.doubleValue("3-21", "Dash in middle");
            fail("Dash in middle");
        } catch (NumberFormatException e) {
            // success
        }

        try {
            Validate.doubleValue("3.2.1", "Multiple dots");
            fail("Multiple dots");
        } catch (NumberFormatException e) {
            // success
        }

        try {
            Validate.doubleValue("3 2", "Whitespace");
            fail("Whitespace");
        } catch (NumberFormatException e) {
            // success
        }

        Validate.strictlyIntValue("123", "Valid strict int");

        try {
            Validate.strictlyIntValue("3.2", "Non-strict Int");
            fail("Non-strict Int");
        } catch (NumberFormatException e) {
            // success
        }
    }

    @Test
    public void checkInstanceOf() throws Exception {
        assertEquals("foo", Validate.instanceOfType("foo", String.class, "foo", null));
        Validate.instanceOfType(new ArrayList<String>(), List.class, "foo", null);

        try {
            Validate.instanceOfType("foo", Integer.class, "foo", null);
            fail("invalid InstanceOf");
        } catch (IllegalArgumentException e) {
            // success
        }

        try {
            Validate.instanceOfType(new ArrayList<String>(), LinkedList.class, "foo", null);
            fail("invalid InstanceOf");
        } catch (IllegalArgumentException e) {
            // success
        }

    }

    @Test
    public void checkAssignableFrom() throws Exception {
        Validate.assignableFromClass(ArrayList.class, List.class, null, null);

        try {
            Validate.assignableFromClass(ArrayList.class, LinkedList.class, "foo", null);
            fail("invalid InstanceOf");
        } catch (IllegalArgumentException e) {
            // success
        }
    }
}