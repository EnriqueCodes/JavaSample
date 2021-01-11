package University;

import java.util.ArrayList;

public class Student extends Person{



    private String cin;
    private ArrayList<Course> courseSchedule = new ArrayList<Course>();

    Student(String name,Address address,String cin ){
        super(name,address);
        this.cin = cin;
    }

    public String getCin() {
        return cin;
    }



    public void setCin(String cin) {
        this.cin = cin;
    }

    public ArrayList<Course> getCourseSchedule() {
        return courseSchedule;
    }

    public void setCourseSchedule(ArrayList<Course> courseSchedule) {
        this.courseSchedule = courseSchedule;
    }

    public void add(Course x){

        courseSchedule.add(x);

    }
    public void delete(Course x){
        courseSchedule.remove(x);
    }

    @Override
    public String toString() {
        return "Name: " + getName() + ", CIN:" + cin + " , " + getAddress().toString();
    }


}
