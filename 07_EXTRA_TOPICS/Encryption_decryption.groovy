
-----------------------------
# Encryption and Decryption:
-----------------------------

1. Encryption 

8. Encryption is the process of converting plain text into a coded format to prevent unauthorized access.
9. It uses algorithms and keys to transform the data.


* How can we achieve encryption in Java?

We don't need to use the javax.crypto package directly to achieve encryption in Java; it's handled by various libraries.

2. Decryption

    - Decryption is the process of converting the encrypted data back into its original form using a key.
    - It reverses the encryption process to make the data readable again.

    Example for encryption and decryption in Java:
    ```
    public class Encryption_Decryption {

        public static void main(String[] args) {

            try {
                String originalText = "Hello, World!";

                // Generate a secret key
                KeyGenerator keyGen = KeyGenerator.getInstance("AES");
                keyGen.init(128); // You can use 192 or 256 bits as well
                SecretKey secretKey = keyGen.generateKey();

                // ---------- ENCRYPTION ----------
                Cipher cipher = Cipher.getInstance("AES");
                cipher.init(Cipher.ENCRYPT_MODE, secretKey);
                byte[] encryptedBytes = cipher.doFinal(originalText.getBytes());
                String encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);

                System.out.println("Encrypted Text: " + encryptedText);

                // ---------- DECRYPTION ----------
                Cipher decryptCipher = Cipher.getInstance("AES");
                decryptCipher.init(Cipher.DECRYPT_MODE, secretKey);
                byte[] decryptedBytes = decryptCipher.doFinal(Base64.getDecoder().decode(encryptedText));
                String decryptedText = new String(decryptedBytes);

                System.out.println("Decrypted Text: " + decryptedText);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    ```

    
