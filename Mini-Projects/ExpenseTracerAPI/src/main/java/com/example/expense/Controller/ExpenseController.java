@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService service;

    @PostMapping("/add")
    public ResponseEntity<?> addExpense(@Valid @RequestBody ExpenseRequestDTO dto) {
        return ResponseEntity.ok(service.addExpense(dto));
    }

    @GetMapping
    public List<ExpenseResponseDTO> getAll() {
        return service.getAllExpenses();
    }
}
