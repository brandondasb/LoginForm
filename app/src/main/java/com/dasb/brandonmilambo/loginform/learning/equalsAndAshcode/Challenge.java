package com.dasb.brandonmilambo.loginform.learning.equalsAndAshcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Challenge {
    public static void main(String... args) {


        SavedSearch one = new SavedSearch("nice cars", "audi");

        SavedSearch two = new SavedSearch("mercs", "mercedes");
        SavedSearch three = new SavedSearch("mercs", "mercedes");
        System.out.println(two.equals(three));

        List<SavedSearch> searches = new ArrayList<SavedSearch>();
        searches.add(one);
        searches.add(two);
        System.out.println(searches);
        Collections.sort(searches);

        System.out.println(searches);
        Person p1 = new Person("Ste", "Parson", 27);
        Person p2 = new Person("brandon", "milambo", 28);
        Person p3 = new Person("John", "Butterworth", 35);
        Person p4 = new Person("Ste", "Parson",28);
        Person p5 = new Person("Ste", "Parson", 27);
// sort by surname (primary sort)
        //if surname is the same  sort in descending (secondary sort.
        // )
        // sort(by age)
        //

        Set<Person> personList = new HashSet<>();
        personList.add(p1);
        personList.add(p2);
        personList.add(p3);
        personList.add(p4);
        personList.add(p5);

        System.out.println(personList);

        List<Person> personList2 = new ArrayList<>();
        personList2.add(p1);
        personList2.add(p2);
        personList2.add(p3);
        personList2.add(p4);
        personList2.add(p5);
        SurnameCompare surnameCompare = new SurnameCompare();
        Collections.sort(personList2, surnameCompare);
        System.out.println("Sorted by name and age:");
        System.out.println(personList2);


    }

    static class SavedSearch implements Comparable<SavedSearch> {
        final String name;

        final String model;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            SavedSearch that = (SavedSearch) o;
            return Objects.equals(name, that.name) &&
                    Objects.equals(model, that.model);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, model);
        }

        SavedSearch(String name, String model) {
            this.name = name;
            this.model = model;
        }


        @Override
        public String toString() {
            return name + model;

        }

        @Override
        public int compareTo(SavedSearch o) {

            //
            return this.name.compareTo(o.name);
        }
    }

    static class SavedSearchComparator implements Comparator<SavedSearch> {
        @Override
        public int compare(SavedSearch o1, SavedSearch o2) {
            return o1.name.compareTo(o2.name);
        }


    }

    static class SurnameCompare implements Comparator<Person> {

        @Override
        public int compare(Person p1, Person p2) {
           int name =  p1.getSurname().compareTo(p2.getSurname());

            if (name == 0) {

                if (p1.getAge() < p2.getAge())
                    return -1;
                if (p1.getAge() > p2.getAge())
                    return 1;
                else return 0;
            }
            return 0;
        }

    }


}


