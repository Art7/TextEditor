package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Artur on 21.04.2015.
 */
public class GUI {
    private JFrame mainFrame;
    private JTextArea textArea;
    private JPanel mainPanel;
    private GridLayout mainGridLayout;
    private JButton closeButton;
    private JButton clearButton;
    private JButton upFontButton;
    private JButton downFontButton;
    private JFrame closeFrame;
    private JPanel closePanel2;
    private JLabel closeLabel;
    private JPanel closePanel;
    private GridLayout closeGridLayout;
    private JButton confirmButton;
    private JButton cancelButton;

    public void startGUI(){

        //mainFrame descriptions
        mainFrame = new JFrame("Text Edtor");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setBounds(100, 100, 400, 300);
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        mainPanel = new JPanel();
        mainGridLayout = new GridLayout(1,10);
        mainPanel.setLayout(mainGridLayout);

        //mainFrame Button actions
        downFontButton = new JButton("Down Font");
        downFontButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Font font = textArea.getFont();
                float size = font.getSize() - 1.0f;
                textArea.setFont(font.deriveFont(size));
            }
        });
        upFontButton = new JButton("Up Font");
        upFontButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Font font = textArea.getFont();
                float size = font.getSize() + 1.0f;
                textArea.setFont(font.deriveFont(size));
            }
        });
        clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
            }
        });
        closeButton = new JButton("Close");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeFrame.setVisible(true);
            }
        });

        //mainFrame addings
        mainFrame.add(BorderLayout.NORTH, mainPanel);
        mainFrame.add(BorderLayout.CENTER, textArea);
        mainPanel.add(downFontButton);
        mainPanel.add(upFontButton);
        mainPanel.add(clearButton);
        mainPanel.add(closeButton);

        //closeFrame descriptions
        closeFrame = new JFrame("Close?");
        closeFrame.setBounds(150, 150, 200, 150);
        closePanel2 = new JPanel();
        closeLabel = new JLabel("Are you sure?");
        closePanel = new JPanel();
        closeGridLayout = new GridLayout(1,2);
        closePanel.setLayout(closeGridLayout);

        //closeFrame Button actions
        confirmButton = new JButton("Confirm");
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeFrame.setVisible(false);
            }
        });

        //closeFrame addings
        closeFrame.add(BorderLayout.CENTER, closePanel2);
        closePanel2.add(closeLabel);
        closeFrame.add(BorderLayout.SOUTH, closePanel);
        closePanel.add(cancelButton);
        closePanel.add(confirmButton);

        //mainFrame show
        mainFrame.setVisible(true);
    }

}
