package Classes;

public class Staff extends Person {
    private int rate;
    public String position;

    

    public Staff(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
        this.title = "Staff";
    }

    public void intro(){
        super.intro();
        if(this.position != null) System.out.println("And my possition is " + this.position);;
    }
    public void setPay(int accPassword, int rate) {
        if(this.checkPassword(accPassword)){
            this.rate = rate;
        }

    }

    public int getPay(int accPassword){

        if(this.checkPassword(accPassword)) return this.rate;
        else return 0;
    }
}
