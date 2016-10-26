package us.hawtrey.preconditions;

import java.util.Collection;
import java.util.Map;

import static java.lang.String.format;

@SuppressWarnings({"unused", "WeakerAccess"})
public class PreChecks {
    private static final Object[] NULL_ARGS = null;

    /**
     * Validates that the reference {@code Object} is not null.
     *
     * @param reference the {@code Object} to validate.
     * @param msg       the message to use for the exception.
     * @return the reference {@code Object} if it is valid.
     * @throws NullPointerException thrown if the reference {@code Object} is null.
     */
    public static <T> T checkNotNull(T reference, String msg) {
        return checkNotNull(reference, msg, NULL_ARGS);
    }

    /**
     * Validates that the reference {@code Object} is not null.
     *
     * @param reference   the {@code Object} to validate.
     * @param msgTemplate the message template used to format the message for the exception.
     * @param msgArgs     the message arguments used to format the message for the exception.
     * @return the reference {@code Object} if it is valid.
     * @throws NullPointerException thrown if the reference {@code Object} is null.
     */
    public static <T> T checkNotNull(T reference, String msgTemplate, Object... msgArgs) {
        if (reference == null) {
            throw new NullPointerException(format(msgTemplate, msgArgs));
        }
        return reference;
    }

    /**
     * Validates that the reference {@code String} is not null and not empty or just whitespace.
     *
     * @param reference the {@code String} to validate.
     * @param msg       the message to use for the exception.
     * @return the reference {@code String} if it is valid.
     * @throws IllegalArgumentException thrown if the reference {@code String} is null.
     */
    public static String checkNotBlank(String reference, String msg) {
        return checkNotBlank(reference, msg, NULL_ARGS);
    }

    /**
     * Validates that the reference {@code String} is not null and not empty or just whitespace.
     *
     * @param reference   the {@code String} to validate.
     * @param msgTemplate the message template used to format the message for the exception.
     * @param msgArgs     the message arguments used to format the message for the exception.
     * @return the reference {@code String} if it is valid.
     * @throws IllegalArgumentException thrown if the reference {@code String} is null.
     */
    public static String checkNotBlank(String reference, String msgTemplate, Object... msgArgs) {
        if (checkNotNull(reference, msgTemplate, msgArgs).trim().length() == 0) {
            throw new IllegalArgumentException(format(msgTemplate, msgArgs));
        }
        return reference;
    }

    /**
     * Validates that the argument is {@code true}.
     *
     * @param reference the {@code Object} returned if the argument is {@code true}.
     * @param argument  the {@code boolean} to evaluate.
     * @param msg       the message to use for the exception.
     * @return the reference {@code Object} if the argument is valid
     * @throws IllegalArgumentException thrown if the reference {@code String} is null
     */
    public static <T> T checkArgument(T reference, boolean argument, String msg) {
        return checkArgument(reference, argument, msg, NULL_ARGS);
    }

    /**
     * Validates that the argument is {@code true}.
     *
     * @param reference   the {@code Object} returned if the argument is {@code true}.
     * @param argument    the {@code boolean} to evaluate.
     * @param msgTemplate the message template used to format the message for the exception.
     * @param msgArgs     the message arguments used to format the message for the exception.
     * @return the reference {@code Object} if the argument is valid
     * @throws IllegalArgumentException thrown if the reference {@code String} is null
     */
    public static <T> T checkArgument(T reference, boolean argument, String msgTemplate, Object... msgArgs) {
        if (!argument) {
            throw new IllegalArgumentException(format(msgTemplate, msgArgs));
        }
        return reference;
    }

    /**
     * Validate that the reference {@code Map} is not empty.
     *
     * @param reference the {@code Map} to validate.
     * @param msg       the message to use for the exception.
     * @return the reference {@code Map} if it is valid.
     * @throws IllegalArgumentException thrown if the reference {@code Map} is empty.
     */
    public static <T extends Map> T checkNotEmpty(T reference, String msg) {
        return checkNotEmpty(reference, msg, NULL_ARGS);
    }

    /**
     * Validate that the reference {@code Map} is not empty.
     *
     * @param reference   the {@code Map} to validate.
     * @param msgTemplate the message template used to format the message for the exception.
     * @param msgArgs     the message arguments used to format the message for the exception.
     * @return the reference {@code Map} if it is valid.
     * @throws IllegalArgumentException thrown if the reference {@code Map} is empty.
     */
    public static <T extends Map> T checkNotEmpty(T reference, String msgTemplate, Object... msgArgs) {
        if (checkNotNull(reference, msgTemplate, msgArgs).isEmpty()) {
            throw new IllegalArgumentException(format(msgTemplate, msgArgs));
        }
        return reference;
    }

