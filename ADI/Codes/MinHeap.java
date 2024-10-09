
class Node {

    int key;
    Node next;

    Node(int key) {
        this.key = key;
        this.next = null;
    }
}

class MinHeap {

    private Node head;

    MinHeap() {
        this.head = null;
    }

    public void insert(int key) {
        Node newNode = new Node(key);
        if (head == null || head.key > key) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null && current.next.key <= key) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public int extractMin() {
        if (head == null) {
            return Integer.MIN_VALUE;  
        } else {
            int min = head.key;
            head = head.next;
            return min;
        }
    }

    public int getMin() {
        return head != null ? head.key : Integer.MIN_VALUE; 
    }


    public static void main(String[] args) {
        MinHeap heap = new MinHeap();
        heap.insert(10);
        heap.insert(5);
        heap.insert(15);

        System.out.println(heap.extractMin()); 
        System.out.println(heap.getMin());      
    }
}
