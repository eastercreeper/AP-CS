import java.lang.reflect.Array;

public class truthTables {
    public static String dec2binString(int dec, int minLength) {
        String binary = "";
        int[] shennanagins = new int[999999999];
        int i = 0;
        while(dec > 0) {
            shennanagins[i] = dec % 2;
            dec /= 2;
                i++;
        }
            for(int j = 0; j <=i ; j++) {
                binary = shennanagins[j] + binary;
            }
            while(binary.length() < minLength) {
                binary = 0 + binary;
            }
        
        return binary;
    }

    public static int bin2dec(String bin) {
            int[] shennanagins = new int[bin.length()];
            for(int i = 0; i < bin.length(); i++) {
                shennanagins[i] = Integer.parseInt(String.valueOf(bin.charAt(bin.length() - 1 - i)));
            }
            int dec = 0;
            for(int i = 0; i < shennanagins.length; i++) {
                dec += shennanagins[i] * Math.pow(2, i);
            }
            return dec;
    }

    public static void main(String[] args) {
        String binary = dec2binString(10, 8);
        System.out.println(binary); // Output: 10001
        int dec = bin2dec("000001010");
        System.out.println(dec); // Output: 106
    }
}
