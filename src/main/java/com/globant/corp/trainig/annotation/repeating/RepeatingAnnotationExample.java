package com.globant.corp.trainig.annotation.repeating;

import java.util.Optional;

public class RepeatingAnnotationExample {

    // Java >= 1.8
    @Attribute(firstName = "fOther", lastName = "lOther")
    @Attribute(age = 55)
    public interface OtherPerson {

    }

    // Java <= 1.7
    @Attributes({ @Attribute(firstName = "fPerson", lastName = "lPerson"), @Attribute(age = 99) })
    public interface Person {

    }

    public int getOtherPersonAnnotation() {
        return OtherPerson.class.getAnnotations().length;
    }

    public int getOtherPersonAttribute() {
        return OtherPerson.class.getAnnotationsByType(Attribute.class).length;
    }

    public int getOtherPersonAttributes() {
        return OtherPerson.class.getAnnotationsByType(Attributes.class).length;
    }

    public String getOtherPersonDataBySingleAnotation() {
        final Attributes attributes = OtherPerson.class.getAnnotation(Attributes.class);
        final StringBuilder result = new StringBuilder();
        for (final Attribute attr : attributes.value()) {
            Optional.ofNullable(attr.firstName()).ifPresent(firstName -> {
                result.append("firstName:").append(firstName).append(";");
            });
            Optional.ofNullable(attr.lastName()).ifPresent(lastName -> {
                result.append("lastName:").append(lastName).append(";");
            });
            Optional.ofNullable(attr.age()).ifPresent(age -> {
                result.append("age:").append(age).append(";");
            });
            result.append("\n");
        }
        return result.toString();
    }

    public int getPersonAnnotation() {
        return Person.class.getAnnotations().length;
    }

    public int getPersonAttribute() {
        return Person.class.getAnnotationsByType(Attribute.class).length;
    }

    public int getPersonAttributes() {
        return Person.class.getAnnotationsByType(Attributes.class).length;
    }

    public String getPersonDataBySingleAnnotation() {
        final Attributes attributes = Person.class.getAnnotation(Attributes.class);
        final StringBuilder result = new StringBuilder();
        for (final Attribute attr : attributes.value()) {
            Optional.ofNullable(attr.firstName()).ifPresent(firstName -> {
                result.append("firstName:").append(firstName).append(";");
            });
            Optional.ofNullable(attr.lastName()).ifPresent(lastName -> {
                result.append("lastName:").append(lastName).append(";");
            });
            Optional.ofNullable(attr.age()).ifPresent(age -> {
                result.append("age:").append(age).append(";");
            });
            result.append("\n");
        }
        return result.toString();
    }
}
