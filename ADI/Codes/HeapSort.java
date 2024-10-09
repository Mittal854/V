import java.util.Arrays;
import java.util.Scanner;

public class HeapSort {
    int[] arr;
    HeapSort(int size){
        arr= new int[size];
    }
    private void maxHeapify(int n, int i){
        int max= i;
        int left= 2*i+1;
        int right= 2*i+2;

        if(left<n && arr[left]>arr[max]) max=left;
        if(right <n && arr[right]>arr[max]) max= right;

        if(max!=i){
            int temp= arr[i];
            arr[i]=arr[max];
            arr[max]=temp;
            maxHeapify(n,max);
        }
    }
    private void minHeapify(int n, int i){
        int min= i;
        int left= 2*i+1;
        int right= 2*i+2;

        if(left<n && arr[left]<arr[min]) min=left;
        if(right <n && arr[right]<arr[min]) min= right;

        if(min!=i){
            int temp= arr[i];
            arr[i]=arr[min];
            arr[min]=temp;
            minHeapify(n,min);
        }
    }

    public void heapSort(){
        int n= arr.length;
        // make binary heap

        for(int i=n/2-1;i>=0;i--){
//            maxHeapify(n,i);
            minHeapify(n,i);
        }

        //sort
        for(int i=n-1;i>=0;i--){
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;

//            maxHeapify(i,0);
            minHeapify(i,0);
        }
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        HeapSort hs= new HeapSort(9);
        for(int i=0;i<9;i++){
            hs.arr[i]=sc.nextInt();
        }

        System.out.println(Arrays.toString(hs.arr));
        hs.heapSort();
        System.out.println(Arrays.toString(hs.arr));

    }
}

/*
7 2 11 13 3 1 9 6 8
 */