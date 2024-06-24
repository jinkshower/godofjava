package practice;

public class HelloJVM {
    public static void main(String[] args) {
        System.out.println("Hello, JVM!");

        Cat hiyen = new Cat(5);
        Cat yihen = new Cat(7);

        hiyen.meow();
        yihen.meow();
    }
}