    /**
     * Validate that the reference {@code Collection} is not empty.
     *
     * @param reference   the {@code Collection} to validate.
     * @param msg       the message to use for the exception.
     * @return the reference {@code Collection} if it is valid.
     * @throws IllegalArgumentException thrown if the reference {@code Collection} is empty.
     */
    public static <T extends Collection> T checkNotEmpty(T reference, String msg) {
        return checkNotEmpty(reference, msg, NULL_ARGS);
    }

    /**
     * Validate that the reference {@code Collection} is not empty.
     *
     * @param reference   the {@code Collection} to validate.
     * @param msgTemplate the message template used to format the message for the exception.
     * @param msgArgs     the message arguments used to format the message for the exception.
     * @return the reference {@code Collection} if it is valid.
     * @throws IllegalArgumentException thrown if the reference {@code Collection} is empty.
     */
    public static <T extends Collection> T checkNotEmpty(T reference, String msgTemplate, Object... msgArgs) {
        if (checkNotNull(reference, msgTemplate, msgArgs).isEmpty()) {
            throw new IllegalArgumentException(format(msgTemplate, msgArgs));
        }
        return reference;
    }

    /**
     * Validate that {@code index} specifies a valid element index in the reference {@code Map}.
     * An element index may range from zero, inclusive, to {@code Map.size()}, exclusive.
     *
     * @param reference the {@code Map} to validate.
     * @param index     the element index to use in the validation
     * @param msg       the message to use for the exception.
     * @return the reference {@code Map} if it is valid.
     * @throws IndexOutOfBoundsException thrown if the {@code index} is not valid for the reference {@code Map}.
     */
    public static <T extends Map> T checkElementIndex(T reference, int index, String msg) {
        return checkElementIndex(reference, index, msg, NULL_ARGS);
    }

    /**
     * Validate that {@code index} specifies a valid element index in the reference {@code Map}.
     * An element index may range from zero, inclusive, to {@code Map.size()}, exclusive.
     *
     * @param reference   the {@code Map} to validate.
     * @param index       the element index to use in the validation
     * @param msgTemplate the message template used to format the message for the exception.
     * @param msgArgs     the message arguments used to format the message for the exception.
     * @return the reference {@code Map} if it is valid.
     * @throws IndexOutOfBoundsException thrown if the {@code index} is not valid for the reference {@code Map}.
     */
    public static <T extends Map> T checkElementIndex(T reference, int index, String msgTemplate, Object... msgArgs) {
        if (!(checkPositiveOrZero(index, msgTemplate, msgArgs) < checkNotNull(reference, msgTemplate, msgArgs).size())) {
            throw new IndexOutOfBoundsException(format(msgTemplate, msgArgs));
        }
        return reference;
    }

    /**
     * Validate that {@code index} specifies a valid element index in the reference {@code Collection}.
     * An element index may range from zero, inclusive, to {@code Collection.size()}, exclusive.
     *
     * @param reference the {@code Collection} to validate.
     * @param index     the element index to use in the validation
     * @param msg       the message to use for the exception.
     * @return the reference {@code Collection} if it is valid.
     * @throws IndexOutOfBoundsException thrown if the {@code index} is not valid for the reference {@code Collection}.
     */
    public static <T extends Collection> T checkElementIndex(T reference, int index, String msg) {
        return checkElementIndex(reference, index, msg, NULL_ARGS);
    }

    /**
     * Validate that {@code index} specifies a valid element index in the reference {@code Collection}.
     * An element index may range from zero, inclusive, to {@code Collection.size()}, exclusive.
     *
     * @param reference   the {@code Collection} to validate.
     * @param index       the element index to use in the validation
     * @param msgTemplate the message template used to format the message for the exception.
     * @param msgArgs     the message arguments used to format the message for the exception.
     * @return the reference {@code Collection} if it is valid.
     * @throws IndexOutOfBoundsException thrown if the {@code index} is not valid for the reference {@code Collection}.
     */
    public static <T extends Collection> T checkElementIndex(T reference, int index, String msgTemplate, Object... msgArgs) {
        if (!(checkPositiveOrZero(index, msgTemplate, msgArgs) < checkNotNull(reference, msgTemplate, msgArgs).size())) {
            throw new IndexOutOfBoundsException(format(msgTemplate, msgArgs));
        }
        return reference;
    }

