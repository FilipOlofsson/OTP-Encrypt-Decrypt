import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class crypto {

    public static void encrypt(File raw, File key) {
        if(raw.length() > key.length()) {
            System.out.println("The key needs to be of the same length or longer than the original file.");
        } else {
            try {
                File output = new File("output.txt");
                BufferedReader rawReader = new BufferedReader(new FileReader(raw));
                BufferedReader keyReader = new BufferedReader(new FileReader(key));
                BufferedWriter outputWriter = new BufferedWriter(new FileWriter(output));

                int rawRead;
                int keyRead;



                while((rawRead = rawReader.read()) != -1 && (keyRead = keyReader.read()) != -1) {
                    outputWriter.write((char) (rawRead % 26 + keyRead % 26));
                }

                outputWriter.close();
                saveFile(output);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void decrypt(File encrypted, File key) {

    }

    private static void saveFile(File file) {

    }

    public static void generateKey() {

    }

}
