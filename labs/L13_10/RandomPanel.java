import javax.swing.*;
import java.awt.*;
import java.security.SecureRandom;

/**
 * Created by zehaeva on 10/27/16.
 */
public class RandomPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        SecureRandom rand = new SecureRandom();
        String font;

        for (int i = 0; i < 10; i++) {
            switch (rand.nextInt(3)) {
                case 0:
                    font = "DialogInput";
                    break;
                case 1:
                    font = "Dialog";
                    break;
                case 2:
                    font = "SansSerif";
                    break;
                case 3:
                    font = "Monospaced";
                    break;
                default:
                    font = "Serif";
                    break;
            }
            g.setFont(new Font(font, Font.PLAIN, 12));
            g.setColor(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
            g.drawString(String.valueOf((char)(rand.nextInt(50) + 32)), 13 + (i * 10), 20);
        }
    }
}
