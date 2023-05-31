package network_security;

public class Substitution {

    public String substitutionLevelOne(String normalText) {
        String encryption = "";
        for (int i = 0; i < normalText.length(); i++) {
            int letter1 = (normalText.charAt(i));
            if (letter1 % 2 == 0) {
                char letter = (char) (letter1 + 5);
                encryption += (letter);
            } else {
                char letter = (char) (letter1 - 5);
                encryption += (letter);
            }
        }
        return encryption;
    }

    public String unsubstitutionLevelOne(String cipherText) {
        String decryption = "";
        for (int i = 0; i < cipherText.length(); i++) {
            int letter1 = (cipherText.charAt(i));

            if (letter1 % 2 == 0) {
                char letter = (char) (letter1 + 5);
                decryption += (letter);
            } else {
                char letter = (char) (letter1 - 5);
                decryption += (letter);
            }
        }
        return decryption;
    }

    public String substitutionLevelTwo(String normalText) {
        String encryption = "";
        for (int i = 0; i < normalText.length(); i++) {
            char c = (char) (normalText.charAt(i) + 10);
            encryption += c;
        }
        return encryption;
    }

    public String unsubstitutionLevelTwo(String cipherText) {
        String decryption = "";
        for (int i = 0; i < cipherText.length(); i++) {
            char c = (char) (cipherText.charAt(i) - 10);
            decryption += (c);
        }
        return decryption;
    }
}
