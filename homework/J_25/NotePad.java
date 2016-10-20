import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Created by zehaeva on 10/13/16.
 */
public class NotePad extends JFrame {
    private JTextArea _text;
    private String _file_name;
    private String _file_path;

    /**
     * starts up the notepad!
     * @throws HeadlessException
     */
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

    /**
     * sets up the menus
     */
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
        new_item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFile();
            }
        });
        file_menu.add(new_item);
        new_item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveFile();
            }
        });
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
        new_item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findText();
            }
        });
        edit_menu.add(new_item);
        new_item = new JMenuItem("Replace");
        new_item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                replaceText();
            }
        });
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
        new_item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeDate();
            }
        });
        edit_menu.add(new_item);

        JMenu format_menu = new JMenu("Format");
        new_item = new JMenuItem("Word Wrap");
        new_item .addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleWordWrap();
            }
        });
        format_menu.add(new_item);
        format_menu.setMnemonic('o');

        JMenu view_menu = new JMenu("View");
        view_menu.setMnemonic('V');

        JMenu help_menu = new JMenu("Help");
        new_item = new JMenuItem("About");
        new_item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                help();
            }
        });
        help_menu.add(new_item);
        help_menu.setMnemonic('H');

        JMenuBar bar = new JMenuBar();
        setJMenuBar(bar);
        bar.add(file_menu);
        bar.add(edit_menu);
        bar.add(format_menu);
        bar.add(view_menu);
        bar.add(help_menu);
    }

    /**
     * clears the text box and allows the user to start writing!
     */
    private void newFile() {
        this._text.setText("");
    }

    /**
     * prompts the user for a file, opens it and loads it into the text box
     */
    private void openFile() {
        JFileChooser chooser = new JFileChooser();
        ArrayList<String> linesToRead = new ArrayList<>();
        int action = chooser.showOpenDialog(this);

        if (action == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            this._file_path = file.getPath();
            Path path = Paths.get(this._file_path);

            String temp = this._text.getText();
            try {
                this._text.setText("");

                // Need to cast the return result to an ArrayList
                linesToRead = (ArrayList<String>) Files.readAllLines(path, StandardCharsets.UTF_8);
                this._text.setText(linesToRead.get(0));
                for (int i = 1; i < linesToRead.size(); i++) {
                    this._text.setText(this._text.getText() + "\n" + linesToRead.get(i));
                }

            } catch (IOException e) {
                this._text.setText(temp);
                System.out.println(path.toString());
            }

        }
    }

    /**
     * Code stolen from the instructor Coveny
     * @param input ArrayList of strings to be written
     * @param fileName name of file to write to
     */
    public static void WriteTextFile(ArrayList<String> input,  String fileName) {
        // We need to set up a path to a file, really its just
        // a text string to the path wrapped in an object
        Path path = Paths.get(fileName);

        // Try and catch prevents "typical" errors from breaking the program.
        // For some error types a try/catch block is REQUIRED to compile.  This
        // is one of those instances.
        try {
            Files.write(path, input, StandardCharsets.UTF_8, StandardOpenOption.CREATE);
        } catch (IOException e) {
            System.out.println("There was a problem getting to the file!");
        }
    }

    /**
     * saves the current file under the current file name
     */
    private void saveFile() {
        if (this._file_path != null) {
            ArrayList<String> text = new ArrayList<>();

            for (String line :
                    this._text.getText().split("\n")) {
                text.add(line);
            }

            this.WriteTextFile(text, this._file_path);
        }
        else {
            this.saveFileAs();
        }
    }

    /**
     * saves the file after prompting for the name and file path
     */
    private void saveFileAs() {

    }

    /**
     * shuts the program down
     */
    private void exit() {
        System.exit(0);
    }

    /**
     * prompts the user for text and then highlights it in the program
     */
    private void findText() {
        String needle = (String)JOptionPane.showInputDialog(this, "Enter Text to find:", "Find");
        String haystack = this._text.getText();
        int needle_start;

        needle_start = haystack.indexOf(needle);

        if (needle_start >= 0) {
            this._text.select(needle_start, needle_start + needle.length());
        }
    }

    /**
     * promts the user for text and then replace it with the provided text
     */
    private void replaceText() {
        JPanel form = new JPanel();
        JTextField needle = new JTextField(8);
        JTextField nails = new JTextField(8);

        form.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridwidth = 1;
        gbc.gridy = 1;
        form.add(new JLabel("Find:"), gbc);
        gbc.gridx = 1;
        form.add(needle, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        form.add(new JLabel("Replace:"), gbc);
        gbc.gridx = 1;
        form.add(nails, gbc);

        int result = JOptionPane.showConfirmDialog(this, form, "Find/Replace", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String temp = this._text.getText();
            temp = temp.replace(needle.getText(), nails.getText());
            this._text.setText(temp);
        }

    }

    /**
     * selects all the text in the text box
     */
    private void selectAllText() {
       this._text.selectAll();
    }

    /**
     * I have no idea what this should do
     */
    private void timeDate() {
        this._text.insert(LocalDateTime.now().toString(), this._text.getCaretPosition());
    }

    private void help() {
        JOptionPane.showMessageDialog(this, "Note Pad: Designed by Howard");
    }

    /**
     * toggles wordwrap on the text box
     */
    private void toggleWordWrap () {
        this._text.setLineWrap(!this._text.getLineWrap());
    }
}
