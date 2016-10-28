import javax.swing.*;
import java.awt.*;

/**
 * Created by zehaeva on 10/27/16.
 */
public class RandomCharacters extends JFrame {
    public RandomCharacters() throws HeadlessException {
        RandomPanel p = new RandomPanel();

        this.add(p);
        this.setTitle("Random Characters!");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setBackground(Color.white);
        this.setSize(200, 200);
    }
}
