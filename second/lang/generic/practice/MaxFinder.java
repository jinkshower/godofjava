package second.lang.generic.practice;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

public class MaxFinder {

    public static void main(String[] args) {
        MaxFinder sample = new MaxFinder();
        sample.testGetMax();
        sample.testGetMin();
    }

    private void testGetMin() {
        System.out.println(getMin(1, 2, 3));
        System.out.println(getMin(3, 2, 1));
        System.out.println(getMin(2, 3, 1));
        System.out.println(getMin("a", "b", "c"));
        System.out.println(getMin("b", "a", "c"));
    }

    private void testGetMax() {
        System.out.println(getMax(1, 2, 3));
        System.out.println(getMax(3, 2, 1));
        System.out.println(getMax(2, 3, 1));
        System.out.println(getMax("a", "b", "c"));
        System.out.println(getMax("b", "c", "a"));
    }



    public <T extends Comparable<T>> T getMax(T ... a) {
        T maxT = a[0];
        for (T tempT : a) {
            if (tempT.compareTo(maxT) > 0) {//좌가 우보다 크면
                maxT = tempT;
            }
        }
        return maxT;
    }

    public <T extends Comparable<T>> T getMin(T ... a) {
        T minT = a[0];
        for (T tempT : a) {
            if (tempT.compareTo(minT) < 0) {
                minT = tempT;
            }
        }
        return minT;
    }

}
