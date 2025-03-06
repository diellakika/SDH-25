package encrypt;

public class transponimi {
    public static void main(String[] args) {
        System.out.println(encrypt("Siguria e te dhenave eshte shume e rendesishme. Ne po mesojme shume gjera te reja!", 7));
        System.out.println(decrypt("S hehrsesherieesueh oureg nhmnmpjmajutatedeome areve e. e t!i e es m ge0ad s iNesj 0", 7));
    }

    public static String encrypt(String plainText, int key) {
        int nrRows = (int) Math.ceil((double) plainText.length()/key);

        char[][] matrix = new char[nrRows][key];

        int index = 0;
        for (int i = 0; i<nrRows; i++) {
            for (int j = 0; j<key; j++) {
                if(index<plainText.length()) {
                    matrix[i][j] = plainText.charAt(index++);
                } else {
                    matrix[i][j] = '0';
                }
            }
        }

        StringBuilder encrypted = new StringBuilder();

        for (int j = 0; j<key; j++) {
            for (int i = 0; i<nrRows; i++) {
                encrypted.append(matrix[i][j]);
            }
        }

        return encrypted.toString();
    }

    public static String decrypt(String cipherText, int key) {
        int nrRows = cipherText.length()/key;

        char[][] matrix = new char[nrRows][key];

        int index = 0;
        for (int j = 0; j<key; j++) {
            for (int i = 0; i<nrRows; i++) {
                matrix[i][j] = cipherText.charAt(index++);
            }
        }

        StringBuilder decrypted = new StringBuilder();

        for (int i = 0; i<nrRows; i++) {
            for (int j = 0; j<key; j++) {
                decrypted.append(matrix[i][j]);
            }
        }

        return decrypted.toString().replace("0", "");
    }
}
