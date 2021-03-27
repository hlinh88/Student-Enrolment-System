package StudentEnrolmentSystem;


import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

public class StudentEnrolment implements StudentEnrolmentManager {
    // three properties and an arrayList to store enrollment
    private Student student;
    private Course course;
    private String semester;
    public ArrayList<StudentEnrolment> enrolmentList= new ArrayList<StudentEnrolment>();

    public StudentEnrolment(){

    }


    /**
     * @param student
     * @param course
     * @param semester
     */
    public StudentEnrolment(Student student, Course course, String semester) {
        super();
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

    @Override
    public String toString() {
        return "StudentEnrolment{" +
                "student=" + student +
                ", course=" + course +
                ", semester='" + semester + '\'' +
                '}';
    }

    //Add StudentEnrollment to list
    @Override
    public void add(StudentEnrolment student){
        enrolmentList.add(student);
    }

    //Update student data
    @Override
    public void update(StudentEnrolment needToUpdate,StudentEnrolment update) {
        //For loop to go through the arrayList
        for (int i = 0; i < enrolmentList.size(); i++) {
            StudentEnrolment student = enrolmentList.get(i);
            if (student.equals(needToUpdate)) {
                enrolmentList.set(i, update);
                break;
            }
        }
    }

    //Delete student data
    @Override
    public void delete(StudentEnrolment delete) {
        for (int i = 0; i < enrolmentList.size(); i++){
            StudentEnrolment student = enrolmentList.get(i);
            if (student.equals(delete)){
                enrolmentList.remove(student);
                break;
            }
        }

    }

    //Return information of one given student
    @Override
    public StudentEnrolment getOne(String id){
        for(int i = 0; i < enrolmentList.size(); i++){
            //return student if the given id in the arrayList
            if (enrolmentList.get(i).getStudent().getId().equals(id)){
                return enrolmentList.get(i);
            }
        }
        return null;
    }

    //Return all elements in the arrayList
    @Override
    public ArrayList<StudentEnrolment> getAll(){
        return enrolmentList;
    }



}