    /**
     * Validate that {@code index} specifies a valid element index in the reference {@code String}.
     * An element index may range from zero, inclusive, to {@code String.length()}, exclusive.
     *
     * @param reference the {@code String} to validate.
     * @param index     the element index to use in the validation
     * @param msg       the message to use for the exception.
     * @return the reference {@code String} if it is valid.
     * @throws IndexOutOfBoundsException thrown if the {@code index} is not valid for the reference {@code String}.
     */
    public static String checkElementIndex(String reference, int index, String msg) {
        return checkElementIndex(reference, index, msg, NULL_ARGS);
    }

    /**
     * Validate that {@code index} specifies a valid element index in the reference {@code String}.
     * An element index may range from zero, inclusive, to {@code String.length()}, exclusive.
     *
     * @param reference   the {@code String} to validate.
     * @param index       the element index to use in the validation
     * @param msgTemplate the message template used to format the message for the exception.
     * @param msgArgs     the message arguments used to format the message for the exception.
     * @return the reference {@code String} if it is valid.
     * @throws IndexOutOfBoundsException thrown if the {@code index} is not valid for the reference {@code String}.
     */
    public static String checkElementIndex(String reference, int index, String msgTemplate, Object... msgArgs) {
        if (!(checkPositiveOrZero(index, msgTemplate, msgArgs) < checkNotNull(reference, msgTemplate, msgArgs).length())) {
            throw new IndexOutOfBoundsException(format(msgTemplate, msgArgs));
        }
        return reference;
    }

    /**
     * Validate that {@code index} specifies a valid position index in the reference {@code Map}.
     * A position index may range from zero, inclusive, to {@code Map.size()}, inclusive.
     *
     * @param reference the {@code Map} to validate.
     * @param index     the position index to use in the validation
     * @param msg       the message to use for the exception.
     * @return the reference {@code Map} if it is valid.
     * @throws IndexOutOfBoundsException thrown if the {@code index} is not valid for the reference {@code Map}.
     */
    public static <T extends Map> T checkPositionIndex(T reference, int index, String msg) {
        return checkPositionIndex(reference, index, msg, NULL_ARGS);
    }

    /**
     * Validate that {@code index} specifies a valid position index in the reference {@code Map}.
     * A position index may range from zero, inclusive, to {@code Map.size()}, inclusive.
     *
     * @param reference   the {@code Map} to validate.
     * @param index       the position index to use in the validation
     * @param msgTemplate the message template used to format the message for the exception.
     * @param msgArgs     the message arguments used to format the message for the exception.
     * @return the reference {@code Map} if it is valid.
     * @throws IndexOutOfBoundsException thrown if the {@code index} is not valid for the reference {@code Map}.
     */
    public static <T extends Map> T checkPositionIndex(T reference, int index, String msgTemplate, Object... msgArgs) {
        if (checkPositiveOrZero(index, msgTemplate, msgArgs) > checkNotNull(reference, msgTemplate, msgArgs).size()) {
            throw new IndexOutOfBoundsException(format(msgTemplate, msgArgs));
        }
        return reference;
    }

    /**
     * Validate that {@code index} specifies a valid position index in the reference {@code Collection}.
     * A position index may range from zero, inclusive, to {@code Collection.size()}, inclusive.
     *
     * @param reference the {@code Collection} to validate.
     * @param index     the position index to use in the validation
     * @param msg       the message to use for the exception.
     * @return the reference {@code Collection} if it is valid.
     * @throws IndexOutOfBoundsException thrown if the {@code index} is not valid for the reference {@code Collection}.
     */
    public static <T extends Collection> T checkPositionIndex(T reference, int index, String msg) {
        return checkPositionIndex(reference, index, msg, NULL_ARGS);
    }

    /**
     * Validate that {@code index} specifies a valid position index in the reference {@code Collection}.
     * A position index may range from zero, inclusive, to {@code Collection.size()}, inclusive.
     *
     * @param reference   the {@code Collection} to validate.
     * @param index       the position index to use in the validation
     * @param msgTemplate the message template used to format the message for the exception.
     * @param msgArgs     the message arguments used to format the message for the exception.
     * @return the reference {@code Collection} if it is valid.
     * @throws IndexOutOfBoundsException thrown if the {@code index} is not valid for the reference {@code Collection}.
     */
    public static <T extends Collection> T checkPositionIndex(T reference, int index, String msgTemplate, Object... msgArgs) {
        if (checkPositiveOrZero(index, msgTemplate, msgArgs) > checkNotNull(reference, msgTemplate, msgArgs).size()) {
            throw new IndexOutOfBoundsException(format(msgTemplate, msgArgs));
        }
        return reference;
    }

