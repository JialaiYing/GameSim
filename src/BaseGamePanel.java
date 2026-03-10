import javax.swing.*;
import java.awt.*;

public abstract class BaseGamePanel extends JPanel {
    protected Main mainApp;
    protected CardLayout layout = new CardLayout();
    protected JPanel container = new JPanel(new BorderLayout());

    public BaseGamePanel(Main mainApp) {
        this.mainApp = mainApp;
        setLayout(layout);

        JPanel intro = new JPanel(new GridBagLayout());
        intro.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;

        JLabel label = new JLabel(getIntroText());
        label.setHorizontalAlignment(SwingConstants.CENTER);

        JButton start = new JButton("START MISSION");
        start.setPreferredSize(new Dimension(180, 50));
        start.addActionListener(e -> { startGame(); layout.show(this, "Game"); });

        gbc.gridy = 0; intro.add(label, gbc);
        gbc.gridy = 1; intro.add(Box.createVerticalStrut(30), gbc);
        gbc.gridy = 2; intro.add(start, gbc);

        add(intro, "Intro");
        add(container, "Game");
    }

    public abstract String getIntroText();
    public abstract void startGame();

    protected void finish(String msg) {
        JOptionPane.showMessageDialog(this, msg);
        layout.show(this, "Intro");
        mainApp.showCard("Menu");
    }
}