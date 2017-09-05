import java.io.*;

class crypto {

    /*
        Method to encrypt a file using a key.
        It manages this by performing bitwise XOR with the unencrypted character and the key.
     */
    static void encrypt(File raw, File key, File output) throws IOException {
        BufferedReader rawReader = new BufferedReader(new FileReader(raw));
        BufferedReader keyReader = new BufferedReader(new FileReader(key));
        DataOutputStream binaryOut = new DataOutputStream(new FileOutputStream(output));

        int rawCode, keyCode;

        while(((rawCode = rawReader.read()) != -1) && ((keyCode = keyReader.read()) != -1)) {     // Read both the raw file and the key until the BufferedReader.read() returns -1, meaning the EOF has been reached.
            binaryOut.writeByte(rawCode ^ keyCode);                                            // Perform bitwise XOR
        }

        binaryOut.close();
    }


    /*
    Method to decrypt a file using a key.
    It manages this by performing bitwise XOR with the encrypted byte and the key.
    */
    static void decrypt(File encrypted, File key, File output) throws IOException {
        BufferedReader encryptedReader = new BufferedReader(new FileReader(encrypted));
        BufferedReader keyReader = new BufferedReader(new FileReader(key));
        DataOutputStream binaryOut = new DataOutputStream(new FileOutputStream(output));

        int rawCode, keyCode;

        while(((rawCode = encryptedReader.read()) != -1) && ((keyCode = keyReader.read()) != -1)) {     // Read both the encrypted file and the key until the BufferedReader.read() returns -1, meaning the EOF has been reached.
            binaryOut.writeByte(rawCode ^ keyCode);                                                  // Perform bitwise XOR
        }

        binaryOut.close();
    }

}
