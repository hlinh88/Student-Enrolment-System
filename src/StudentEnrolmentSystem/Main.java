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
            System.out.print("1. Create a student information\n" +
                            "2. Create a course information\n" +
                            "3. Enroll a students for 1 semester\n" +
                            "4. Print all courses of a student in a semester. Update or add or delete courses from the list\n" +
                            "5. Print all courses for 1 student in 1 semester\n" +
                            "6. Print all students of 1 course in 1 semester\n" +
                            "7. Prints all courses offered in 1 semester\n" +
                            "0. Quit\n"+
                            "Your option: ");

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
                    System.out.print("Create a student information");
                    //Get student information from user input
                    System.out.print("Student ID: ");
                    String sID = scan.next();
                    System.out.print("Student name: ");
                    String studentName = scan.next();
                    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("M/d/yyyy");
                    System.out.print("Birthdate: (MM/DD/YYYY)");
                    LocalDate studentBirthDate = LocalDate.parse(scan.next(), dateFormat);
                    //Create new student
                    Student student = new Student(sID, studentName, studentBirthDate);
                    //Add student to student list
                    studentList.add(student);


                //case 2 (Create a course information)
                case "2":
                    System.out.print("Create a course information");
                    //Get course information from user input
                    System.out.print("Course ID: ");
                    String cID = scan.next();
                    System.out.print("Course name: ");
                    String courseName = scan.next();
                    System.out.print("Number of credits: ");
                    int numOfCredits = scan.nextInt();
                    //Create new course
                    Course course = new Course(cID, courseName, numOfCredits);
                    //Add course to course list
                    courseList.add(course);

                //case 3 (Enroll a students for 1 semester)
                case "3":
                    System.out.print("Enroll a students for 1 semester");
                    //Ask for student id, course, and semester to add to the enrollment list
                    System.out.print("Student ID: ");
                    String studentId = scan.next();
                    System.out.print("Course: ");
                    String courseId = scan.next();
                    System.out.print("Semester: ");
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


                //case 4 (Update or delete an enrolment of a students for 1 semester)
                case "4":
                    System.out.println("Update an enrolment of a students for 1 semester");
                    //Get the student that need to update enrollment
                    System.out.print("Student ID of student that you want to update: ");
                    String updateStudentID = scan.next();
                    System.out.print("Semester of student that you want to update: ");
                    String updateSemester = scan.next();
                    //Create an arrayList to store all courses of a student
                    ArrayList<String> courseOfAStudent = new ArrayList<>();
                    //Create an arrayList to store all Enrollment of that student
                    ArrayList<StudentEnrolment> enrolmentOfAStudent = new ArrayList<>();


                    //For loop to get the student element for update
                    for (int i = 0; i < studentEnrolment.enrolmentList.size(); i++){
                        //check the student in the enrolmentList has the unique ID and enrolled in unique semester
                        if (studentEnrolment.enrolmentList.get(i).getStudent().getId().equals(updateStudentID)
                        && studentEnrolment.enrolmentList.get(i).getSemester().equals(updateSemester)){
                            //add the course to courses that student has
                            courseOfAStudent.add(studentEnrolment.enrolmentList.get(i).getCourse().toString());
                            enrolmentOfAStudent.add(studentEnrolment.enrolmentList.get(i));
                        }
                    }
                    //Print all the courses of a student
                    System.out.println("Courses of student " + updateStudentID +": ");
                    //Loop printing all courses of a student
                    for (int i = 0; i < courseOfAStudent.size(); i++){
                        System.out.println(courseOfAStudent.get(i));
                    }


                    boolean stillUpOrDel = false;
                    while(!stillUpOrDel) {
                        //Ask user to update or delete
                        System.out.print("1. Add new course\n" +
                                "2. Delete a course\n" +
                                "3. Update a course\n" +
                                "0. Quit\n" +
                                "Your option: ");
                        String userAns = scan.next();
                        //Add new course option
                        if (userAns.equals("1")){
                            //Ask for user input course information they want to update
                            System.out.print("Course ID: ");
                            String addCourseID = scan.next();
                            System.out.print("Course name: ");
                            Scanner scanner = new Scanner(System.in);
                            String addCourseName = "";
                            addCourseName += scanner.nextLine();
                            System.out.print("Number of credits: ");
                            int addNumberOfCredits = scan.nextInt();
                            Course newCourse = new Course(addCourseID, addCourseName, addNumberOfCredits);
                            StudentEnrolment newCourseEnrollment = new StudentEnrolment(enrolmentOfAStudent.get(0).getStudent(), newCourse, enrolmentOfAStudent.get(0).getSemester());
                            //Add new course to StudentEnrolment list
                            studentEnrolment.add(newCourseEnrollment);
                            System.out.println("Added successfully!!!");
                        }


                        //Delete the course option
                        else if (userAns.equals("2")) {
                            System.out.print("Course ID need to delete: ");
                            String courseDelete = scan.next();
                            for (int i = 0; i < enrolmentOfAStudent.size(); i++) {
                                if (enrolmentOfAStudent.get(i).getCourse().getId().equals(courseDelete)) {
                                    //Find the course and delete in the StudentEnrollment List in StudentEnrollment.java
                                    studentEnrolment.delete(enrolmentOfAStudent.get(i));
                                    break;
                                }
                            }
                            System.out.println("Deleted successfully!!!");
                        }
                        //Update the course option (Thiếu name và number of credits)
                        else if (userAns.equals("3")) {
                            System.out.print("Course ID need to update: ");
                            String courseIdNeedToUpdate = scan.next();
                            System.out.print("Course ID updated: ");
                            String courseIdUpdated = scan.next();
                            for (int i = 0; i < enrolmentOfAStudent.size(); i++) {
                                //check the course need to update
                                if (enrolmentOfAStudent.get(i).getCourse().getId().equals(courseIdNeedToUpdate)) {
                                    //Store information before update
                                    StudentEnrolment temp = enrolmentOfAStudent.get(i);
                                    //Update the course of a student
                                    enrolmentOfAStudent.get(i).getCourse().setId(courseIdUpdated);
                                    //Update it in the StudentEnrollment List in StudentEnrollment.java
                                    studentEnrolment.update(temp, enrolmentOfAStudent.get(i));
                                }
                            }
                            System.out.println("Updated successfully!!!");
                        }
                        else if(userAns.equals("0")){
                            System.out.println("Thanks for using the system, you can continue your work!");
                            break;
                        }
                        else {
                            System.out.println("Invalid input. Please try again!");
                            break;

                        }

                    }
                    //Print all courses for 1 student in 1 semester
                case "5":
                    System.out.println("Display all courses for 1 student in 1 semester");

            }


        }
    }
}