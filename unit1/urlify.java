public class urlify{
    public static void main(String ...args){
    char x[]="Mr John Smith    ".toCharArray();
    urlify(x,13);
    System.out.println(x);
    }
    static void urlify(char[] str, int trueLength) {

    int spaceCount = 0;

    for(int i = 0; i < trueLength; i++)
    {
        if(str[i] == ' ')
            spaceCount++;
    }

    int index = trueLength + spaceCount * 2;

    for(int i = trueLength - 1; i >= 0; i--)
    {
        if(str[i] == ' ')
        {
            str[index - 1] = '0';
            str[index - 2] = '2';
            str[index - 3] = '%';

            index -= 3;
        }
        else
        {
            str[index - 1] = str[i];
            index--;
        }
    }
}
}
