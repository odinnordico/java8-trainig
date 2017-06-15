package com.globant.corp.trainig.nashorn;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class NashornExample {

    private static final String NASHORN = "nashorn";
    private static final ScriptEngineManager ENGINE_MANAGER = new ScriptEngineManager();
    private static final ScriptEngine ENGINE = ENGINE_MANAGER.getEngineByName(NASHORN);
    private static final String FILE = "src/main/resources/js/HelloWorld.js";

    public static List<String> getAvailableEnines() {
        final List<ScriptEngineFactory> engineFactories = ENGINE_MANAGER.getEngineFactories();
        return engineFactories.stream().map(sef -> {
            final StringBuilder scriptEngineFactoryString = new StringBuilder();
            scriptEngineFactoryString.append("Name: ");
            scriptEngineFactoryString.append(sef.getEngineName());
            scriptEngineFactoryString.append(";\tVersion: ");
            scriptEngineFactoryString.append(sef.getEngineVersion());
            scriptEngineFactoryString.append(";\tLanguage: ");
            scriptEngineFactoryString.append(sef.getLanguageName());
            scriptEngineFactoryString.append(";\tLanguage Version: ");
            scriptEngineFactoryString.append(sef.getLanguageVersion());
            return scriptEngineFactoryString.toString();
        }).collect(Collectors.toList());
    }

    public static String greet(final String name) {
        return "Hi you " + name + " from JAVA 8";
    }

    public static void nashornCallInterfaceJSImpl() throws FileNotFoundException, ScriptException {
        ENGINE.eval(new FileReader(FILE));
        final Object impl = ENGINE.get("runnableJS");
        final Invocable invocable = (Invocable) ENGINE;
        final Runnable runnable = invocable.getInterface(impl, Runnable.class);
        final Thread t1 = new Thread(runnable);
        t1.start();
        final Thread t2 = new Thread(runnable);
        t2.start();
    }

    public static void nashornHelloWorld(final String name) throws ScriptException {
        final StringBuilder jsSentence = new StringBuilder();
        jsSentence.append("print('");
        jsSentence.append("Hello ");
        jsSentence.append(name);
        jsSentence.append("!');");
        ENGINE.eval(jsSentence.toString());
    }

    public static void nashornHelloWorldFromFile() throws ScriptException, FileNotFoundException {
        System.out.println(FILE);
        ENGINE.eval(new FileReader(FILE));
    }

    public static void nashornJavaCodeFromJSFuinction(final String name) throws ScriptException {
        final String jsSenteces = "var NashornExample = Java.type('com.globant.corp.trainig.nashorn.NashornExample');var result = NashornExample.greet('"
                + name + "');print(result);";
        ENGINE.eval(jsSenteces);
    }

    public static String nashornJSFuinctionFromJavaCode(final String name, final int num1, final int num2)
            throws ScriptException, NoSuchMethodException {
        final String jsFunctions = "var greet = function(name){return 'Hi you' + name + ' from JAVASCRIPT';}; var sum = function(num1,num2){return num1+num2};";
        ENGINE.eval(jsFunctions);
        final Invocable invocable = (Invocable) ENGINE;
        final String greet = invocable.invokeFunction("greet", name).toString();
        final String sum = invocable.invokeFunction("sum", num1, num2).toString();
        return greet + " and yout answer is " + sum;
    }
}
