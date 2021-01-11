package University;

import java.util.ArrayList;

public class FacultyMember extends Person{

    private String employeeId;
    private ArrayList<Course> teaching = new ArrayList<>();

    public FacultyMember(String name, Address address, String employeeId) {
        super(name, address);
        this.employeeId=employeeId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public ArrayList<Course> getTeaching() {
        return teaching;
    }

    public void setTeaching(ArrayList<Course> teaching) {
        this.teaching = teaching;
    }
    public void add(Course x){

        teaching.add(x);
    }

    public void delete(Course x){
        teaching.remove(x);
    }
}
