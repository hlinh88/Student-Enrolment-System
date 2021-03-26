package StudentEnrolmentSystem;


import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentEnrolment implements StudentEnrolmentManager {
    // three properties and an arrayList to store enrollment
    private Student student;
    private Course course;
    private String semester;
    public ArrayList<StudentEnrolment> studentList= new ArrayList<StudentEnrolment>();

    /**
     * @param student
     * @param course
     * @param semester
     */
    public StudentEnrolment(Student student, Course course, String semester) {
        this.student = student;
        this.course = course;
        this.semester = semester;
    }


    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    //Add StudentEnrollment to list
    @Override
    public void add(StudentEnrolment student){
        studentList.add(student);
    }

    //Update student data
    @Override
    public void update(StudentEnrolment update){
        //For loop to go through the arrayList
        for (int i = 0; i < studentList.size(); i++){
            StudentEnrolment student = studentList.get(i);
            //Finding the student elements in the list to update
            if (student.getStudent().getId() == update.getStudent().getId()){
                studentList.set(i, update);
                break;
            }
        }
    }

    //Delete student data

    //Return information of one given student
    @Override
    public StudentEnrolment getOne(String id){
        for(int i = 0; i < studentList.size(); i++){
            //return student if the given id in the arrayList
            if (studentList.get(i).getStudent().getId() == id){
                return studentList.get(i);
            }
        }
        return null;
    }

    //Return all elements in the arrayList
    public ArrayList<StudentEnrolment> getAll(){
        return studentList;
    }



}




