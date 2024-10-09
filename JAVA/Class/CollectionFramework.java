
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionFramework {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        // List<Integer> list = new LinkedList<>();
        // List<Integer> list = new Vector<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        System.out.println(list);
        list.add(1);
        list.add(6);
        list.add(9);
        list.add(4);
        System.out.println(list);
        list.add(2, 26);
        System.out.println(list);
        list1.add(45);
        list1.add(62);
        list1.add(12);
        list1.add(35);
        System.out.println(list1);
        // list.addAll(list1);
        list.addAll(3, list1);
        System.out.println(list);
        list.remove(4);
        System.out.println(list);
        list.removeAll(list1);
        System.out.println(list);
        list.remove(Integer.valueOf(26));
        System.out.println(list);
        System.out.println(list.contains(6));
        list.clear();
        System.out.println(list);

        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        list.addAll(Arrays.asList(arr));
        System.out.println(list);

        System.out.println(list.get(3));
        list.set(3, 24);
        System.out.println(list);
    }
}
