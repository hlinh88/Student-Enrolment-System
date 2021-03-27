package StudentEnrolmentSystem;

import java.time.LocalDate;

public class Student {
    private String id;
    private String name;
    private LocalDate birthdate;

    public Student(){

    }

    /**
     * @param id
     * @param name
     * @param birthdate
     */
    public Student(String id, String name, LocalDate birthdate) {
        super();
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return the birthdate
     */
    public LocalDate getBirthdate() {
        return birthdate;
    }
    /**
     * @param birthdate the birthdate to set
     */
    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}
