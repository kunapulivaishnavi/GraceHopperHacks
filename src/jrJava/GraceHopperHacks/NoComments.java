package jrJava.GraceHopperHacks;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NoComments {

    private JFrame frame;
    static JPanel panel;

    public NoComments() {

        frame = new JFrame("No Comments");
        frame.setBounds(100, 100, 500, 10);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        GridLayout layout = new GridLayout(5, 5);
        panel.setLayout(layout);
        panel.setBackground(Color.WHITE);
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 20, 10));
        frame.add(panel);
        JLabel label = new JLabel("                                                      No Comments.      ");
        panel.add(label);
        frame.setVisible(true);
    }
}
