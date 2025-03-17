import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Password Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // TODO : use gridy++ and get rid of the inset bullshit
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridy++;
        panel.add(new JLabel("Password Length"),gbc);
        JSpinner startPageInput = new JSpinner(new SpinnerNumberModel(0,0,Integer.MAX_VALUE,1));
        panel.add(startPageInput,gbc);

        // Numbers Question
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel.add(new JLabel("Include numbers ?"), gbc);

        // Numbers Yes/No Options
        gbc.gridx = 1;
        gbc.gridy = 2;
        JComboBox numbersComboBox = new JComboBox<>(new String[]{"Yes", "No"});
        panel.add(numbersComboBox, gbc);

        // Uppercase Letters Question
        // TODO : Ideally you would use a checkbox for this
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Include Uppercase letters ?"), gbc);

        // Uppercase Yes/No Options
        // TODO : Ideally you would use a checkbox for this
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(new JComboBox<>(new String[]{"Yes", "No"}), gbc);

        // Button
        // TODO : class method as separate for button press
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.EAST;
        JButton generateButton = new JButton("Generate");
        panel.add(generateButton, gbc);
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int startPageInputInt = (int) startPageInput.getValue();
                // TODO : figure out "yes"/"no" boolean values
                boolean numbersComboBoxBool = (boolean) numbersComboBox.getValue();
            }
        });

        frame.add(panel);
        frame.setVisible(true);

    }

}