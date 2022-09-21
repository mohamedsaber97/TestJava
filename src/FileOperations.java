import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class FileOperations extends Component {
    JFileChooser readFileChooser, writeFileChooser;
    int readResult, writeResult;
    File readFile, writeFile;
    FileReader fileReader;
    BufferedReader bufferedReader;

    //method to read invoice header data from .csv file
    public ArrayList<InvoiceHeader> readFile() {
        readFileChooser = new JFileChooser();
        readResult = readFileChooser.showOpenDialog(this);
        if (readResult == JFileChooser.APPROVE_OPTION) {
            readFile = readFileChooser.getSelectedFile();
            System.out.println("read file is : " + readFile);
            String line;
            try {
                fileReader = new FileReader(readFile);
                bufferedReader = new BufferedReader(fileReader);
                while ((line = bufferedReader.readLine()) != null) {
                    String[] data = line.split(",");    // use comma as separator
                    System.out.println("Invoice "
                            + "["
                            + "invoice num = " + data[0]
                            + ", invoice Date = " + data[1]
                            + ", customer name = " + data[2]
                            + "]");
                }
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return null;
    }


    //method to write invoice header data to .csv file
    public ArrayList<InvoiceHeader> writeFile() {
        writeFileChooser = new JFileChooser();
        writeResult = writeFileChooser.showOpenDialog(this);
        if (writeResult == JFileChooser.APPROVE_OPTION) {
            writeFile = writeFileChooser.getSelectedFile();
            System.out.println("we save data to csv file");
            System.out.println("write file is : " + writeFile);
        }
        return null;
    }
}