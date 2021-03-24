package StudentEnrolmentSystem;

import java.util.ArrayList;

public interface StudentEnrolmentManager {
    //Add StudentEnrolment to the list
    public void add(StudentEnrolment s);

    //Update an enrolment of student to the list
    public void update(StudentEnrolment s);

    //Delete student with given id
    // public boolean delete(int id);

    //Return student with given id
    public StudentEnrolment getOne(int id);

    //Return student array list
    public ArrayList<StudentEnrolment> getAll();
}
