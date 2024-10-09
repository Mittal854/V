
import javax.swing.JOptionPane;

class GUI{
    public static void main(String[] args) {
        String name=JOptionPane.showInputDialog("Name");
        JOptionPane.showMessageDialog(null, name);

        int age=Integer.parseInt(JOptionPane.showInputDialog("Age"));  // Bcoz always return String
        JOptionPane.showMessageDialog(null, age);
    }
}