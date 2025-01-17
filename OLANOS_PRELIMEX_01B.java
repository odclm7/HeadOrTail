import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
Author: Cheni Lei Olanos
Date: 1/17/2025

323 Prelim Exercise 1b
Filename: LASTNAME_PRELIMEX_01B.java
Create a program that will illustrate the flipping of 3 coins for 10 trials. 
For each flip per trial, the coin could either be tail or head. 
Display the number of tails or heads for each trial.
 */
public class OLANOS_PRELIMEX_01B {
    private int trials = 10;
    private int trial = 1;

    /**
     * Runs the application through the class object
     * Calls for the flipCoin method
     * @param args
     */
    public static void main(String[] args) {
        OLANOS_PRELIMEX_01B flipCoinApp = new OLANOS_PRELIMEX_01B();
        flipCoinApp.flipCoin();
    }

    /**
    flipCoin method:
    - Simulates a coin flip
    - Contains most of the functionalities for the application
     */
    public void flipCoin(){

        // Set up the JFrame for the GUI
        JFrame flipCoinFrame = new JFrame("Coin Flipping Simulation");
        flipCoinFrame.setSize(400, 500);
        flipCoinFrame.setLayout(null);

        // Add a label to guide the user
        JLabel instructionLabel = new JLabel("Click 'Flip Coins' to start the simulation");
        instructionLabel.setFont(new Font("Arial", Font.BOLD, 15));
        instructionLabel.setHorizontalAlignment(SwingConstants.LEFT);
        instructionLabel.setBounds(50, 30, 300, 50);
        flipCoinFrame.add(instructionLabel);

        // Add a label to indicate how many trials are available
        JLabel trialLabel = new JLabel("Trials: 10");
        trialLabel.setFont(new Font("Arial", 15, 13));
        trialLabel.setBounds(50, 60, 200, 50);
        flipCoinFrame.add(trialLabel); //Add label to the panel

        // Create a JTextArea to display the results
        JTextArea resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setBounds(90, 120, 200, 170);
        flipCoinFrame.add(resultArea);

        // Add a button to trigger the coin flip simulation
        JButton flipButton = new JButton("Flip Coins");
        flipButton.setBounds(110, 320, 150, 30);
        flipCoinFrame.add(flipButton);

        // Frame Configuration
        flipCoinFrame.setLocationRelativeTo(null);
        flipCoinFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        flipCoinFrame.setVisible(true);

        // Action listener for the button to start the coin flips
        flipButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Check if there are remaining trials
                if (trials > 0) {
                    // Perform one trial
                    Random random = new Random();
                    int heads = 0;
                    int tails = 0;

                    // Flip 3 coins for the trial
                    for (int flip = 0; flip < 3; flip++) {
                        int coinFlip = random.nextInt(2); // 0 for Tails, 1 for Heads
                        if (coinFlip == 0) {
                            tails++;
                        } else {
                            heads++;
                        }
                    }
                                        
                    // Display the result of the current trial
                    resultArea.append("Trial " + trial + ": Heads = " + heads + ", Tails = " + tails + "\n");
                    trial++;

                    // Decrement the trial count
                    trials--;
                    trialLabel.setText("Trials available: " + trials);

                    // Disable button if no trials are left
                    if (trials == 0) {
                        flipButton.setEnabled(false);
                        instructionLabel.setText("Simulation Complete!");
                    }
                } // End of if (trials > 0)
            } // End of actionPerformed() method
        }); // End of flipButton Action Listener
    } // End of flipCoin() method
} // End of OLANOS_PRELIMEX_01B class