    /**
     * Validate that {@code index} specifies a valid position index in the reference {@code String}.
     * A position index may range from zero, inclusive, to {@code String.length()}, inclusive.
     *
     * @param reference the {@code String} to validate.
     * @param index     the position index to use in the validation
     * @param msg       the message to use for the exception.
     * @return the reference {@code String} if it is valid.
     * @throws IndexOutOfBoundsException thrown if the {@code index} is not valid for the reference {@code String}.
     */
    public static String checkPositionIndex(String reference, int index, String msg) {
        return checkPositionIndex(reference, index, msg, NULL_ARGS);
    }

    /**
     * Validate that {@code index} specifies a valid position index in the reference {@code String}.
     * A position index may range from zero, inclusive, to {@code String.length()}, inclusive.
     *
     * @param reference   the {@code String} to validate.
     * @param index       the position index to use in the validation
     * @param msgTemplate the message template used to format the message for the exception.
     * @param msgArgs     the message arguments used to format the message for the exception.
     * @return the reference {@code String} if it is valid.
     * @throws IndexOutOfBoundsException thrown if the {@code index} is not valid for the reference {@code String}.
     */
    public static String checkPositionIndex(String reference, int index, String msgTemplate, Object... msgArgs) {
        if (checkPositiveOrZero(index, msgTemplate, msgArgs) > checkNotNull(reference, msgTemplate, msgArgs).length()) {
            throw new IndexOutOfBoundsException(format(msgTemplate, msgArgs));
        }
        return reference;
    }

    /**
     * Validate that the reference {@code Number} falls within the range.
     * The range is from {@code start}, inclusive, to {@code end}, exclusive.
     *
     * @param reference the {@code Number} to validate.
     * @param start     the starting {@code Number} for the range.
     * @param end       the ending {@code Number} for the range.
     * @param msg       the message to use for the exception.
     * @return the reference {@code Number} if it is valid.
     * @throws IllegalArgumentException thrown if the reference {@code Number} falls outside of the range.
     */
    public static <T extends Number & Comparable<T>> T checkRange(T reference, T start, T end, String msg) {
        return checkRange(reference, start, end, msg, NULL_ARGS);
    }

    /**
     * Validate that the reference {@code Number} falls within the range.
     * The range is from {@code start}, inclusive, to {@code end}, exclusive.
     *
     * @param reference   the {@code Number} to validate.
     * @param start       the starting {@code Number} for the range.
     * @param end         the ending {@code Number} for the range.
     * @param msgTemplate the message template used to format the message for the exception.
     * @param msgArgs     the message arguments used to format the message for the exception.
     * @return the reference {@code Number} if it is valid.
     * @throws IllegalArgumentException thrown if the reference {@code Number} falls outside of the range.
     */
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

    /**
     * Validate that the reference {@code Number} is greater than {@code 0}.
     *
     * @param reference the {@code Number} to validate.
     * @param msg       the message to use for the exception.
     * @return the reference {@code Number} if it is valid.
     * @throws IllegalArgumentException thrown if the reference {@code Number} is less than or equal to {@code 0}.
     */
    public static <T extends Number> T checkPositive(T reference, String msg) {
        return checkPositive(reference, msg, NULL_ARGS);
    }

    /**
     * Validate that the reference {@code Number} is greater than {@code 0}.
     *
     * @param reference   the {@code Number} to validate.
     * @param msgTemplate the message template used to format the message for the exception.
     * @param msgArgs     the message arguments used to format the message for the exception.
     * @return the reference {@code Number} if it is valid.
     * @throws IllegalArgumentException thrown if the reference {@code Number} is less than or equal to {@code 0}.
     */
    public static <T extends Number> T checkPositive(T reference, String msgTemplate, Object... msgArgs) {
        if (!(checkNotNull(reference, msgTemplate, msgArgs).doubleValue() > 0.0)) {
            throw new IllegalArgumentException(format(msgTemplate, msgArgs));
        }
        return reference;
    }

    /**
     * Validate that the reference {@code Number} is greater than or equal to {@code 0}.
     *
     * @param reference the {@code Number} to validate.
     * @param msg       the message to use for the exception.
     * @return the reference {@code Number} if it is valid.
     * @throws IllegalArgumentException thrown if the reference {@code Number} is less than {@code 0}.
     */
    public static <T extends Number> T checkPositiveOrZero(T reference, String msg) {
        return checkPositiveOrZero(reference, msg, NULL_ARGS);
    }

