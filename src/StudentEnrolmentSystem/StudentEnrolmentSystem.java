package StudentEnrolmentSystem;

import javax.swing.*;
import java.io.*;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class StudentEnrolmentSystem {

    /**
     * Saving CSV file method
     */
    public static void saveCSV(String str, String fileName){
        try{
            FileWriter fw = new FileWriter(fileName, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            pw.println(str);
            pw.flush();
            pw.close();

            JOptionPane.showMessageDialog(null, "File CSV saved successfully!");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "File CSV not saved successfully!");
        }
    }

    /**
     * Read file
     */
    private static void FileReader(StudentEnrolment studentEnrolment, List<Student> studentList, List<Course> courseList, String fileName) throws IOException {
        FileReader file = new FileReader(fileName);
        Scanner scanFile = new Scanner(file);
        while (scanFile.hasNextLine()){
            String[] data = scanFile.nextLine().split(",");
            String studentID = data[0];
            String studentName = data[1];
            String birthdate = data[2];
            String courseID = data[3];
            String courseName = data[4];
            int numOfCredits = Integer.parseInt(data[5]);
            String semester = data[6];
            Student student = new Student(studentID, studentName, birthdate);
            //Add student to student arraylist
            studentList.add(student);
            Course course = new Course(courseID, courseName, numOfCredits);
            //Add course to course arraylist
            courseList.add(course);
            //Create enrollment
            StudentEnrolment studentEnroll = new StudentEnrolment(student, course, semester);
            studentEnrolment.add(studentEnroll);
        }
        file.close();
    }


    //Main function
    public static void main(String[] args) throws IOException {
        final String COMMA_DELIMITER = ",";
        final String NEW_LINE_SEPARATOR = "\n";

        //Initialize student enrolment object
        StudentEnrolment studentEnrolment = new StudentEnrolment();

        /**
         * These sets take care of the list of student and course specifically(not enrollment)
         */
        List<Student> studentList = new ArrayList<>();
        List<Course> courseList = new ArrayList<>();


        //Asking for user file else will run the default.csv
        boolean userChoice = true;
        while(userChoice)
        {
            System.out.print("Enter filename for input (###.csv) or QUIT to load the default file: ");
            Scanner userFileInput = new Scanner(System.in);
            String userFileIn = userFileInput.next();
            if (userFileIn.equalsIgnoreCase("QUIT")){
                //Loading default.csv
                FileReader(studentEnrolment, studentList, courseList, "default.csv");
                userChoice = false;
            }
            else{
                FileReader(studentEnrolment, studentList, courseList, userFileIn);
                userChoice = false;
            }
        }




        //main while loop display menu
        boolean quit = false;
        while (!quit) {
            System.out.println("WELCOME TO STUDENT ENROLMENT SYSTEM!!!");
            System.out.println("             ---♡ヅ♡---");
            System.out.print("""
                    1. Create student information
                    2. Create course information
                    3. Enroll a students for 1 semester
                    4. Print all courses of a student in a semester. Update or add or delete courses from the list
                    5. Print all courses for 1 student in 1 semester
                    6. Print all students of 1 course in 1 semester
                    7. Print all courses offered in 1 semester
                    8. Get information of an enrolment
                    9. Print all enrollments\s
                    0. Quit
                    Your option:\s""");

            //Ask user for option choice
            Scanner scan = new Scanner(System.in);
            String option = "";

            if (scan.hasNext()) {
                option = scan.next();
            }

            //if else for the option choice

            switch (option) {
                case "1":
                    //case 1 (Create a new student information)
                    System.out.println("Create a student information");
                    //Get student information from user input
                    System.out.print("Student ID: ");
                    String sID = scan.next();
                    Scanner studentNameScan = new Scanner(System.in);
                    System.out.print("Student name: ");
                    String studentName = "";
                    studentName += studentNameScan.nextLine();
                    Scanner birthScan = new Scanner(System.in);
                    System.out.print("Birthdate (YYYY-MM-DD): ");
                    String studentBirthDate = birthScan.next();
                    //Create new student
                    Student student = new Student(sID, studentName, studentBirthDate);
                    //Add student to student list
                    studentList.add(student);
                    System.out.println("Created student successfully!");
                    //Print student list
                    for (Student list : studentList) {
                        System.out.println(list.toString());
                    }
                    break;


                case "2":
                    //case 2 (Create a new course information)
                    System.out.println("Create a course information");
                    //Get course information from user input
                    System.out.print("Course ID: ");
                    String cID = scan.next();
                    Scanner courseNameScan = new Scanner(System.in);
                    System.out.print("Course name: ");
                    String courseName = "";
                    courseName += courseNameScan.nextLine();
                    System.out.print("Number of credits: ");
                    int numOfCredits = scan.nextInt();
                    //Create new course
                    Course course = new Course(cID, courseName, numOfCredits);
                    //Add course to course list
                    courseList.add(course);
                    System.out.println("Created course successfully!");
                    //Print course list
                    for (Course list : courseList) {
                        System.out.println(list.toString());
                    }
                    break;



                case "3":
                    //case 3 (Enroll a students for 1 semester)
                    System.out.println("Enroll a students for 1 semester");
                    //Ask for student id, course, and semester to add to the enrollment list
                    //Print list of students for user to pick for enrolment
                    for (Student listOfStudent : studentList) {
                        System.out.println(listOfStudent);
                    }
                    System.out.print("Pick a student ID to enroll (If you want to add a new student, enter 'QUIT' and choose option 1.) : ");
                    String studentIdEnroll = scan.next();
                    if (studentIdEnroll.equals("QUIT")){
                        break;
                    }
                    for (Course listOfCourse : courseList) {
                        System.out.println(listOfCourse);
                    }
                    System.out.print("Pick a course ID to enroll (If you want to add a new course, enter 'QUIT' and choose option 1.): ");
                    String courseIdEnroll = scan.next();
                    if (courseIdEnroll.equals("QUIT")){
                        break;
                    }
                    System.out.print("Semester: ");
                    String semester = scan.next();
                    Student enrolledStudent = new Student();
                    Course enrolledCourse = new Course();
                    //For loop check the information of that student in the list
                    for (Student studentToEnroll : studentList) {
                        if (studentToEnroll.getId().equals(studentIdEnroll)) {
                            enrolledStudent = studentToEnroll;
                        }
                    }
                    for (Course courseToEnroll : courseList) {
                        if (courseToEnroll.getId().equals(courseIdEnroll)) {
                            enrolledCourse = courseToEnroll;
                        }
                    }
                    //Create enrollment for that student
                    StudentEnrolment newEnrollment = new StudentEnrolment(enrolledStudent, enrolledCourse, semester);
                    //Enroll the enrolment to the StudentEnrolment list
                    studentEnrolment.add(newEnrollment);
                    System.out.println("Enrolled successfully!!!");
                    break;



                case "4":
                    //case 4 (Print all courses of a student in a semester. Update or add or delete courses from the list)
                    System.out.println("Print all courses of a student in a semester. Update or add or delete courses from the list");
                    //Get the student that need to update enrollment
                    System.out.print("Student ID: ");
                    String updateStudentID = scan.next();
                    System.out.print("Semester: ");
                    String updateSemester = scan.next();
                    //Create an arrayList to store all courses of a student
                    ArrayList<String> courseOfAStudent = new ArrayList<>();
                    //Create an arrayList to store all Enrollment of that student
                    ArrayList<StudentEnrolment> enrolmentOfAStudent = new ArrayList<>();

                    //For loop to get the student element for update
                    for (int i = 0; i < studentEnrolment.enrolmentList.size(); i++){
                        //check the student in the enrolmentList has the unique ID and enrolled in unique semester
                        if (studentEnrolment.enrolmentList.get(i).getStudent().getId().equalsIgnoreCase(updateStudentID)
                        && studentEnrolment.enrolmentList.get(i).getSemester().equalsIgnoreCase(updateSemester)){
                            //add the course to courses that student has
                            courseOfAStudent.add(studentEnrolment.enrolmentList.get(i).getCourse().toString());
                            enrolmentOfAStudent.add(studentEnrolment.enrolmentList.get(i));
                        }
                    }
                    //Print all the courses of a student
                    System.out.println("Courses of student " + updateStudentID +": ");
                    //Loop printing all courses of a student
                    for (String value : courseOfAStudent) {
                        System.out.println(value);
                    }

                    boolean op = true;
                    while(op) {
                        //Ask user to update or delete
                        System.out.print("""
                                1. Add new course
                                2. Delete a course
                                3. Update a course
                                0. Quit
                                Your option:\s""");
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
                            if (studentEnrolment.add(newCourseEnrollment)){
                                System.out.println("Added successfully!!!");
                            }
                            else{
                                System.out.println("Invalid");
                            }



                        }


                        //Delete the course option
                        else if (userAns.equals("2")) {
                            System.out.print("Course ID need to delete: ");
                            String courseDelete = scan.next();
                            for (StudentEnrolment enrolment : enrolmentOfAStudent) {
                                if (enrolment.getCourse().getId().equals(courseDelete)) {
                                    //Find the course and delete in the StudentEnrollment List in StudentEnrollment.java
                                    if(studentEnrolment.delete(enrolment)){
                                        System.out.println("Deleted successfully!!!");
                                    }
                                    else{
                                        System.out.println("Invalid");
                                    }
                                    break;
                                }
                            }


                        }
                        //Update the course option
                        else if (userAns.equals("3")) {
                            System.out.print("Course ID need to update: ");
                            String courseIdNeedToUpdate = scan.next();
                            System.out.print("Course ID updated: ");
                            String courseIdUpdated = scan.next();
                            for (StudentEnrolment enrolment : enrolmentOfAStudent) {
                                //check the course need to update
                                if (enrolment.getCourse().getId().equals(courseIdNeedToUpdate)) {
                                    //Store information before update
                                    StudentEnrolment temp = enrolment;
                                    //Update the course of a student
                                    enrolment.getCourse().setId(courseIdUpdated);
                                    //Update it in the StudentEnrollment List in StudentEnrollment.java
                                    if(studentEnrolment.update(temp, enrolment)){
                                        System.out.println("Updated successfully!!!");
                                    }
                                    else{
                                        System.out.println("Invalid");
                                    }

                                }
                            }
                        }
                        else if(userAns.equals("0")){
                            System.out.println("Thanks for using the system, you can continue your work!");
                            op = false;
                            break;
                        }
                        else {
                            System.out.println("Invalid input. Please try again!");
                            break;

                        }

                    }
                    break;

                case "5":
                    //Print all courses for 1 student in 1 semesters (same as case 4)
                    System.out.println("Display all courses for 1 student in 1 semester");
                    System.out.print("Student ID: ");
                    String allCourseStudentID = scan.next();
                    System.out.print("Semester: ");
                    String allCourseSemester = scan.next();
                    //Create an arrayList to store all courses of a student
                    ArrayList<String> allCourseOfAStudent = new ArrayList<>();

                    //For loop to get the student element for update
                    for (int i = 0; i < studentEnrolment.enrolmentList.size(); i++){
                        //check the student in the enrolmentList has the unique ID and enrolled in unique semester
                        if (studentEnrolment.enrolmentList.get(i).getStudent().getId().equals(allCourseStudentID)
                                && studentEnrolment.enrolmentList.get(i).getSemester().equals(allCourseSemester)){
                            //add the course to courses that student has
                            allCourseOfAStudent.add(studentEnrolment.enrolmentList.get(i).getCourse().toString());
                        }
                    }
                    //Print all the courses of a student
                    System.out.println("Courses of student " + allCourseStudentID +": ");
                    //Loop printing all courses of a student
                    String savedCSV = "";
                    for (String s : allCourseOfAStudent) {
                        System.out.println(s);
                        savedCSV += s;
                        savedCSV += NEW_LINE_SEPARATOR;
                    }
                    //allows to save as CSV file
                    while (true){
                        System.out.print("Save as CSV files (Y/N): ");
                        String save = scan.next();
                        if (save.equals("Y")){
                            System.out.print("Filename (filename.txt): ");
                            Scanner scanFileName = new Scanner(System.in);
                            String fileNameCase5 = scanFileName.nextLine();

                            saveCSV(savedCSV, fileNameCase5);
                            System.out.println("Saved as CSV file successfully!");

                        }
                        break;
                    }
                    break;


                case "6":
                    //Print all students of 1 course in 1 semester
                    System.out.print("Enter the course ID you want to check: ");
                    String courseIDOfAllStudents = scan.next();
                    System.out.print("Semester: ");
                    String semesterOfAllStudents = scan.next();
                    //Name of that course for displaying
                    String nameOfThatCourse = "";
                    //Array list to store all students of user input course and semester
                    ArrayList<String> studentOfCourseAndSemester = new ArrayList<>();
                    //For loop to add all students from enrolment list to the list
                    for (int i = 0; i < studentEnrolment.enrolmentList.size(); i++){
                        if (studentEnrolment.enrolmentList.get(i).getCourse().getId().equalsIgnoreCase(courseIDOfAllStudents)
                        && studentEnrolment.enrolmentList.get(i).getSemester().equalsIgnoreCase(semesterOfAllStudents)){
                            studentOfCourseAndSemester.add(studentEnrolment.enrolmentList.get(i).getStudent().toString());
                            nameOfThatCourse = studentEnrolment.enrolmentList.get(i).getCourse().getName();
                        }
                    }
                    //Display
                    String studentOfCourseAndSemesterSavedCSV = "";
                    System.out.println("All students of course " + courseIDOfAllStudents + ": " + nameOfThatCourse + " of semester "+ semesterOfAllStudents + ": ");
                    for (String s : studentOfCourseAndSemester) {
                        System.out.println(s);
                        studentOfCourseAndSemesterSavedCSV += s;
                        studentOfCourseAndSemesterSavedCSV += NEW_LINE_SEPARATOR;
                    }

                    //allows to save as CSV file
                    while (true){
                        System.out.print("Save as CSV files (Y/N): ");
                        String save = scan.next();
                        if (save.equals("Y")){
                            System.out.print("Filename (filename.txt): ");
                            Scanner scanFileName = new Scanner(System.in);
                            String fileNameCase5 = scanFileName.nextLine();

                            saveCSV(studentOfCourseAndSemesterSavedCSV, fileNameCase5);
                            System.out.println("Saved as CSV file successfully!");

                        }
                        break;
                    }
                    break;

                case "7":
                    //Print all courses offered in 1 semester
                    System.out.print("Enter the semester you want to check: ");
                    String semesterAllCourse = scan.next();
                    //Arraylist to store all courses
                    ArrayList<String> allCoursesInSemester = new ArrayList<>();
                    for (int i = 0; i < studentEnrolment.enrolmentList.size(); i++){
                        if (studentEnrolment.enrolmentList.get(i).getSemester().equals(semesterAllCourse)){
                            allCoursesInSemester.add(studentEnrolment.enrolmentList.get(i).getCourse().toString());

                        }
                    }
                    //Remove duplicate courses
                    ArrayList<String> removeDuplicated = new ArrayList<>();
                    for (String element : allCoursesInSemester){
                        if (!removeDuplicated.contains(element)){
                            removeDuplicated.add(element);
                        }
                    }
                    System.out.println("All courses of semester "+ semesterAllCourse + ": ");
                    String allCourseOfSemesterSavedCSV = "";
                    for (String s : removeDuplicated) {
                        System.out.println(s);
                        allCourseOfSemesterSavedCSV += s;
                        allCourseOfSemesterSavedCSV += NEW_LINE_SEPARATOR;
                    }

                    //allows to save as CSV file
                    while (true){
                        System.out.print("Save as CSV files (Y/N): ");
                        String save = scan.next();
                        if (save.equals("Y")){
                            System.out.print("Filename (filename.txt): ");
                            Scanner scanFileName = new Scanner(System.in);
                            String fileNameCase5 = scanFileName.nextLine();

                            saveCSV(allCourseOfSemesterSavedCSV, fileNameCase5);
                            System.out.println("Saved as CSV file successfully!");

                        }
                        break;
                    }
                    break;

                case "8":
                    //Get information of one enrolment
                    System.out.print("Student ID of that enrolment: ");
                    String sid = scan.next();
                    System.out.print("Course ID of that enrolment: ");
                    String cid = scan.next();
                    //Print that enrolment
                    System.out.println("Information of that enrolment: \n" + studentEnrolment.getOne(sid,cid));
                    //allows to save as CSV file
                    while (true){
                        System.out.print("Save as CSV files (Y/N): ");
                        String save = scan.next();
                        if (save.equals("Y")){
                            System.out.print("Filename (filename.txt): ");
                            Scanner scanFileName = new Scanner(System.in);
                            String fileNameCase5 = scanFileName.nextLine();

                            saveCSV(studentEnrolment.getOne(sid,cid).toString(), fileNameCase5);
                            System.out.println("Saved as CSV file successfully!");

                        }
                        break;
                    }
                    break;

                case "9":
                    //Display all enrollments
                    ArrayList<StudentEnrolment> printAll = new ArrayList<StudentEnrolment>();
                    printAll = studentEnrolment.getAll();
                    System.out.println("All enrolments: ");
                    String allEnrolmentSavedCSV = "";
                    for (StudentEnrolment enrolment : printAll) {
                        System.out.println(enrolment);
                        allEnrolmentSavedCSV += enrolment;
                        allEnrolmentSavedCSV += NEW_LINE_SEPARATOR;
                    }
                    //allows to save as CSV file
                    while (true){
                        System.out.print("Save as CSV files (Y/N): ");
                        String save = scan.next();
                        if (save.equals("Y")){
                            System.out.print("Filename (filename.txt): ");
                            Scanner scanFileName = new Scanner(System.in);
                            String fileNameCase5 = scanFileName.nextLine();

                            saveCSV(allEnrolmentSavedCSV, fileNameCase5);
                            System.out.println("Saved as CSV file successfully!");

                        }
                        break;
                    }
                    break;
                case "0":
                    System.out.println("Goodbye! Thank you for using the system! Have a good day ヅ");
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }


        }
    }




}