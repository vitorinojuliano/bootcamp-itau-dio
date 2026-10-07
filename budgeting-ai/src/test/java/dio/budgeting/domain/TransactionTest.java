package dio.budgeting.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TransactionTest {

    @Test
    void should_createTransaction_when_dataIsValid() {
        var transaction = new Transaction("Mercado", 5000, Category.GROCERIES);

        assertThat(transaction.getAmount()).isEqualTo(5000);
        assertThat(transaction.getId()).isNotNull();
    }

    @Test
    void should_throwException_when_amountIsNotPositive() {
        assertThatThrownBy(() -> new Transaction("Mercado", 0, Category.GROCERIES))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void should_throwException_when_descriptionIsBlank() {
        assertThatThrownBy(() -> new Transaction("  ", 5000, Category.GROCERIES))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void should_throwException_when_categoryIsNull() {
        assertThatThrownBy(() -> new Transaction("Mercado", 5000, null))
                .isInstanceOf(IllegalArgumentException.class);
    }
}