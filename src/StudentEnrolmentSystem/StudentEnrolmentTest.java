package StudentEnrolmentSystem;

import org.junit.*;

import java.util.ArrayList;


public class StudentEnrolmentTest {
    public static StudentEnrolment obj = new StudentEnrolment();


    @Test
    public void testAdd() {
        System.out.println("Test add");
        StudentEnrolment addTest1 = new StudentEnrolment(new Student("S101312","Alex Mike","10/13/1998"), new Course("COSC4030","Theory of Computation",5), "2020C");
        //Create existed enrolment to test
        obj.add(addTest1);
        StudentEnrolment addTest2 = new StudentEnrolment(new Student("S102732","Mark Duong","8/28/2001"), new Course("COSC4030","Theory of Computation",5), "2020C");

        Assert.assertTrue(obj.add(addTest2));
        Assert.assertFalse(obj.add(addTest1));
    }


    @Test
    public void update() {
        System.out.println("Update test");
        StudentEnrolment updateTest1 = new StudentEnrolment(new Student("S101312","Kobe Bryant","10/13/1998"), new Course("COSC4030","Theory of Computation",5), "2020C");
        obj.add(updateTest1);
        StudentEnrolment updateTest2 = new StudentEnrolment(new Student("S101312","Kobe Bryant","10/13/1998"), new Course("BUS2232","Business Law",3), "2020B");
        StudentEnrolment updateTest3 = new StudentEnrolment(new Student("S123456","Lebron James","10/13/1998"), new Course("BUS2232","Business Law",3), "2020B");

        Assert.assertTrue(obj.update(updateTest1, updateTest2));
        Assert.assertFalse(obj.update(updateTest3, updateTest1));
    }

    @Test
    public void delete() {
        System.out.println("Delete test");
        StudentEnrolment updateTest1 = new StudentEnrolment(new Student("S101312","Kobe Bryant","10/13/1998"), new Course("COSC4030","Theory of Computation",5), "2020C");
        obj.add(updateTest1);
        StudentEnrolment updateTest2 = new StudentEnrolment(new Student("S101312","Kobe Bryant","10/13/1998"), new Course("BUS2232","Business Law",3), "2020B");

        Assert.assertTrue(obj.delete(updateTest1));
        Assert.assertFalse(obj.delete(updateTest2));
    }

    @Test
    public void getOne() {
        System.out.println("Get one test");
        StudentEnrolment updateTest1 = new StudentEnrolment(new Student("S101312","Kobe Bryant","10/13/1998"), new Course("COSC4030","Theory of Computation",5), "2020C");
        obj.add(updateTest1);


        Assert.assertEquals(updateTest1, obj.getOne("S101312", "COSC4030"));

    }

    @Test
    public void getAll() {
        ArrayList<StudentEnrolment> test = new ArrayList<StudentEnrolment>();
        StudentEnrolment updateTest1 = new StudentEnrolment(new Student("S101312","Kobe Bryant","10/13/1998"), new Course("COSC4030","Theory of Computation",5), "2020C");
        StudentEnrolment updateTest2 = new StudentEnrolment(new Student("S123456","Lebron James","10/13/1998"), new Course("BUS2232","Business Law",3), "2020B");
        obj.add(updateTest1);
        obj.add(updateTest2);
        test.add(updateTest1);
        test.add(updateTest2);

        Assert.assertEquals(test, obj.getAll());

    }
}