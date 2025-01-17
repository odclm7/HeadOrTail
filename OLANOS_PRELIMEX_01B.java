import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class OLANOS_PRELIMEX_01B {
    public static void main(String[] args) {
        OLANOS_PRELIMEX_01B flipCoinApp = new OLANOS_PRELIMEX_01B();
        flipCoinApp.flipCoin();
    }

    public void flipCoin(){

        // Set up the JFrame for the GUI
        JFrame flipCoinFrame = new JFrame("Coin Flipping Simulation");

        flipCoinFrame.setSize(400, 400);
        flipCoinFrame.setLayout(new BorderLayout());

        // Create a panel to display the results
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(11, 1)); // 10 trials + 1 for the button

        JLabel blankLabel1 = new JLabel("");
        panel.add(blankLabel1);

        // Add a label to guide the user
        JLabel instructionLabel = new JLabel("Click 'Flip Coins' to start the simulation");
        instructionLabel.setFont(new Font("Arial", Font.BOLD, 20));
        instructionLabel.setHorizontalAlignment(SwingConstants.LEFT);
        panel.add(instructionLabel);

        JLabel blankLabel2 = new JLabel("");
        panel.add(blankLabel2);

        // Add a label to guide the user
        

        // Create and add labels for trials
        for (int trials = 1; trials <= 10; trials++) {
            // Create a new JLabel for each trial
            JLabel trialLabel = new JLabel("Trial " + trials + ": Pending");
            panel.add(trialLabel); // Add the label to the panel
        }

        // Add a button to trigger the coin flip simulation
        JButton flipButton = new JButton("Flip Coins");
        panel.add(flipButton);

        // Create a JTextArea to display the results
        JTextArea resultArea = new JTextArea(10, 20);
        resultArea.setEditable(false);
        panel.add(new JScrollPane(resultArea));

        // Add the panel to the frame
        flipCoinFrame.add(panel, BorderLayout.CENTER);

        flipCoinFrame.setLocationRelativeTo(null);
        flipCoinFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        flipCoinFrame.setVisible(true);

        // Action listener for the button to start the coin flips
        flipButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Clear the previous results
                resultArea.setText("");
                
                // Perform 10 trials
                Random random = new Random();
                for (int trial = 1; trial <= 10; trial++) {
                    int heads = 0;
                    int tails = 0;
                    
                    // Flip 3 coins for each trial
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
                }
            }
        });
    }
}
