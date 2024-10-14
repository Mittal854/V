
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Trees {

    Scanner sc = new Scanner(System.in);

    class Node {

        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }

    }

    public Node createTree() {
        int data = sc.nextInt();
        if (data == -1) {
            return null;
        }
        Node root = new Node(data);
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node temp = q.poll();
            System.out.print("Left of " + temp.data);
            data = sc.nextInt();
            if (data != -1) {
                temp.left = new Node(data);
                q.add(temp.left);
            }
            System.out.print("Right of " + temp.data);
            data = sc.nextInt();
            if (data != -1) {
                temp.right = new Node(data);
                q.add(temp.right);
            }

        }

        return root;
    }

    public void levelOrder(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node temp = q.poll();
            if (temp == null) {
                System.out.println();
                if (!q.isEmpty()) {
                    q.add(null);
                }
            } else {
                System.out.print(temp.data+" ");
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
        }
    }

    public void preorder(Node root)
    {
        if(root==null)
        {
            return;
        }

        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public void inorder(Node root)
    {
        if(root==null) return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public void postorder(Node root)
    {
        if(root==null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
    }

    public static void main(String[] args) {
        Trees t=new Trees();
        Node root=t.createTree();
        t.levelOrder(root);
        System.out.println();
        t.preorder(root);
        System.out.println();
        t.postorder(root);
        System.out.println();
        t.inorder(root);
        
    }
    

}
