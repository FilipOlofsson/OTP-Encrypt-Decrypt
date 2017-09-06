import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Controller implements ActionListener, MouseListener {

    MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");

    GUI gui;

    private boolean selectedFile;
    private boolean selectedKey;

    private File origFile;
    private File keyFile;

    private String Seed = "";

    public Controller(int width, int height, String title) throws NoSuchAlgorithmException {
        gui = new GUI(width, height, title, this);
        gui.addMouseListener(this);
        gui.getContentPane().addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new java.io.File("."));

        if(e.getSource().equals(gui.openFileButton)) {
            if(fileChooser.showOpenDialog(gui) == JFileChooser.APPROVE_OPTION) {
                origFile = fileChooser.getSelectedFile();
                selectedFile = true;
            }
        } else if(e.getSource().equals(gui.openKeyButton)) {
            if(fileChooser.showOpenDialog(gui) == JFileChooser.APPROVE_OPTION) {
                keyFile = fileChooser.getSelectedFile();
                selectedKey = true;
            }
        } else if(e.getSource().equals(gui.encryptButton)) {
            if(selectedFile && selectedKey) {
                try {
                    crypto.encrypt(origFile, keyFile, new File("Encrypted.dat"));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            } else {
                System.out.println("You need to choose both a file to encrypt and a key file in order to encrypt.");
            }
        } else if(e.getSource().equals(gui.decryptButton)) {
            if(selectedFile && selectedKey) {
                try {
                    crypto.decrypt(origFile, keyFile, new File("Decrypted.txt"));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            } else {
                System.out.println("You need to choose both a file to decrypt and a key file in order to decrypt.");
            }
        } else if(e.getSource().equals(gui.generateKeyButton)) {
            if(Seed.length() < 10000) {
                System.out.println("Seed is not strong enough. Move your mouse around more.");
            } else {
                try {
                    if(selectedFile)
                        crypto.generateKey(Seed, origFile);
                    else
                        System.out.println("You need to choose a file to encrypt in order to determine the length of the key file.");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Seed +=  String.format("%032X", new BigInteger(1, messageDigest.digest(("" + e.getX() + e.getY()).getBytes())));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Seed +=  String.format("%032X", new BigInteger(1, messageDigest.digest(("" + e.getX() + e.getY()).getBytes())));
    }
}
