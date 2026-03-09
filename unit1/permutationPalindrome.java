public class permutationPalindrome{
    public static void main(String ...args){
    String s="Tact Coa";
    System.out.println(isAnyPalindromeFound(s));

    }
    static boolean isAnyPalindromeFound(String s){
        int [] table= new int[26];
        for(char c: s.toLowerCase().toCharArray()){
            if(c>='a' && c<='z'){
                int index=c-'a';
                table[index]++;
            }

        }
        int oddCount=0;
        for(int count:table){
            if(count%2==1)
            oddCount++;

        }
        return oddCount<=1;

    }

}
