package jrJava.GraceHopperHacks;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class Student implements ActionListener {
    private JButton button;
    private JFrame frame;
    static JPanel panel;
    private JTabbedPane tabbed;
    private JPanel page1, page2;
    JTextField textField;
    JTextField textField2;
    static JTextField textField3;
    private String[] pageNames = { "Types of Bullying", "Report a Problem" };

    public Student() {
        frame = new JFrame("Student");
        frame.setBounds(100, 100, 1000, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 20, 10));
        frame.add(panel);
        frame.getRootPane().setBorder(BorderFactory.createMatteBorder(40, 40, 30, 40, Color.ORANGE));

        tabbed = new JTabbedPane();
        tabbed.setBackground(Color.WHITE);
        panel.add(tabbed);

        preparePage1();
        preparePage2();

        frame.setVisible(true);
    }

    private void preparePage1() {
        page1 = new JPanel();
        page1.setBackground(Color.WHITE);
        GridLayout layout = new GridLayout(5, 5);
        page1.setLayout(layout);
        JLabel label = new JLabel(
                "Physical Bullying: Physical bullying involves physically injuring someone or something causing both long term and short term damage.");
        page1.add(label);
        JLabel label1 = new JLabel(
                "Verbal Bullying: Verbal bullying is when someone is abused by verbal remarks, which can escelate to dangerous levels.");
        page1.add(label1);
        JLabel label2 = new JLabel(
                "Social Bullying: Social bullying is done to cause harm to or hurt someones social reputation.");
        page1.add(label2);
        JLabel label3 = new JLabel(
                "Cyber Bullying: Cyber bullying is harm inflicted through the use of computers, phones, and other electronic devices on various social media platforms.");
        page1.add(label3);

        tabbed.addTab(pageNames[0], page1);
    }

    private void preparePage2() {
        page2 = new JPanel();
        GridLayout layout = new GridLayout(9, 9);
        page2.setLayout(layout);
        textField = new JTextField("Username");
        JLabel label14 = new JLabel("Enter you username");
        page2.add(label14);
        textField.setColumns(25);
        page2.add(textField);

        textField3 = new JTextField("Explain the incident");
        JLabel label17 = new JLabel("Explain the incident that occured");
        page2.add(label17);
        // textField1.setRows(25);
        page2.add(textField3);

        JTextField textField2 = new JTextField("Date");
        JLabel label16 = new JLabel("Enter the date you witnessed the incident");
        page2.add(label16);
        // textField1.setRows(25);
        page2.add(textField2);

        button = new JButton("Submit");
        button.addActionListener(this);
        page2.add(button);

        tabbed.addTab(pageNames[1], page2);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            String studentID = textField.getText();
            if (StudentData.getData().contains(studentID)) {
                ProblemData.append(textField3.getText());
                new ThankYou();
            } else {
                new Incorrect();
            }
        }
    }
}
