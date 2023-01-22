package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;

class Gui implements ActionListener {

    private JFrame frame;
    private JPanel panel;
    private JTextField textField;
    private JTextField text_result;
    private JButton button;
    private JLabel userLabel;
    private JLabel numberOfPins;
    public int result;
    public int rows;

    public Gui(){

        panel = new JPanel();
        frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400,400);
        frame.add(panel);
        panel.setLayout(null);

        //label for NOfrows
        userLabel = new JLabel("Enter number of rows: ");
        userLabel.setBounds(10,20,150,25);
        panel.add(userLabel);

        //number of pins
        numberOfPins = new JLabel("The number of pins are:");
        numberOfPins.setBounds(10,60,150,25);
        panel.add(numberOfPins);

        //text field for user data entering
        textField = new JTextField(20);
        textField.setBounds(153,20,170,25);
        panel.add(textField);

        //text Field 2 for results
        text_result = new JTextField(20);
        text_result.setBounds(153,60,170,25);
        panel.add(text_result);

        //button
        button = new JButton("Enter");
        button.setBounds(100,160,160,80);
        button.addActionListener(this);
        panel.add(button);

        frame.setVisible(true);
    }

    //the working code
     public static int  numberOfPins(int n){
         if (n <= 0){
             return 0;
         }
         else {
             return n + numberOfPins(n-1);
         }
     }

    @Override
    public void actionPerformed(ActionEvent l) {
        try{
        rows = Integer.parseInt(textField.getText());
            result = numberOfPins(rows);
            text_result.setText(String.valueOf(result));
        }
        catch (NumberFormatException e){
            JOptionPane.showMessageDialog(panel,"Wrong Entry\n Try again!!","Error", JOptionPane.ERROR_MESSAGE);

        }
        catch (StackOverflowError s){
            JOptionPane.showMessageDialog(panel,"Enter a smaller number","Error", JOptionPane.ERROR_MESSAGE);
        }
    }

     public static void main(String[] args) {
         new Gui();
     }
}
