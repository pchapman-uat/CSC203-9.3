// Since all of the classes are stored in a folder, we must import them
// the '.*' Specifies that all elements from the folder are inported
import Classes.*;

// Import the array list library, this allows for dynamicly adjusting arrays
import java.util.ArrayList;
// Import the scanner, this allows for reading input in the terminal
import java.util.Scanner;


public class Main {
    // Create a new scanner object
    static Scanner scanner = new Scanner(System.in);   

    // Create a function that prints a message and then returns the next line
    public static String input(String msg){
        System.out.println(msg);
        String testing = scanner.nextLine();
        return testing;
    }

    // Function to add classes to a student, this accepts a Student object
    // This would idealy be put within the class, but due to it using the scanner, I was unable to do so
    // I attempted to put the scanner as an input to the function but that failed
    public static void addClasses(Student student){
        // Get the number of classes from the user 
        int  totalClasses = Integer.parseInt(input("How many calsses should " + student.firstName + " take?"));
        // Create an array for the number of classes
        // An array list was not used as we knew the size of the array already
        String[] allClasses = new String[totalClasses];
        // For loop for the number of classes
        for (int i = 0; i < totalClasses; i++) {
            // Set the vlaue at the index of the loop of the class ID inputed by the user
            allClasses[i] = input("Please enter the class ID");
        }
        // Add all the classes to the student
        student.addClasses(allClasses);
    }
    public static void main(String[] args) {
        
        System.out.println("\t\t Welcome to UAT\n");

        // Create example objects of Staff, Professor, and Student
        Staff staff1 = new Staff("Preston", "Chapman", 19);
        Professor professor1 = new Professor("Tony", "Hinton", 0);
        Student student1 = new Student("John","Doe", 19);
        

        // Assign a class to the proffesor object
        professor1.assignClass("CSC203", "Java Programing I", 10);
        // Add a class to the student
        student1.addClasses(new String[]{"CSC230"});

        // Create array lists of all of the Staff, Professors, and Studdents
        ArrayList<Staff> allStaff = new ArrayList<Staff>();
        allStaff.add(staff1);
        ArrayList<Professor> allProfessors = new ArrayList<Professor>();
        allProfessors.add(professor1);
        ArrayList<Student> allStudents = new ArrayList<Student>();
        allStudents.add(student1);

        // While loop for the interactions with the user, will continue until the user says "leave"
        String choice = "";
        while(!choice.equals("leave")) {
            // Ask the user what they would like to do, then print the options, and store their responce
            System.out.println("What would you like to do: ");
            choice =  input("Create | List | AddClasses | Action | Leave ").toLowerCase();
            // Creating a new Person
            if(choice.equals("create")) {
                // Ask for the first name, last name, and age, as these are shared between all classes
                String firstName = input("What is their first name");
                String lastName = input("What is their last name");
                int age = Integer.parseInt(input("What is their age (0 for none)"));

                // Ask for the title of them, and create the respective object
                // Add the object to the respective ArrayList
                System.out.println("What is their title");
                String createChoice = input("Staff | Professor | Student").toLowerCase();
                if (createChoice.equals("staff")) {
                    Staff userStaff = new Staff(firstName, lastName, age);
                    allStaff.add(userStaff);
                } else if (createChoice.equals("professor")) {
                    Professor userProfessor = new Professor(firstName, lastName, age);
                    allProfessors.add(userProfessor);
                } else if (createChoice.equals("student")){
                    Student userStudent = new Student(firstName, lastName, age);
                    allStudents.add(userStudent);
                }
            // If the user selected list, display all people of type
            } else if(choice.equals("list")){
                System.out.println("list what type?");
                // Ask what type of person to list
                String listChoice = input("Staff | Professor | Student").toLowerCase();
                
                // Display all of the intros for the people of the type
                if(listChoice.equals("staff")){
                    for (Staff staff : allStaff) {
                        staff.intro();
                        System.out.println("");
                    }
                } else if(listChoice.equals("professor")){
                    for (Professor proff : allProfessors) {
                        proff.intro();
                        System.out.println("");
                    }
                } else if(listChoice.equals("student")){
                    for (Student student : allStudents) {
                        student.intro();
                        System.out.println("");
                    }
                }
            // If the user wants to add classes
            } else if(choice.equals("addclasses")){
                // Display all students
                int i = 1;
                for (Student student : allStudents) {
                    System.err.println("["+i+"]"+ student.firstName + " " + student.lastName);
                    i++;
                }
                // Request the number for the student, then run the addClasses function
                int studentNum = Integer.parseInt(input("What student do you want to add classes too?"));
                addClasses(allStudents.get(studentNum - 1));
            // If the user wants to have a person do an action
            } else if(choice.equals("action")){
                // Ask what type of person to do the action to
                String actionPerson = input("Staff | Professor | Student").toLowerCase();
                // Create an array list of posible actions
                ArrayList<String> actions = new ArrayList<String>();
                
                // Create a general person object, this is replaced with either a Staff, Professor, or Student
                Person person = new Person("dummy","dummy", 0);
                // Create a dummy object that will be replaced with a student if needed
                Student actionStudent = new Student("dummy", "dummy", 0);
                // Create a dummy object that will be replaced with a professor if needed
                Professor actionProfessor = new Professor("dummy", "dummy", 0);
                // Add the options eat and sleep since all people have it
                actions.add("Eat");
                actions.add("Sleep");
                actions.add("getLocation");
                actions.add("setLocation");
                actions.add("setPassword");
                // Display all people of the type
                if(actionPerson.equals("staff")){
                    int i = 1;
                    for (Staff staff : allStaff) {
                        System.err.println("["+i+"]"+ staff.firstName + " " + staff.lastName);
                        i++;
                    }
                    int personNum = Integer.parseInt(input("What staff should do an action?"));
                    person = allStaff.get(personNum - 1);
                } else if(actionPerson.equals("professor")){
                    int i = 1;
                    for (Professor prof : allProfessors) {
                        System.err.println("["+i+"]"+ prof.firstName + " " + prof.lastName);
                        i++;
                       
                    }
                    int personNum = Integer.parseInt(input("What staff should do an action?"));
                    // Save the object to the action Professor, and the general person variables
                    actionProfessor = allProfessors.get(personNum - 1);
                    person = actionProfessor;
                    // add the action option of teach
                    actions.add("Teach");
                }   else if(actionPerson.equals("student")){
                    int i = 1;
                    for (Student student : allStudents) {
                        System.err.println("["+i+"]"+ student.firstName + " " + student.lastName);
                        i++;
                    }
                    int personNum = Integer.parseInt(input("What staff should do an action?"));
                    // Save the object to the action Student, and the general student variables
                    actionStudent = allStudents.get(personNum - 1); 
                    person = actionStudent;
                    // add the action option of study
                    actions.add("Study");
                }
                //  Create tyhe action options message
                String actionMsg = "";
                for (String type : actions) {
                    actionMsg = actionMsg + type + " | ";
                }

                // Dispaly the question for the action
                System.out.println("What action should " + person.firstName + "do?");
                String action = input(actionMsg).toLowerCase();
                // Run the sleep or eat function respectivly

                if(action.equals("sleep")) person.sleep(10);
                else if(action.equals("eat")) person.eat("apple");

                else if(action.equals("setpassword")){
                    int pswrd = Integer.parseInt(input("Please enter the password (Numbers only)"));
                    person.setPassword(pswrd);
                } else if(action.equals("setlocation")){
                    int pswrd = Integer.parseInt(input("Please enter the password (Numbers only)"));
                    String location = input("Please enter the location");
                    person.setProperty(pswrd, location);
                } else if(action.equals("getlocation")){
                    int pswrd = Integer.parseInt(input("Please enter the password (Numbers only)"));
                    System.out.println(person.firstName + " Is currently at " + person.getProperty(pswrd));

                }
                // if the person is a student, and they selected study, run study
                // This is why the actionStudent was saved, as the general person vairable would not work in this case
                else if(actionPerson.equals("student")) {
                    if(action.equals("study")) actionStudent.study();
                }
                // Do the same for the professor and teaching
                else if(actionPerson.equals("professor")) {
                    if(action.equals("teach")) actionProfessor.teachClass();
                }
            }
            // Code will now loop until the user says leave
        }
        
        System.out.println("Finished");

    }
}

