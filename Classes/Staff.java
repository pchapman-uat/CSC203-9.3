// Package is used to include this with the other Classes when importing
package Classes;

// Extends means it will inhearit the properties of person
public class Staff extends Person {
    // Create public variables
    public String position;
    // Create private variables
    private int rate;
    

    
    // Construct the object using the parent class, while adding the title of staff
    public Staff(String firstName, String lastName, int age) {
        // Super is used for the constructor of the parent class
        super(firstName, lastName, age);
        this.title = "Staff";
    }

    // intro is already called in the parent, defining it here overides it
    public void intro(){
        // Call the orginal intro
        super.intro();
        // Display the position of possible
        if(this.position != null) System.out.println("And my possition is " + this.position);
    }
    // Set the pay if the password is correct
    public void setPay(int accPassword, int rate) {
        if(this.checkPassword(accPassword)){
            this.rate = rate;
        }

    }

    // Get the pay if the password is correct, else return 0
    public int getPay(int accPassword){

        if(this.checkPassword(accPassword)) return this.rate;
        else return 0;
    }
}
