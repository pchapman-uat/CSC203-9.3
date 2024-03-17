package Classes;

public class Person {
    public String firstName;
    public String lastName;
    public int age;
    public String title;

    private int accPassword;
    private String propertyLocation;

    public Person(String firstName, String lastName, int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public void setPassword(int accPassword){
        if(this.accPassword == 0) this.accPassword = accPassword;
    }
    public Boolean checkPassword(int accPassword){
        return accPassword == this.accPassword;
    }

    public void intro(){
        String part2 = "";
        if(this.age > 0 ) part2 = " and I am " + Integer.toString(this.age) + " years old";
        System.out.println("Hello! My name is " + this.firstName + " " + this.lastName + part2 );
        if(this.title != null) System.out.println("My Title is: " + this.title);
    }

    public void eat(String food){
        System.out.println(this.firstName + " ate the " + food);
        
    }
    public void sleep(int hours){
        System.out.println(this.firstName + " slept for " + hours + " hours");
    }
    public String setProperty(int accPassword, String location){
        if(checkPassword(accPassword)) this.propertyLocation = location;
        return this.propertyLocation;
    }
    public String getProperty(int accPassword){
        if(checkPassword(accPassword)) return this.propertyLocation;
        else return "N/A";
    }


}
