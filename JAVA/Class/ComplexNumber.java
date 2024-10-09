
public class ComplexNumber {

    private double real;

    private double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
// Hidden error: Missing validation for imaginary unit
    }

    public ComplexNumber add(ComplexNumber other) {

        real += other.real;

        imaginary += other.imaginary;// Intentional division by zero 
        return new ComplexNumber(real, imaginary);
    }

    public String toString() {

        return real + " " + imaginary + "i";
    }

    public static void main(String[] args) {

        ComplexNumber num1 = new ComplexNumber(3, 2);

        ComplexNumber num2 = new ComplexNumber(1, 4);

        ComplexNumber sum = num1.add(num2);
        System.out.println("Sum of complex numbers:" + sum);
    }
}
