package miniproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SequenceAnalyzer extends JFrame implements ActionListener {

    JTextField termField, sequenceField, evenField, oddField, guessField;
    JLabel resultLabel;

    JButton generateButton, checkButton;

    int correctAnswer = 0;

    public SequenceAnalyzer(){

        setTitle("Sequence Pattern Analyzer");
        setSize(520,420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridLayout(7,2,10,10));

        getContentPane().setBackground(new Color(220,240,255));

        add(new JLabel("Enter number of terms:"));
        termField = new JTextField();
        add(termField);

        generateButton = new JButton("Generate");
        add(generateButton);
        add(new JLabel(""));

        add(new JLabel("Sequence:"));
        sequenceField = new JTextField();
        sequenceField.setEditable(false);
        add(sequenceField);

        add(new JLabel("Even Numbers:"));
        evenField = new JTextField();
        evenField.setEditable(false);
        add(evenField);

        add(new JLabel("Odd Numbers:"));
        oddField = new JTextField();
        oddField.setEditable(false);
        add(oddField);

        add(new JLabel("Guess Next Number:"));
        guessField = new JTextField();
        add(guessField);

        checkButton = new JButton("Check Answer");
        add(checkButton);

        resultLabel = new JLabel("");
        add(resultLabel);

        generateButton.addActionListener(this);
        checkButton.addActionListener(this);

        setVisible(true);
    }

    // YOUR ORIGINAL SEQUENCE LOGIC
    public int sequence(int n){
        return (int)(Math.pow(2,n) + Math.pow(n+1,2));
    }

    public void actionPerformed(ActionEvent e){

        if(e.getSource() == generateButton){

            int n;

            try{
                n = Integer.parseInt(termField.getText());
            }
            catch(Exception ex){
                resultLabel.setText("Enter a valid number");
                return;
            }

            String seq="";
            String even="";
            String odd="";

            for(int i=0;i<n;i++){

                int value = sequence(i);

                seq += value + " ";

                if(value % 2 == 0)
                    even += value + " ";
                else
                    odd += value + " ";
            }

            correctAnswer = sequence(n);

            sequenceField.setText(seq);
            evenField.setText(even);
            oddField.setText(odd);
        }

        if(e.getSource() == checkButton){

            int guess;

            try{
                guess = Integer.parseInt(guessField.getText());
            }
            catch(Exception ex){
                resultLabel.setText("Enter valid guess");
                return;
            }

            if(guess == correctAnswer)
                resultLabel.setText("✔ Correct!");
            else
                resultLabel.setText("✘ Wrong! Correct answer is " + correctAnswer);
        }
    }

    public static void main(String[] args){
        new SequenceAnalyzer();
    }
}