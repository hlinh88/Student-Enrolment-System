package StudentEnrolmentSystem;

import java.util.ArrayList;

public interface StudentEnrolmentManager {
    //Add StudentEnrolment to the list
    public boolean add(StudentEnrolment record);

    //Update an enrolment of student to the list
    public boolean update(StudentEnrolment oldRecord,StudentEnrolment newRecord);

    //Delete student with given id
    public boolean delete(StudentEnrolment record);

    //Return student with given id
    public StudentEnrolment getOne(String sid, String cid);

    //Return student array list
    public ArrayList<StudentEnrolment> getAll();
}
