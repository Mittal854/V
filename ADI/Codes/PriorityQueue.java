
import java.util.*;

class PQHeap {

    ArrayList<Integer> pq = new ArrayList<>();

    private void heapifyUp(int i) {
        if (i == 0) {
            return;
        }
        int par = (i - 1);

        if (pq.get(par) >= pq.get(i)) {
            return;
        }

        if (pq.get(par) < pq.get(i)) {
            int temp = pq.get(i);
            pq.set(i, pq.get(par));
            pq.set(par, temp);
            heapifyUp(par);
        }
    }

    private void heapifyDown(int i) {
        int n = pq.size();
        if (n < 0) {
            return;
        }
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int max = i;

        if (left < n && pq.get(left) > pq.get(max)) {
            max = left;
        }
        if (right < n && pq.get(right) > pq.get(max)) {
            max = right;
        }
        if (max != i) {
            int temp = pq.get(max);
            pq.set(max, pq.get(i));
            pq.set(i, temp);
            heapifyDown(max);
        }

    }

    public boolean isEmpty() {
        return pq.isEmpty();
    }

    public void add(int num) {
        pq.add(num);
        heapifyUp(pq.size() - 1);
    }

    public int remove() {
        if (isEmpty()) {
            return -1;
        }
        int value = pq.get(0);
        int n = pq.size();
        if (pq.size() == 1) {
            pq.clear();
        }
        pq.set(0, pq.get(n - 1));
        pq.remove(n - 1);

        heapifyDown(0);

        return value;
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        }

        return pq.get(0);
    }

}

class PQLinkedList {

    private class ListNode {

        int data;
        ListNode next;

        ListNode(int d) {
            data = d;
        }
    }
    private ListNode head;

    public void add(int num) {
        ListNode newNode = new ListNode(num);
        if (head == null) {
            head = newNode;
            return;
        }
        ListNode currNode = head;
        ListNode prevNode = null;

        while (currNode != null && currNode.data > num) {
            prevNode = currNode;
            currNode = currNode.next;
        }
        if (prevNode == null) {
            newNode.next = head;
            head = newNode;
            return;
        }
        prevNode.next = newNode;
        newNode.next = currNode;
    }

    public int remove() {
        if (head == null) {
            return -1;
        }
        int value = head.data;
        head = head.next;
        return value;
    }

    public int peek() {
        return head.data;
    }
}

public class PriorityQueue {

    public static void main(String[] args) {
        PQHeap pq = new PQHeap();
        pq.add(11);
        System.out.println(pq.pq);
        pq.add(15);
        System.out.println(pq.pq);

        pq.add(12);
        System.out.println(pq.pq);

        pq.add(19);
        System.out.println(pq.pq);

        pq.add(5);
        System.out.println(pq.pq);

        pq.add(6);
        System.out.println(pq.pq);
        pq.add(31);
        System.out.println(pq.pq);

        System.out.println(pq.peek());
        System.out.println(pq.remove());
        System.out.println(pq.pq);
        System.out.println(pq.remove());
        System.out.println(pq.pq);

    }
}
