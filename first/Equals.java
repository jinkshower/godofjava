package first;

import java.util.Objects;

public class Equals {

    public static void main(String[] args) {
        Ex1 ex1 = new Ex1(3, 5);
        Ex1 ex2 = new Ex1(3, 5);
        System.out.println(ex1.equals(ex2));
    }
}

class Ex1 {
    int x;
    int y;

    public Ex1(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        final Ex1 ex1 = (Ex1) object;
        return x == ex1.x && y == ex1.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
