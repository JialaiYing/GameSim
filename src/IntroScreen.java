import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class IntroScreen extends JPanel {
    private Main mainApp;

    public IntroScreen(Main mainApp) {
        this.mainApp = mainApp;
        setBackground(new Color(25, 25, 112)); // Midnight Blue for a strong intro
        setLayout(new GridBagLayout()); // Use GridBagLayout for perfect centering

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 0, 10, 0); // Padding

        // Large Title
        JLabel titleLabel = new JLabel("Welcome to Career Explorer!");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 50));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(titleLabel, gbc);

        // Small Instruction
        gbc.gridy = 1;
        JLabel clickLabel = new JLabel("Click anywhere to proceed...");
        clickLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        clickLabel.setForeground(new Color(200, 200, 200)); // Lighter gray for instruction
        clickLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(clickLabel, gbc);

        // Mouse Listener to transition to MenuPanel
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mainApp.showCard("Menu"); // Transition to the MenuPanel
            }
        });
    }

    // Optional: Override paintComponent for custom background drawing if needed,
    // but setting background color is enough for this simple screen.
}