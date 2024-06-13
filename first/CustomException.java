package first;

public class CustomException {

    public static void main(String[] args) {
        CustomException sample = new CustomException();
        try {
            sample.throwMyException(13);
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    public void throwMyException(int number) throws MyException {
        try {
            if (number > 12) {
                throw new MyException("Number is greater than 12");
            }
        } catch (MyException e) {
            e.printStackTrace();
        }
    }
}

class MyException extends Exception {

    public MyException() {
        super();
    }

    public MyException(String message) {
        super(message);
    }
}
