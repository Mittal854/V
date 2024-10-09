
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

class Student {

    int rollno;
    String name;

    Student(int rollno, String name) {
        this.rollno = rollno;
        this.name = name;
    }

    @Override
    public String toString() {
        return rollno + " " + name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rollno,name);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Student student = (Student) obj;
        return rollno == student.rollno && Objects.equals(name, student.name);
    }


}

public class CollectionQuestion {

    public static void main(String[] args) {
        Set<Student> st = new HashSet<>();
        st.add(new Student(1, "A"));
        st.add(new Student(1, "A"));
        st.add(new Student(2, "B"));
        st.add(new Student(3, "C"));
        st.add(new Student(4, "D"));

        // for (Student s : st) {
        //     System.out.println(s.rollno + " " + s.name);
        // }
        Iterator<Student> itr = st.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

    }
}
