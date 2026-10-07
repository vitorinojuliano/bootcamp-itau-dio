package dio.budgeting.application;

import dio.budgeting.application.output.CategoryTotalOutput;
import dio.budgeting.domain.Category;
import dio.budgeting.domain.Transaction;
import dio.budgeting.domain.TransactionRepository;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;

@Service
public class SumTransactionsByCategoryUseCase {
    private final TransactionRepository transactionRepository;

    public SumTransactionsByCategoryUseCase(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Tool(name = "sum-transactions-by-category", description = "Calcula o total gasto (em reais) em uma categoria")
    public CategoryTotalOutput execute(@ToolParam(description = "Categoria de uma transação") Category category) {
        var total = transactionRepository.findAllByCategory(category).stream()
                .mapToLong(Transaction::getAmount)
                .sum();

        return CategoryTotalOutput.of(category.name(), total);
    }
}