
import java.util.LinkedList;
import java.util.Queue;

public class DoubleQueue {

    static void doubleQueue(Queue<Integer> que) {
        int size = que.size();
        for (int i = 0; i < size; i++) {
            int x = (int) que.poll();
            que.add(x);
            que.add(x);
        }
    }

    public static void main(String[] args) {
        Queue<Integer> que = new LinkedList<>();
        que.add(1);
        que.add(2);
        que.add(3);
        que.add(4);
        que.add(5);
        System.out.println(que);
        doubleQueue(que);
        System.out.println(que);

    }
}
