package us.hawtrey.preconditions;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import static java.lang.String.format;

@SuppressWarnings({"unused", "WeakerAccess"})
public class PreChecks {
    private static final Object[] NULL_ARGS = null;

    public static <T> T checkNotNull(T reference, String msg) {
        return checkNotNull(reference, msg, NULL_ARGS);
    }

    public static <T> T checkNotNull(T reference, String msgTemplate, Object... msgArgs) {
        if (reference == null) {
            throw new NullPointerException(format(msgTemplate, msgArgs));
        }
        return reference;
    }

    public static String checkNotBlank(String reference, String msg) {
        return checkNotBlank(reference, msg, NULL_ARGS);
    }

    public static String checkNotBlank(String reference, String msgTemplate, Object... msgArgs) {
        if (checkNotNull(reference, msgTemplate, msgArgs).trim().length() == 0) {
            throw new IllegalArgumentException(format(msgTemplate, msgArgs));
        }
        return reference;
    }

    public static <T> T checkArgument(T reference, boolean argument, String msg) {
        return checkArgument(reference, argument, msg, NULL_ARGS);
    }

    public static <T> T checkArgument(T reference, boolean argument, String msgTemplate, Object... msgArgs) {
        if (!argument) {
            throw new IllegalArgumentException(format(msgTemplate, msgArgs));
        }
        return reference;
    }

    public static <T extends Map> T checkElementIndex(T reference, int index, String msg) {
        return checkElementIndex(reference, index, msg, NULL_ARGS);
    }

    public static <T extends Map> T checkElementIndex(T reference, int index, String msgTemplate, Object... msgArgs) {
        if (!(checkPositiveOrZero(index, msgTemplate, msgArgs) < checkNotNull(reference, msgTemplate, msgArgs).size())) {
            throw new IndexOutOfBoundsException(format(msgTemplate, msgArgs));
        }
        return reference;
    }

    public static <T extends Collection> T checkElementIndex(T reference, int index, String msg) {
        return checkElementIndex(reference, index, msg, NULL_ARGS);
    }

    public static <T extends Collection> T checkElementIndex(T reference, int index, String msgTemplate, Object... msgArgs) {
        if (!(checkPositiveOrZero(index, msgTemplate, msgArgs) < checkNotNull(reference, msgTemplate, msgArgs).size())) {
            throw new IndexOutOfBoundsException(format(msgTemplate, msgArgs));
        }
        return reference;
    }

    public static String checkElementIndex(String reference, int index, String msg) {
        return checkElementIndex(reference, index, msg, NULL_ARGS);
    }

    public static String checkElementIndex(String reference, int index, String msgTemplate, Object... msgArgs) {
        if (!(checkPositiveOrZero(index, msgTemplate, msgArgs) < checkNotNull(reference, msgTemplate, msgArgs).length())) {
            throw new IndexOutOfBoundsException(format(msgTemplate, msgArgs));
        }
        return reference;
    }

    public static <T extends Map> T checkPositionIndex(T reference, int index, String msg) {
        return checkPositionIndex(reference, index, msg, NULL_ARGS);
    }

    public static <T extends Map> T checkPositionIndex(T reference, int index, String msgTemplate, Object... msgArgs) {
        if (checkPositiveOrZero(index, msgTemplate, msgArgs) > checkNotNull(reference, msgTemplate, msgArgs).size()) {
            throw new IndexOutOfBoundsException(format(msgTemplate, msgArgs));
        }
        return reference;
    }

    public static <T extends List> T checkPositionIndex(T reference, int index, String msg) {
        return checkPositionIndex(reference, index, msg, NULL_ARGS);
    }

    public static <T extends List> T checkPositionIndex(T reference, int index, String msgTemplate, Object... msgArgs) {
        if (checkPositiveOrZero(index, msgTemplate, msgArgs) > checkNotNull(reference, msgTemplate, msgArgs).size()) {
            throw new IndexOutOfBoundsException(format(msgTemplate, msgArgs));
        }
        return reference;
    }

