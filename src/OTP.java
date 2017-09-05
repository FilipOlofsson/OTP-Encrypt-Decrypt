/*
    One Time Pad Encryption and Decryption
    Created by Filip Olofsson 2017-09-05

    Usage:
        Either run with no arguments and using the GUI or using three arguments, -c or -d for encryption or decryption,
        file path for the input file, file path for the key file and a file path for the output file.

        Example:
            -c C:/Path/To/Raw/File.txt C:/Path/To/Key/File.txt C:/Path/To/Output.txt

 */
import java.io.File;
import java.io.IOException;

public class OTP {
    public static void main(String[] args) throws IOException {

        if(args.length == 0) {
            GUI gui = new GUI(200, 100, "xd");
        } else if(args.length == 4) {
            if(args[0].equals("-c") || args[0].equals("-d")) {

                File originalFile = new File(args[1]);

                if(!originalFile.exists())
                    incorrectUsage();

                File keyFile = new File(args[2]);
                if(!keyFile.exists())
                    incorrectUsage();

                File outputFile = new File(args[3]);

                if(args[0].equals("-c"))
                    crypto.encrypt(originalFile, keyFile, outputFile);
                else
                    crypto.decrypt(originalFile, keyFile, outputFile);


            } else {
                incorrectUsage();
            }
        } else {
            incorrectUsage();
        }
    }


    /*
        Bad solution to deal with end users, a better solution would be using exceptions but this works.
     */
    private static void incorrectUsage() {
        System.out.println("Incorrect usage. You can either use no arguments and launch with a GUI or you can use it with the command prompt.");
        System.out.println("To encrypt using the command prompt you use \"java OTP -c C:/Path/To/Raw/File.txt C:/Path/To/Key/File.txt C:/Path/To/Output.txt");
        System.out.println("To decrypt using the command prompt you use \"java OTP -d C:/Path/To/Encrypted/File.txt C:/Path/To/Key/File.txt C:/Path/To/Output.txt");
        System.exit(-1);
    }
}
