package second.lang.generic;

public class GenericWildcardSample {

    public static void main(String[] args) {
        GenericWildcardSample sample = new GenericWildcardSample();
        sample.callGenericMethod();
    }

    public void callGenericMethod() {
        WildCardGeneric<String> wildcard = new WildCardGeneric<>();
        genericMethod(wildcard, "Data");
    }

    public <T> void genericMethod(WildCardGeneric<T> c, T addValue) {
        c.setWildcard(addValue);
        T value = c.getWildcard();
        System.out.println(value);
    }
}
