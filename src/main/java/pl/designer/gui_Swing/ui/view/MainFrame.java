package pl.designer.gui_Swing.ui.view;

import javax.swing.*;

public class MainFrame extends  JFrame {
    public static final int WIDTH = 1300;
    public static final int HEIGHT = 600;
    private JTextArea mainTA;
    private JPanel MainPanel;
    private JButton automaticChange;
    private JTextField oldLetterField;
    private JTextField newLetterField;
    private JButton selectFileButton;
    private JTextArea messageTA;
    private JTextArea changedTA;
    private JButton changeButton;


    public MainFrame() {
        setSize(WIDTH, HEIGHT);
        setContentPane(MainPanel);
        setLocationRelativeTo(null);
        mainTA.setLineWrap(true);
        messageTA.setLineWrap(true);
        changedTA.setLineWrap(true);
    }

    public JTextArea getWelcomeTA() {
        return mainTA;
    }

    public JButton getAutomaticChange() {
        return automaticChange;
    }

    public JTextField getOldLetterField() {
        return oldLetterField;
    }

    public JTextField getNewLetterField() {
        return newLetterField;
    }

    public JButton getSelectFileButton() {
        return selectFileButton;
    }

    public JTextArea getMessageTA() {
        return messageTA;
    }

    public JTextArea getChangedTA() {
        return changedTA;
    }

    public JButton getChangeButton() {
        return changeButton;
    }


}
