import java.util.StringTokenizer;

public class StringTokenizerQues {
    
    public static void main(String[] args) {
        StringTokenizer str=new StringTokenizer("hello:i am:good",":",true);
        System.out.println(str.countTokens());
        while(str.hasMoreTokens()){
            System.out.println(str.nextToken());
        }

    }
}
