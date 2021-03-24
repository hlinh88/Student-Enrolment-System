package StudentEnrolmentSystem;

public class Course {
    private String id;
    private String name;
    private int numOfCredits;
    /**
     * @param id
     * @param name
     * @param numOfCredits
     */

    public Course(String id, String name, int numOfCredits) {
        this.id = id;
        this.name = name;
        this.numOfCredits = numOfCredits;
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
     * @return the numOfCredits
     */
    public int getNumOfCredits() {
        return numOfCredits;
    }
    /**
     * @param numOfCredits the numOfCredits to set
     */
    public void setNumOfCredits(int numOfCredits) {
        this.numOfCredits = numOfCredits;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", numOfCredits=" + numOfCredits +
                '}';
    }
}
