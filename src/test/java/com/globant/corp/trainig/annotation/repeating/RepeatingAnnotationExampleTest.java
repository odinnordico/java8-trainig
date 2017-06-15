package com.globant.corp.trainig.annotation.repeating;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class RepeatingAnnotationExampleTest {

    private RepeatingAnnotationExample annotationExample;

    @Test
    public void checkPersonsAnnotationsTest() {
        final int person = annotationExample.getPersonAnnotation();
        final int otherPerson = annotationExample.getOtherPersonAnnotation();
        System.out.println(String.format("Annotation:: Person %s <--> OtherPerson %s", person, otherPerson));
        assertEquals(person, otherPerson);
    }

    @Test
    public void checkPersonsAttributesTest() {
        final int person = annotationExample.getPersonAttributes();
        final int otherPerson = annotationExample.getOtherPersonAttributes();
        System.out.println(String.format("Attributes:: Person %s <--> OtherPerson %s", person, otherPerson));
        assertEquals(person, otherPerson);
    }

    @Test
    public void checkPersonsAttributeTest() {
        final int person = annotationExample.getPersonAttribute();
        final int otherPerson = annotationExample.getOtherPersonAttribute();
        System.out.println(String.format("Attribute:: Person %s <--> OtherPerson %s", person, otherPerson));
        assertEquals(person, otherPerson);
    }

    @Test
    public void getOtherPersonDataBySingleAnotationTest(){
        final String otherPersonData = annotationExample.getOtherPersonDataBySingleAnotation();
        System.out.println("OtherPerson::" + otherPersonData);
        assertNotNull(otherPersonData);
    }

    @Test
    public void getPersonDataBySingleAnnotationTest(){
        final String personData = annotationExample.getPersonDataBySingleAnnotation();
        System.out.println("Person::" + personData);
        assertNotNull(personData);
    }

    @Before
    public void init() {
        annotationExample = new RepeatingAnnotationExample();
    }
}
