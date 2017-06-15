package com.globant.corp.trainig.map;

import java.util.HashMap;
import java.util.Map;

public class MapExample {

    public static final String DEFAULT_VALUE = "DefaultValue";
    private final Map<String, String> MAP = new HashMap<>();

    public MapExample() {
        for (int i = 0; i < 5; i++) {
            MAP.put("key" + i, "value" + i);
        }
    }

    public int computeIfAbsent(final String key, final String value) {
        // If the specified key is not already associated with a value (or is mapped to null), attempts to compute its
        // value using the given mapping function and enters it into this map unless null.
        MAP.computeIfAbsent(key, val -> String.format("(%s) %s", key, value));
        return printMapWithEntrySet();
    }

    public int computeIfPresent(final String key, final String value) {
        // If the value for the specified key is present and non-null, attempts to compute a new mapping given the key
        // and its current mapped value.
        MAP.computeIfPresent(key, (k, v) -> String.format("(%s) %s -> %s", k, v, value));
        return printMapWithEntrySet();
    }

    public String getNotNullValue(final String key) {
        // Returns the value to which the specified key is mapped, or defaultValue if this map contains no mapping for
        // the key.
        return MAP.getOrDefault(key, DEFAULT_VALUE);
    }

    public int mapSize() {
        return MAP.size();
    }

    public int printMapWithEntrySet() {
        MAP.entrySet().stream().forEach(entry -> System.out
                .print(String.format("Row[Key: %s <-->Value: %s]\n", entry.getKey(), entry.getValue())));
        return MAP.size();
    }

    public int printMapWithForEach() {
        // Performs the given action for each entry in this map until all entries have been processed or the action
        // throws an exception.
        MAP.forEach((k, v) -> System.out.print(String.format("Row[Key: %s <-->Value: %s]\n", k, v)));
        return MAP.size();
    }

    public int putIfAbsent(final String key, final String value) {
        // If the specified key is not already associated with a value (or is mapped to null) associates it with the
        // given value and returns null, else returns the current value.
        MAP.putIfAbsent(key, value);
        return printMapWithEntrySet();
    }
}
