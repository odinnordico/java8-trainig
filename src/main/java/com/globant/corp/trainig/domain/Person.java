package com.globant.corp.trainig.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/*
 * @author diego
 */
@AllArgsConstructor
@Builder
@Getter
@ToString
public final class Person {
    private final String name;
    private final int age;
    private final String ocupation;
}