package us.hawtrey.preconditions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static us.hawtrey.preconditions.PreChecks.checkNotNull;

@SuppressWarnings({"unused", "WeakerAccess"})
public class Assurances {

    public static <T> T assureNotNull(T reference, T defaultValue) {
        return reference == null ? defaultValue : reference;
    }

    public static <T> T assureNotNull(T reference, Class<T> defaultClass) {
        try {
            return reference != null ? reference :
                    checkNotNull(defaultClass, "Default class provided to assurance can not be NULL").newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new IllegalArgumentException("Unable to instantiate the default class in assurance", e);
        }
    }

    @SuppressWarnings("unchecked")
    public static <C extends List<T>, T> C assureNotNull(C reference) {
        return reference != null ? reference : (C) new ArrayList<T>();
    }

    @SuppressWarnings("unchecked")
    public static <C extends Set<T>, T> C assureNotNull(C reference) {
        return reference != null ? reference : (C) new HashSet<T>();
    }

    @SuppressWarnings("unchecked")
    public static <M extends Map<K, V>, K, V> M assureNotNull(M reference) {
        return reference != null ? reference : (M) new HashMap<K, V>();
    }

    public static <T> ArrayList<T> assureArrayList(Collection<T> reference) {
        Collection<T> temp = reference != null ? reference : new ArrayList<>();
        return (temp instanceof ArrayList) ? (ArrayList<T>) temp : new ArrayList<>(temp);
    }

    public static <T> LinkedList<T> assureLinkedList(Collection<T> reference) {
        Collection<T> temp = reference != null ? reference : new LinkedList<>();
        return (temp instanceof LinkedList) ? (LinkedList<T>) temp : new LinkedList<>(temp);
    }

    public static <T> HashSet<T> assureHashSet(Collection<T> reference) {
        Collection<T> temp = reference != null ? reference : new HashSet<>();
        return (temp instanceof HashSet) ? (HashSet<T>) temp : new HashSet<>(temp);
    }

    public static <K, V> HashMap<K, V> assureHashMap(Map<K, V> reference) {
        Map<K, V> temp = reference != null ? reference : new HashMap<>();
        return (temp instanceof HashMap) ? (HashMap<K, V>) temp : new HashMap<>(temp);
    }

    public static String assureTrimOrEmpty(String reference) {
        return assureNotNull(reference, "").trim();
    }

    public static String assureTrimLowerOrEmpty(String reference) {
        return assureTrimOrEmpty(reference).toLowerCase();
    }

    public static String assureTrimUpperOrEmpty(String reference) {
        return assureTrimOrEmpty(reference).toUpperCase();
    }

    public static String assureTrimOrNull(String reference) {
        return getPossibleNullString(assureTrimOrEmpty(reference));
    }

    public static String assureTrimLowerOrNull(String reference) {
        return getPossibleNullString(assureTrimLowerOrEmpty(reference));
    }

    public static String assureTrimUpperOrNull(String reference) {
        return getPossibleNullString(assureTrimUpperOrEmpty(reference));
    }

    private static String getPossibleNullString(String reference) {
        return reference.length() == 0 ? null : reference;
    }

    public static int assureInt(String reference) {
        return assureInt(reference, 0);
    }

    public static int assureInt(String reference, int defaultValue) {
        return (int) assureDouble(reference, defaultValue);
    }

    public static Integer assureIntegerOrNull(String reference) {
        Double dub = assureDoubleOrNull(reference);
        return dub == null ? null : dub.intValue();
    }

    public static long assureLong(String reference) {
        return assureLong(reference, 0L);
    }

    public static long assureLong(String reference, long defaultValue) {
        return (long) assureDouble(reference, defaultValue);
    }

    public static Long assureLongOrNull(String reference) {
        Double dub = assureDoubleOrNull(reference);
        return dub == null ? null : dub.longValue();
    }

    public static float assureFloat(String reference) {
        return assureFloat(reference, 0F);
    }

    public static float assureFloat(String reference, float defaultValue) {
        return (float) assureDouble(reference, defaultValue);
    }

    public static Float assureFloatOrNull(String reference) {
        Double dub = assureDoubleOrNull(reference);
        return dub == null ? null : dub.floatValue();
    }

    public static double assureDouble(String reference) {
        return assureDouble(reference, 0D);
    }

    public static double assureDouble(String reference, double defaultValue) {
        Double dub = assureDoubleOrNull(reference);
        return dub == null ? defaultValue : dub;
    }

    public static Double assureDoubleOrNull(String reference) {
        String ref = assureTrimOrNull(reference);
        if (ref == null) {
            return null;
        }
        boolean hasDecimal = false;
        boolean hasSign = false;
        int size = ref.length();
        for (int i = 0; i < size; i++) {
            char charAt = ref.charAt(i);
            if (charAt == '-' || charAt == '+') {
                if (i != 0 || size == 1) {
                    return null;
                }
                hasSign = true;
            } else if (charAt == '.') {
                if (hasDecimal || size == 1) {
                    return null;
                }
                hasDecimal = true;
            } else if (Character.isWhitespace(charAt)) {
                return null;
            } else if (!Character.isDigit(charAt)) {
                return null;
            }
        }
        if (hasDecimal && hasSign && size == 2) {
            return null;
        }
        return new Double(ref);
    }

}
