class Pen{

    String color;
    String type;
    public void write(){
        System.out.println("writing something");
    }
    public void printcolor()
    {
        System.out.println(this.color);
    }

}


public class OOPS {
    public static void main(String[] args){
        Pen pen1 = new Pen();
        Pen pen2 = new Pen();
        pen1.color = "Blue";
        pen2.color = "Black";
        pen1.type="gel";
        pen2.type="ballpoint";
        pen1.write();
        pen1.printcolor();
        pen2.printcolor();
    }
}
