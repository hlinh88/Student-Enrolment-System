package StudentEnrolmentSystem;

import java.util.ArrayList;

public interface StudentEnrolmentManager {
    //Add StudentEnrolment to the list
    public void add(StudentEnrolment s);

    //Update an enrolment of student to the list
    public void update(StudentEnrolment needToUpdate,StudentEnrolment update);

    //Delete student with given id
    public void delete(StudentEnrolment delete);

    //Return student with given id
    public StudentEnrolment getOne(String sid, String cid);

    //Return student array list
    public ArrayList<StudentEnrolment> getAll();
}
