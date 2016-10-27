package us.hawtrey.preconditions;

import java.util.Collection;
import java.util.Map;

import static java.lang.String.format;

@SuppressWarnings({"unused", "WeakerAccess"})
public class Validate {
    private static final Object[] NULL_ARGS = null;

    /**
     * Validates that the reference {@code Object} is not null.
     *
     * @param reference the {@code Object} to validate.
     * @param msg       the message to use for the exception.
     * @return the reference {@code Object} if it is valid.
     * @throws NullPointerException thrown if the reference {@code Object} is null.
     */
    public static <T> T notNull(T reference, String msg) {
        return notNull(reference, msg, NULL_ARGS);
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
    public static <T> T notNull(T reference, String msgTemplate, Object... msgArgs) {
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
    public static String notBlank(String reference, String msg) {
        return notBlank(reference, msg, NULL_ARGS);
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
    public static String notBlank(String reference, String msgTemplate, Object... msgArgs) {
        if (notNull(reference, msgTemplate, msgArgs).trim().length() == 0) {
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
    public static <T> T argument(T reference, boolean argument, String msg) {
        return argument(reference, argument, msg, NULL_ARGS);
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
    public static <T> T argument(T reference, boolean argument, String msgTemplate, Object... msgArgs) {
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
    public static <T extends Map> T notEmpty(T reference, String msg) {
        return notEmpty(reference, msg, NULL_ARGS);
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
    public static <T extends Map> T notEmpty(T reference, String msgTemplate, Object... msgArgs) {
        if (notNull(reference, msgTemplate, msgArgs).isEmpty()) {
            throw new IllegalArgumentException(format(msgTemplate, msgArgs));
        }
        return reference;
    }

    /**
     * Validate that the reference {@code Collection} is not empty.
     *
     * @param reference the {@code Collection} to validate.
     * @param msg       the message to use for the exception.
     * @return the reference {@code Collection} if it is valid.
     * @throws IllegalArgumentException thrown if the reference {@code Collection} is empty.
     */
    public static <T extends Collection> T notEmpty(T reference, String msg) {
        return notEmpty(reference, msg, NULL_ARGS);
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
    public static <T extends Collection> T notEmpty(T reference, String msgTemplate, Object... msgArgs) {
        if (notNull(reference, msgTemplate, msgArgs).isEmpty()) {
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
    public static <T extends Map> T elementIndex(T reference, int index, String msg) {
        return elementIndex(reference, index, msg, NULL_ARGS);
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
    public static <T extends Map> T elementIndex(T reference, int index, String msgTemplate, Object... msgArgs) {
        if (!(positiveOrZero(index, msgTemplate, msgArgs) < notNull(reference, msgTemplate, msgArgs).size())) {
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
    public static <T extends Collection> T elementIndex(T reference, int index, String msg) {
        return elementIndex(reference, index, msg, NULL_ARGS);
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
    public static <T extends Collection> T elementIndex(T reference, int index, String msgTemplate, Object... msgArgs) {
        if (!(positiveOrZero(index, msgTemplate, msgArgs) < notNull(reference, msgTemplate, msgArgs).size())) {
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
    public static String elementIndex(String reference, int index, String msg) {
        return elementIndex(reference, index, msg, NULL_ARGS);
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
    public static String elementIndex(String reference, int index, String msgTemplate, Object... msgArgs) {
        if (!(positiveOrZero(index, msgTemplate, msgArgs) < notNull(reference, msgTemplate, msgArgs).length())) {
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
    public static <T extends Map> T positionIndex(T reference, int index, String msg) {
        return positionIndex(reference, index, msg, NULL_ARGS);
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
    public static <T extends Map> T positionIndex(T reference, int index, String msgTemplate, Object... msgArgs) {
        if (positiveOrZero(index, msgTemplate, msgArgs) > notNull(reference, msgTemplate, msgArgs).size()) {
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
    public static <T extends Collection> T positionIndex(T reference, int index, String msg) {
        return positionIndex(reference, index, msg, NULL_ARGS);
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
    public static <T extends Collection> T positionIndex(T reference, int index, String msgTemplate, Object... msgArgs) {
        if (positiveOrZero(index, msgTemplate, msgArgs) > notNull(reference, msgTemplate, msgArgs).size()) {
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
    public static String positionIndex(String reference, int index, String msg) {
        return positionIndex(reference, index, msg, NULL_ARGS);
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
    public static String positionIndex(String reference, int index, String msgTemplate, Object... msgArgs) {
        if (positiveOrZero(index, msgTemplate, msgArgs) > notNull(reference, msgTemplate, msgArgs).length()) {
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
    public static <T extends Number & Comparable<T>> T inRange(T reference, T start, T end, String msg) {
        return inRange(reference, start, end, msg, NULL_ARGS);
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
    public static <T extends Number & Comparable<T>> T inRange(T reference, T start, T end, String msgTemplate, Object... msgArgs) {
        notNull(reference, msgTemplate, msgArgs);
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
    public static <T extends Number> T positive(T reference, String msg) {
        return positive(reference, msg, NULL_ARGS);
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
    public static <T extends Number> T positive(T reference, String msgTemplate, Object... msgArgs) {
        if (!(notNull(reference, msgTemplate, msgArgs).doubleValue() > 0.0)) {
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
    public static <T extends Number> T positiveOrZero(T reference, String msg) {
        return positiveOrZero(reference, msg, NULL_ARGS);
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
    public static <T extends Number> T positiveOrZero(T reference, String msgTemplate, Object... msgArgs) {
        if (!(notNull(reference, msgTemplate, msgArgs).doubleValue() >= 0.0)) {
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
    public static <T extends Number> T negative(T reference, String msg) {
        return negative(reference, msg, NULL_ARGS);
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
    public static <T extends Number> T negative(T reference, String msgTemplate, Object... msgArgs) {
        if (!(notNull(reference, msgTemplate, msgArgs).doubleValue() < 0.0)) {
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
    public static <T extends Number> T negativeOrZero(T reference, String msg) {
        return negativeOrZero(reference, msg, NULL_ARGS);
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
    public static <T extends Number> T negativeOrZero(T reference, String msgTemplate, Object... msgArgs) {
        if (!(notNull(reference, msgTemplate, msgArgs).doubleValue() <= 0.0)) {
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
    public static int intValue(String reference, String msg) {
        return intValue(reference, msg, NULL_ARGS);
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
    public static int intValue(String reference, String msgTemplate, Object... msgArgs) {
        return (int) doubleValue(reference, msgTemplate, msgArgs);
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
    public static int strictlyIntValue(String reference, String msg) {
        return strictlyIntValue(reference, msg, NULL_ARGS);
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
    public static int strictlyIntValue(String reference, String msgTemplate, Object... msgArgs) {
        Double dub = doubleValue(reference, msgTemplate, msgArgs);
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
    public static long longValue(String reference, String msg) {
        return longValue(reference, msg, NULL_ARGS);
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
    public static long longValue(String reference, String msgTemplate, Object... msgArgs) {
        return (long) doubleValue(reference, msgTemplate, msgArgs);
    }

    /**
     * Validates that the reference {@code String} is a valid {@code float}.
     *
     * @param reference the {@code String} to validate.
     * @param msg       the message to use for the exception.
     * @return the {@code float} value of the reference {@code String}.
     * @throws NumberFormatException thrown if the reference {@code String} is not a valid {@code float}.
     */
    public static float floatValue(String reference, String msg) {
        return floatValue(reference, msg, NULL_ARGS);
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
    public static float floatValue(String reference, String msgTemplate, Object... msgArgs) {
        return (float) doubleValue(reference, msgTemplate, msgArgs);
    }

    /**
     * Validates that the reference {@code String} is a valid {@code double}.
     *
     * @param reference the {@code String} to validate.
     * @param msg       the message to use for the exception.
     * @return the {@code double} value of the reference {@code String}.
     * @throws NumberFormatException thrown if the reference {@code String} is not a valid {@code double}.
     */
    public static double doubleValue(String reference, String msg) {
        return doubleValue(reference, msg, NULL_ARGS);
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
    public static double doubleValue(String reference, String msgTemplate, Object... msgArgs) {
        notBlank(reference, msgTemplate, msgArgs);
        Double dub = Assure.doubleOrNull(reference);
        if (dub == null) {
            throw new NumberFormatException(format(msgTemplate, msgArgs));
        }
        return dub;
    }

    public static <T> T instanceOfType(T reference, Class<?> type, String msgTemplate, Object... msgArgs) {
        if (!(notNull(type, msgTemplate, msgArgs).isInstance(notNull(reference, msgTemplate, msgArgs)))) {
            throw new IllegalArgumentException(format(msgTemplate, msgArgs));
        }
        return reference;
    }

    public static Class<?> assignableFromClass(Class<?> reference, Class<?> type, String msgTemplate, Object... msgArgs) {
        if (!(notNull(type, msgTemplate, msgArgs).isAssignableFrom(notNull(reference, msgTemplate, msgArgs)))) {
            throw new IllegalArgumentException(format(msgTemplate, msgArgs));
        }
        return reference;
    }
}
