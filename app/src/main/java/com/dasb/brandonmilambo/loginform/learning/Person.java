package com.dasb.brandonmilambo.loginform.learning;

import java.util.Objects;

public class Person {
    private final String forename;
    private final String surname;
    private Integer age;

    public Person(String forename, String surname) {
        this.forename = forename;
        this.surname = surname;
    }
    public Person(String forename,String surname,int age){
        this(forename,surname );
        this.age = age;
    }

    public String getForename() {
        return forename;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(forename, person.forename) &&
                Objects.equals(surname, person.surname) &&
                Objects.equals(age, person.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(forename, surname, age);
    }

    @Override
    public String toString() {
        return forename+surname+age;
    }
}
