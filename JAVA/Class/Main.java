// import java.util.*;

interface Person {

    String getName();
    
    int getAge();
}
interface Employee extends Person {

    int getEmployeeId();

    String getDepartment();
}

interface Student extends Person {

    int getStudentId();

    String getMajor();
}

abstract class UniversityPerson implements Person {

    String name;
    int age;
}

class Professor extends UniversityPerson implements Employee {

    int employeeId;
    String Department;

    public int getEmployeeId() {
        return employeeId;
    }

    public String getDepartment() {
        return Department;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

}

class Lecturer extends Professor {

    String specialization;

    String getSpecialization() {
        return specialization;
    }
}

class TeachingAssistant extends UniversityPerson implements Employee {

    int employeeId;
    String department;

    public int getEmployeeId() {
        return employeeId;
    }

    public String getDepartment() {
        return department;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

}

class UndergraduateStudent extends UniversityPerson implements Student {

    int studentId;
    String major;

    public int getStudentId() {
        return studentId;
    }

    public String getMajor() {
        return major;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

}

class GraduateStudent extends UndergraduateStudent {

    String thesisTitle;

    String getThesisTitle() {
        return thesisTitle;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getMajor() {
        return major;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

class University {

    Employee[] employees = new Employee[5];
    Student[] students = new Student[5];
    static int countE = 0;
    static int counts = 0;

    void addEmployee(Employee emp) {
        employees[countE] = emp;
        countE++;
    }

    void addStudent(Student stu) {
        students[counts] = stu;
        counts++;
    }

    void printEmployees() {
        for (int i = 0; i < countE; i++) {
            Employee e = employees[i];
            System.out.println("Name: " + e.getName());
            System.out.println("Age: " + e.getAge());
            System.out.println("Employee Id: " + e.getEmployeeId());
            System.out.println("Department: " + e.getDepartment());
            System.out.println();
        }
    }

    void printStudenst() {
        for (int i = 0; i < counts; i++) {
            Student s = students[i];
            System.out.println("Name: " + s.getName());
            System.out.println("Age: " + s.getAge());
            System.out.println("Student Id: " + s.getStudentId());
            System.out.println("Major: " + s.getMajor());
            System.out.println();
        }
    }
}

class Main {
    public static void main(String[] args) {
        University university = new University();
        Professor prof = new Professor();
        prof.name = "Dr. Smith";
        prof.age = 45;
        prof.employeeId = 101;
        prof.Department = "Computer Science";

        Lecturer lecturer = new Lecturer();
        lecturer.name = "Dr. Johnson";
        lecturer.age = 38;
        lecturer.employeeId = 102;
        lecturer.Department = "Mathematics";
        lecturer.specialization = "Algebra";

        TeachingAssistant ta = new TeachingAssistant();
        ta.name = "Alice";
        ta.age = 25;
        ta.employeeId = 103;
        ta.department = "Physics";

        university.addEmployee(prof);
        university.addEmployee(lecturer);
        university.addEmployee(ta);

        UndergraduateStudent ugStudent = new UndergraduateStudent();
        ugStudent.name = "John";
        ugStudent.age = 20;
        ugStudent.studentId = 201;
        ugStudent.major = "Computer Science";

        GraduateStudent gradStudent = new GraduateStudent();
        gradStudent.name = "Emily";
        gradStudent.age = 24;
        gradStudent.studentId = 202;
        gradStudent.major = "Biology";
        gradStudent.thesisTitle = "Plant Biology";

        university.addStudent(ugStudent);
        university.addStudent(gradStudent);

        System.out.println("Employees:");
        university.printEmployees();

        System.out.println("Students:");
        university.printStudenst();
    }
}
