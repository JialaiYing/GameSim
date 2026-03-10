import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Entrepreneur extends BaseGamePanel {
    private int capital = 20000;
    private ArrayList<Integer> history = new ArrayList<>();

    public Entrepreneur(Main m) {
        super(m);
        JPanel p = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Draw Boardroom Background
                g2.setColor(new Color(44, 62, 80));
                g2.fillRect(0, 0, 800, 600);

                // Draw Market Chart
                g2.setColor(Color.WHITE);
                g2.drawRect(100, 100, 600, 300);
                g2.setColor(new Color(46, 204, 113));
                g2.setStroke(new BasicStroke(3));

                for (int i = 1; i < history.size(); i++) {
                    int x1 = 100 + (i - 1) * 60;
                    int y1 = 400 - (history.get(i - 1) / 200);
                    int x2 = 100 + i * 60;
                    int y2 = 400 - (history.get(i) / 200);
                    g2.drawLine(x1, y1, x2, y2);
                }

                g2.setColor(Color.YELLOW);
                g2.setFont(new Font("SansSerif", Font.BOLD, 22));
                String text = "Company Valuation: $" + capital;
                FontMetrics fm = g2.getFontMetrics();
                g2.drawString(text, 400 - fm.stringWidth(text)/2, 80);
            }
        };

        JPanel controls = new JPanel();
        String[] actions = {"Hire Engineers", "Viral Marketing", "Cut Costs"};
        for (String a : actions) {
            JButton b = new JButton(a);
            b.addActionListener(e -> {
                if (a.equals("Hire Engineers")) capital += 8000;
                else if (a.equals("Viral Marketing")) capital += 15000;
                else capital -= 5000;

                history.add(capital);
                p.repaint();
                if (history.size() >= 10) finish(capital > 60000 ? "IPO Success! You are a Billionaire." : "Venture Failed.");
            });
            controls.add(b);
        }
        container.add(p, BorderLayout.CENTER);
        container.add(controls, BorderLayout.SOUTH);
    }

    public String getIntroText() { return "<html><center><h1>ENTREPRENEUR</h1>Reach a $60,000 valuation through<br>10 rounds of market strategy.</center></html>"; }
    public void startGame() { capital = 20000; history.clear(); history.add(capital); }
}