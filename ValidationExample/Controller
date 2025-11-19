@PostMapping("/add")
public ResponseEntity<?> addExpense(@Valid @RequestBody ExpenseRequestDTO dto) {
    Expense saved = service.addExpense(dto);
    return ResponseEntity.ok(saved);
}
