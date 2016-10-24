package us.hawtrey.preconditions;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import static java.lang.String.format;

@SuppressWarnings({"unused", "WeakerAccess"})
public class PreChecks {

    public static <T> T checkNotNull(T reference, String msg) {
        if (reference == null) {
            throw new NullPointerException(msg);
        }
        return reference;
    }

    public static <T> T checkNotNull(T reference, String msgTemplate, Object... msgArgs) {
        if (reference == null) {
            throw new NullPointerException(format(msgTemplate, msgArgs));
        }
        return reference;
    }

    public static String checkNotBlank(String reference, String msg) {
        if (checkNotNull(reference, msg).trim().length() == 0) {
            throw new IllegalArgumentException(msg);
        }
        return reference;
    }

    public static String checkNotBlank(String reference, String msgTemplate, Object... msgArgs) {
        if (checkNotNull(reference, msgTemplate, msgArgs).trim().length() == 0) {
            throw new IllegalArgumentException(format(msgTemplate, msgArgs));
        }
        return reference;
    }

    public static <T> T checkArgument(T reference, boolean argument, String msg) {
        if (!argument) {
            throw new IllegalArgumentException(msg);
        }
        return reference;
    }

    public static <T> T checkArgument(T reference, boolean argument, String msgTemplate, Object... msgArgs) {
        if (!argument) {
            throw new IllegalArgumentException(format(msgTemplate, msgArgs));
        }
        return reference;
    }

    public static <T extends Map> T checkElementIndex(T reference, int index, String msg) {
        if (!(checkPositiveOrZero(index, msg) < checkNotNull(reference, msg).size())) {
            throw new IndexOutOfBoundsException(msg);
        }
        return reference;
    }

    public static <T extends Map> T checkElementIndex(T reference, int index, String msgTemplate, Object... msgArgs) {
        if (!(checkPositiveOrZero(index, msgTemplate, msgArgs) < checkNotNull(reference, msgTemplate, msgArgs).size())) {
            throw new IndexOutOfBoundsException(format(msgTemplate, msgArgs));
        }
        return reference;
    }

    public static <T extends Collection> T checkElementIndex(T reference, int index, String msg) {
        if (!(checkPositiveOrZero(index, msg) < checkNotNull(reference, msg).size())) {
            throw new IndexOutOfBoundsException(msg);
        }
        return reference;
    }

    public static <T extends Collection> T checkElementIndex(T reference, int index, String msgTemplate, Object... msgArgs) {
        if (!(checkPositiveOrZero(index, msgTemplate, msgArgs) < checkNotNull(reference, msgTemplate, msgArgs).size())) {
            throw new IndexOutOfBoundsException(format(msgTemplate, msgArgs));
        }
        return reference;
    }

    public static String checkElementIndex(String reference, int index, String msg) {
        if (!(checkPositiveOrZero(index, msg) < checkNotNull(reference, msg).length())) {
            throw new IndexOutOfBoundsException(msg);
        }
        return reference;
    }

    public static String checkElementIndex(String reference, int index, String msgTemplate, Object... msgArgs) {
        if (!(checkPositiveOrZero(index, msgTemplate, msgArgs) < checkNotNull(reference, msgTemplate, msgArgs).length())) {
            throw new IndexOutOfBoundsException(format(msgTemplate, msgArgs));
        }
        return reference;
    }

    public static <T extends Map> T checkPositionIndex(T reference, int index, String msg) {
        if (checkPositiveOrZero(index, msg) > checkNotNull(reference, msg).size()) {
            throw new IndexOutOfBoundsException(msg);
        }
        return reference;
    }

    public static <T extends Map> T checkPositionIndex(T reference, int index, String msgTemplate, Object... msgArgs) {
        if (checkPositiveOrZero(index, msgTemplate, msgArgs) > checkNotNull(reference, msgTemplate, msgArgs).size()) {
            throw new IndexOutOfBoundsException(format(msgTemplate, msgArgs));
        }
        return reference;
    }

    public static <T extends List> T checkPositionIndex(T reference, int index, String msg) {
        if (checkPositiveOrZero(index, msg) > checkNotNull(reference, msg).size()) {
            throw new IndexOutOfBoundsException(msg);
        }
        return reference;
    }

    public static <T extends List> T checkPositionIndex(T reference, int index, String msgTemplate, Object... msgArgs) {
        if (checkPositiveOrZero(index, msgTemplate, msgArgs) > checkNotNull(reference, msgTemplate, msgArgs).size()) {
            throw new IndexOutOfBoundsException(format(msgTemplate, msgArgs));
        }
        return reference;
    }

    public static String checkPositionIndex(String reference, int index, String msg) {
        if (checkPositiveOrZero(index, msg) > checkNotNull(reference, msg).length()) {
            throw new IndexOutOfBoundsException(msg);
        }
        return reference;
    }

    public static String checkPositionIndex(String reference, int index, String msgTemplate, Object... msgArgs) {
        if (checkPositiveOrZero(index, msgTemplate, msgArgs) > checkNotNull(reference, msgTemplate, msgArgs).length()) {
            throw new IndexOutOfBoundsException(format(msgTemplate, msgArgs));
        }
        return reference;
    }