    /**
     * Validate that the reference {@code Number} is greater than or equal to {@code 0}.
     *
     * @param reference   the {@code Number} to validate.
     * @param msgTemplate the message template used to format the message for the exception.
     * @param msgArgs     the message arguments used to format the message for the exception.
     * @return the reference {@code Number} if it is valid.
     * @throws IllegalArgumentException thrown if the reference {@code Number} is less than {@code 0}.
     */
    public static <T extends Number> T checkPositiveOrZero(T reference, String msgTemplate, Object... msgArgs) {
        if (!(checkNotNull(reference, msgTemplate, msgArgs).doubleValue() >= 0.0)) {
            throw new IllegalArgumentException(format(msgTemplate, msgArgs));
        }
        return reference;
    }

    /**
     * Validate that the reference {@code Number} is less than {@code 0}.
     *
     * @param reference the {@code Number} to validate.
     * @param msg       the message to use for the exception.
     * @return the reference {@code Number} if it is valid.
     * @throws IllegalArgumentException thrown if the reference {@code Number} is greater than or equal to {@code 0}.
     */
    public static <T extends Number> T checkNegative(T reference, String msg) {
        return checkNegative(reference, msg, NULL_ARGS);
    }

    /**
     * Validate that the reference {@code Number} is less than {@code 0}.
     *
     * @param reference   the {@code Number} to validate.
     * @param msgTemplate the message template used to format the message for the exception.
     * @param msgArgs     the message arguments used to format the message for the exception.
     * @return the reference {@code Number} if it is valid.
     * @throws IllegalArgumentException thrown if the reference {@code Number} is greater than or equal to {@code 0}.
     */
    public static <T extends Number> T checkNegative(T reference, String msgTemplate, Object... msgArgs) {
        if (!(checkNotNull(reference, msgTemplate, msgArgs).doubleValue() < 0.0)) {
            throw new IllegalArgumentException(format(msgTemplate, msgArgs));
        }
        return reference;
    }

    /**
     * Validate that the reference {@code Number} is less than or equal to {@code 0}.
     *
     * @param reference the {@code Number} to validate.
     * @param msg       the message to use for the exception.
     * @return the reference {@code Number} if it is valid.
     * @throws IllegalArgumentException thrown if the reference {@code Number} is greater than {@code 0}.
     */
    public static <T extends Number> T checkNegativeOrZero(T reference, String msg) {
        return checkNegativeOrZero(reference, msg, NULL_ARGS);
    }

    /**
     * Validate that the reference {@code Number} is less than or equal to {@code 0}.
     *
     * @param reference   the {@code Number} to validate.
     * @param msgTemplate the message template used to format the message for the exception.
     * @param msgArgs     the message arguments used to format the message for the exception.
     * @return the reference {@code Number} if it is valid.
     * @throws IllegalArgumentException thrown if the reference {@code Number} is greater than {@code 0}.
     */
    public static <T extends Number> T checkNegativeOrZero(T reference, String msgTemplate, Object... msgArgs) {
        if (!(checkNotNull(reference, msgTemplate, msgArgs).doubleValue() <= 0.0)) {
            throw new IllegalArgumentException(format(msgTemplate, msgArgs));
        }
        return reference;
    }

    /**
     * Validates that the reference {@code String} is a valid {@code int}.
     *
     * @param reference the {@code String} to validate.
     * @param msg       the message to use for the exception.
     * @return the {@code int} value of the reference {@code String}.
     * @throws NumberFormatException thrown if the reference {@code String} is not a valid {@code int}.
     */
    public static int checkInt(String reference, String msg) {
        return checkInt(reference, msg, NULL_ARGS);
    }

    /**
     * Validates that the reference {@code String} is a valid {@code int}.
     *
     * @param reference   the {@code String} to validate.
     * @param msgTemplate the message template used to format the message for the exception.
     * @param msgArgs     the message arguments used to format the message for the exception.
     * @return the {@code int} value of the reference {@code String}.
     * @throws NumberFormatException thrown if the reference {@code String} is not a valid {@code int}.
     */
    public static int checkInt(String reference, String msgTemplate, Object... msgArgs) {
        return (int) checkDouble(reference, msgTemplate, msgArgs);
    }

