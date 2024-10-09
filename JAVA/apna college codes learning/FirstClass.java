// import java.util.*;

class FirstClass {
    public static void main(String[] args) {
        // //output
        // System.out.println("Hello World");

        // //variable
        // int a=20;
        // int b=10;
        // System.out.println(a+b);
        // System.out.println(a-b);

        // //input
        // Scanner sc=new Scanner(System.in);
        // String name=sc.nextLine();
        // System.out.println(name);
        // // String fullname=sc.nextLine();
        // // System.out.println(fullname);

        // //ques sum of two numbers
        // int num1=sc.nextInt();
        // int num2=sc.nextInt();
        // System.out.println(num1+num2);

        // //Conditional Statements
        // int age=sc.nextInt();
        // if(age>=18)
        // {
        // System.out.println("You are adult");
        // }
        // else{
        // System.out.println("You are not an adult");
        // }

        // Scanner sc=new Scanner(System.in);
        // int a =sc.nextInt();
        // int b=sc.nextInt();
        // if(a>b)
        // {
        // System.out.println("A is greater");
        // }
        // else if(a==b)
        // {
        // System.out.println("A is equal to B");
        // }
        // else
        // {
        // System.out.println("B is greater");
        // }
        // sc.close();

        // Scanner sc = new Scanner(System.in);
        // int a = sc.nextInt();
        // switch (a) {
        // case 1:System.out.println("Hello");
        // break;
        // case 2:System.out.println("Nameste");
        // break;
        // case 3:System.out.println("Bonjour");
        // break;
        // default:System.out.println("Sat Shri Akal");
        // }
        // sc.close();

        // //Loops
        // for(int i=0;i<5;i++)
        // {
        // System.out.println("Hello World");
        // }

        // // Patterns
        // // 1.Butterfly

        // int n = 4;
        // for (int i = 1; i <= n; i++) {
        // for (int j = 1; j <= i; j++) {
        // System.out.print("*");
        // }
        // for (int s = 0; s < 2 * n - 2 * i; s++) {
        // System.out.print(" ");
        // }
        // for (int j = 1; j <= i; j++) {
        // System.out.print("*");
        // }
        // System.out.println();
        // }
        // for (int i = n; i >= 1; i--) {
        // for (int j = 1; j <= i; j++) {
        // System.out.print("*");
        // }
        // for (int s = 0; s < 2 * n - 2 * i; s++) {
        // System.out.print(" ");
        // }
        // for (int j = 1; j <= i; j++) {
        // System.out.print("*");
        // }
        // System.out.println();
        // }

        // //Arrays
        // int[] marks=new int[3];
        // marks[0]=1;
        // marks[1]=2;
        // marks[2]=3;
        // System.out.print(marks[1]);

        // //2d Arrays
        // Scanner sc=new Scanner(System.in);
        // int m=sc.nextInt();
        // int n=sc.nextInt();
        // int[][] matrix=new int[m][n];
        // for(int i=0;i<m;i++)
        // {
        // for(int j=0;j<n;j++)
        // {
        // matrix[i][j]=sc.nextInt();
        // }
        // }
        // for(int i=0;i<m;i++)
        // {
        // for(int j=0;j<n;j++)
        // {
        // System.out.print(matrix[i][j]+" ");
        // }
        // System.out.println();
        // }

        // sc.close();

        // Reversing of a string
        StringBuilder sb = new StringBuilder("Bhuvesh");
        for (int i = 0; i < sb.length() / 2; i++) {
            int start = i;
            int end = sb.length() - i - 1;
            char first = sb.charAt(start);
            char last = sb.charAt(end);
            sb.setCharAt(start, last);
            sb.setCharAt(end, first);

        }
        System.out.println(sb);

    }
}