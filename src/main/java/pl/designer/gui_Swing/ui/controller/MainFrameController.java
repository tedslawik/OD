package pl.designer.gui_Swing.ui.controller;

import pl.designer.gui_Swing.ui.view.MainFrame;
import pl.logic.FileAnalysis;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrameController {

    private MainFrame mainFrame;
    private JTextArea mainTA;
    private JButton automaticChange;
    private JTextField oldLetterField;
    private JTextField newLetterField;
    private JButton selectFileButton;
    private JTextArea messageTA;
    private JTextArea changedTA;
    private JButton changeButton;

    public MainFrameController() {
        initComponents();
        initListeners();

    }

    public void showMainFrameWindow() {

        mainFrame.setVisible(true);
    }

    private void initComponents() {
        mainFrame = new MainFrame();
        automaticChange = mainFrame.getAutomaticChange();
        mainTA = mainFrame.getWelcomeTA();
        oldLetterField = mainFrame.getOldLetterField();
        newLetterField = mainFrame.getNewLetterField();
        selectFileButton = mainFrame.getSelectFileButton();
        messageTA = mainFrame.getMessageTA();
        changedTA =mainFrame.getChangedTA();
        changeButton =mainFrame.getChangeButton();
    }


    private void initListeners() {
        changeButton.addActionListener(new ChangeButtonListener());
        selectFileButton.addActionListener(new SelectButtonLister());
        automaticChange.addActionListener(new AutomaticChangeListener());
    }

    private class SelectButtonLister implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            new FileAnalysis().setSelectFileButton(mainTA);
            new FileAnalysis().charCounter(mainTA, messageTA);

        }
    }
private class  AutomaticChangeListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        new FileAnalysis().automaticChange(mainTA,changedTA);
    }
}
    private class ChangeButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
             new FileAnalysis().changeCharInString(mainTA,oldLetterField,newLetterField,changedTA);
        }
    }

}
