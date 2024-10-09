
import java.util.*;
class FirstClass{

    public static boolean primeNumber(int no)
    {
        boolean prime=true;
        for(int i=2;i<=Math.sqrt(no);i++)
        {
            if(no%i==0)
            {
                prime=false;
                break;
            }
        }
        return prime;
    }

    public static int[] minMax(int[] arr)
    {
        int max=-1;
        int min=arr[0];
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]>max){
                max=arr[i];
            }
            if(arr[i]<min){
                min=arr[i];
            }
        }
        int[] result={min,max};
        return result;

    }
    public static void main(String[] args)
    {   
        System.out.println("1.Hello world");
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        System.out.println(a+b);
        int no=sc.nextInt();
        if(primeNumber(no))
        {
            System.out.println("The no is prime");
        }
        else{
            System.out.println("The no is not prime");
        }
        int size=sc.nextInt();
        int[] arr=new int[size];
        for(int i=0;i<size;i++)
        {
            arr[i]=sc.nextInt();
        }
        int[] ans=minMax(arr);
        System.out.println("The min element is: "+ans[0]);
        System.out.println("The max element is: "+ans[1]);
        sc.close();
    }
}