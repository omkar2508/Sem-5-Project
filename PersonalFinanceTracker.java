import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Transaction {
    private String description;
    private double amount;

    public Transaction(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }
}

public class PersonalFinanceTracker extends JFrame {
    private List<Transaction> transactions;
    private JList<String> transactionList;
    private DefaultListModel<String> listModel;

    public PersonalFinanceTracker() {
        transactions = new ArrayList<>();
        listModel = new DefaultListModel<>();
        transactionList = new JList<>(listModel);

        setTitle("Personal Finance Tracker");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel entryPanel = new JPanel();
        entryPanel.setLayout(new GridLayout(4, 1));

        JTextField descriptionField = new JTextField();
        JTextField amountField = new JTextField();

        entryPanel.add(new JLabel("Description:"));
        entryPanel.add(descriptionField);
        entryPanel.add(new JLabel("Amount:"));
        entryPanel.add(amountField);

        JButton addButton = new JButton("Add Transaction");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String description = descriptionField.getText();
                double amount = Double.parseDouble(amountField.getText());
                addTransaction(description, amount);
                descriptionField.setText("");
                amountField.setText("");
            }
        });

        JButton saveButton = new JButton("Save Transactions");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveTransactionsToFile();
            }
        });

        add(entryPanel, BorderLayout.NORTH);
        add(new JScrollPane(transactionList), BorderLayout.CENTER);
        add(addButton, BorderLayout.SOUTH);
        add(saveButton, BorderLayout.SOUTH);
    }

    public void addTransaction(String description, double amount) {
        Transaction transaction = new Transaction(description, amount);
        transactions.add(transaction);
        listModel.addElement(description + " - $" + amount);
    }

    public void saveTransactionsToFile() {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showSaveDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            try (FileWriter writer = new FileWriter(fileChooser.getSelectedFile())) {
                for (Transaction transaction : transactions) {
                    writer.write(transaction.getDescription() + "," + transaction.getAmount() + "\n");
                }
                writer.flush();
                JOptionPane.showMessageDialog(this, "Transactions saved successfully.", "Success",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error saving transactions.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PersonalFinanceTracker tracker = new PersonalFinanceTracker();
            tracker.setVisible(true);
        });
    }
}
