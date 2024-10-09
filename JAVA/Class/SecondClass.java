import java.util.*;


class SecondClass{

    public static int noOfK(int[][] arr,int a)
    {
        int count=0;
        if(arr.length==0)
        {
            return 0;
        }
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[0].length;j++)
            {
                if(arr[i][j]==a)
                {
                    count++;
                }
            }
        }
        return count;
    }
    public static void diagonalPrinting(int[][] arr)
    {
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i][i]+" ");
        }
    }
    public static int[][] transposeMatrix(int[][] arr)
    {
        int[][] transpose=new int[arr[0].length][arr.length];
        for(int i=0;i<arr[0].length;i++)
        {
            for(int j=0;j<arr.length;j++)
            {
                transpose[i][j]=arr[j][i];
            }
        }
        return transpose;
    }
    public static int[][] rotate90(int[][] arr)
    {
        int[][] transpose = new int[arr[0].length][arr.length];
        for (int i = 0; i < arr[0].length; i++) {
            for (int j = 0; j < arr.length; j++) {
                transpose[i][j] = arr[j][i];
            }
        }
        int[][] rotate=new int[transpose.length][transpose[0].length];
        for(int i=0;i<rotate.length;i++)
        {
            for(int j=0;j<rotate[0].length;j++)
            {
                rotate[i][rotate[0].length-1-j]=transpose[i][j];
            }
        }
        return rotate;
    }
    public static void main(String[] args){
        // int[][] arr={{1,2,3},{4,5,6}};
        // for(int i=0;i<arr[0].length;i++)
        // {
        //     System.out.print(arr[0][i]+" ");
        // }
        // System.out.println();
        // for(int i=0;i<arr.length;i++)
        // {
        //     System.out.println(arr[i][arr[0].length-1]);
        // }

        Scanner sc=new Scanner(System.in);
        // int no=sc.nextInt();
        int rows=sc.nextInt();
        int cols=sc.nextInt();
        int[][] arr=new int[rows][cols];
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                arr[i][j]=sc.nextInt();
            }
        }
        // int a=noOfK(arr, no);
        // System.out.println(a);
        // diagonalPrinting(arr);
        // int[][] transpose=transposeMatrix(arr);
        int[][] rotate=rotate90(arr);
        for(int i=0;i<rotate.length;i++)
        {
            for(int j=0;j<rotate[0].length;j++)
            {
                System.out.print(rotate[i][j]+" ");
            }
            System.out.println();
        }

        sc.close();

    }
}