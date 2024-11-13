import java.util.*;
public class Heaps {

    static class MinHeap{
        ArrayList<Integer> arr=new ArrayList<>();

        public void add(int a)
        {
            arr.add(a);
            int x=arr.size()-1;
            int p=(x-1)/2;
            while(x>0 && arr.get(x)<arr.get(p))
            {
                int temp=arr.get(x);
                arr.set(x,arr.get(p));
                arr.set(p,temp);
                x=p;
                p=(x-1)/2;
            }
        }

    }

    public static void main(String[] args) {
        
    }
}
