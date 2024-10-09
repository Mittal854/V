
import java.util.Scanner;


class RectangleException{

    double perimeter;
    double area;


    public void validate(double length,double breadth)
    {
        if(length>0 && breadth>0)
        {
            perimeter=2*(length+breadth);
            area=length*breadth;
            System.out.println("Perimeter: "+perimeter);
            System.out.println("Area: "+area);

        }
        else
        {
            throw new RectangleInvalidException("RectangleInvalidException: Not a valid rectangle");
        }
    }

}
class RectangleInvalidException extends RuntimeException{

    public RectangleInvalidException(String message)
    {
        super(message);
    }
}

public class ExceptionHandling {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double length=sc.nextDouble();
        double breadth=sc.nextDouble();
        RectangleException obj=new RectangleException();
        try {
            obj.validate(length, breadth);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        sc.close(); 
    }
}