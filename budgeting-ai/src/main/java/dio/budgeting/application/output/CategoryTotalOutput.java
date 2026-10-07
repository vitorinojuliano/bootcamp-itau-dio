package dio.budgeting.application.output;

import java.math.BigDecimal;

public record CategoryTotalOutput(String category, double total) {
    public static CategoryTotalOutput of(String category, long totalAmount) {
        return new CategoryTotalOutput(category, BigDecimal.valueOf(totalAmount, 2).doubleValue());
    }
}