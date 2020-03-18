import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BillingDate {
    public static List<LocalDate> getBillingDate(int a, int b, int y) {
        return IntStream.range(1, 12).mapToObj(month -> {
            int lastDayOfMonth = YearMonth.of(y, month).lengthOfMonth();

            LocalDate firstPayment = LocalDate.of(y, month, lastDayOfMonth >= a ? a : lastDayOfMonth);
            LocalDate lastPayment = LocalDate.of(y, month, lastDayOfMonth >= b ? b : lastDayOfMonth);

            List<LocalDate> datePair = List.of(firstPayment, lastPayment);

            return datePair;
        }).flatMap(List::stream).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(getBillingDate(5, 20, 2020));
        System.out.println(getBillingDate(15, 30, 2020));
        System.out.println(getBillingDate(15, 30, 2019));
    }
}

