package Classes;

public class Professor extends Staff {
    public int numStudents;
    public String classID;
    public String className;

    public Professor(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
        this.position = "Professor";
    }



    public void assignClass(String classID, String className, int numStudents){
        this.numStudents = numStudents;
        this.classID = classID;
        this.className = className;
    }
    
    public void teachClass(){
        System.out.println("Professor " + this.firstName + " started teaching " + this.classID + " " + this.className);
    }

}