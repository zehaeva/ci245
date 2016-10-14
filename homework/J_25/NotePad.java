import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by zehaeva on 10/13/16.
 */
public class NotePad extends JFrame {
    private JTextArea _text;

    public NotePad() throws HeadlessException {

        this.setPreferredSize(new Dimension(500, 500));

        this.setLayout(new BorderLayout());

        setUpMenu();

        this._text = new JTextArea();
        this._text.setAutoscrolls(true);

        JScrollPane scroll = new JScrollPane(this._text);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        this.add(scroll);

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setUpMenu() {
        JMenu file_menu = new JMenu("File");
        file_menu.setMnemonic('F');

        JMenuItem new_item = new JMenuItem("New");
        new_item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newFile();
            }
        });
        file_menu.add(new_item);
        new_item = new JMenuItem("Open");
        file_menu.add(new_item);
        new_item = new JMenuItem("Save");
        file_menu.add(new_item);
        new_item = new JMenuItem("Save As");
        file_menu.add(new_item);
        new_item = new JMenuItem("Exit");
        new_item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        file_menu.add(new_item);

        JMenu edit_menu = new JMenu("Edit");
        edit_menu.setMnemonic('E');

        new_item = new JMenuItem("Find");
        edit_menu.add(new_item);
        new_item = new JMenuItem("Replace");
        edit_menu.add(new_item);
        new_item = new JMenuItem("Select All");
        new_item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectAllText();
            }
        });
        edit_menu.add(new_item);
        new_item = new JMenuItem("Time/Date");
        edit_menu.add(new_item);

        JMenu format_menu = new JMenu("Format");
        format_menu.setMnemonic('o');

        JMenu view_menu = new JMenu("View");
        view_menu.setMnemonic('V');

        JMenu help_menu = new JMenu("Help");
        help_menu.setMnemonic('H');

        JMenuBar bar = new JMenuBar();
        setJMenuBar(bar);
        bar.add(file_menu);
        bar.add(edit_menu);
        bar.add(format_menu);
        bar.add(view_menu);
        bar.add(help_menu);
    }

    private void newFile() {
        this._text.setText("");
    }

    private void openFile() {

    }

    private void saveFile() {

    }

    private void saveFileAs() {

    }

    private void exit() {
        System.exit(0);
    }

    private void findText() {

    }

    private void replaceText() {

    }

    private void selectAllText() {
       this._text.selectAll();
    }

    private void timeDate() {

    }

    private void toggleWordWrap () {
        this._text.setLineWrap(!this._text.getLineWrap());
    }
}
