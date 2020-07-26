package jrJava.GraceHopperHacks;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Teacher implements ActionListener {
    private JButton button;
    private JFrame frame;
    static JPanel panel;
    private JPanel page2;
    JTextField textField;
    JTextField textField2;
    static JTextField textField3;
    static HashMap<String, String> map = new HashMap<String, String>();

    public Teacher() {
        frame = new JFrame("Teacher");
        frame.setBounds(100, 100, 1000, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 20, 10));
        panel.setVisible(true);
        frame.add(panel);
        frame.getRootPane().setBorder(BorderFactory.createMatteBorder(40, 40, 30, 40, Color.CYAN));

        preparePage2();

        frame.setVisible(true);
    }

    private void preparePage2() {

        page2 = new JPanel();
        GridLayout layout = new GridLayout(9, 9);
        page2.setLayout(layout);

        textField = new JTextField("Email");
        JLabel label14 = new JLabel("Enter your email");
        page2.add(label14);
        textField.setColumns(25);
        page2.add(textField);
        JLabel label2_space = new JLabel("");
        page2.add(label2_space);

        textField2 = new JTextField("Password");
        JLabel label16 = new JLabel("Enter your password");
        page2.add(label16);
        page2.add(textField2);
        JLabel label3_space = new JLabel("");
        page2.add(label3_space);
        JLabel label4_space = new JLabel("");
        page2.add(label4_space);

        button = new JButton("Submit");

        button.addActionListener(this);
        page2.add(button);

        frame.add(page2);

    }

    public void actionPerformed(ActionEvent e) {
        String a = textField.getText();
        String b = textField2.getText();
        Map<String, String> map2 = TeacherData.getData();
        System.out.println(map2);
        if (map2.containsKey(a)) {
            if (map2.get(a).equals(b)) {
                try {
                    new ComplaintsHomePage();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            } else
                new TeacherIncorrect();
        } else
            new TeacherIncorrect();
    }
}
