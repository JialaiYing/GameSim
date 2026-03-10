import javax.swing.*;
import java.awt.*;

public class Politician extends BaseGamePanel {
    private int approval = 50;

    public Politician(Main m) {
        super(m);
        JPanel p = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Sky/Wall
                g2.setColor(new Color(173, 216, 230));
                g2.fillRect(0,0,800,600);

                // Crowd Drawing
                g2.setColor(new Color(50, 50, 50));
                for(int i=0; i < approval; i++) {
                    int row = i / 10;
                    int col = i % 10;
                    g2.fillOval(100 + col * 60, 400 + row * 30, 30, 30); // Audience heads
                }

                // Podium
                g2.setColor(new Color(139, 69, 19));
                g2.fillRect(350, 320, 100, 150);
                g2.setColor(Color.BLACK);
                g2.drawRect(350, 320, 100, 150);

                // Centered Rating
                g2.setFont(new Font("Serif", Font.BOLD, 30));
                g2.setColor(Color.BLACK);
                String s = "Public Approval: " + approval + "%";
                FontMetrics fm = g2.getFontMetrics();
                g2.drawString(s, 400 - fm.stringWidth(s)/2, 100);
            }
        };

        JPanel actions = new JPanel();
        JButton b1 = new JButton("Pass Education Bill");
        b1.addActionListener(e -> { approval += 10; update(p); });
        JButton b2 = new JButton("Increase Taxes");
        b2.addActionListener(e -> { approval -= 10; update(p); });

        actions.add(b1); actions.add(b2);
        container.add(p, BorderLayout.CENTER);
        container.add(actions, BorderLayout.SOUTH);
    }

    private void update(JPanel p) {
        p.repaint();
        if (approval >= 100) finish("Political Legend! You were elected President.");
        if (approval <= 0) finish("The people have revolted. Career over.");
    }

    public String getIntroText() { return "<html><center><h1>POLITICIAN</h1>Win the crowd's favor.<br>Reach 100% approval to win.</center></html>"; }
    public void startGame() { approval = 50; }
}