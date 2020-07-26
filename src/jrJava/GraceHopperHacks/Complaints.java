
package jrJava.GraceHopperHacks;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Complaints {
    static int i = 0;
    static boolean selected = false;
    static ArrayList<String> list;
    static JCheckBox j;
    static JCheckBox j2;
    static ActionListener actionListener;

    public static void main(String[] args) {
        new Complaints();
    }

    Complaints() {
        try {
            displayComplaints();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void displayComplaints() throws Exception {
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        list = new ArrayList<String>();
        frame = new JFrame();
        panel = new JPanel();
        panel.setAlignmentX(100);
        panel.setAlignmentY(100);
        panel.setBounds(90, 90, 900, 400);
        panel.setLayout(new GridLayout(90, 0));

        List<String> list = ProblemData.unread();
        if (list.isEmpty()) {
            new NoComments();
        }
        System.out.println(list);

        JLabel label = new JLabel("   ");
        panel.add(label);
        label = new JLabel(
                "    ***Check the box if the problem has been solved. Then check the 'next' CheckBox to move on. ");
        label.setFont(new java.awt.Font("Arial", Font.BOLD, 18));
        System.out.println("i is " + i);
        System.out.println(list.get(i));
        j = new JCheckBox(list.get(i));
        j.setFont(new java.awt.Font("Arial", Font.BOLD, 20));
        // i++;
        j2 = new JCheckBox("next");
        j2.setBounds(10, 10, 10, 10);
        j2.setFont(new java.awt.Font("Arial", Font.BOLD, 20));
        // j2.setBackground(Color.BLUE);
        j2.setForeground(Color.BLUE);

        panel.add(label);
        label = new JLabel("   ");
        panel.add(label);
        panel.add(j);
        panel.add(new JLabel(" "));
        panel.add(new JLabel(" "));
        panel.add(new JLabel(" "));
        panel.add(new JLabel(" "));
        panel.add(new JLabel(" "));
        panel.add(j2);
        // ;
        JScrollPane scroll = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        ActionListener actionListener = new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                System.out.println("First Action Performed method");

                if (j2.isSelected()) {
                    if (j.isSelected()) {
                        if (i == list.size() - 1)
                            new NoComments();
                        ProblemData.replace(j.getText(), "read");
                        System.out.println(j.getText());
                        try {
                            displayComplaints();
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                    } else if (!j.isSelected()) {
                        try {

                            if (i == list.size() - 1) {
                                new NoComments();

                            } else {
                                i++;
                                displayComplaints();
                            }
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            }
        };

        j2.addActionListener(actionListener);
        j.addActionListener(actionListener);
        frame.setTitle("Complaints");
        frame.setBounds(100, 100, 1000, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(scroll);
        frame.getRootPane().setBorder(BorderFactory.createMatteBorder(40, 40, 30, 40, Color.GREEN));
        frame.setVisible(true);
    }
}
