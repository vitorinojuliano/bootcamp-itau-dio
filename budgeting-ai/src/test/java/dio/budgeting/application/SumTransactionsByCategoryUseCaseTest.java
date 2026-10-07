package dio.budgeting.application;

import dio.budgeting.domain.Category;
import dio.budgeting.domain.Transaction;
import dio.budgeting.domain.TransactionRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SumTransactionsByCategoryUseCaseTest {

    @Test
    void should_sumAmountsInReais_when_categoryHasTransactions() {
        var useCase = new SumTransactionsByCategoryUseCase(repositoryWith(
                new Transaction("Mercado", 5000, Category.GROCERIES),
                new Transaction("Padaria", 1550, Category.GROCERIES)));

        var output = useCase.execute(Category.GROCERIES);

        assertThat(output.category()).isEqualTo("GROCERIES");
        assertThat(output.total()).isEqualTo(65.50);
    }

    @Test
    void should_returnZero_when_categoryHasNoTransactions() {
        var useCase = new SumTransactionsByCategoryUseCase(repositoryWith());

        assertThat(useCase.execute(Category.AUTO).total()).isZero();
    }

    private TransactionRepository repositoryWith(Transaction... transactions) {
        return new TransactionRepository() {
            @Override
            public Transaction save(Transaction transaction) {
                return transaction;
            }

            @Override
            public List<Transaction> findAllByCategory(Category category) {
                return List.of(transactions);
            }
        };
    }
}