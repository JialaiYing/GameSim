import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class MenuPanel extends JPanel {
    public MenuPanel(Main mainApp) {
        setLayout(new GridBagLayout());
        setBackground(new Color(33, 37, 41)); // Sleek dark theme
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.insets = new Insets(15, 15, 15, 15);

        JLabel title = new JLabel("CAREER EXPLORER");
        title.setFont(new Font("SansSerif", Font.BOLD, 48));
        title.setForeground(new Color(248, 249, 250));

        JLabel subtitle = new JLabel("Master your profession. Conquer the challenge.");
        subtitle.setFont(new Font("SansSerif", Font.ITALIC, 18));
        subtitle.setForeground(new Color(173, 181, 189));

        JLabel description = new JLabel("Welcome to Career Explorer. You can either choose your profession, or the roll dice for a more spiced up experience.");
        subtitle.setFont(new Font("SansSerif", Font.ITALIC, 18));
        subtitle.setForeground(new Color(173, 181, 189));


        gbc.gridy = 0; add(title, gbc);
        gbc.gridy = 1; add(subtitle, gbc);

        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        btnPanel.setOpaque(false);

        String[] roles = {"Nurse", "Entrepreneur", "Politician"};
        for (String role : roles) {
            JButton b = createStyledButton(role);
            b.addActionListener(e -> mainApp.showCard(role));
            btnPanel.add(b);
        }

        JButton diceBtn = createStyledButton("🎲 Roll Dice");
        diceBtn.setBackground(new Color(108, 117, 125));
        diceBtn.addActionListener(e -> {
            String[] choices = {"Nurse", "Entrepreneur", "Politician"};
            mainApp.showCard(choices[new Random().nextInt(3)]);
        });

        gbc.gridy = 2; add(btnPanel, gbc);
        gbc.gridy = 3; add(diceBtn, gbc);
    }

    private JButton createStyledButton(String text) {
        JButton b = new JButton(text);
        b.setPreferredSize(new Dimension(150, 45));
        b.setFont(new Font("SansSerif", Font.BOLD, 14));
        b.setFocusPainted(false);
        return b;
    }
}