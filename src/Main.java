import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Password Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // Password Length question Jlabel
        gbc.gridy++;
        panel.add(new JLabel("Password Length"),gbc);
        JSpinner startPageInput = new JSpinner(new SpinnerNumberModel(0,0,Integer.MAX_VALUE,1));
        panel.add(startPageInput,gbc);

        // Numbers question JLabel
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel.add(new JLabel("Include numbers ?"), gbc);

        // Numbers Yes/No Options
        gbc.gridx = 1;
        gbc.gridy = 2;
        JCheckBox numberCheck = new JCheckBox();
        panel.add(numberCheck, gbc);

        // Uppercase letters question Jlabel
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Include Uppercase letters ?"), gbc);

        // Uppercase Yes/No Options
        gbc.gridx = 1;
        gbc.gridy = 3;
        JCheckBox uppercaseCheck = new JCheckBox();
        panel.add(uppercaseCheck, gbc);

        // Button
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.EAST;
        JButton generateButton = new JButton("Generate");
        // Generate button Action Listener
        panel.add(generateButton, gbc);
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // declare stuff
                int startPageInputInt = (int) startPageInput.getValue();
                boolean uppercaseCheckSelected = uppercaseCheck.isSelected();
                boolean numberCheckSelected = numberCheck.isSelected();
                String generatedPassword = "";
                Random random = new Random();
                /* todo : maybe put stuff in a while so the password generates accordingly
                              something like while (has numbers , is uppercase , is lowercase) idfk
                 */
                for (int i = 0; i < startPageInputInt; i++) {
                    // Generate a random lowercase letter
                    char randomLetter = (char) ('a' + random.nextInt(26));
                    // If user wants uppercase
                    if (uppercaseCheckSelected && random.nextInt(2) == 0) {
                        randomLetter = Character.toUpperCase(randomLetter);
                    }
                }
            }
        });

        frame.add(panel);
        frame.setVisible(true);

    }

}