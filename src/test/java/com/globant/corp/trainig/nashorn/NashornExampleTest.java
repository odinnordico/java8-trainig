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
    public void nashornCallInterfaceJSImplTest() {
        try {
            NashornExample.nashornCallInterfaceJSImpl();
            assertTrue(true);
        } catch (final ScriptException | FileNotFoundException e) {
            e.printStackTrace();
            fail("Fail with " + e);
        }
    }

    @Test
    public void nashornHelloWorldFromFileTest() {
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

    @Test
    public void nashornJavaCodeFromJSFuinctionTest() {
        try {
            final String name = "java8";
            NashornExample.nashornJavaCodeFromJSFuinction(name);
            assertTrue(true);
        } catch (final ScriptException e) {
            e.printStackTrace();
            fail("Fail with " + e);
        }
    }

    @Test
    public void nashornJSFuinctionFromJavaCodeTest() {
        try {
            final String name = "java8";
            final int num1 = 1;
            final int num2 = 2;
            final String jsResults = NashornExample.nashornJSFuinctionFromJavaCode(name, num1, num2);
            System.out.println(jsResults);
            assertTrue(jsResults.contains(name));
            assertTrue(jsResults.contains(String.valueOf(1 + 2)));
        } catch (final ScriptException | NoSuchMethodException e) {
            e.printStackTrace();
            fail("Fail with " + e);
        }
    }
}
