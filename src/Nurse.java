import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Nurse extends BaseGamePanel {
    private int sx = 150, dir = 10;
    private Timer t;

    public Nurse(Main m) {
        super(m);
        JPanel p = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Background: Hospital Room
                g2.setColor(new Color(200, 230, 230));
                g2.fillRect(0,0,800,600);
                g2.setColor(Color.WHITE);
                g2.fillRect(0, 400, 800, 200); // Floor

                // Draw Patient Arm
                g2.setColor(new Color(236, 188, 180));
                g2.fillRoundRect(200, 250, 400, 100, 50, 50);

                // Draw Nurse Hand holding Syringe
                g2.setColor(Color.WHITE);
                g2.fillRect(370, 50, 60, 120); // Syringe body
                g2.setColor(new Color(173, 216, 230, 180));
                g2.fillRect(375, 70, 50, 80); // Liquid
                g2.setColor(Color.BLACK);
                g2.drawRect(370, 50, 60, 120);
                g2.setStroke(new BasicStroke(3));
                g2.drawLine(400, 170, 400, 250); // Needle

                // Timing UI
                g2.setColor(new Color(50, 50, 50));
                g2.fillRoundRect(150, 480, 500, 30, 15, 15);
                g2.setColor(new Color(46, 204, 113)); // Sweet spot
                g2.fillRect(380, 480, 40, 30);
                g2.setColor(Color.YELLOW);
                g2.fillRect(sx, 475, 10, 40);
            }
        };
        p.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                t.stop();
                finish(sx >= 380 && sx <= 420 ? "Perfect Shot!" : "Ouch! You missed the muscle.");
            }
        });
        container.add(p);
        t = new Timer(20, e -> { sx += dir; if(sx<150 || sx>640) dir*=-1; p.repaint(); });
    }

    public String getIntroText() { return "<html><center><h1>NURSE WORLD</h1>Steady hands! Inject the flu shot<br>at the right moment.</center></html>"; }
    public void startGame() { sx=150; t.start(); }
}