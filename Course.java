package University;

public class Course {

    private String identifier;
    private int units;

    public Course(String identifier, int units) {
        this.identifier = identifier;
        this.units = units;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    @Override
    public String toString() {
        return "Course Name: " + identifier + ", # of units: " + units;
    }
}

