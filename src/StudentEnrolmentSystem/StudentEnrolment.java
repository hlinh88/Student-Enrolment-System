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

    /**
     * check duplicated enrolment
     */
    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()){
            return false;
        }

        return this.student == ((StudentEnrolment) obj).student
                && this.course == ((StudentEnrolment) obj).course
                && this.semester == ((StudentEnrolment) obj).semester;
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
    public boolean add(StudentEnrolment record){
        for (int i = 0; i < enrolmentList.size(); i++){
            if (enrolmentList.get(i).equals(record)){
                System.out.println("Enrolment existed!");
                return false;
            }
        }
        enrolmentList.add(record);
        return true;
    }

    //Update student data
    @Override
    public boolean update(StudentEnrolment oldRecord,StudentEnrolment newRecord) {
        //For loop to go through the arrayList
        for (int i = 0; i < enrolmentList.size(); i++) {
            StudentEnrolment student = enrolmentList.get(i);
            if (student.equals(oldRecord)) {
                enrolmentList.set(i, newRecord);
                return true;
            }
        }
        return false;
    }

    //Delete student data
    @Override
    public boolean delete(StudentEnrolment record) {
        for (int i = 0; i < enrolmentList.size(); i++){
            StudentEnrolment student = enrolmentList.get(i);
            if (student.equals(record)){
                enrolmentList.remove(student);
                return true;
            }
        }
        return false;
    }

    //Return information of one given student
    @Override
    public StudentEnrolment getOne(String sid, String cid){
        for (int i = 0; i < enrolmentList.size(); i++) {
            //return student if the given id in the arrayList
            if (enrolmentList.get(i).getStudent().getId().equals(sid) && enrolmentList.get(i).getCourse().getId().equals(cid) ) {
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




