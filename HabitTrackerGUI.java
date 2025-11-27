import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class HabitTrackerGUI {
private JFrame frame;
private DefaultListModel<String> listModel;
private ArrayList<Habit> habitList;
private JList<String> habitJList;
private JTextField habitField, timeField;

public HabitTrackerGUI() {
habitList = new ArrayList<>();

frame = new JFrame("Habit Tracker App");
frame.setSize(440, 400);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

listModel = new DefaultListModel<>();
habitJList = new JList<>(listModel);

habitField = new JTextField();
timeField = new JTextField();
JButton addButton = new JButton("Add Habit");
JButton markButton = new JButton("Mark Complete");
JButton resetButton = new JButton("Reset");
JButton infoButton = new JButton("Show Info");

JPanel panel = new JPanel();
panel.setLayout(null);

// DARK THEME COLORS
Color darkBlue = new Color(21, 32, 43);
Color darkerBlue = new Color(26, 39, 52);
Color gray = new Color(200, 200, 200);
Color darkGray = new Color(90, 90, 90);

panel.setBackground(darkBlue);

// Fonts
Font buttonFont = new Font("Arial", Font.BOLD, 14);
Font textFont = new Font("Arial", Font.PLAIN, 14);
Font listFont = new Font("Arial", Font.BOLD, 15);

habitField.setFont(textFont);
timeField.setFont(textFont);
habitJList.setFont(listFont);
addButton.setFont(buttonFont);
markButton.setFont(buttonFont);
resetButton.setFont(buttonFont);
infoButton.setFont(buttonFont);

// Button Colors
addButton.setBackground(darkGray);
addButton.setForeground(gray);

markButton.setBackground(darkerBlue);
markButton.setForeground(gray);

resetButton.setBackground(darkGray);
resetButton.setForeground(gray);

infoButton.setBackground(darkerBlue);
infoButton.setForeground(gray);

// Text field colors
habitField.setBackground(gray);
timeField.setBackground(gray);

// List colors
habitJList.setBackground(darkGray);
habitJList.setForeground(gray);

// Placement
habitField.setBounds(20, 20, 170, 35);
timeField.setBounds(200, 20, 110, 35);
addButton.setBounds(320, 20, 90, 35);

habitJList.setBounds(20, 70, 390, 140);

markButton.setBounds(20, 220, 120, 35);
resetButton.setBounds(160, 220, 120, 35);
infoButton.setBounds(300, 220, 110, 35);

// Heading
JLabel heading = new JLabel("Habit Tracker");
heading.setFont(new Font("Arial", Font.BOLD, 22));
heading.setBounds(20, 310, 250, 40);
heading.setForeground(gray);

panel.add(habitField);
panel.add(timeField);
panel.add(addButton);
panel.add(habitJList);
panel.add(markButton);
panel.add(resetButton);
panel.add(infoButton);
panel.add(heading);

frame.add(panel);

// Add Habit
addButton.addActionListener(e -> {
String name = habitField.getText();
String time = timeField.getText();
if (!name.isEmpty() && !time.isEmpty()) {
Habit h = new Habit(name, time);
habitList.add(h);
listModel.addElement(h.toString());
habitField.setText("");
timeField.setText("");
JOptionPane.showMessageDialog(frame,
"Habit '" + name + "' added for " + time + "!",
"Habit Notification", JOptionPane.INFORMATION_MESSAGE);
} else {
JOptionPane.showMessageDialog(frame,
"Please fill both habit name and time.",
"Input Error", JOptionPane.ERROR_MESSAGE);
}
});

// Mark Complete
markButton.addActionListener(e -> {
int idx = habitJList.getSelectedIndex();
if (idx >= 0) {
habitList.get(idx).markCompleted();
listModel.set(idx, habitList.get(idx).toString());
JOptionPane.showMessageDialog(frame,
"Habit '" + habitList.get(idx).getName() + "' marked as Completed!",
"Habit Notification", JOptionPane.INFORMATION_MESSAGE);
} else {
JOptionPane.showMessageDialog(frame,
"Please select a habit!", "Select Error", JOptionPane.WARNING_MESSAGE);
}
});

// Reset Habit
resetButton.addActionListener(e -> {
int idx = habitJList.getSelectedIndex();
if (idx >= 0) {
habitList.get(idx).resetHabit();
listModel.set(idx, habitList.get(idx).toString());
JOptionPane.showMessageDialog(frame,
"Habit '" + habitList.get(idx).getName() + "' reset to Pending!",
"Habit Notification", JOptionPane.INFORMATION_MESSAGE);
} else {
JOptionPane.showMessageDialog(frame,
"Please select a habit!", "Select Error", JOptionPane.WARNING_MESSAGE);
}
});

// Show Info Button
infoButton.addActionListener(e -> {
int idx = habitJList.getSelectedIndex();
if (idx >= 0) {
Habit h = habitList.get(idx);
String info = "Habit: " + h.getName()
+ "\nTime: " + h.getTime()
+ "\nStatus: " + (h.isCompleted() ? "Completed" : "Pending");
JOptionPane.showMessageDialog(frame, info, "Habit Info", JOptionPane.INFORMATION_MESSAGE);
}
});

frame.setVisible(true);
}

public static void main(String[] args) {
new HabitTrackerGUI();
}
}
