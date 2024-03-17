// Package is used to include this with the other Classes when importing
package Classes;

public class Person {
    // Create public variables
    // Create the First Name, Last Name, age, and title variables
    public String firstName;
    public String lastName;
    public int age;
    public String title;

    // Create a password variable
    private int accPassword;
    // Create a property location Variable
    private String propertyLocation;

    // Constructor for the class object
    public Person(String firstName, String lastName, int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    // Set the password no matter what
    public void setPassword(int accPassword){
        this.accPassword = accPassword;
    }
    // Check if inputed password is the same as actual password
    public Boolean checkPassword(int accPassword){
        if(accPassword == this.accPassword) return true;
        else{
            System.out.println("Incorrect Password, please change password if needed");
            return false;
        }
    }

    // Display an intro about the person
    public void intro(){
        String part2 = "";
        // If they are older than 0, display age message
        if(this.age > 0 ) part2 = " and I am " + Integer.toString(this.age) + " years old";
        System.out.println("Hello! My name is " + this.firstName + " " + this.lastName + part2 );
        // If they have a title, dispaly it
        if(this.title != null) System.out.println("My Title is: " + this.title);
    }

    // Eat function that has an input of the string of the food
    public void eat(String food){
        System.out.println(this.firstName + " ate the " + food);
        
    }
    // A sleep fucntion for the duration of hours
    public void sleep(int hours){
        System.out.println(this.firstName + " slept for " + hours + " hours");
    }

    // Set the property of the location inputed, if the password is correct
    public String setProperty(int accPassword, String location){
        if(checkPassword(accPassword)) this.propertyLocation = location;
        return this.propertyLocation;
    }
    // Get the location if the password is correct, else return N/A
    public String getProperty(int accPassword){
        if(checkPassword(accPassword)) return this.propertyLocation;
        else return "N/A";
    }


}
