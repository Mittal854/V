// public class My_Exception {
//     public static void main(String args[]) {
//         try {
//             int x = 10;
//             int y = 5;
//             int z = 3;
//             System.out.println(x / (y - z));

//         } catch (Exception abcd) {
//             System.out.println(abcd.getMessage());

//         }

//     }
// }

// public class My_Exception {
//     public static void main(String args[]) {
//         try {
//             int x = 10;
//             int y = 0;
//             int z= x / y;
//             System.out.println(z); // Division by zero will happen here.

//         // } catch (ArithmeticException e) { // Catch specific exceptions, e.g., ArithmeticException.
//         //     System.out.println(e.getMessage()); // This will print "Division by zero".

//         } catch (Exception e) { // Catch any other exceptions.
//             System.out.println("An error occurred: " + e.getMessage());

//         }
//     }
// }

public class MyExceptionDemo{

    // public static void main(String[] args) {
    //     try {
    //         int x = 10;

    //         int y = 0;

    //         int z = x / y;

    //         System.out.println(" Z = " + z);

    //     } catch (Exception abcd) {
    //         System.out.println(" Message : " + abcd.getMessage());
    //         // exception.printStackTrace();
    //     }

    // }
    public static void main(String[] args) {

        try {
            int[] arr = new int[3];

            arr[0] = 10;
            arr[1] = 20;
            arr[2] = 30;

            arr[3] = 40;

            int z = 0;

            int value = (arr[0] + arr[1] + arr[2]) / z;

            System.out.println(" value : " + value);
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println(" Message :  " + exception);
        } catch (ArithmeticException exception) {
            System.out.println(" Message : =>  " + exception.getMessage());
        } catch (Exception exception) {
            System.out.println(" Message " + exception.getMessage());
        }

    }

}