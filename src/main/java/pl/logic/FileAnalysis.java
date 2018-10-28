package pl.logic;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

import static java.util.stream.Collectors.toMap;

public class FileAnalysis {
    static List<Integer> usedChars = new ArrayList<>();

    public List<Character> setCustom() {
        List<Character> alphabet = new ArrayList<>();
        alphabet.add('l');
        alphabet.add('g');
        alphabet.add('d');
        alphabet.add('c');
        alphabet.add('f');

        alphabet.add('k');
        alphabet.add('r');
        alphabet.add('v');
        alphabet.add('x');
        alphabet.add('p');

        alphabet.add('o');
        alphabet.add('n');
        alphabet.add('b');
        alphabet.add('q');
        alphabet.add('a');

        alphabet.add('t');
        alphabet.add('e');
        alphabet.add('s');
        alphabet.add('m');
        alphabet.add('i');

        alphabet.add('h');
        alphabet.add('z');
        alphabet.add('u');
        alphabet.add('y');
        alphabet.add('w');
        alphabet.add('j');

        return alphabet;
    }

    public List<Character> setAlphabet() {
        List<Character> alphabet = new ArrayList<>();
        alphabet.add('a');
        alphabet.add('b');
        alphabet.add('c');
        alphabet.add('d');
        alphabet.add('e');

        alphabet.add('f');
        alphabet.add('g');
        alphabet.add('h');
        alphabet.add('i');
        alphabet.add('j');

        alphabet.add('k');
        alphabet.add('l');
        alphabet.add('m');
        alphabet.add('n');
        alphabet.add('o');

        alphabet.add('p');
        alphabet.add('q');
        alphabet.add('r');
        alphabet.add('s');
        alphabet.add('t');

        alphabet.add('u');
        alphabet.add('v');
        alphabet.add('w');
        alphabet.add('x');
        alphabet.add('y');
        alphabet.add('z');

        return alphabet;
    }

    public void setSelectFileButton(JTextArea mainTA) {
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File file = chooser.getSelectedFile();
        String fileName = file.getAbsolutePath();
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            mainTA.read(bufferedReader, null);
            bufferedReader.close();
            mainTA.requestFocus();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

    public void charCounter(JTextArea mainTA, JTextArea messageTA) {
        String sentence = mainTA.getText();
        Map<String, Long> charCount = new HashMap<>();
        for (char charachter : sentence.toLowerCase().toCharArray()) {
            String charAsString = Character.toString(charachter);
            if (charCount.containsKey(charAsString)) {
                long val = charCount.get(charAsString) + 1;
                charCount.put(charAsString, val);
            } else {
                charCount.put(charAsString, 1l);
            }
        }
        HashMap sorted = charCount
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(
                        toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

        messageTA.append(String.valueOf(sorted));
        int counter = 0;
        for (Object entryCnt : sorted.entrySet()) {
            if (counter != 0) {
                Object lettersOftext = entryCnt;
                System.out.println(entryCnt);
            } else
                counter++;
        }

    }

    public void changeCharInString(JTextArea mainTA, JTextField oldLetterField, JTextField newLetterField, JTextArea changeTA) {
        String sentence;
        List<Integer> usedChar;
        usedChar = usedChars;
        System.out.println("first" + usedChar);
        if (changeTA.getText().length() == 0) {
            sentence = mainTA.getText();
        } else {
            sentence = changeTA.getText();
        }

        usedChar.add(-1);
        changeTA.setText("");
        char[] sentenceArray = sentence.toCharArray();
        for (int k = 0; k < sentenceArray.length; k++) {
            if (sentenceArray[k] == oldLetterField.getText().charAt(0) && checkIfAbsent(k, usedChar) == false) {
                System.out.println("to jessst k " + k);
                sentenceArray[k] = newLetterField.getText().charAt(0);
                usedChar.add(k);

            }

        }

        usedChars = usedChar;
        System.out.println("inside" + usedChar);
        System.out.println("global" + usedChars);
        sentence = String.valueOf(sentenceArray);
        changeTA.append(sentence);
    }

    public boolean checkIfAbsent(int index, List<Integer> array) {
        boolean letterAbsent = false;
        for (int i = 0; i < array.size(); i++) {
            if (index == array.get(i)) {
                letterAbsent = true;
            }
        }

        return letterAbsent;
    }

    public void automaticChange(JTextArea mainTA, JTextArea changeTA) {
        List<Character> commonLetters = setCustom();
        List<Character> alphabet = setAlphabet();

        String sentence;
        List<Integer> usedChar;
        usedChar = usedChars;
        if (changeTA.getText().length() == 0) {
            sentence = mainTA.getText();
        } else {
            sentence = changeTA.getText();
        }

        usedChar.add(-1);
        changeTA.setText("");
        char[] sentenceArray = sentence.toCharArray();
        System.out.println(alphabet);
        System.out.println(commonLetters);
        for (int k = 0; k < sentenceArray.length; k++) {
            for (int i = 0; i < alphabet.size(); i++) {

                if (sentenceArray[k] == alphabet.get(i) && checkIfAbsent(k, usedChar) == false) {
                    sentenceArray[k] = commonLetters.get(i);
                    usedChar.add(k);
                }
            }
            usedChars = usedChar;

        }
        sentence = String.valueOf(sentenceArray);
        changeTA.append(sentence);
    }


}
