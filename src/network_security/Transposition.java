package network_security;

public class Transposition {

    public String transposeLevelOne(String normalText) {
        
        char[] transpose = new char[normalText.length()];
        int start = 0, end = normalText.length() - 1;
        for (int i = 0; i < normalText.length(); i++) {
            if (i % 2 == 0) {
                transpose[i] = normalText.charAt(start);
                start++;
            } else {
                transpose[i] = normalText.charAt(end);
                end--;
            }
        }
        return new String(transpose);
    }

    public String untransposeLevelOne(String transposeTxt) {
        char[] untransposeTxt = new char[transposeTxt.length()];

        int start = 0, end = transposeTxt.length() - 1;

        for (int i = 0; i < transposeTxt.length(); i++) {
            if (i % 2 == 0) {
                untransposeTxt[start] = transposeTxt.charAt(i);
                start++;
            } else {
                untransposeTxt[end] = transposeTxt.charAt(i);
                end--;
            }
        }
        return new String(untransposeTxt);
    }

    public String TransposeLevelTwo(int key, String plainText) {
        int rows = (plainText.length() + key - 1) / key;
        char[][] transpositionLookTable = new char[key][rows];
        int col = 0;
        int row = 0;
        for (int i = 0; i < plainText.length(); i++) {
            transpositionLookTable[col][row] = plainText.charAt(i);
            col++;
            if (col == key) {
                col = 0;
                row++;
            }
        }

        String ciphertext = "";
        for (int i = 0; i < key; i++) {
            for (int j = 0; j < transpositionLookTable[i].length; j++) {
                if (transpositionLookTable[i][j] != '\0') {
                    ciphertext += transpositionLookTable[i][j];
                }
            }
        }
        return ciphertext;
    }

    public String unTransposeLevelTwo(int key, String ciphertext) {
        int rows = (ciphertext.length() + key - 1) / key;
        char[][] transpositionLookTable = new char[key][rows];
        int col = 0;
        int row = 0;
        for (int i = 0; i < ciphertext.length(); i++) {
            transpositionLookTable[col][row] = '*';
            col++;
            if (col == key) {
                col = 0;
                row++;
            }
        }
        int index = 0;
        for (col = 0; col < key; col++) {
            for (row = 0; row < rows; row++) {
                if (transpositionLookTable[col][row] == '*') {
                    transpositionLookTable[col][row] = ciphertext.charAt(index);
                    index++;
                }
            }
        }
        String decryptedMessage = "";
        for (row = 0; row < rows; row++) {
            for (col = 0; col < key; col++) {
                decryptedMessage += transpositionLookTable[col][row];
            }
        }
        return decryptedMessage;
    }
}
