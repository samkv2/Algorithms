// Implement an algorithm to determine if a string has all unique characters. 
// What if you cannot use additional data structures?
public class isUnique {
    public static boolean isUnique(String str) {

        if (str.length() > 128) {
            return false; 
        }

        boolean[] charSet = new boolean[128]; 

        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i); 
            if (charSet[val]) { 
                return false; // Not unique
            }
            charSet[val] = true; /
        }
        return true; 
    }

    public static void main(String[] args) {
        String testString = "abcdefg";
        System.out.println(isUnique(testString)); // Output: true

        String testString2 = "hello";
        System.out.println(isUnique(testString2)); // Output: false
    }
}
