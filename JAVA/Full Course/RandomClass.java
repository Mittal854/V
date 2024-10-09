
import java.util.Random;

class RandomClass {
    
    public static void main(String[] args) {
        Random random=new Random();
        int x=random.nextInt(); // generates a random integer from the entire range of integers
        System.out.println(x);

        int y=random.nextInt(6); // generates a random integer from 0 to 5
        System.out.println(y);

        int z=random.nextInt(6)+1; // generates a random integer from 1 to 6
        System.out.println(z);

        double d=random.nextDouble(); // generates a random double from 0.0 to 1.0
        System.out.println(d);
        
    }
}
