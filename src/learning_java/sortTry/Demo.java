package learning_java.sortTry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        Person p1 = new Person("Jack",18);
        Person p2 = new Person("Lucy",20);
        Person p3 = new Person("Bruce",19);
        Person p4 = new Person("Lili",16);
        List<Person> rawList = new ArrayList();
        rawList.add(p1);
        rawList.add(p2);
        rawList.add(p3);
        rawList.add(p4);
        Collections.sort(rawList,new Comparator<Person>() {
            @Override
            public int compare(Person p1,Person p2) {
                if(p1.age > p2.age) return 1;
                else if (p1.age == p2.age) return 0;
                else return -1;
            }
        });
        for(Person p:rawList) {
            System.out.println(p);
        }
    }
}


