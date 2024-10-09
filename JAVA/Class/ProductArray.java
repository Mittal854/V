
import java.util.Scanner;

public class ProductArray {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        int pro=1;
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
            pro*=arr[i];
        }
        int[] arr2=new int[n];
        for(int i=0;i<n;i++)
        {
            arr2[i]=pro/arr[i];
        }
        for(int i:arr2)
        {
            System.out.print(i+" ");
        }

    }
}
