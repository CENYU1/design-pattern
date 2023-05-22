package com.cenyu.iterator;

public class Client {

    public static void main(String[] args) {
        // studentAggregate, the aggregate objects, is similar to ArrayList
        StudentAggregate studentAggregate = new StudentAggregateImpl();

        studentAggregate.addStudent(new Student("cenyu", "001"));
        studentAggregate.addStudent(new Student("kevin", "002"));
        studentAggregate.addStudent(new Student("kevincen", "003"));

        // get the corresponding iterator
        StudentIterator iterator = studentAggregate.getStudentIterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
