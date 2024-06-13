package second.thread.sync;

public class ModifyAmountThread extends Thread {
    private CommonCalculate calc;
    private boolean addFlag;

    public ModifyAmountThread(CommonCalculate calc, boolean addFlag) {
        this.calc = calc;
        this.addFlag = addFlag;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            if (addFlag) {
                calc.plus(1);
            } else {
                calc.minus(1);
            }
        }
    }
}
