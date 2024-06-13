package first;

public class StaticEx {

    public static void main(String[] args) {
        StaticEx ex = new StaticEx();
        ex.makeStaticBlockObject();
    }

    private void makeStaticBlockObject() {
        System.out.println("Creating Block");
        StaticEx2 ex2 = new StaticEx2();
        System.out.println("Created Block");
        System.out.println("------------------------");
        System.out.println("Creating Block2");
        StaticEx2 ex3 = new StaticEx2();
        System.out.println("Created Block2");
    }
}

class StaticEx2 {
    static int data = 1;

    public StaticEx2() {
        System.out.println("This is a constructor.");
    }

    static {
        System.out.println("**first static block**");
        data = 3;
    }

    static {
        System.out.println("**second static block**");
        data = 5;
    }

    public static int getData() {
        return data;
    }
}
