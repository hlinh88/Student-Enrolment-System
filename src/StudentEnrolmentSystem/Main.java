package StudentEnrolmentSystem;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    //Main function
    public static void main(String[] args) {
        //Create sample students information in Student class
        Student student1 = new Student("s1111111", "Ashley Gilbert", LocalDate.of(2002, Month.MAY, 25));
        Student student2 = new Student("s2222222", "Lulu Walker", LocalDate.of(1998, Month.OCTOBER, 10));
        Student student3 = new Student("s3333333", "Katherine Langford", LocalDate.of(2000, Month.JUNE, 9));
        Student student4 = new Student("s4444444", "Bert Lynch", LocalDate.of(2001, Month.JULY, 10));


        //Create sample courses information in Course class
        Course course1 = new Course("COSC1111", "Software Architecture: Design & Implementation", 12);
        Course course2 = new Course("COSC2222", "Software Engineering Fundamentals for IT", 12);
        Course course3 = new Course("COSC3333", "Software Engineering Project Management", 12);
        Course course4 = new Course("COSC4444", "Programming Project 1", 12);


        //boolean quit

        boolean quit = false;
        while (!quit) {
            System.out.println("WELCOME TO STUDENT ENROLMENT SYSTEM!!!");
            System.out.println("             ---♡♡♡---");
            System.out.println("1. Create a student information\n" +
                            "2. Create a course information\n" +
                            "2. Update an enrollment\n" +
                            "3. Delete an enrollment\n" +
                            "4. Enroll a students for 1 semester\n" +
                            "5. Update an enrolment of a students for 1 semester\n" +
                            "6. Print all courses for 1 student in 1 semester\n" +
                            "7. Print all students of 1 course in 1 semester\n" +
                            "8. Prints all courses offered in 1 semester\n" +
                            "0. Quit");

            //Ask user for option choice
            Scanner scan = new Scanner(System.in);
            String option = "";

            if (scan.hasNext()) {
                option = scan.next();
            }

            //if else for the option choice
            switch (option) {
                //case 1 (Create a student information)
                case "1":
                    System.out.println("Create a student information");
                    //Get student information from user input
                    System.out.println("Student ID: ");
                    String studentID = scan.next();
                    System.out.println("Student name: ");
                    String studentName = scan.next();
                    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("M/d/yyyy");
                    System.out.println("Birthdate: (MM/DD/YYYY)");
                    LocalDate studentBirthDate = LocalDate.parse(scan.next(), dateFormat);
                    //Create student
                    Student student = new Student(studentID, studentName, studentBirthDate);








                // case 4 (Enroll a students for 1 semester)
                case "4":
                    System.out.println("Enroll a students for 1 semester");
                    //ask for student id, course, and semester to add to the enrollment list
                    System.out.println("Student ID: ");
                    String studentId = scan.next();
                    System.out.println("Course: ");
                    String courseID = scan.next();
                    System.out.println("Semester: ");
                    String semester = scan.next();

            }
        }
    }
}