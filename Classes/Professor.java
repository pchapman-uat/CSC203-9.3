// Package is used to include this with the other Classes when importing
package Classes;

// Extends means it will inhearit the properties of Staff
public class Professor extends Staff {
    // Creat public vairables
    public int numStudents;
    public String classID;
    public String className;

 // Construct the object using the parent class, while adding the positon of Professor
    public Professor(String firstName, String lastName, int age) {
        // Super is used for the constructor of the parent class
        super(firstName, lastName, age);
        this.position = "Professor";
    }

    // intro is already called in the parent, defining it here overides it
    public void intro() {
        // Call the orginal intro
        super.intro();
        // If there is a classID and name, display the information
        if(classID != null && className != null) System.out.println("I teach " + this.classID + " " + this.className + " for " + this.numStudents + " Students");
        
    }

    // assign the class values
    public void assignClass(String classID, String className, int numStudents){
        this.numStudents = numStudents;
        this.classID = classID;
        this.className = className;
    }
    // have the professor start teaching
    public void teachClass(){
        System.out.println("Professor " + this.firstName + " started teaching " + this.classID + " " + this.className);
    }

}