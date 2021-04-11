package StudentEnrolmentSystem;

import java.time.LocalDate;
import java.util.Objects;

public class Student {
    private String id;
    private String name;
    private String birthdate;

    public Student(){

    }

    /**
     * @param id
     * @param name
     * @param birthdate
     */
    public Student(String id, String name, String birthdate) {
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
    public String getBirthdate() {
        return birthdate;
    }
    /**
     * @param birthdate the birthdate to set
     */
    public void setBirthdate(String birthdate) {
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

    /**
     * check duplicated student
     */
    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()){
            return false;
        }

        return this.id == ((Student) obj).id
                && this.name == ((Student) obj).name
                && this.birthdate == ((Student) obj).birthdate;
    }
    @Override
    public int hashCode(){
        return Objects.hash(id, name, birthdate);
    }
}
