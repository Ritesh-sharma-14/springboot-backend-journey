public class ExpenseRequestDTO {

    @NotBlank
    private String title;

    @Positive
    private double amount;

    @NotBlank
    private String category;

    @PastOrPresent
    private LocalDate date;

    // getters + setters
}
