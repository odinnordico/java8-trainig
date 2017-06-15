package com.globant.corp.trainig.optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class OptionalExampleTest {

    @Test
    public void optionalFilterListToListTest() {
        final String prefix = "a";
        final List<Optional<String>> optionalList = new ArrayList<>();
        optionalList.add(Optional.of(null));// 1st element empty
        optionalList.add(Optional.of(prefix + "1st element"));// 2nd element match with prefix
        optionalList.add(Optional.of("3rd element"));// 3rd element don't match with prefix
        optionalList.add(Optional.of(prefix + "4th element"));// 4th element match with prefix
        optionalList.add(Optional.empty());// 5th element empty
        optionalList.add(Optional.of("6th element"));// 6th element don't match with prefix
        final List<String> strings = OptionalExample.optionalFilterListToList(optionalList, prefix);
        strings.forEach(System.out::println);
        assertEquals(2, strings.size());
    }

    @Test
    public void optionalIfPresentSpellStringTest() {
        try {
            OptionalExample.optionalIfPresentSpellString("STRING");
        } catch (final Exception e) {
            fail("Value is not null, should work");
        }

        try {
            OptionalExample.optionalIfPresentSpellString(null);
        } catch (final Exception e) {
            fail("Value is null but consumer is not");
        }
    }

    @Test
    public void optionalMapUpperCaseTest() {
        final String second = "1st element";
        final String fourth = "4th element";
        final List<Optional<String>> optionalList = new ArrayList<>();
        optionalList.add(Optional.empty()); // 1st element empty
        optionalList.add(Optional.of(second)); // 2nd element not empty
        optionalList.add(Optional.empty()); // 3rd element empty
        optionalList.add(Optional.of(fourth));// 4th element not empty
        final List<String> strings = OptionalExample.optionalMapUpperCase(optionalList);
        strings.forEach(System.out::println);
        assertEquals(fourth.toUpperCase(), strings.get(1));
    }

    @Test
    public void optionalOfNullableTest() {
        assertTrue(OptionalExample.optionalOfNullable(""));
        assertFalse(OptionalExample.optionalOfNullable(null));
    }

    @Test
    public void optionalOfTest() {
        assertTrue(OptionalExample.optionalOf(""));
        try {
            OptionalExample.optionalOf(null);
            fail("If Optional.of got a null-value should throws NullPointerException");
        } catch (final NullPointerException e) {
            assertNotNull(e);
        }
    }

    @Test
    public void optionalOrElseGetTest() {
        final String string = UUID.randomUUID().toString();
        assertEquals(string, OptionalExample.optionalOrElseGet(string));
        assertEquals(OptionalExample.EMPTY_STRING, OptionalExample.optionalOrElseGet(null));
    }

    @Test
    public void optionalOrElseTest() {
        final String string = UUID.randomUUID().toString();
        assertEquals(string, OptionalExample.optionalOrElse(string));
        assertEquals(OptionalExample.EMPTY_STRING, OptionalExample.optionalOrElse(null));
    }

    @Test
    public void optionalOrThrowTest() {
        final String string = UUID.randomUUID().toString();
        assertEquals(string, OptionalExample.optionalOrThrow(string));
        try {
            OptionalExample.optionalOrThrow(null);
            fail("When the sipplied value is null a given exception is thrown");
        } catch (final RuntimeException e) {
            assertEquals(OptionalExample.EXCEPTION_MSG, e.getMessage());
        }
    }

}
