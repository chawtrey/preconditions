package us.hawtrey.preconditions;

import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@SuppressWarnings("ConstantConditions")
public class PreChecksTest {

    @Test
    public void checkNotNull() throws Exception {
        assertEquals("abc", PreChecks.checkNotNull("abc", "valid"));
        assertEquals("", PreChecks.checkNotNull("", "valid blank"));
        assertEquals("  ", PreChecks.checkNotNull("  ", "valid whitespace"));

        try {
            PreChecks.checkNotNull(null, "invalid");
            fail("checkNotNull");
        } catch (NullPointerException e) {
            // success
        }
    }

    @Test
    public void checkNotBlank() throws Exception {
        assertEquals("abc", PreChecks.checkNotBlank("abc", "valid"));

        try {
            PreChecks.checkNotBlank("", "invalid blank");
            fail("checkNotBlank blank");
        } catch (IllegalArgumentException e) {
            // success
        }

        try {
            PreChecks.checkNotBlank("   ", "invalid whitespace");
            fail("checkNotBlank whitespace");
        } catch (IllegalArgumentException e) {
            // success
        }

        try {
            PreChecks.checkNotBlank(null, "invalid null");
            fail("checkNotBlank null");
        } catch (NullPointerException e) {
            // success
        }
    }

    @Test
    public void checkArgument() throws Exception {
        assertEquals("abc", PreChecks.checkArgument("abc", true, "valid"));

        try {
            PreChecks.checkArgument("abc", false, "invalid");
            fail("checkArgument");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    @Test
    public void checkNotEmpty() throws Exception {
        HashMap<String, String> map = new HashMap<>();

        try {
            PreChecks.checkNotEmpty(map, "empty map");
            fail("map is empty");
        } catch (Exception e) {
            // success
        }

        map.put("foo", "bar");
        PreChecks.checkNotEmpty(map, "non-empty map");

        ArrayList<String> list = new ArrayList<>();

        try {
            PreChecks.checkNotEmpty(list, "empty list");
            fail("list is empty");
        } catch (Exception e) {
            // success
        }

        list.add("foo");
        PreChecks.checkNotEmpty(list, "non-empty list");
    }

    @Test
    public void checkElementIndexMap() throws Exception {
        HashMap<String, Object> input = new HashMap<>();
        input.put("foo", "bar");

        assertEquals(input, PreChecks.checkElementIndex(input, 0, "valid"));

        try {
            PreChecks.checkElementIndex(input, 1, "invalid");
            fail("invalid index");
        } catch (IndexOutOfBoundsException e) {
            // success
        }

        try {
            PreChecks.checkElementIndex(input, -1, "invalid");
            fail("negative index");
        } catch (IllegalArgumentException e) {
            // success
        }

        try {
            input = null;
            PreChecks.checkElementIndex(input, 0, "invalid");
            fail("null input");
        } catch (NullPointerException e) {
            // success
        }
    }

    @Test
    public void checkElementIndexList() throws Exception {
        ArrayList<String> input = null;
        try {
            PreChecks.checkElementIndex(input, 0, "NULL ArrayList");
            fail("Should fail since list is null");
        } catch (NullPointerException e) {
            // success
        }

        input = new ArrayList<>();
        input.add("foo");

        PreChecks.checkElementIndex(input, 0, "Success ArrayList");

        try {
            PreChecks.checkElementIndex(input, 1, "ArrayList");
            fail("Should fail since list only has 1 entry");
        } catch (IndexOutOfBoundsException e) {
            // success
        }

        try {
            PreChecks.checkElementIndex(input, -1, "ArrayList");
            fail("Should fail since -1 is invalid index");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    @Test
    public void checkElementIndexString() throws Exception {
        PreChecks.checkElementIndex("a", 0, "Success String");

        try {
            PreChecks.checkElementIndex("a", 1, "String");
            fail("Should fail since String is only 1 character long");
        } catch (IndexOutOfBoundsException e) {
            // success
        }

        try {
            PreChecks.checkElementIndex("", 0, "String");
            fail("Should fail since String is empty");
        } catch (IndexOutOfBoundsException e) {
            // success
        }

        try {
            PreChecks.checkElementIndex("a", -1, "String");
            fail("Should fail since -1 is invalid index");
        } catch (IllegalArgumentException e) {
            // success
        }

        try {
            String input = null;
            PreChecks.checkElementIndex(input, 0, "NULL ArrayList");
            fail("Should fail since String is null");
        } catch (NullPointerException e) {
            // success
        }
    }

    @Test
    public void checkPositionIndexMap() throws Exception {
        HashMap<String, Object> input = new HashMap<>();
        input.put("foo", "bar");

        assertEquals(input, PreChecks.checkPositionIndex(input, 0, "valid"));
        assertEquals(input, PreChecks.checkPositionIndex(input, 1, "valid"));

        try {
            PreChecks.checkPositionIndex(input, 2, "invalid");
            fail("invalid index");
        } catch (IndexOutOfBoundsException e) {
            // success
        }

        try {
            PreChecks.checkPositionIndex(input, -1, "invalid");
            fail("negative index");
        } catch (IllegalArgumentException e) {
            // success
        }

        try {
            input = null;
            PreChecks.checkPositionIndex(input, 0, "invalid");
            fail("null input");
        } catch (NullPointerException e) {
            // success
        }
    }

    @Test
    public void checkPositionIndexList() throws Exception {
        ArrayList<String> input = new ArrayList<>();
        input.add("foo");

        PreChecks.checkPositionIndex(input, 0, "Success ArrayList");
        PreChecks.checkPositionIndex(input, 1, "Success ArrayList");

        try {
            PreChecks.checkPositionIndex(input, 2, "ArrayList");
            fail("Should fail since list only has 1 entry");
        } catch (IndexOutOfBoundsException e) {
            // success
        }

        try {
            PreChecks.checkPositionIndex(input, -1, "ArrayList");
            fail("Should fail since -1 is invalid index");
        } catch (IllegalArgumentException e) {
            // success
        }

        try {
            input = null;
            PreChecks.checkPositionIndex(input, 0, "NULL ArrayList");
            fail("Should fail since list is null");
        } catch (NullPointerException e) {
            // success
        }

    }

    @Test
    public void checkPositionIndexString() throws Exception {
        String input = "";
        PreChecks.checkPositionIndex(input, 0, "Success String");

        input = "a";
        PreChecks.checkPositionIndex(input, 0, "Success String");
        PreChecks.checkPositionIndex(input, 1, "Success String");

        try {
            PreChecks.checkPositionIndex(input, 2, "String");
            fail("Should fail since String is only 1 character long");
        } catch (IndexOutOfBoundsException e) {
            // success
        }

        try {
            PreChecks.checkPositionIndex(input, -1, "String");
            fail("Should fail since -1 is invalid index");
        } catch (IllegalArgumentException e) {
            // success
        }

        try {
            input = null;
            PreChecks.checkPositionIndex(input, 0, "NULL ArrayList");
            fail("Should fail since String is NULL");
        } catch (NullPointerException e) {
            // success
        }
    }

    @Test
    public void checkRange() throws Exception {
        Integer i = 5;
        assertEquals(i, PreChecks.checkRange(i, 0, 10, "Integer"));

        PreChecks.checkRange(1.234, 0.0, 10.0, "Double");

        PreChecks.checkRange(2.321F, 2F, 3F, "Float");

        PreChecks.checkRange(0.000000000001, 0D, 1D, "Double 1");
        PreChecks.checkRange(0.999999999999, 0D, 1D, "Double 2");

        PreChecks.checkRange(2, 2, 2, "all values equal");

        try {
            PreChecks.checkRange(1.000000000001, 0D, 1D, "Double");
            fail("out of range");
        } catch (IllegalArgumentException e) {
            // success
        }

        try {
            PreChecks.checkRange(1.000000000001, null, 1D, "Double");
            fail("null start");
        } catch (IllegalArgumentException e) {
            // success
        }

        try {
            PreChecks.checkRange(1.000000000001, 0D, null, "Double");
            fail("null end");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    @Test
    public void checkPositive() throws Exception {
        PreChecks.checkPositive(1, "integer");
        PreChecks.checkPositive(1L, "long");
        PreChecks.checkPositive(0.000000000000001, "double");
        PreChecks.checkPositive(0.000000000000001F, "float");
        PreChecks.checkPositive(new BigInteger("1"), "big integer");
        try {
            PreChecks.checkPositive(0, "zero");
            fail("Should fail since value is zero");
        } catch (IllegalArgumentException e) {
            // success
        }
        try {
            PreChecks.checkPositive(-0.000000000000001D, "double");
            fail("Should fail since value is not positive");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    @Test
    public void checkPositiveOrZero() throws Exception {
        PreChecks.checkPositiveOrZero(1, "integer");
        PreChecks.checkPositiveOrZero(1L, "long");
        PreChecks.checkPositiveOrZero(0.000000000000001, "double");
        PreChecks.checkPositiveOrZero(0.000000000000001F, "float");
        PreChecks.checkPositiveOrZero(new BigInteger("1"), "big integer");
        PreChecks.checkPositiveOrZero(0, "zero");
        try {
            PreChecks.checkPositiveOrZero(-0.000000000000001D, "double");
            fail("Should fail since value is not positive");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    @Test
    public void checkNegative() throws Exception {
        PreChecks.checkNegative(-1, "int");
        PreChecks.checkNegative(-10000L, "long");
        PreChecks.checkNegative(-0.00000000001D, "double");
        try {
            PreChecks.checkNegative(0, "zero");
            fail("Should fail since value zero");
        } catch (IllegalArgumentException e) {
            // success
        }
        try {
            PreChecks.checkNegative(0.000000000000001D, "double");
            fail("Should fail since value is not negative");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    @Test
    public void checkNegativeOrZero() throws Exception {
        PreChecks.checkNegativeOrZero(-10000L, "long");
        PreChecks.checkNegativeOrZero(-0.00000000001D, "double");
        PreChecks.checkNegativeOrZero(0, "zero");
        try {
            PreChecks.checkNegativeOrZero(0.000000000000001D, "double");
            fail("Should fail since value is not negative");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    @Test
    public void checkNumber() throws Exception {
        Double d = PreChecks.checkDouble("1.23", "Double 1.23");
        assertEquals(new Double("1.23"), d);

        double d2 = PreChecks.checkDouble("123", "Double 123");
        assertEquals(123D, d2, 0D);

        PreChecks.checkDouble("  1233  ", "Untrimmed");

        PreChecks.checkDouble("-3.21", "Negative");

        Long l1 = PreChecks.checkLong("123", "Long 123");
        assertEquals(new Long(123), l1);

        long l2 = PreChecks.checkLong("12.3", "decimal to Long");
        assertEquals(12L, l2);

        int i1 = PreChecks.checkInt("12", "to Integer");
        assertEquals(12, i1);

        Integer i2 = PreChecks.checkInt("12.3", "decimal to Integer");
        assertEquals(new Integer(12), i2);

        float f1 = PreChecks.checkFloat("12.0003", "to Float");
        assertEquals(12.0003F, f1, 0F);

        Float f2 = PreChecks.checkFloat("123", "non-decimal to Float");
        assertEquals(123F, f2, 0F);

        try {
            PreChecks.checkDouble("3-21", "Dash in middle");
            fail("Dash in middle");
        } catch (NumberFormatException e) {
            // success
        }

        try {
            PreChecks.checkDouble("3.2.1", "Multiple dots");
            fail("Multiple dots");
        } catch (NumberFormatException e) {
            // success
        }

        try {
            PreChecks.checkDouble("3 2", "Whitespace");
            fail("Whitespace");
        } catch (NumberFormatException e) {
            // success
        }

        PreChecks.checkIntStrictly("123", "Valid strict int");

        try {
            PreChecks.checkIntStrictly("3.2", "Non-strict Int");
            fail("Non-strict Int");
        } catch (NumberFormatException e) {
            // success
        }
    }
}