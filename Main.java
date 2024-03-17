import Classes.*;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    Scanner scanner = new Scanner(System.in);   

    public String input(String msg){
        System.out.println(msg);
        return scanner.nextLine();
    }

    public void addClasses(Student student){ 
        int  totalClasses = Integer.parseInt(input("How many calsses should " + student.firstName + " take?"));
        int i = 0;
        String[] allClasses = new String[totalClasses];
        while(i < totalClasses){
            allClasses[i] = input("Please enter the class ID");
            i++;
        }
        student.addClasses(allClasses);
    }
    public void main(String[] args) {
        
        System.out.println("\t\t Welcome to UAT\n");

        Staff staff1 = new Staff("Preston", "Chapman", 19);
        Professor professor1 = new Professor("Tony", "Hinton", 0);
        Student student1 = new Student("John","Doe", 19);
        

        professor1.assignClass("CSC230", "Class 1", 10);
        student1.addClasses(new String[]{"CSC230"});
        ArrayList<Staff> allStaff = new ArrayList<Staff>();
        allStaff.add(staff1);
        ArrayList<Professor> allProfessors = new ArrayList<Professor>();
        allProfessors.add(professor1);
        ArrayList<Student> allStudents = new ArrayList<Student>();
        allStudents.add(student1);


        staff1.intro();
        professor1.intro();
        System.out.println("What would you like to do: ");
        String choice = "";


        while(!choice.equals("leave")) {
            choice =  input("Create | List | AddClasses | Action | Leave ").toLowerCase();
            if(choice.equals("create")) {
                String firstName = input("What is their first name");
                String lastName = input("What is their last name");
                int age = Integer.parseInt(input("What is their age (0 for none)"));

                System.out.println("What would you like to do?");
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
            } else if(choice.equals("list")){
                System.out.println("list what type?");
                String listChoice = input("Staff | Professor | Student").toLowerCase();
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
            } else if(choice.equals("addclasses")){
                int i = 1;
                for (Student student : allStudents) {
                    System.err.println("["+i+"]"+ student.firstName + " " + student.lastName);
                    i++;
                }
                int studentNum = Integer.parseInt(input("What student do you want to add classes too?"));
                addClasses(allStudents.get(studentNum - 1));
            } else if(choice.equals("action")){
                String actionPerson = input("Staff | Professor | Student").toLowerCase();

                ArrayList<String> actions = new ArrayList<String>();
                
                Person person = new Person("dummy","dummy", 0);
                Student actionStudent = new Student("dummy", "dummy", 0);
                Professor actionProfessor = new Professor("dummy", "dummy", 0);
                actions.add("Eat");
                actions.add("Sleep");
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
                    actionProfessor = allProfessors.get(personNum - 1);
                    person = actionProfessor;
                    actions.add("Teach");
                }   else if(actionPerson.equals("student")){
                    int i = 1;
                    for (Student student : allStudents) {
                        System.err.println("["+i+"]"+ student.firstName + " " + student.lastName);
                        i++;
                    }
                    int personNum = Integer.parseInt(input("What staff should do an action?"));
                    actionStudent = allStudents.get(personNum - 1); 
                    person = actionStudent;
                    actions.add("Study");
                }
                String actionMsg = "";
                for (String type : actions) {
                    actionMsg = actionMsg + type + " | ";
                }

                System.out.println("What action should " + person.firstName + "do?");
                String action = input(actionMsg).toLowerCase();
                if(action.equals("sleep")) person.sleep(10);
                else if(action.equals("eat")) person.eat("apple");
                else if(actionPerson.equals("student")) {
                    if(action.equals("study")) actionStudent.study();
                }
                else if(actionPerson.equals("professor")) {
                    if(action.equals("teach")) actionProfessor.teachClass();
                }
            }
        }
        
    
        System.out.println("Finished");

    }
}

