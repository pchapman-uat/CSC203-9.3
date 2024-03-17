package Classes;

import java.util.ArrayList;
import java.util.Random;

public class Student extends Person {
    public ArrayList<String> classes = new ArrayList<String>();
    public Student(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
    }
    public void addClasses(String[] classes){
        for (String classname : classes) {
            this.classes.add(classname);
        }

    }
    public void intro(){
        super.intro();
        this.printClasses();
    }
    public void study(){
        
        Random rand = new Random();
        int size = this.classes.size();
        int randId = rand.nextInt(size);

        String studyClass = classes.get(randId);
        String msg;
        if(size > 0 ) msg = this.firstName + "is now studding " + studyClass;
        else  msg = this.firstName + "has no classes to studdy";
        System.out.println(msg);

    }
    public void printClasses(){
        if(this.classes.size() > 0) {
            System.out.println(this.firstName + " Is taking the following clases..");
            for (String className : classes) {
                System.out.println(className);
            }
        }
    }
}