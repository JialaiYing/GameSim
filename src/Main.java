import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    private CardLayout cardLayout = new CardLayout();
    private JPanel mainPanel = new JPanel(cardLayout);

    public Main() {
        setTitle("Career Explorer: Professional Worlds");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Registering the screens
        mainPanel.add(new IntroScreen(this), "Intro"); // <-- NEW: Starts with IntroScreen
        mainPanel.add(new MenuPanel(this), "Menu");
        mainPanel.add(new Nurse(this), "Nurse");
        mainPanel.add(new Entrepreneur(this), "Entrepreneur");
        mainPanel.add(new Politician(this), "Politician");

        add(mainPanel);
        setLocationRelativeTo(null);
        setVisible(true);

        cardLayout.show(mainPanel, "Intro"); // <-- Ensures IntroScreen is shown first
    }

    public void showCard(String cardName) {
        cardLayout.show(mainPanel, cardName);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}