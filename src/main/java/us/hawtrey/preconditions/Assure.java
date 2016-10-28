package us.hawtrey.preconditions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unused", "WeakerAccess", "unchecked"})
public class Assure {

    /**
     * Returns the reference value if it is not {@code null}.
     * Otherwise it will return the default value. The default value may also be
     * {@code null} in which case the return value will be {@code null}.
     *
     * @param reference    an {@code Object} that is validated.
     * @param defaultValue the {@code Object} that is returned when reference is {@code null}.
     * @return the reference object or the default object
     */
    public static <T> T notNull(T reference, T defaultValue) {
        return reference == null ? defaultValue : reference;
    }

    /**
     * Returns the reference value if it is not {@code null}.
     * Otherwise it will return a new instance of the default {@link java.lang.Class}
     *
     * @param reference    the {@code Object} that is validated.
     * @param defaultClass the {@link java.lang.Class} that will be used to instantiate the return object
     * @return the reference object or a new instance of the default class
     * @throws NullPointerException     thrown when both the reference object and the default class are null
     * @throws IllegalArgumentException thrown when the default class is not concrete or
     *                                  it does not have a zero parameter constructor
     */
    public static <T> T notNull(T reference, Class<T> defaultClass) {
        try {
            return reference != null ? reference :
                    Validate.notNull(defaultClass, "Default class provided to assurance can not be NULL").newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new IllegalArgumentException("Unable to instantiate the default class in assurance", e);
        }
    }

    /**
     * Returns the reference value if it is not {@code null}.
     * Otherwise it will return a new empty {@link java.util.ArrayList}.
     *
     * @param reference an {@code Object} that implements {@link java.util.List}
     * @return the reference object or a new empty {@link java.util.ArrayList}.
     */
    public static <C extends List<T>, T> C notNull(C reference) {
        return reference != null ? reference : (C) new ArrayList<T>();
    }

    /**
     * Returns the reference value if it is not {@code null}.
     * Otherwise it will return a new empty {@link java.util.HashSet}.
     *
     * @param reference an {@code Object} that implements {@link java.util.Set}
     * @return the reference object or a new empty {@link java.util.HashSet}.
     */
    public static <C extends Set<T>, T> C notNull(C reference) {
        return reference != null ? reference : (C) new HashSet<T>();
    }

    /**
     * Returns the reference value if it is not {@code null}.
     * Otherwise it will return a new empty {@link java.util.HashMap}.
     *
     * @param reference an {@code Object} that implements {@link java.util.Map}
     * @return the reference object or a new empty {@link java.util.HashMap}.
     */
    public static <M extends Map<K, V>, K, V> M notNull(M reference) {
        return reference != null ? reference : (M) new HashMap<K, V>();
    }

    /**
     * Always returns an {@link java.util.ArrayList}.
     * If the reference object is not null and an {@link java.util.ArrayList} it will return the reference object.
     * If the reference object is not null and not an {@link java.util.ArrayList}
     * it will return a new {@link java.util.ArrayList} containing all elements of the reference object,
     * in the order they are returned by the collection's iterator.
     * Otherwise it will return a new empty {@link java.util.ArrayList}.
     *
     * @param reference an {@code Object} that implements {@link java.util.Collection}
     * @return an {@link java.util.ArrayList}.
     */
    public static <T> ArrayList<T> arrayList(Collection<T> reference) {
        Collection<T> temp = reference != null ? reference : new ArrayList<>();
        return (temp instanceof ArrayList) ? (ArrayList<T>) temp : new ArrayList<>(temp);
    }

    /**
     * Always returns a {@link java.util.LinkedList}.
     * If the reference object is not null and a {@link java.util.LinkedList} it will return the reference object.
     * If the reference object is not null and not a {@link java.util.LinkedList}
     * it will return a new {@link java.util.LinkedList} containing all elements of the reference object,
     * in the order they are returned by the collection's iterator.
     * Otherwise it will return a new empty {@link java.util.LinkedList}.
     *
     * @param reference an {@code Object} that implements {@link java.util.Collection}
     * @return a {@link java.util.LinkedList}.
     */
    public static <T> LinkedList<T> linkedList(Collection<T> reference) {
        Collection<T> temp = reference != null ? reference : new LinkedList<>();
        return (temp instanceof LinkedList) ? (LinkedList<T>) temp : new LinkedList<>(temp);
    }

