package University;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Driver {

    public static void main(String[] args) {

        //Create a scanner object for user input
        Scanner sc = new Scanner(System.in);

        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Course> courses = new ArrayList<>();
        ArrayList<FacultyMember> faculty = new ArrayList<>();
        //Variable unique to  Student
        String cin;
        //variable unique to faculty
        String employeeId;
        //Variables that both student and faculty have in common
        String name;
        int streetNumber;
        String streetName;
        String city;
        String state;
        String country;

        //Variables for courses
        String identifier;
        int units;

        //student and course index
        int studentIndex;
        int courseIndex;
        int facultyIndex;

        int choice = 0;
        do {
            showMenu();
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter Name: ");
                    name= sc.nextLine();
                    System.out.println("Enter CIN: ");
                    cin = sc.nextLine();
                    System.out.println("-------Student Address------- ");
                    System.out.println(" ");
                    System.out.println("Enter street number: ");
                    streetNumber = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter street name: ");
                    streetName = sc.nextLine();
                    System.out.println("Enter city: ");
                    city = sc.nextLine();
                    System.out.println("Enter state: ");
                    state = sc.nextLine();
                    System.out.println("Enter country: ");
                    country = sc.nextLine();

                    //Create a new address
                    Address address = new Address(streetNumber, streetName, city, state, country);
                    //Create a student
                    students.add(new Student(name, address, cin));
                    break;
                case 2://Print list of students and show index
                    System.out.println("-------Students-------");
                    for (int i = 0; i < students.size(); i++) {
                        System.out.println(students.get(i).toString()+" Index: " + i);
                    }
                    System.out.println("Enter index of student you want to delete: ");
                    studentIndex = sc.nextInt();
                    sc.nextLine();
                    students.remove(studentIndex);
                    System.out.println("Student at index "+ studentIndex + " deleted.");



                    break;

                case 3:
                    if(students.isEmpty()){
                        System.out.println("There are no students enrolled. Add a student using option 1:");
                        System.out.println(" ");
                        break;}
                    for (int i = 0; i < students.size(); i++) {
                        System.out.println(students.get(i).toString());

                    }
                    break;
                case 4:
                    //check if there are students and courses in order to add a student to a course

                    if(students.isEmpty() && courses.isEmpty()){
                        System.out.println("You have not added any courses or students!");
                        System.out.println(" ");
                        break;
                    }
                    else if(courses.isEmpty()){
                        System.out.println("You have not created a course. Add a course using option 6:");
                        System.out.println(" ");
                        break;
                    }
                    else if(students.isEmpty()){
                        System.out.println("There are no students enrolled. Add a student using option 1:");
                        System.out.println(" ");
                        break;


                    }

                    //print list of students/courses and show index
                    System.out.println("-------Students-------");
                    for (int i = 0; i < students.size(); i++) {
                        System.out.println(students.get(i).toString()+" Index: " + i);
                    }
                    System.out.println(" ");
                    System.out.println("-------Courses-------");
                    //print list of courses and show index
                    for (int i = 0; i < courses.size(); i++) {
                        System.out.println(courses.get(i).toString() + " Index: "+ i);
                    }
                    System.out.println(" ");
                    System.out.println("Enter the index of the student you want to enroll in a course: ");
                    studentIndex = sc.nextInt();
                    System.out.println("Enter the index of the course: ");
                    courseIndex = sc.nextInt();
                    sc.nextLine();

                    students.get(studentIndex).add(courses.get(courseIndex));
                    System.out.println("Student at index " + studentIndex + " is now enrolled in course at index " + courseIndex);

                    break;
                case 5:
                    if(students.isEmpty()){
                        System.out.println("There are no students enrolled. Add a student using option 1:");
                        System.out.println(" ");
                        break;}
                    // Print students and courses/ show index so that user can choose which student to drop from desired course
                    System.out.println("-------Students-------");
                    for (int i = 0; i < students.size(); i++) {
                        System.out.println(students.get(i).toString()+" Index: " + i);
                    }
                    System.out.println(" ");
                    System.out.println("-------Courses-------");
                    //print list of courses and show index
                    for (int i = 0; i < courses.size(); i++) {
                        System.out.println(courses.get(i).toString() + " Index: "+ i);
                    }
                    System.out.println(" ");
                    System.out.println("Enter index of student you want to drop from a course: ");
                    studentIndex = sc.nextInt();
                    System.out.println("Enter index of course: ");
                    courseIndex = sc.nextInt();
                    sc.nextLine();
                    students.get(studentIndex).delete(courses.get(courseIndex));

                    System.out.println("Student at index " + studentIndex + " has been dropped from " + courses.get(courseIndex).getIdentifier());

                    break;
                case 6:
                    System.out.println("Enter course identifier : eg(, EE-132) ");
                    identifier = sc.nextLine();


                    System.out.println("Enter # of units: ");
                    units = sc.nextInt();
                    sc.nextLine();

                    courses.add(new Course(identifier, units));
                    break;
                case 7:
                    for (int i = 0; i < courses.size(); i++) {
                        System.out.println(courses.get(i).toString());
                    }
                    break;
                case 8:
                    System.out.println("Enter Name: ");
                    name = sc.nextLine();

                    System.out.println("Enter employee ID: ");
                    employeeId = sc.nextLine();

                    System.out.println("-------Faculty Address------- ");
                    System.out.println(" ");
                    System.out.println("Enter street number: ");
                    streetNumber = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter street name: ");
                    streetName = sc.nextLine();
                    System.out.println("Enter city: ");
                    city = sc.nextLine();
                    System.out.println("Enter state: ");
                    state = sc.nextLine();
                    System.out.println("Enter country: ");
                    country = sc.nextLine();

                    //Create a new address
                    Address facultyAddress = new Address(streetNumber, streetName, city, state, country);
                    //Create a student
                    faculty.add(new FacultyMember(name, facultyAddress, employeeId));
                    break;
                case 9:
                    System.out.println("-------Faculty-------");
                    for (int i = 0; i < faculty.size(); i++) {
                        System.out.println(faculty.get(i).toString()+ " Index: "+ i);
                    }
                    System.out.println("Enter the index of a faculty member you want to delete: ");
                    facultyIndex=sc.nextInt();
                    faculty.remove(facultyIndex);

                        break;

                case 10:
                    //If faculty list is empty print a message
                    if(faculty.isEmpty()){
                        System.out.println("There are no faculty in the system. Use option 8 to add faculty: ");
                        System.out.println(" ");
                        break;
                    }
                    System.out.println("-------Faculty-------");
                    for (int i = 0; i < faculty.size(); i++) {
                        System.out.println(faculty.get(i).toString());
                        break;
                    }
                case 11:
                    if(faculty.isEmpty() && courses.isEmpty()){
                        System.out.println("You have not added any courses or students!");
                        System.out.println(" ");
                        break;
                    }
                    else if(courses.isEmpty()){
                        System.out.println("You have not created a course. Add a course using option 6:");
                        System.out.println(" ");
                        break;
                    }
                    else if(faculty.isEmpty()){
                        System.out.println("There are no students enrolled. Add a student using option 1:");
                        System.out.println(" ");
                        break;
                    }

                    //print list of Faculty/courses and show index
                    System.out.println("-------Faculty-------");
                    for (int i = 0; i < faculty.size(); i++) {
                        System.out.println(faculty.get(i).toString()+" Index: " + i);
                    }
                    System.out.println(" ");
                    System.out.println("-------Courses-------");
                    //print list of courses and show index
                    for (int i = 0; i < courses.size(); i++) {
                        System.out.println(courses.get(i).toString() + " Index: "+ i);
                    }
                    System.out.println(" ");
                    System.out.println("Enter the index of the faculty you want to assign to a course: ");
                    facultyIndex = sc.nextInt();
                    System.out.println("Enter the index of the course: ");
                    courseIndex = sc.nextInt();

                    faculty.get(facultyIndex).add(courses.get(courseIndex));
                    System.out.println("Student at index " + facultyIndex + " is now enrolled in course at index " + courseIndex) ;
                    break;
                case 12:
                    if(faculty.isEmpty()){
                        System.out.println("There are no faculty in the system. Use option 8 to add faculty: ");
                        System.out.println(" ");
                        break;
                    }
                    //print list of Faculty/courses and show index
                    System.out.println("-------Faculty-------");
                    for (int i = 0; i < faculty.size(); i++) {
                        System.out.println(faculty.get(i).toString()+" Index: " + i);
                    }
                    System.out.println(" ");
                    System.out.println("-------Courses-------");
                    //print list of courses and show index
                    for (int i = 0; i < courses.size(); i++) {
                        System.out.println(courses.get(i).toString() + " Index: "+ i);
                    }
                    System.out.println(" ");
                    System.out.println("Enter the index of faculty member you want to drop from a course: ");
                    facultyIndex=sc.nextInt();
                    System.out.println("Enter the index of the course: ");
                    courseIndex = sc.nextInt();
                    faculty.get(facultyIndex).delete(courses.get(courseIndex));
                    System.out.println("Faculty at index " + facultyIndex + " has been dropped from " + courses.get(courseIndex).getIdentifier());








            }
        }while (choice != 13) ;





    }

    public static void showMenu() {
        //Student Menu
        System.out.println("Students");
        System.out.println("1.Add student");
        System.out.println("2.Delete Student");
        System.out.println("3.Print list of students");
        System.out.println("4.Enroll student into course");
        System.out.println("5.Drop student from course");
        System.out.println(" ");
        //Course Menu
        System.out.println("Courses");
        System.out.println("6.Add course");
        System.out.println("7.Print list of courses");
        System.out.println(" ");
        //Faculty Menu
        System.out.println("Faculty");
        System.out.println("8.Add faculty");
        System.out.println("9.Delete Faculty");
        System.out.println("10.Print list of Faculty");
        System.out.println("11.Assign faculty to course");
        System.out.println("12.Drop faculty from course");
        System.out.println(" ");
        System.out.println("13.Exit");
    }


}