    public static String checkPositionIndex(String reference, int index, String msg) {
        return checkPositionIndex(reference, index, msg, NULL_ARGS);
    }

    public static String checkPositionIndex(String reference, int index, String msgTemplate, Object... msgArgs) {
        if (checkPositiveOrZero(index, msgTemplate, msgArgs) > checkNotNull(reference, msgTemplate, msgArgs).length()) {
            throw new IndexOutOfBoundsException(format(msgTemplate, msgArgs));
        }
        return reference;
    }

    public static <T extends Number & Comparable<T>> T checkRange(T reference, T start, T end, String msg) {
        return checkRange(reference, start, end, msg, NULL_ARGS);
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
        return sComp > 0 && eComp < 0;
    }

    public static <T extends Number> T checkPositive(T reference, String msg) {
        return checkPositive(reference, msg, NULL_ARGS);
    }

    public static <T extends Number> T checkPositive(T reference, String msgTemplate, Object... msgArgs) {
        if (!(checkNotNull(reference, msgTemplate, msgArgs).doubleValue() > 0.0)) {
            throw new IllegalArgumentException(format(msgTemplate, msgArgs));
        }
        return reference;
    }

    public static <T extends Number> T checkPositiveOrZero(T reference, String msg) {
        return checkPositiveOrZero(reference, msg, NULL_ARGS);
    }

    public static <T extends Number> T checkPositiveOrZero(T reference, String msgTemplate, Object... msgArgs) {
        if (!(checkNotNull(reference, msgTemplate, msgArgs).doubleValue() >= 0.0)) {
            throw new IllegalArgumentException(format(msgTemplate, msgArgs));
        }
        return reference;
    }

    public static <T extends Number> T checkNegative(T reference, String msg) {
        return checkNegative(reference, msg, NULL_ARGS);
    }

    public static <T extends Number> T checkNegative(T reference, String msgTemplate, Object... msgArgs) {
        if (!(checkNotNull(reference, msgTemplate, msgArgs).doubleValue() < 0.0)) {
            throw new IllegalArgumentException(format(msgTemplate, msgArgs));
        }
        return reference;
    }

    public static <T extends Number> T checkNegativeOrZero(T reference, String msg) {
        return checkNegativeOrZero(reference, msg, NULL_ARGS);
    }

    public static <T extends Number> T checkNegativeOrZero(T reference, String msgTemplate, Object... msgArgs) {
        if (!(checkNotNull(reference, msgTemplate, msgArgs).doubleValue() <= 0.0)) {
            throw new IllegalArgumentException(format(msgTemplate, msgArgs));
        }
        return reference;
    }

    public static int checkInt(String reference, String msg) {
        return checkInt(reference, msg, NULL_ARGS);
    }

    public static int checkInt(String reference, String msgTemplate, Object... msgArgs) {
        return (int) checkDouble(reference, msgTemplate, msgArgs);
    }

    public static int checkIntStrictly(String reference, String msg) {
        return checkIntStrictly(reference, msg, NULL_ARGS);
    }

    public static int checkIntStrictly(String reference, String msgTemplate, Object... msgArgs) {
        Double dub = checkDouble(reference, msgTemplate, msgArgs);
        if (!dub.toString().endsWith(".0")) {
            throw new NumberFormatException(format(msgTemplate, msgArgs));
        }
        return dub.intValue();
    }

    public static long checkLong(String reference, String msg) {
        return checkLong(reference, msg, NULL_ARGS);
    }

    public static long checkLong(String reference, String msgTemplate, Object... msgArgs) {
        return (long) checkDouble(reference, msgTemplate, msgArgs);
    }

    public static float checkFloat(String reference, String msg) {
        return checkFloat(reference, msg, NULL_ARGS);
    }

    public static float checkFloat(String reference, String msgTemplate, Object... msgArgs) {
        return (float) checkDouble(reference, msgTemplate, msgArgs);
    }

    public static double checkDouble(String reference, String msg) {
        return checkDouble(reference, msg, NULL_ARGS);
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
