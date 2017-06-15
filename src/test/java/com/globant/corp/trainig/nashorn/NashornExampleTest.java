package com.globant.corp.trainig.nashorn;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;
import java.util.List;

import javax.script.ScriptException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class NashornExampleTest {

    @Test
    public void getAvailableEninesTest() {
        final List<String> availableEngines = NashornExample.getAvailableEnines();
        availableEngines.forEach(System.out::println);
        assertFalse(availableEngines.isEmpty());
    }

    @Test
    public void nashornHelloWorldFromFile() {
        try {
            NashornExample.nashornHelloWorldFromFile();
            assertTrue(true);
        } catch (final ScriptException | FileNotFoundException e) {
            e.printStackTrace();
            fail("Fail with " + e);
        }
    }

    @Test
    public void nashornHelloWorldTest() {
        try {
            NashornExample.nashornHelloWorld("java8");
            assertTrue(true);
        } catch (final ScriptException e) {
            e.printStackTrace();
            fail("Fail with " + e);
        }
    }
}