    /**
     * Always returns a {@link java.util.HashSet}. 
     * If the reference object is not null and a {@link java.util.HashSet} it will return the reference object.
     * If the reference object is not null and not a {@link java.util.HashSet}
     * it will return a new {@link java.util.HashSet} containing all elements of the reference object, 
     * in the order they are returned by the collection's iterator.
     * Otherwise it will return a new empty {@link java.util.HashSet}.
     *
     * @param reference an {@code Object} that implements {@link java.util.Collection}
     * @return a {@link java.util.HashSet}.
     */
    public static <T> HashSet<T> hashSet(Collection<T> reference) {
        Collection<T> temp = reference != null ? reference : new HashSet<>();
        return (temp instanceof HashSet) ? (HashSet<T>) temp : new HashSet<>(temp);
    }

    /**
     * Always returns a {@link java.util.HashMap}. 
     * If the reference object is not null and a {@link java.util.HashMap} it will return the reference object.
     * If the reference object is not null and not a {@link java.util.HashMap}
     * it will return a new {@link java.util.HashMap} with the same mappings as the
     * reference {@link java.util.Map}.
     * Otherwise it will return a new empty {@link java.util.HashMap}.
     *
     * @param reference an {@code Object} that implements {@link java.util.Map}
     * @return a {@link java.util.HashMap}.
     */
    public static <K, V> HashMap<K, V> hashMap(Map<K, V> reference) {
        Map<K, V> temp = reference != null ? reference : new HashMap<>();
        return (temp instanceof HashMap) ? (HashMap<K, V>) temp : new HashMap<>(temp);
    }

    /**
     * Returns a String whose value is the reference String
     * after a {@link java.lang.String#trim()} has been performed.
     * If the reference String is null, an empty String is returned
     *
     * @param reference a {@link java.lang.String} to be evaluated.
     * @return the reference object trimmed of leading and trailing whitespace.
     */
    public static String trimmedOrEmpty(String reference) {
        return notNull(reference, "").trim();
    }

    /**
     * Returns a String whose value is the reference String
     * after a {@link java.lang.String#trim()}
     * and a {@link String#toLowerCase()} have been performed.
     * If the reference String is null, an empty String is returned
     *
     * @param reference a {@link java.lang.String} to be evaluated.
     * @return the reference object trimmed of leading and trailing whitespace and case shifted.
     */
    public static String trimmedLowerOrEmpty(String reference) {
        return trimmedOrEmpty(reference).toLowerCase();
    }

    /**
     * Returns a String whose value is the reference String
     * after a {@link java.lang.String#trim()}
     * and a {@link String#toUpperCase()} have been performed.
     * If the reference String is null, an empty String is returned
     *
     * @param reference a {@link java.lang.String} to be evaluated.
     * @return the reference object trimmed of leading and trailing whitespace and case shifted.
     */
    public static String trimmedUpperOrEmpty(String reference) {
        return trimmedOrEmpty(reference).toUpperCase();
    }

    /**
     * Returns a String whose value is the reference String
     * after a {@link java.lang.String#trim()} has been performed.
     * If the reference String is null, a null is returned
     *
     * @param reference a {@link java.lang.String} to be evaluated.
     * @return the reference object trimmed of leading and trailing whitespace.
     */
    public static String trimmedOrNull(String reference) {
        return (reference == null) ? null : trimmedOrEmpty(reference);
    }

    /**
     * Returns a String whose value is the reference String
     * after a {@link java.lang.String#trim()}
     * and a {@link String#toLowerCase()} have been performed.
     * If the reference String is null, a null is returned
     *
     * @param reference a {@link java.lang.String} to be evaluated.
     * @return the reference object trimmed of leading and trailing whitespace and case shifted.
     */
    public static String trimmedLowerOrNull(String reference) {
        return (reference == null) ? null : trimmedLowerOrEmpty(reference);
    }

    /**
     * Returns a String whose value is the reference String
     * after a {@link java.lang.String#trim()}
     * and a {@link String#toUpperCase()} have been performed.
     * If the reference String is null, a null is returned
     *
     * @param reference a {@link java.lang.String} to be evaluated.
     * @return the reference object trimmed of leading and trailing whitespace and case shifted.
     */
    public static String trimmedUpperOrNull(String reference) {
        return (reference == null) ? null : trimmedUpperOrEmpty(reference);
    }

