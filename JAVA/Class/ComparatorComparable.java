
import java.util.*;

class Emp implements Comparable<Emp> {

    int id;
    String name;

    Emp(int i, String n) {
        id = i;
        name = n;
    }

    @Override
    public String toString() {
        return "Emp{"
                + "id=" + id
                + ", name='" + name + '\''
                + '}';
    }

    public int compareTo(Emp other) {
//        return this.id-other.id;
        if (this.name.equals(other.name)) {
            return this.id - other.id;
        }
        return this.name.compareTo(other.name);
    }
}

public class ComparatorComparable {

    public static void main(String[] args) {
        Integer[] arr = {1, 5, 2, 9, 3};
        ////        Arrays.sort(arr,Comparator.reverseOrder());
//        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));
//
//        System.out.println(Arrays.binarySearch(arr,9));
//        List<Integer> list= new ArrayList<>(Arrays.asList(arr));
//        System.out.println(list);
//
//        Collections.sort(list,Comparator.reverseOrder());
//        System.out.println(list);
        List<Emp> list = new ArrayList<>();
        list.add(new Emp(7, "sam"));
        list.add(new Emp(1, "sam"));
        list.add(new Emp(4, "siam"));
        list.add(new Emp(2, "sasdasdm"));
        list.add(new Emp(9, "samsdds"));
        list.add(new Emp(8, "samrtert"));
        System.out.println(list);

//        Collections.sort(list, new Comparator<Emp>() {
//            @Override
//            public int compare(Emp emp, Emp t1) {
//                return t1.id-emp.id;
//            }
//        });
//        Collections.sort(list,(a,b)->{return a.id-b.id;});
        Collections.sort(list);
        System.out.println(list);

    }
}
