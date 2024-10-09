
import java.util.Scanner;

public class MathClass {
    public static void main(String[] args) {
        double a=-10.8;
        double b=20.1;
        System.out.println("Max is: "+Math.max(a,b));
        System.out.println("Min is: "+Math.min(a,b));
        System.out.println("Abs: "+Math.abs(a));
        System.out.println("Sqrt: "+Math.sqrt(b));
        System.out.println("Round off: "+Math.round(a));
        System.out.println("ceil: "+Math.ceil(b));
        System.out.println("Floor: "+Math.floor(a));
        System.out.println("Power: "+Math.pow(b,a));

        //Finding Hypotenous
        double x;
        double y;
        double z;
        Scanner sc=new Scanner(System.in);
        x=sc.nextDouble();
        y=sc.nextDouble();
        z=Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
        System.out.println("Hypotenous is: "+z);

    }
}
