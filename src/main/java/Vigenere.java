import java.util.Scanner;

public class Vigenere {
    public static String encryptVigenere(String message, String key) {
        String encryptedM = "";
        int stringLength = message.length();
        int keyLength = key.length();
        int k = 0;
        char newChar = 'a';

        for(int i = 0; i < stringLength; i++){
            char indexedChar = message.charAt(i);
            char keyChar = key.charAt(k);
            int keyInt = keyChar - 'A';

            if ((indexedChar <= 'Z') && (indexedChar >= 'A')){
                newChar = (char)(indexedChar + keyInt);
                if (newChar > 'Z'){
                    newChar = (char)(newChar - 26);
                }
                k += 1;
            }else if ((indexedChar <= 'z') && (indexedChar >= 'a')){
                newChar = (char)(indexedChar + keyInt);
                if (newChar > 'z'){
                    newChar = (char)(newChar - 26);
                }
                k += 1;
            }else{
                newChar = indexedChar;
            }
            encryptedM += newChar;
            if (k == keyLength){
                k = 0;
            }
            
        }
        return encryptedM;
    }

    public static String decryptVigenere(String message, String key) {
        String decryptedM = "";
        int stringLength = message.length();
        int keyLength = key.length();
        int k = 0;
        char newChar = 'a';

        for(int i = 0; i < stringLength; i++){
            char indexedChar = message.charAt(i);
            char keyChar = key.charAt(k);
            int keyInt = keyChar - 'A';

            if ((indexedChar <= 'Z') && (indexedChar >= 'A')){
                newChar = (char)(indexedChar - keyInt);
                if (newChar < 'A'){
                    newChar = (char)(newChar + 26);
                }
                k += 1;
            }else if ((indexedChar <= 'z') && (indexedChar >= 'a')){
                newChar = (char)(indexedChar - keyInt);
                if (newChar < 'a'){
                    newChar = (char)(newChar + 26);
                }
                k += 1;
            }else{
                newChar = indexedChar;
            }
            decryptedM += newChar;
            if (k == keyLength){
                k = 0;
            }
            
        }
        return decryptedM;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Would you like to \"encrypt\" or \"decrypt\" a message?");
        String command = scan.nextLine().trim().toLowerCase();

        if (command.equals("encrypt")) {
            System.out.println("Please enter your message to be encrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter the key for your message: ");
            String key = scan.nextLine().trim().toUpperCase();
            System.out.println("Here is your encrypted message: ");
            System.out.println(encryptVigenere(message, key));
        }
        else if (command.equals("decrypt")) {
            System.out.println("Please enter your message to be decrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter the key for your message: ");
            String key = scan.nextLine().trim().toUpperCase();
            System.out.println("Here is your decrypted message: ");
            System.out.println(decryptVigenere(message, key));
        }
        else {
            System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
        }

        scan.close();
    }
}
