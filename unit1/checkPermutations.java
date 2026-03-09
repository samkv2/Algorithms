public class checkPermutations {
    public static void main(String ...args){
    System.out.println("************ Is permutation check by counting characters ********** ");
    String a="abcdefgh";
    String b="ghecbdfa";

    System.out.println(isPermutation(a,b)); // will print true
    }

    static boolean isPermutation(String s1, String s2){
        if(s1.length()!=s2.length()) return false;
        int count[] = new int[128];

        for(char c: s1.toCharArray()){
            count[c]++;
        }
        for(char c: s2.toCharArray()){
            count[c]--;
            if(count[c]<0) return false;

        }

        return true;
    }

}
