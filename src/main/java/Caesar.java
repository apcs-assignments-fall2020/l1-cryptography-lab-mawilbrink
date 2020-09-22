import java.util.Scanner;

public class Caesar {
    public static String encryptCaesar(String message) {
        String encryptedM = "";
        int length = message.length();
        char newChar = 'a';

        for(int i =0; i < length; i++){
            char indexedChar = message.charAt(i);
            if ((indexedChar < 'X' && indexedChar >= 'A')||(indexedChar < 'x' && indexedChar >= 'a')){
                newChar = (char)(indexedChar + 3);
            }else if ((indexedChar <= 'Z' && indexedChar >= 'X')||(indexedChar <= 'z' && indexedChar >= 'x')){
                newChar = (char)(indexedChar - 23);
            }else{
                newChar = indexedChar;
            }

            encryptedM += newChar;
            
        }
        
        return encryptedM;
    }

    public static String decryptCaesar(String message) {
        String decryptedM = "";
        int length = message.length();
        char newChar = 'a';

        for(int i =0; i < length; i++){
            char indexedChar = message.charAt(i);
            if ((indexedChar <= 'Z' && indexedChar >= 'D')||(indexedChar <= 'z' && indexedChar >= 'd')){
                newChar = (char)(indexedChar - 3);
            }else if ((indexedChar <= 'C' && indexedChar >= 'A')||(indexedChar <= 'c' && indexedChar >= 'a')){
                newChar = (char)(indexedChar + 23);
            }else{
                newChar = indexedChar;
            }

            decryptedM += newChar;
            
        }
        
        return decryptedM;
    }

    public static String encryptCaesarKey(String message, int key) {
        String encryptedM = "";
        int length = message.length();
        char newChar = 'a';

        for(int i=0; i<length; i++){
           char indexedChar = message.charAt(i); 
           int charNum = indexedChar;
           
           if(indexedChar <= 'Z' && indexedChar >= 'A'){
            charNum = (charNum + key);
            newChar = (char)(((charNum-65)%26)+65);
           }else if(indexedChar <= 'z' && indexedChar >= 'a'){
            charNum = (charNum + key);
            newChar = (char)(((charNum-97)%26)+97);
           }else{
            newChar = indexedChar;
           }
           encryptedM += newChar;
           

        }

        return encryptedM;
    
    }

    public static String decryptCaesarKey(String message, int key) {
        String decryptedM = "";
        int length = message.length();
        char newChar = 'a';

        for(int i=0; i<length; i++){
           char indexedChar = message.charAt(i); 
           int charNum = indexedChar;
           
           if(indexedChar <= 'Z' && indexedChar >= 'A'){
            charNum = (charNum - (key));
            newChar = (char)(((charNum-65)%26)+65);
           }else if(indexedChar <= 'z' && indexedChar >= 'a'){
            charNum = (charNum - (key));
            newChar = (char)(((charNum-97)%26)+97);
           }else{
            newChar = indexedChar;
           }
           decryptedM += newChar;
           // the math in this method isnt working - xyz arent translating properly 

        }

        return decryptedM;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println(decryptCaesarKey("cheud audbv",3));
        System.out.println("Would you like to \"encrypt\" or \"decrypt\" a message?");
        String command = scan.nextLine().trim().toLowerCase();

        if (command.equals("encrypt")) {
            System.out.println("Please enter your message to be encrypted: ");
            String message = scan.nextLine();
            System.out.println("Here is your encrypted message: ");
            System.out.println(encryptCaesar(message));
        }
        else if (command.equals("decrypt")) {
            System.out.println("Please enter your message to be decrypted: ");
            String message = scan.nextLine();
            System.out.println("Here is your decrypted message: ");
            System.out.println(decryptCaesar(message));
        }
        else {
            System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
        }

        scan.close();
    }
}
