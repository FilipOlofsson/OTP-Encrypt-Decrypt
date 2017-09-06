import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;

public class GUI extends JFrame {

    Button openFileButton;
    Button openKeyButton;
    Button encryptButton;
    Button decryptButton;
    Button generateKeyButton;

    GUI(int width, int height, String title, ActionListener ac) throws NoSuchAlgorithmException {
        JFrame jFrame = new JFrame();
        setSize(new Dimension(width, height));
        setTitle(title);
        setVisible(true);
        setLayout(new FlowLayout());
        setBackground(Color.black);
        setLocationRelativeTo(null);
        setResizable(false);
        jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        initComponents(ac);
    }

    private void initComponents(ActionListener ac) {
        openFileButton = new Button("Open File");
        add(openFileButton);
        openFileButton.addActionListener(ac);

        openKeyButton = new Button("Open Key");
        add(openKeyButton);
        openKeyButton.addActionListener(ac);

        encryptButton = new Button("Encrypt");
        add(encryptButton);
        encryptButton.addActionListener(ac);

        decryptButton = new Button("Decrypt");
        add(decryptButton);
        decryptButton.addActionListener(ac);

        generateKeyButton = new Button("Generate Key");
        add(generateKeyButton);
        generateKeyButton.addActionListener(ac);

    }

}
