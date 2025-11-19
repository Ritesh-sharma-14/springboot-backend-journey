@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public ExpenseResponseDTO addExpense(ExpenseRequestDTO dto) {
        Expense expense = mapper.map(dto, Expense.class);
        Expense saved = repo.save(expense);
        return mapper.map(saved, ExpenseResponseDTO.class);
    }

    @Override
    public List<ExpenseResponseDTO> getAllExpenses() {
        return repo.findAll()
                .stream()
                .map(exp -> mapper.map(exp, ExpenseResponseDTO.class))
                .collect(Collectors.toList());
    }
}
