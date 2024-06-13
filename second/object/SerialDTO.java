package second.object;

import java.io.Serializable;

public class SerialDTO implements Serializable {
    private String bookName;
    private int bookOrder;
    private boolean bestSeller;
    private long soldPerDay;

    public SerialDTO(final String bookName, final int bookOrder, final boolean bestSeller,
        final long soldPerDay) {
        super();
        this.bookName = bookName;
        this.bookOrder = bookOrder;
        this.bestSeller = bestSeller;
        this.soldPerDay = soldPerDay;
    }

    @Override
    public String toString() {
        return "SerialDTO{" +
            "bookName='" + bookName + '\'' +
            ", bookOrder=" + bookOrder +
            ", bestSeller=" + bestSeller +
            ", soldPerDay=" + soldPerDay +
            '}';
    }
}
