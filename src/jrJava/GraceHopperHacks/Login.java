package jrJava.GraceHopperHacks;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Login implements ActionListener {
    private JButton[] buttons;
    private String[] pageNames = { "Student", "Teacher" };
    private JFrame buttonsFrame;
    private JPanel buttonsPanel;

    public Login() {

        buttonsFrame = new JFrame("Control Frame");
        buttonsFrame.setBounds(850, 600, 100, 80);
        buttonsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        buttonsPanel = new JPanel();
        buttonsPanel.setBackground(Color.WHITE);
        buttonsFrame.add(buttonsPanel);

        buttons = new JButton[2];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton(pageNames[i]);
            buttonsPanel.add(buttons[i]);
            buttons[i].addActionListener(this);
        }

        buttonsFrame.pack();
        buttonsFrame.setVisible(true);

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
        }

        buttons[1].requestFocus();
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == buttons[0]) {
            new Student();
        } else if (e.getSource() == buttons[1]) {
            new Teacher();
        }
    }

    public static void main(String[] args) throws IOException {
        StudentData.read();
        TeacherData.read();
        ProblemData.read();

        new Login();
    }
}
