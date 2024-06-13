package first;

public class Poly {
    public static void main(String[] args) {
        Parent parent = new Parent();
        Child child = new Child();
        Parent parent2 = new Child();

//        if (parent instanceof first.Child) {
//            child = (first.Child) parent;
//        } always false; parent is not an instance of first.Child
        Object obj = new Object();

        parent.printName();
        child.printName();
        parent2.printName();
    }
}

class Parent {
    public void printName() {
        System.out.println("first.Parent");
    }
}

class Child extends Parent {
    public void printName() {
        System.out.println("first.Child");
    }
}