    /**
     * Returns the {@code int} value of the reference String.
     * If the reference String is not a valid number or is null then {@code 0} is returned.
     *
     * @param reference a {@link java.lang.String} to be evaluated.
     * @return the {@code int} value of the reference String
     */
    public static int intValue(String reference) {
        return (int) doubleValue(reference, 0D);
    }

    /**
     * Returns the {@code int} value of the reference String.
     * If the reference String is not a valid number or is null then the default value is returned.
     *
     * @param reference a {@link java.lang.String} to be evaluated.
     * @return the {@code int} value of the reference String
     */
    public static int intValue(String reference, int defaultValue) {
        return (int) doubleValue(reference, defaultValue);
    }

    /**
     * Returns the {@link java.lang.Integer} value of the reference String.
     * If the reference String is not a valid number or is null then null is returned
     *
     * @param reference a {@link java.lang.String} to be evaluated.
     * @return the {@link java.lang.Integer} value of the reference String
     */
    public static Integer integerOrNull(String reference) {
        Double dub = doubleOrNull(reference);
        return dub == null ? null : dub.intValue();
    }

    /**
     * Returns the {@code long} value of the reference String.
     * If the reference String is not a valid number or is null then {@code 0} is returned.
     *
     * @param reference a {@link java.lang.String} to be evaluated.
     * @return the {@code long} value of the reference String
     */
    public static long longValue(String reference) {
        return (long) doubleValue(reference, 0D);
    }

    /**
     * Returns the {@code long} value of the reference String.
     * If the reference String is not a valid number or is null then the default value is returned.
     *
     * @param reference a {@link java.lang.String} to be evaluated.
     * @return the {@code long} value of the reference String
     */
    public static long longValue(String reference, long defaultValue) {
        return (long) doubleValue(reference, defaultValue);
    }

    /**
     * Returns the {@link java.lang.Long} value of the reference String.
     * If the reference String is not a valid number or is null then null is returned
     *
     * @param reference a {@link java.lang.String} to be evaluated.
     * @return the {@link java.lang.Long} value of the reference String
     */
    public static Long longOrNull(String reference) {
        Double dub = doubleOrNull(reference);
        return dub == null ? null : dub.longValue();
    }

    /**
     * Returns the {@code float} value of the reference String.
     * If the reference String is not a valid number or is null then {@code 0.0} is returned.
     *
     * @param reference a {@link java.lang.String} to be evaluated.
     * @return the {@code float} value of the reference String
     */
    public static float floatValue(String reference) {
        return (float) doubleValue(reference, 0D);
    }

    /**
     * Returns the {@code float} value of the reference String.
     * If the reference String is not a valid number or is null then the default value is returned.
     *
     * @param reference a {@link java.lang.String} to be evaluated.
     * @return the {@code float} value of the reference String
     */
    public static float floatValue(String reference, float defaultValue) {
        return (float) doubleValue(reference, defaultValue);
    }

    /**
     * Returns the {@link java.lang.Float} value of the reference String.
     * If the reference String is not a valid number or is null then null is returned
     *
     * @param reference a {@link java.lang.String} to be evaluated.
     * @return the {@link java.lang.Float} value of the reference String
     */
    public static Float floatOrNull(String reference) {
        Double dub = doubleOrNull(reference);
        return dub == null ? null : dub.floatValue();
    }

    /**
     * Returns the {@code double} value of the reference String.
     * If the reference String is not a valid number or is null then {@code 0.0} is returned.
     *
     * @param reference a {@link java.lang.String} to be evaluated.
     * @return the {@code double} value of the reference String
     */
    public static double doubleValue(String reference) {
        return doubleValue(reference, 0D);
    }

    /**
     * Returns the {@code double} value of the reference String.
     * If the reference String is not a valid number or is null then the default value is returned.
     *
     * @param reference a {@link java.lang.String} to be evaluated.
     * @return the {@code double} value of the reference String
     */
    public static double doubleValue(String reference, double defaultValue) {
        Double dub = doubleOrNull(reference);
        return dub == null ? defaultValue : dub;
    }

    /**
     * Returns the {@link java.lang.Double} value of the reference String.
     * If the reference String is not a valid number or is null then null is returned
     *
     * @param reference a {@link java.lang.String} to be evaluated.
     * @return the {@link java.lang.Double} value of the reference String
     */
    public static Double doubleOrNull(String reference) {
        if (reference == null) return null;
        try {
            return new Double(trimmedOrEmpty(reference));
        } catch (NumberFormatException e) {
            return null;
        }
    }

}
