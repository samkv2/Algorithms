public class StringRotation {

    public static void main(String[] args)
    {
        String s1 = "waterbottle";
        String s2 = "erbottlewat";

        System.out.println(isRotation(s1,s2));
    }

    static boolean isRotation(String s1,String s2)
    {
        if(s1.length() != s2.length() || s1.length()==0)
            return false;

        String combined = s1 + s1;

        return combined.contains(s2);
    }
}
