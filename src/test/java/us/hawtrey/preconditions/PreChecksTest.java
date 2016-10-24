package us.hawtrey.preconditions;

import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@SuppressWarnings("ConstantConditions")
public class PreChecksTest {
    @Test
    public void checkInRange() throws Exception {
        Integer i = 5;
        Integer newI = PreChecks.checkRange(i, 0, 10, "Integer");
        assertEquals(i, newI);

        PreChecks.checkRange(1.234, 0.0, 10.0, "Double");

        PreChecks.checkRange(2.321F, 2F, 3F, "Float");

        PreChecks.checkRange(0.000000000001, 0D, 1D, "Double 1");
        PreChecks.checkRange(0.999999999999, 0D, 1D, "Double 2");

        PreChecks.checkRange(2, 2, 2, "all values equal");

        try {
            PreChecks.checkRange(1.000000000001, 0D, 1D, "Double");
            fail("out of range");
        } catch (Exception e) {
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
            PreChecks.checkPositive(-0.000000000000001D, "double");
            fail("Should fail since value is not positive");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    @Test
    public void checkNegativeOrZero() throws Exception {
        PreChecks.checkNegativeOrZero(0L, "zero long");
        PreChecks.checkNegativeOrZero(0, "zero integer");
        PreChecks.checkNegativeOrZero(-10000L, "long");
        PreChecks.checkNegativeOrZero(-0.00000000001D, "double");
        try {
            PreChecks.checkNegativeOrZero(0.000000000000001D, "double");
            fail("Should fail since value is not negative");
        } catch (IllegalArgumentException e) {
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
    public void checkPositionIndexList() throws Exception {
        ArrayList<String> input = null;
        try {
            PreChecks.checkPositionIndex(input, 0, "NULL ArrayList");
            fail("Should fail since list is null");
        } catch (NullPointerException e) {
            // success
        }

        input = new ArrayList<>();
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
    }

    @Test
    public void checkElementIndexString() throws Exception {
        try {
            String input = null;
            PreChecks.checkElementIndex(input, 0, "NULL ArrayList");
            fail("Should fail since String is null");
        } catch (NullPointerException e) {
            // success
        }

        try {
            PreChecks.checkElementIndex("", 0, "String");
            fail("Should fail since String is empty");
        } catch (IndexOutOfBoundsException e) {
            // success
        }

        PreChecks.checkElementIndex("a", 0, "Success String");

        try {
            PreChecks.checkElementIndex("a", 1, "String");
            fail("Should fail since String is only 1 character long");
        } catch (IndexOutOfBoundsException e) {
            // success
        }

        try {
            PreChecks.checkElementIndex("a", -1, "String");
            fail("Should fail since -1 is invalid index");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    @Test
    public void checkPositionIndexString() throws Exception {
        try {
            String input = null;
            PreChecks.checkPositionIndex(input, 0, "NULL ArrayList");
            fail("Should fail since String is NULL");
        } catch (NullPointerException e) {
            // success
        }

        PreChecks.checkPositionIndex("", 0, "Success String");
        PreChecks.checkPositionIndex("a", 0, "Success String");
        PreChecks.checkPositionIndex("a", 1, "Success String");

        try {
            PreChecks.checkPositionIndex("a", 2, "String");
            fail("Should fail since String is only 1 character long");
        } catch (IndexOutOfBoundsException e) {
            // success
        }

        try {
            PreChecks.checkPositionIndex("a", -1, "String");
            fail("Should fail since -1 is invalid index");
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