
public class MyThread {

    public static void main(String[] args) {
        for (int i = 1; i < 6; i++) {
            try {
                Thread.sleep(1000); // Static method, no need for an instance of Thread
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println(i);
        }
    }
}
