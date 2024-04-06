import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FarmManagementApplication {

    static ExpenditureRecord[] expenditureRecords = new ExpenditureRecord[100];
    static IncomeRecord[] incomeRecords = new IncomeRecord[100];
    static int expenditureCount = 0;
    static int incomeCount = 0;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Farm Management Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new GridLayout(0, 2));

        JButton addExpenditureButton = new JButton("Add Expenditure Record");
        addExpenditureButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addExpenditureRecord();
            }
        });

        JButton addIncomeButton = new JButton("Add Income Record");
        addIncomeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addIncomeRecord();
            }
        });

        JButton viewExpenditureButton = new JButton("View Expenditure Records");
        viewExpenditureButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                viewExpenditureRecords();
            }
        });

        JButton viewIncomeButton = new JButton("View Income Records");
        viewIncomeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                viewIncomeRecords();
            }
        });

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        frame.add(addExpenditureButton);
        frame.add(addIncomeButton);
        frame.add(viewExpenditureButton);
        frame.add(viewIncomeButton);
        frame.add(exitButton);

        frame.setVisible(true);
    }

    private static void addExpenditureRecord() {
        String date = JOptionPane.showInputDialog("Enter date (DD/MM/YYYY):");
        double amount = Double.parseDouble(JOptionPane.showInputDialog("Enter amount:"));
        String category = JOptionPane.showInputDialog("Enter category:");
        String description = JOptionPane.showInputDialog("Enter description:");

        expenditureRecords[expenditureCount++] = new ExpenditureRecord(date, amount, category, description);
        JOptionPane.showMessageDialog(null, "Expenditure record added successfully!");
    }

    private static void addIncomeRecord() {
        String date = JOptionPane.showInputDialog("Enter date (DD/MM/YYYY):");
        double amount = Double.parseDouble(JOptionPane.showInputDialog("Enter amount:"));
        String source = JOptionPane.showInputDialog("Enter source:");
        String description = JOptionPane.showInputDialog("Enter description:");

        incomeRecords[incomeCount++] = new IncomeRecord(date, amount, source, description);
        JOptionPane.showMessageDialog(null, "Income record added successfully!");
    }

    private static void viewExpenditureRecords() {
        String[] columnNames = {"Date", "Amount", "Category", "Description"};
        Object[][] data = new Object[expenditureCount][4];

        for (int i = 0; i < expenditureCount; i++) {
            ExpenditureRecord record = expenditureRecords[i];
            data[i] = new Object[]{record.date, record.amount, record.category, record.description};
        }

        JTable table = new JTable(data, columnNames);
        JOptionPane.showMessageDialog(null, new JScrollPane(table), "Expenditure Records", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void viewIncomeRecords() {
        String[] columnNames = {"Date", "Amount", "Source", "Description"};
        Object[][] data = new Object[incomeCount][4];

        for (int i = 0; i < incomeCount; i++) {
            IncomeRecord record = incomeRecords[i];
            data[i] = new Object[]{record.date, record.amount, record.source, record.description};
        }

        JTable table = new JTable(data, columnNames);
        JOptionPane.showMessageDialog(null, new JScrollPane(table), "Income Records", JOptionPane.INFORMATION_MESSAGE);
    }

    static class ExpenditureRecord {
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
    }

    static class IncomeRecord {
        private final String date;
        private final double amount;
        private final String source;
        private final String description;

        public IncomeRecord(String date, double amount, String source, String description) {
            this.date = date;
            this.amount = amount;
            this.source = source;
            this.description = description;
        }
    }
}
