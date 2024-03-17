// Package is used to include this with the other Classes when importing
package Classes;

// Include the array list library for dynamic arrays
import java.util.ArrayList;
// Import random for random numbers
import java.util.Random;

// Extend based on the parent class Person
public class Student extends Person {
    // Create an array list for all of the students classes
    public ArrayList<String> classes = new ArrayList<String>();
    // Constructor for the student
    public Student(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
        this.title = "Student";
    }
    // Add classes from array
    public void addClasses(String[] classes){
        for (String classname : classes) {
            this.classes.add(classname);
        }

    }
    // intro is already called in the parent, defining it here overides it
    public void intro(){
        // Run the orginal intro
        super.intro();
        this.printClasses();
    }
    // Function for when the student studies
    public void study(){
        // Create a new random object
        Random rand = new Random();
        // Get the size (length) of the classes
        int size = this.classes.size();
        // get a random id from 0 to the total size
        int randId = rand.nextInt(size);

        // Set the study class to the random class
        String studyClass = classes.get(randId);
        String msg;
        // if there are more than 0 classes, display study message
        if(size > 0 ) msg = this.firstName + "is now studding " + studyClass;
        // else dispaly no classes
        else  msg = this.firstName + "has no classes to studdy";
        System.out.println(msg);

    }
    // Print all classes the student is taking
    public void printClasses(){
        // Check if the size is greater than 0
        if(this.classes.size() > 0) {
            // Display the class info message 
            System.out.println(this.firstName + " Is taking the following clases..");
            // For each class display the class name
            for (String className : classes) {
                System.out.println(className);
            }
        }
    }
}