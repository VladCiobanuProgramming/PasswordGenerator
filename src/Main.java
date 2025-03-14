import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Password Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 350);

        // TODO : use gridy++ and get rid of the inset bullshit
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        panel.add(new JLabel("Start Page"),gbc);
        gbc.gridy++;
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
        panel.add(new JComboBox<>(new String[]{"Yes", "No"}), gbc);

        // Uppercase Letters Question
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Include Uppercase letters ?"), gbc);

        // Uppercase Yes/No Options
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(new JComboBox<>(new String[]{"Yes", "No"}), gbc);

        // Button
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(new JButton("Button"), gbc);

        frame.add(panel);
        frame.setVisible(true);
    }
}