    /**
     * Validates that the reference {@code String} is a valid {@code int}.
     * The strict validation ensures that reference {@code String} represents a whole number.
     *
     * @param reference the {@code String} to validate.
     * @param msg       the message to use for the exception.
     * @return the {@code int} value of the reference {@code String}.
     * @throws NumberFormatException thrown if the reference {@code String} is not a valid {@code int}.
     */
    public static int checkIntStrictly(String reference, String msg) {
        return checkIntStrictly(reference, msg, NULL_ARGS);
    }

    /**
     * Validates that the reference {@code String} is a valid {@code int}.
     * The strict validation ensures that reference {@code String} represents a whole number.
     *
     * @param reference   the {@code String} to validate.
     * @param msgTemplate the message template used to format the message for the exception.
     * @param msgArgs     the message arguments used to format the message for the exception.
     * @return the {@code int} value of the reference {@code String}.
     * @throws NumberFormatException thrown if the reference {@code String} is not a valid {@code int}.
     */
    public static int checkIntStrictly(String reference, String msgTemplate, Object... msgArgs) {
        Double dub = checkDouble(reference, msgTemplate, msgArgs);
        if (!dub.toString().endsWith(".0")) {
            throw new NumberFormatException(format(msgTemplate, msgArgs));
        }
        return dub.intValue();
    }

    /**
     * Validates that the reference {@code String} is a valid {@code long}.
     *
     * @param reference the {@code String} to validate.
     * @param msg       the message to use for the exception.
     * @return the {@code long} value of the reference {@code String}.
     * @throws NumberFormatException thrown if the reference {@code String} is not a valid {@code long}.
     */
    public static long checkLong(String reference, String msg) {
        return checkLong(reference, msg, NULL_ARGS);
    }

    /**
     * Validates that the reference {@code String} is a valid {@code long}.
     *
     * @param reference   the {@code String} to validate.
     * @param msgTemplate the message template used to format the message for the exception.
     * @param msgArgs     the message arguments used to format the message for the exception.
     * @return the {@code long} value of the reference {@code String}.
     * @throws NumberFormatException thrown if the reference {@code String} is not a valid {@code long}.
     */
    public static long checkLong(String reference, String msgTemplate, Object... msgArgs) {
        return (long) checkDouble(reference, msgTemplate, msgArgs);
    }

    /**
     * Validates that the reference {@code String} is a valid {@code float}.
     *
     * @param reference the {@code String} to validate.
     * @param msg       the message to use for the exception.
     * @return the {@code float} value of the reference {@code String}.
     * @throws NumberFormatException thrown if the reference {@code String} is not a valid {@code float}.
     */
    public static float checkFloat(String reference, String msg) {
        return checkFloat(reference, msg, NULL_ARGS);
    }

    /**
     * Validates that the reference {@code String} is a valid {@code float}.
     *
     * @param reference   the {@code String} to validate.
     * @param msgTemplate the message template used to format the message for the exception.
     * @param msgArgs     the message arguments used to format the message for the exception.
     * @return the {@code float} value of the reference {@code String}.
     * @throws NumberFormatException thrown if the reference {@code String} is not a valid {@code float}.
     */
    public static float checkFloat(String reference, String msgTemplate, Object... msgArgs) {
        return (float) checkDouble(reference, msgTemplate, msgArgs);
    }

    /**
     * Validates that the reference {@code String} is a valid {@code double}.
     *
     * @param reference the {@code String} to validate.
     * @param msg       the message to use for the exception.
     * @return the {@code double} value of the reference {@code String}.
     * @throws NumberFormatException thrown if the reference {@code String} is not a valid {@code double}.
     */
    public static double checkDouble(String reference, String msg) {
        return checkDouble(reference, msg, NULL_ARGS);
    }

    /**
     * Validates that the reference {@code String} is a valid {@code double}.
     *
     * @param reference   the {@code String} to validate.
     * @param msgTemplate the message template used to format the message for the exception.
     * @param msgArgs     the message arguments used to format the message for the exception.
     * @return the {@code double} value of the reference {@code String}.
     * @throws NumberFormatException thrown if the reference {@code String} is not a valid {@code double}.
     */
    public static double checkDouble(String reference, String msgTemplate, Object... msgArgs) {
        checkNotBlank(reference, msgTemplate, msgArgs);
        Double dub = Assurances.assureDoubleOrNull(reference);
        if (dub == null) {
            throw new NumberFormatException(format(msgTemplate, msgArgs));
        }
        return dub;
    }
}
