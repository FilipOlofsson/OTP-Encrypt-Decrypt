import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class GUI extends JFrame implements ActionListener {

    private Button openFileButton;
    private Button openKeyButton;
    private Button encryptButton;
    private Button decryptButton;

    private boolean selectedFile;
    private boolean selectedKey;

    private File origFile;
    private File keyFile;


    GUI(int width, int height, String title) {
        JFrame jFrame = new JFrame();
        initComponents();
        setSize(new Dimension(width, height));
        setTitle(title);
        setVisible(true);
        setLayout(new FlowLayout());

        setBackground(Color.black);
        jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }


    /*
    Initialize all the buttons and adds ActionListeners to all of them.
     */
    private void initComponents() {
        openFileButton = new Button("Open File");
        add(openFileButton);
        openFileButton.addActionListener(this);

        openKeyButton = new Button("Open Key");
        add(openKeyButton);
        openKeyButton.addActionListener(this);

        encryptButton = new Button("Encrypt");
        add(encryptButton);
        encryptButton.addActionListener(this);

        decryptButton = new Button("Decrypt");
        add(decryptButton);
        decryptButton.addActionListener(this);
    }


    /*
        Actionhandler, gets called each time a button is pressed.
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new java.io.File("."));

        if(e.getSource().equals(openFileButton)) {
            if(fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                origFile = fileChooser.getSelectedFile();
                selectedFile = true;
            }
        } else if(e.getSource().equals(openKeyButton)) {
            if(fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                keyFile = fileChooser.getSelectedFile();
                selectedKey = true;
            }
        } else if(e.getSource().equals(encryptButton)) {
            if(selectedFile && selectedKey) {
                try {
                    System.out.println(origFile.getAbsolutePath());
                    crypto.encrypt(origFile, keyFile, new File("Encrypted.dat"));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        } else if(e.getSource().equals(decryptButton)) {
            if(selectedFile && selectedKey) {
                try {
                    System.out.println(origFile.getAbsolutePath());
                    crypto.decrypt(origFile, keyFile, new File("Decrypted.txt"));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}
