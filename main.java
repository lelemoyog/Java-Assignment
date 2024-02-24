import java.util.Scanner;

public class FarmManagementApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize arrays to store expenditure and income records
        ExpenditureRecord[] expenditureRecords = new ExpenditureRecord[100]; // Assuming maximum 100 records
        IncomeRecord[] incomeRecords = new IncomeRecord[100]; // Assuming maximum 100 records

        int expenditureCount = 0;
        int incomeCount = 0;

        boolean exit = false;
        while (!exit) {
            System.out.println("1. Add Expenditure Record");
            System.out.println("2. Add Income Record");
            System.out.println("3. View Expenditure Records");
            System.out.println("4. View Income Records");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Add Expenditure Record
                    System.out.print("Enter date (DD/MM/YYYY): ");
                    String date = scanner.nextLine();
                    System.out.print("Enter amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();

                    expenditureRecords[expenditureCount++] = new ExpenditureRecord(date, amount, category, description);
                    System.out.println("Expenditure record added successfully!");
                    break;
                case 2:
                    // Add Income Record
                    System.out.print("Enter date (DD/MM/YYYY): ");
                    date = scanner.nextLine();
                    System.out.print("Enter amount: ");
                    amount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter source: ");
                    String source = scanner.nextLine();
                    System.out.print("Enter description: ");
                    description = scanner.nextLine();

                    incomeRecords[incomeCount++] = new IncomeRecord(date, amount, source, description);
                    System.out.println("Income record added successfully!");
                    break;
                case 3:
                    // View Expenditure Records
                    System.out.println("Expenditure Records:");
                    for (int i = 0; i < expenditureCount; i++) {
                        System.out.println(expenditureRecords[i]);
                    }
                    break;
                case 4:
                    // View Income Records
                    System.out.println("Income Records:");
                    for (int i = 0; i < incomeCount; i++) {
                        System.out.println(incomeRecords[i]);
                    }
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}

class ExpenditureRecord {
    private String date;
    private double amount;
    private String category;
    private String description;

    public ExpenditureRecord(String date, double amount, String category, String description) {
        this.date = date;
        this.amount = amount;
        this.category = category;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Date: " + date + ", Amount: " + amount + ", Category: " + category + ", Description: " + description;
    }
}

class IncomeRecord {
    private String date;
    private double amount;
    private String source;
    private String description;

    public IncomeRecord(String date, double amount, String source, String description) {
        this.date = date;
        this.amount = amount;
        this.source = source;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Date: " + date + ", Amount: " + amount + ", Source: " + source + ", Description: " + description;
    }
}