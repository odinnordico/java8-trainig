package com.globant.corp.trainig.nashorn;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class NashornExample {

    private static final String NASHORN = "nashorn";
    private static final ScriptEngineManager ENGINE_MANAGER = new ScriptEngineManager();
    private static final ScriptEngine ENGINE = ENGINE_MANAGER.getEngineByName(NASHORN);
    private static final String FILE = "/HelloWorld.js";

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
}
