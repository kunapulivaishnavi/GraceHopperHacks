package jrJava.GraceHopperHacks;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ComplaintsHomePage implements ActionListener {

    JButton button = new JButton();
    public static ArrayList<String> commentsArrayList = new ArrayList<String>();

    ComplaintsHomePage() throws Exception {
        JFrame frame = new JFrame();

        JPanel panel = new JPanel();
        panel.setAlignmentX(20);
        panel.setAlignmentY(30);
        panel.setSize(330, 240);
        panel.setLayout(new GridLayout(100, 0));
        JLabel label = new JLabel("Complaints lodged by students --->");
        label.setBounds(30, -300, 1000, 1000);
        label.setFont(new Font("Verdana", Font.PLAIN, 50));
        label.setPreferredSize(new Dimension(1000, 1000));
        button = new JButton("Next");
        JScrollPane scroll = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        button.setBounds(700, 350, 80, 30);
        button.addActionListener(this);
        frame.add(label);
        frame.add(button);
        frame.add(scroll);

        frame.setTitle("Complaints");

        frame.setBounds(100, 100, 1000, 500);
        frame.getRootPane().setBorder(BorderFactory.createMatteBorder(40, 20, 30, 30, Color.PINK));
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            new Complaints();
        }

    }

}
