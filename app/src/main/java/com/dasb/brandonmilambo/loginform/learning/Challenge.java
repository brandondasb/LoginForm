package com.dasb.brandonmilambo.loginform.learning;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Challenge {
    public static void main(String... args) {

// LIST of letters
// for loop find the index to match
// update the
        //the  ugly way
//        char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
//        int val1 = 0;
//        int val2 = 0;
//        int val3 = 0;
//        alphabet.toString();
//        for (int i = 0; i < alphabet.length; i++) {
//
//            if (alphabet[i] == args[1].charAt(0)) {
//                val1 = i + 2;
//
//            } else if (alphabet[i] == args[1].charAt(1)) {
//                val2 = i + 2;
//            } else if (alphabet[i] == args[1].charAt(2)) {
//                val3 = i + 2;
//            }
//        }
//        System.out.println(alphabet[val1] + "" + alphabet[val2] + "" + alphabet[val3]);
//
//
//        SavedSearch one = new SavedSearch("nklcars", "audi");
//
//        SavedSearch two = new SavedSearch("mercs", "mercedes");
//        SavedSearch three = new SavedSearch("mercs", "mercedes");
//        System.out.println(two.equals(three));
//
//        List<SavedSearch> searches = new ArrayList<SavedSearch>();
//        searches.add(one);
//        searches.add(two);
//        System.out.println(searches);
//        Collections.sort(searches);
//
//        System.out.println(searches);
Person p1 = new Person("Ste","Parson", 27);
Person p2 = new Person("brandon","milambo", 28);
Person p3 = new Person("John","Butterworth", 35);
Person p4 = new Person("Ste","Parson");
Person p5 = new Person("Ste","Parson", 27);
// sort by surname (primary sort)
        //if surname is the same  sort in descending (secondary sdrt.
        // )
       // sort(by )
        //

        Set<Person> personList = new HashSet<>();
        personList.add(p1);
        personList.add(p2);
        personList.add(p3);
        personList.add(p4);
        personList.add(p5);

        System.out.println(personList);

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


    }


