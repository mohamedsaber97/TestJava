import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class TeatFrame extends JFrame implements ActionListener {

    JMenuBar menuBar;
    JMenu menu;
    JMenuItem loadFile, saveFile, exit;
    JTable table;
    JTextArea textArea;

    FileOperations fileOperations = new FileOperations();
    ArrayList<InvoiceHeader> readData = new ArrayList<>();
    ArrayList<InvoiceHeader> savedData = new ArrayList<>();


    public TeatFrame() {
        super("Test Frame");

        setSize(700, 1000);
        setLocation(100, 100);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        menuBar = new JMenuBar();
        menu = new JMenu("File");
        loadFile = new JMenuItem("Load File", 'L');
        loadFile.addActionListener(this);
        loadFile.setActionCommand("l");
        saveFile = new JMenuItem("Save File", 'S');
        saveFile.addActionListener(this);
        saveFile.setActionCommand("s");
        exit = new JMenuItem("Exit", 'E');
        exit.addActionListener(this);
        exit.setActionCommand("e");
        menu.add(loadFile);
        menu.add(saveFile);
        menu.addSeparator();
        menu.add(exit);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        String[] cols = {"No.", "Date", "Customer", "Total"};
        int rows = 4;
        DefaultTableModel model = new DefaultTableModel(rows, cols.length);
        model.setColumnIdentifiers(cols);
        table = new JTable(model);
        add(new JScrollPane(table));

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {
            case "l" -> readData = fileOperations.readFile();
            case "s" -> savedData = fileOperations.writeFile();
            case "e" -> System.exit(0);
        }
    }

    void openFile() {
        JFileChooser fs = new JFileChooser();
        int result = fs.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            String path = fs.getSelectedFile().getPath();
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(path);
                int size = fis.available();
                byte[] b = new byte[size];
                fis.read(b);
                textArea.setText(new String(b));
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    void saveFile() {
        JFileChooser fs2 = new JFileChooser();
        int result = fs2.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            String path = fs2.getSelectedFile().getPath();
            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream(path);
                byte[] b = textArea.getText().getBytes();
                fos.write(b);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
