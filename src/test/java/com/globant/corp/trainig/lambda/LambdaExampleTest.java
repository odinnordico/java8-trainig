package com.globant.corp.trainig.lambda;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.globant.corp.trainig.constants.Comparator;
import com.globant.corp.trainig.domain.Person;

@RunWith(JUnit4.class)
public class LambdaExampleTest {

   private LambdaExample lambdaExample;

   @Test
   public void doNothingTest() {
      final List<Person> persons = createPersons(10);
      lambdaExample = new LambdaExample(persons);
      lambdaExample.doNothing();
      assertTrue(true);
   }

   private List<Person> createPersons(final int count) {
      final List<Person> persons = new ArrayList<>();
      final Stream<Integer> iterationStream = Stream.iterate(1, n -> n + 1).limit(count);
      iterationStream.forEach(iteration -> {
         final Person person = Person.builder().ocupation(new StringBuilder().append("Ocup").append(" ").append(iteration).toString())
               .name(new StringBuilder().append("Person").append(" ").append(iteration).toString()).age(new Random().nextInt(70)).build();
         persons.add(person);
      });
      return persons;
   }

   @Test
   public void filterPersonsByEqualAgeTest() {
      System.out.println("EQUAL--------------------------------------------------------------------------------------------------------------");
      final List<Person> persons = createPersons(10);
      lambdaExample = new LambdaExample(persons);
      final List<Person> filteredPersons = lambdaExample.filterPersonsByAge(30, Comparator.EQUAL);
      System.out.println("Found:***************************************************************");
      filteredPersons.forEach(System.out::println);
      System.out.println("OF:***************************************************************");
      persons.forEach(System.out::println);
      assertTrue(true);
   }

   @Test
   public void filterPersonsByMajorAgeTest() {
      System.out.println("MAJOR--------------------------------------------------------------------------------------------------------------");
      final List<Person> persons = createPersons(10);
      lambdaExample = new LambdaExample(persons);
      final List<Person> filteredPersons = lambdaExample.filterPersonsByAge(30, Comparator.MAJOR);
      System.out.println("Found:***************************************************************");
      filteredPersons.forEach(System.out::println);
      System.out.println("OF:***************************************************************");
      persons.forEach(System.out::println);
      assertTrue(true);
   }

   @Test
   public void filterPersonsByMinorAgeTest() {
      System.out.println("MINOR--------------------------------------------------------------------------------------------------------------");
      final List<Person> persons = createPersons(10);
      lambdaExample = new LambdaExample(persons);
      final List<Person> filteredPersons = lambdaExample.filterPersonsByAge(30, Comparator.MINOR);
      System.out.println("Found:***************************************************************");
      filteredPersons.forEach(System.out::println);
      System.out.println("OF:***************************************************************");
      persons.forEach(System.out::println);
      assertTrue(true);
   }

}