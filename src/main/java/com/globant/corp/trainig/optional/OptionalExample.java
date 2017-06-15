package com.globant.corp.trainig.optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OptionalExample {

    public static final String EMPTY_STRING = "";
    public static final String EXCEPTION_MSG = "String value is null";

    public static List<String> optionalFilterListToList(final List<Optional<String>> strings, final String prefix) {
        
       return strings.stream().filter( // filter the list with result of optional filter
                optional -> {
                    // If a value is present, and the value matches the given predicate, return an Optional describing
                    // the
                    // value, otherwise return an empty Optional
                    return optional.filter(string -> string.startsWith(prefix)).isPresent(); // Filtering in the
                    // optional
                }).map(string -> string.get()).collect(Collectors.toList());
    }

    public static void optionalIfPresentSpellString(final String string) {
        // If a value is present, invoke the specified consumer with the value, otherwise do nothing.
        Optional.ofNullable(string).ifPresent(value -> Arrays.asList(string.split("")).forEach(System.out::println));
    }

    public static List<String> optionalMapUpperCase(final List<Optional<String>> strings) {
        final List<Optional<String>> stringsFiltered = strings.stream().filter(optional -> optional.isPresent())
                .collect(Collectors.toList()); // filtering
        // empty
        // optional
        return stringsFiltered.stream()
                .map(string -> string.map(String::toUpperCase)// If a value is present, apply the
                        // provided mapping function to it,
                        // and if the result is non-null,
                        // return an Optional describing
                        // the result. Otherwise return an
                        // empty Optional.
                        .get())
                .collect(Collectors.toList());
    }

    public static boolean optionalOf(final String string) {
        // Returns an Optional with the specified present non-null value.
        // NullPointerException - if value is null
        return Optional.of(string).isPresent();
    }

    public static boolean optionalOfNullable(final String string) {
        // Returns an Optional describing the specified value, if non-null, otherwise returns an empty Optional.
        return Optional.ofNullable(string).isPresent();
    }

    public static String optionalOrElse(final String value) {
        // Return the value if present, otherwise return other.
        return Optional.ofNullable(value).orElse(EMPTY_STRING);
    }

    public static String optionalOrElseGet(final String value) {
        // Return the value if present, otherwise invoke other and return the result of that invocation.
        return Optional.ofNullable(value).orElseGet(() -> EMPTY_STRING);
    }

    public static String optionalOrThrow(final String value) {
        // Return the contained value, if present, otherwise throw an exception to be created by the provided supplier.
        return Optional.ofNullable(value).orElseThrow(() -> new RuntimeException(EXCEPTION_MSG));
    }

}