    public static <T extends Number & Comparable<T>> T checkRange(T reference, T start, T end, String msg) {
        checkNotNull(reference, msg);
        if (!isInRange(reference, start, end)) {
            throw new IllegalArgumentException(msg);
        }
        return reference;
    }

    public static <T extends Number & Comparable<T>> T checkRange(T reference, T start, T end, String msgTemplate, Object... msgArgs) {
        checkNotNull(reference, msgTemplate, msgArgs);
        if (!isInRange(reference, start, end)) {
            throw new IllegalArgumentException(format(msgTemplate, msgArgs));
        }
        return reference;
    }

    private static <T extends Number & Comparable<T>> boolean isInRange(T reference, T start, T end) {
        if (start == null || end == null) {
            return false;
        }
        int sComp = reference.compareTo(start);
        if (sComp == 0) {
            return true;
        }
        int eComp = reference.compareTo(end);
        if (sComp > 0 && eComp < 0) {
            return true;
        }
        return false;
    }

    public static <T extends Number> T checkPositive(T reference, String msg) {
        if (!(checkNotNull(reference, msg).doubleValue() > 0.0)) {
            throw new IllegalArgumentException(msg);
        }
        return reference;
    }

    public static <T extends Number> T checkPositive(T reference, String msgTemplate, Object... msgArgs) {
        if (!(checkNotNull(reference, msgTemplate, msgArgs).doubleValue() > 0.0)) {
            throw new IllegalArgumentException(format(msgTemplate, msgArgs));
        }
        return reference;
    }

    public static <T extends Number> T checkPositiveOrZero(T reference, String msg) {
        if (!(checkNotNull(reference, msg).doubleValue() >= 0.0)) {
            throw new IllegalArgumentException(msg);
        }
        return reference;
    }

    public static <T extends Number> T checkPositiveOrZero(T reference, String msgTemplate, Object... msgArgs) {
        if (!(checkNotNull(reference, msgTemplate, msgArgs).doubleValue() >= 0.0)) {
            throw new IllegalArgumentException(format(msgTemplate, msgArgs));
        }
        return reference;
    }

    public static <T extends Number> T checkNegative(T reference, String msg) {
        if (!(checkNotNull(reference, msg).doubleValue() < 0.0)) {
            throw new IllegalArgumentException(msg);
        }
        return reference;
    }

    public static <T extends Number> T checkNegative(T reference, String msgTemplate, Object... msgArgs) {
        if (!(checkNotNull(reference, msgTemplate, msgArgs).doubleValue() < 0.0)) {
            throw new IllegalArgumentException(format(msgTemplate, msgArgs));
        }
        return reference;
    }

    public static <T extends Number> T checkNegativeOrZero(T reference, String msg) {
        if (!(checkNotNull(reference, msg).doubleValue() <= 0.0)) {
            throw new IllegalArgumentException(msg);
        }
        return reference;
    }

    public static <T extends Number> T checkNegativeOrZero(T reference, String msgTemplate, Object... msgArgs) {
        if (!(checkNotNull(reference, msgTemplate, msgArgs).doubleValue() <= 0.0)) {
            throw new IllegalArgumentException(format(msgTemplate, msgArgs));
        }
        return reference;
    }

    public static int checkInt(String reference, String msg) {
        return (int) checkDouble(reference, msg);
    }

    public static int checkInt(String reference, String msgTemplate, Object... msgArgs) {
        return (int) checkDouble(reference, msgTemplate, msgArgs);
    }

    public static int checkIntStrictly(String reference, String msg) {
        Double dub = checkDouble(reference, msg);
        if (!dub.toString().endsWith(".0")) {
            throw new NumberFormatException(msg);
        }
        return dub.intValue();
    }

    public static int checkIntStrictly(String reference, String msgTemplate, Object... msgArgs) {
        Double dub = checkDouble(reference, msgTemplate, msgArgs);
        if (!dub.toString().endsWith(".0")) {
            throw new NumberFormatException(format(msgTemplate, msgArgs));
        }
        return dub.intValue();
    }

    public static long checkLong(String reference, String msg) {
        return (long) checkDouble(reference, msg);
    }

    public static long checkLong(String reference, String msgTemplate, Object... msgArgs) {
        return (long) checkDouble(reference, msgTemplate, msgArgs);
    }

    public static float checkFloat(String reference, String msg) {
        return (float) checkDouble(reference, msg);
    }

    public static float checkFloat(String reference, String msgTemplate, Object... msgArgs) {
        return (float) checkDouble(reference, msgTemplate, msgArgs);
    }

    public static double checkDouble(String reference, String msg) {
        checkNotBlank(reference, msg);
        Double dub = Assurances.assureDoubleOrNull(reference);
        if (dub == null) {
            throw new NumberFormatException(msg);
        }
        return dub;
    }

    public static double checkDouble(String reference, String msgTemplate, Object... msgArgs) {
        checkNotBlank(reference, msgTemplate, msgArgs);
        Double dub = Assurances.assureDoubleOrNull(reference);
        if (dub == null) {
            throw new NumberFormatException(format(msgTemplate, msgArgs));
        }
        return dub;
    }
}
