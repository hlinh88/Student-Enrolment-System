package StudentEnrolmentSystem;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    //Main function
    public static void main(String[] args) {
        //Create sample students information in Student class
        Student student1 = new Student("s1111111", "Luu Khanh Linh", LocalDate.of(2002, Month.MAY, 25));
        Student student2 = new Student("s2222222", "Nguyen Khanh Long", LocalDate.of(1998, Month.OCTOBER, 10));
        Student student3 = new Student("s3333333", "Pham Hong Nhung", LocalDate.of(2000, Month.JUNE, 9));
        Student student4 = new Student("s4444444", "Nguyen Thi Minh Hien", LocalDate.of(2001, Month.JULY, 10));


        //Create sample courses information in Course class
        Course course1 = new Course("COSC1111", "Software Architecture: Design & Implementation", 12);
        Course course2 = new Course("COSC2222", "Software Engineering Fundamentals for IT", 12);
        Course course3 = new Course("COSC3333", "Software Engineering Project Management", 12);
        Course course4 = new Course("COSC4444", "Programming Project 1", 12);


        //Initialize student enrolment object
        StudentEnrolment studentEnrolment = new StudentEnrolment();

        //Create sample enrollments
        StudentEnrolment studentEnrolment1 = new StudentEnrolment(student1, course1, "2021A");
        studentEnrolment.add(studentEnrolment1);
        StudentEnrolment studentEnrolment2 = new StudentEnrolment(student1, course2, "2021A");
        studentEnrolment.add(studentEnrolment2);
        StudentEnrolment studentEnrolment3 = new StudentEnrolment(student1, course3, "2021A");
        studentEnrolment.add(studentEnrolment3);




        //An array to store list of students and courses
        ArrayList<Student> studentList = new ArrayList<>();
        ArrayList<Course> courseList = new ArrayList<>();

        //Add students to the list
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);

        //Add Courses to the list
        courseList.add(course1);
        courseList.add(course2);
        courseList.add(course3);
        courseList.add(course4);




        //main while loop display menu
        boolean quit = false;
        while (!quit) {
            System.out.println("WELCOME TO STUDENT ENROLMENT SYSTEM!!!");
            System.out.println("             ---♡♡♡---");
            System.out.println("1. Create a student information\n" +
                            "2. Create a course information\n" +
                            "3. Enroll a students for 1 semester\n" +
                            "4. Update an enrolment of a students for 1 semester\n" +
                            "5. Print all courses for 1 student in 1 semester\n" +
                            "6. Print all students of 1 course in 1 semester\n" +
                            "7. Prints all courses offered in 1 semester\n" +
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
                    String sID = scan.next();
                    System.out.println("Student name: ");
                    String studentName = scan.next();
                    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("M/d/yyyy");
                    System.out.println("Birthdate: (MM/DD/YYYY)");
                    LocalDate studentBirthDate = LocalDate.parse(scan.next(), dateFormat);
                    //Create new student
                    Student student = new Student(sID, studentName, studentBirthDate);
                    //Add student to student list
                    studentList.add(student);


                //case 2 (Create a course information)
                case "2":
                    System.out.println("Create a course information");
                    //Get course information from user input
                    System.out.println("Course ID: ");
                    String cID = scan.next();
                    System.out.println("Course name: ");
                    String courseName = scan.next();
                    System.out.println("Number of credits: ");
                    int numOfCredits = scan.nextInt();
                    //Create new course
                    Course course = new Course(cID, courseName, numOfCredits);
                    //Add course to course list
                    courseList.add(course);

                //case 3 (Enroll a students for 1 semester)
                case "3":
                    System.out.println("Enroll a students for 1 semester");
                    //Ask for student id, course, and semester to add to the enrollment list
                    System.out.println("Student ID: ");
                    String studentId = scan.next();
                    System.out.println("Course: ");
                    String courseId = scan.next();
                    System.out.println("Semester: ");
                    String semester = scan.next();
                    Student enrolledStudent = new Student();
                    Course enrolledCourse = new Course();
                    //For loop check the information of that student in the list
                    for (int i = 0; i < studentList.size(); i++){
                        if (studentList.get(i).getId().equals(studentId)){
                            enrolledStudent = studentList.get(i);
                        }
                    }
                    for (int i = 0; i< courseList.size(); i++){
                        if (courseList.get(i).getId().equals(courseId)){
                            enrolledCourse = courseList.get(i);
                        }
                    }
                    //Create enrollment for that student
                    StudentEnrolment newEnrollment = new StudentEnrolment(enrolledStudent, enrolledCourse, semester);
                    //Enroll the enrolment to the StudentEnrolment list
                    studentEnrolment.add(newEnrollment);


                //case 4 (Update an enrolment of a students for 1 semester)
                case "4":
                    System.out.println("Update an enrolment of a students for 1 semester");
                    //Get the student that need to update enrollment
                    System.out.println("Student ID of student that you want to update: ");
                    String updateStudentID = scan.next();
                    System.out.println("Semester of student that you want to update: ");
                    String updateSemester = scan.next();
                    //Create an arrayList to store all courses of a student
                    ArrayList<Course> courseOfAStudent = new ArrayList<>();

                    //For loop to get the student element for update
                    for (int i = 0; i < studentEnrolment.enrolmentList.size(); i++){
                        //check the student in the enrolmentList has the unique ID and enrolled in unique semester
                        if (studentEnrolment.enrolmentList.get(i).getStudent().getId() == (updateStudentID)
                        && studentEnrolment.enrolmentList.get(i).getSemester() == (updateSemester)){
                            courseOfAStudent.add(studentEnrolment.enrolmentList.get(i).getCourse());
                        }
                    }
                    //Print all the courses of a student
                    System.out.println("Courses: " + courseOfAStudent);

                    //kẹt ở phần update
            }


        }
    }
}