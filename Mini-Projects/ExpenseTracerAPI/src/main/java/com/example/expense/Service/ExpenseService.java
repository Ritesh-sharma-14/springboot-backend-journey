public interface ExpenseService {
    ExpenseResponseDTO addExpense(ExpenseRequestDTO dto);
    List<ExpenseResponseDTO> getAllExpenses();
}
