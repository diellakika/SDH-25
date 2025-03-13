package encrypt;
public class OneTimePad {
    public static void main(String[] args) {
        String plaintext="HELLO";
        String celesi="XMCKL";
        String ciphertext="EQNVZ";
        enkriptimi(plaintext,celesi);
        dekriptimi(ciphertext,celesi);
    }
    public static void enkriptimi(String plaintext, String celesi){
        for(int i=0;i<plaintext.length();i++){
            StringBuilder enkriptimi=new StringBuilder();
            enkriptimi.append( (char)((plaintext.charAt(i)-'A'+celesi.charAt(i)-'A')%26+'A'));
            System.out.println(enkriptimi);
        }

    }
    public static void dekriptimi(String ciphertext, String celesi){
        for(int i=0;i<ciphertext.length();i++){
            StringBuilder dekriptimi=new StringBuilder();
            dekriptimi.append( (char)(ciphertext.charAt(i)-celesi.charAt(i))%26+'A');
            System.out.println(dekriptimi);
        }

    }
}
