import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class GUI extends JFrame implements ActionListener {

    JFrame jFrame;

    Button openFileButton;
    Button openKeyButton;
    Button encryptButton;
    Button decryptButton;
    Button generateKey;

    boolean selectedFile;
    boolean selectedKey;

    File origFile;
    File keyFile;


    GUI(int width, int height, String title) {
        jFrame = new JFrame();
        setSize(new Dimension(width, height));
        setTitle(title);
        setVisible(true);
        setLayout(new FlowLayout());
        initComponents();
        setBackground(Color.black);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    void initComponents() {
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

        generateKey = new Button("Generate Key");
        add(generateKey);
        generateKey.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JFileChooser fileChooser = new JFileChooser();

        if(e.getSource().equals(openFileButton)) {
            if(fileChooser.showOpenDialog(this) == fileChooser.APPROVE_OPTION) {
                origFile = fileChooser.getSelectedFile();
                selectedFile = true;
            }
        } else if(e.getSource().equals(openKeyButton)) {
            if(fileChooser.showOpenDialog(this) == fileChooser.APPROVE_OPTION) {
                keyFile = fileChooser.getSelectedFile();
                selectedKey = true;
            }
        } else if(e.getSource().equals(encryptButton)) {
            if(selectedFile && selectedKey) {
                crypto.encrypt(origFile, keyFile);
            }
        } else if(e.getSource().equals(decryptButton)) {
            if(selectedFile && selectedKey) {
                crypto.decrypt(origFile, keyFile);
            }
        } else if(e.getSource().equals(generateKey)) {
            crypto.generateKey();
        }
    }
}
