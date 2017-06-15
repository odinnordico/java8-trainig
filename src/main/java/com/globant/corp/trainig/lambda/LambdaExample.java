package com.globant.corp.trainig.lambda;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.globant.corp.trainig.constants.Comparator;
import com.globant.corp.trainig.domain.Person;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LambdaExample {
   private final List<Person> persons;

   public List<Person> filterPersonsByAge(final int age, final Comparator comparator) {
      // Define a predicate with Lambda expression
      final Predicate<Person> comparationPredicate;

      if (Comparator.EQUAL.equals(comparator)) {
         comparationPredicate = person -> person.getAge() == age;
      } else if (Comparator.MAJOR.equals(comparator)) {
         comparationPredicate = person -> person.getAge() > age;
      } else if (Comparator.MINOR.equals(comparator)) {
         comparationPredicate = person -> person.getAge() < age;
      } else {
         comparationPredicate = person -> Optional.ofNullable(person).isPresent();
      }

      return persons.stream().filter(comparationPredicate).collect(Collectors.toList());
   }

   public void doNothing() {
      IntStream.range(1, 10).forEach(System.out::print);
      System.out.println();
      System.out.println("ANY " + IntStream.range(1, 10).anyMatch(x -> x % 2 == 0));
      System.out.println("ALL " + IntStream.range(1, 10).allMatch(x -> x % 2 == 0));
      System.out.println("NONE " + IntStream.range(1, 10).noneMatch(x -> x % 2 == 0));
      System.out.println("FIND FIRST " + IntStream.range(1, 10).findFirst());
   }
}
