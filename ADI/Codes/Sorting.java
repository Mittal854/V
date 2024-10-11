

class QuickSort {

    int[] arr;

    QuickSort() {
        arr = new int[]{23, 16, 1, 11, 45, 36, 27};
    }

    public void quickSort() {
        quickSort(0, arr.length - 1);
    }

    private void quickSort(int start, int end) {
        if (start < end) {
            int pivotIndex = partition(start, end);
            quickSort(start, pivotIndex - 1);
            quickSort(pivotIndex + 1, end);
        }
    }

    private int partition(int start, int end) {
        int pivotIndex = start;

        while (start < end) {
            while (start <= end && arr[start] < arr[pivotIndex]) {
                start++;
            }
            while (end >= start && arr[end] > arr[pivotIndex]) {
                end--;
            }
            if (start < end) {
                swap(start, end);
            }
        }
        swap(end, pivotIndex);
        return end;
    }

    private void swap(int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}

class MergeSorting {

    private class ListNode {

        int data;
        ListNode next;

        ListNode(int data) {
            this.data = data;
        }
    }

    ListNode head;

    public void makeList() {
        head = new ListNode(10);
        head.next = new ListNode(25);
        head.next.next = new ListNode(15);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(35);
        head.next.next.next.next.next = new ListNode(45);
        head.next.next.next.next.next.next = new ListNode(2);

    }

    public void mergeSort() {
        head = mergeSort(head);
    }

    public ListNode mergeSort(ListNode currNode) {
        if (currNode == null || currNode.next == null) {
            return currNode;
        }

        ListNode middle = findMiddle(currNode);
        ListNode left = currNode;
        ListNode right = middle.next;
        middle.next = null;
        left = mergeSort(left);
        right = mergeSort(right);
        currNode = merge(left, right);
        return currNode;
    }

    private ListNode findMiddle(ListNode currNode) {
        ListNode slow = currNode;
        ListNode fast = currNode;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyNode = new ListNode(0);
        ListNode currNode = dummyNode;
        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                currNode.next = head1;
                head1 = head1.next;
            } else {
                currNode.next = head2;
                head2 = head2.next;
            }
            currNode = currNode.next;
        }
        if (head1 != null) {
            currNode.next = head1;
        }
        if (head2 != null) {
            currNode.next = head2;
        }
        return dummyNode.next;
    }

    public void print() {
        ListNode currNode = head;
        while (currNode.next != null) {
            System.out.print(currNode.data + "->");
            currNode = currNode.next;
        }
        System.out.println(currNode.data + "->null");
    }
}

public class Sorting {

    public static void main(String[] args) {
//        QuickSort qs= new QuickSort();
//        System.out.println(Arrays.toString(qs.arr));
//        qs.quickSort();
//        System.out.println(Arrays.toString(qs.arr));
        MergeSorting ms = new MergeSorting();
        ms.makeList();
        ms.print();
        ms.mergeSort();
        ms.print();
    }
}
