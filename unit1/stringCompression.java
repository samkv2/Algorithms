public class stringCompression{
    public static void main(String ...args){
        String str="aabccccaaa";
        System.out.println(compress(str));
    }

    static String compress(String str){
        StringBuilder compressed= new StringBuilder();
        int count=0;
        for(int i=0;i<str.length();i++){
            count++;
            if(i+1>=str.length()||str.charAt(i)!=str.charAt(i+1)){
                compressed.append(str.charAt(i));
                compressed.append(count);
                count=0;
            }
        }
        if(compressed.length()>=str.length())
         return str;

        return compressed.toString();


    }


}
