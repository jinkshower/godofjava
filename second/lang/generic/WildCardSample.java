package second.lang.generic;

public class WildCardSample {

    public static void main(String[] args) {
        WildCardSample sample = new WildCardSample();
        sample.callWildcardMethod();
    }

    private void callWildcardMethod() {
        WildCardGeneric<String> wildcard = new WildCardGeneric<>();
        wildcard.setWildcard("A");
        wildcardStringMethod(wildcard);
    }

    private void wildcardStringMethod(final WildCardGeneric<?> wildcard) {
        Object value = wildcard.getWildcard();// 실제 객체는 String.
        System.out.println("value = " + value); // 다형성으로 String의 toString() 호출
    }
}
