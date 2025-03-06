package encrypt;

import java.util.Arrays;

public class columnarTransposition {
    public static void main(String[] args) {
        System.out.println(encrypt("enkriptoketemesazh", "sigurte"));
    }

    public static String encrypt(String plainText, String key) {
        int nrRows = (int) Math.ceil((double) plainText.length()/key.length());

        char[][] matrix = new char[nrRows][key.length()];

        int index = 0;
        for (int i = 0; i<nrRows; i++) {
            for (int j = 0; j<key.length(); j++) {
                if(index<plainText.length()) {
                    matrix[i][j] = plainText.charAt(index++);
                } else {
                    matrix[i][j] = '0';
                }
            }
        }

        StringBuilder encrypted = new StringBuilder();
        int[] order = order(key);
        for (int kolona : order) {
            for (int i = 0; i<nrRows; i++) {
                encrypted.append(matrix[i][kolona]);
            }
        }
        return encrypted.toString();

    }

    public static int[] order(String key) {
        int[] order = new int[key.length()];
        char[] chars = key.toCharArray();
        Arrays.sort(chars);

        for (int i = 0; i<chars.length; i++) {
            order[i] = key.indexOf(chars[i]);
        }
        return order;
    }

}
