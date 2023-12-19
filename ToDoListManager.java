import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ToDoListManager extends JFrame {
    private DefaultListModel<Task> tasks;
    private JList<Task> taskList;
    private JTextField taskInputField;
    private JTextField timeInputField;
    private JComboBox<String> priorityComboBox;

    public ToDoListManager() {
        tasks = new DefaultListModel<>();
        taskList = new JList<>(tasks);
        taskInputField = new JTextField(20);
        timeInputField = new JTextField(20);

        JButton addButton = new JButton("Add Task");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTask();
            }
        });

        JButton removeButton = new JButton("Remove Task");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeTask();
            }
        });

        JPanel inputPanel = new JPanel();
        inputPanel.add(taskInputField);
        inputPanel.add(timeInputField);
        inputPanel.add(priorityComboBox);
        inputPanel.add(addButton);

        setLayout(new BorderLayout());
        add(new JScrollPane(taskList), BorderLayout.CENTER);
        add(inputPanel, BorderLayout.NORTH);
        add(removeButton, BorderLayout.SOUTH);

        String[] priorities = { "High", "Medium", "Low" };
        priorityComboBox = new JComboBox<>(priorities);

        setTitle("To-Do List Manager");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void addTask() {
        String taskName = taskInputField.getText().trim();
        String time = timeInputField.getText().trim();
        String priority = (String) priorityComboBox.getSelectedItem();

        if (!taskName.isEmpty() && !time.isEmpty()) {
            Task newTask = new Task(taskName, time, priority);
            tasks.addElement(newTask);
            taskInputField.setText("");
            timeInputField.setText("");
        }
    }

    private void removeTask() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex >= 0) {
            tasks.remove(selectedIndex);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ToDoListManager todoApp = new ToDoListManager();
                todoApp.setVisible(true);
            }
        });
    }
}

class Task {
    private String name;
    private String time;
    private String priority;

    public Task(String name, String time, String priority) {
        this.name = name;
        this.time = time;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    public String getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return name + " (Time: " + time + ", Priority: " + priority + ")";
    }
}
