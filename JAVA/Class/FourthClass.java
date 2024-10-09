// class Person {
//     private String name;
//     private int age;

//     public void setAttributes(String name, int age) {
//         if (age < 0) {
//             System.out.println("Invalid age");
//             return;
//         }
//         this.name = name;
//         this.age = age;
//     }

//     public void getAttributes() {
//         System.out.println(this.name);
//         System.out.println(this.age);
//     }
// }

// public class FourthClass {
//     public static void main(String[] args) {
//         Person p1 = new Person();
//         p1.setAttributes("Bhuvesh", 20);
//         p1.getAttributes();
//     }
// }

// class Animal {
//     public void makeSound() {

//     }
// }
// class Dog extends Animal{
//     public void makeSound()
//     {
//         System.out.println("Bark");
//     }
// }
// class Cat extends Animal{
//     public void makeSound()
//     {
//         System.out.println("Meow");
//     }
// } 
// public class FourthClass{
//     public static void main(String[] args)
//     {
//         Dog d1 = new Dog();
//         d1.makeSound();
//         Cat c1 = new Cat();
//         c1.makeSound();
//     }
// }

// class Vehicle{
//     public String make;
//     public String model;

// }
// class Car extends Vehicle{
//     int nod;

//     Car(String make,String model,int nod)
//     {
//         this.make=make;
//         this.model=model;
//         this.nod=nod;
//     }
//     public void displayProp()
//     {
//         System.out.println(this.make);
//         System.out.println(this.model);
//         System.out.println(this.nod);
//     }
// }

// public class FourthClass{
//     public static void main(String[] args)
//     {
//         Car c1=new Car("RR","RR Phantom",2024);
//         c1.displayProp();
//     }
// }

interface Shape {
    abstract void draw();
}
class Circle implements Shape{
    public void draw(){
        System.out.println("drawing circle");
    }
}
class Square implements Shape{
    public void draw(){
        System.out.println("drawing square");
    }
}
public class FourthClass{
    public static void main(String[] args)
    {
        Square s1=new Square();
        s1.draw();
        Circle c1=new Circle();
        c1.draw();
    }
}