
import java.util.*;

public class StringQuestion {

    // -------------------------Ques1-------------------------------------------
    // public static void main(String[] args) {
    //     try (Scanner sc = new Scanner(System.in)) {
    //         String s = sc.nextLine();
    //         String s1 = "";
    //         String word = "";
    //         for (int i = 0; i < s.length(); i++) {
    //             if (s.charAt(i) == ' ') {
    //                 word = word.substring(0, 1).toUpperCase() + word.substring(1);
    //                 s1 += word + " ";
    //                 word = "";
    //             } else {
    //                 word = word + s.charAt(i);
    //             }
    //         }
    //         word = word.substring(0, 1).toUpperCase() + word.substring(1);
    //         s1 += word;
    //         System.out.println(s1);
    //     }
    // }


    //----------------------------Ques2--------------------------------------------
    // public static void main(String[] args) {
    //     try (Scanner sc = new Scanner(System.in)) {
    //         String s = sc.nextLine();
    //         StringBuilder word = new StringBuilder("");
    //         String s1="";
    //         for(int i=0;i<s.length();i++)
    //         {
    //             if(s.charAt(i)==' ')
    //             {
    //                 char ch1=word.charAt(0);
    //                 char ch2=word.charAt(word.length()-1);
    //                 word.setCharAt(0, ch2);
    //                 word.setCharAt(word.length()-1, ch1);
    //                 s1+=word+" ";
    //                 word.setLength(0);
    //             }
    //             else{
    //                 word.append(s.charAt(i));
    //             }
    //         }
    //         char ch1 = word.charAt(0);
    //         char ch2 = word.charAt(word.length() - 1);
    //         word.setCharAt(0, ch2);
    //         word.setCharAt(word.length() - 1, ch1);
    //         s1 += word + " ";
    //         System.out.println(s1);
    //     }
    // }

    //-------------------------Ques3-----------------------
    // public static void main(String[] args) {
    //     try (Scanner sc = new Scanner(System.in)) {
    //         String s = sc.nextLine();
    //         String s1 = "";
    //         String word = "";
    //         for (int i = 0; i < s.length(); i++) {
    //             if (s.charAt(i) == ' ') {
    //                 int isPal = 1;
    //                 int left = 0;
    //                 int right = word.length() - 1;
    //                 word = word.toLowerCase();
    //                 while (left <= right) {
    //                     if (word.charAt(left) != word.charAt(right)) {
    //                         isPal = 0;
    //                         break;
    //                     }
    //                     left++;
    //                     right--;
    //                 }
    //                 if (isPal == 1) {
    //                     s1 += word + " ";
    //                 }
    //                 word = "";
    //             } else {
    //                 word += s.charAt(i);
    //             }
    //         }
    //         int isPal = 1;
    //         int left = 0;
    //         int right = word.length() - 1;
    //         word = word.toLowerCase();
    //         while (left <= right) {
    //             if (word.charAt(left) != word.charAt(right)) {
    //                 isPal = 0;
    //                 break;
    //             }
    //             left++;
    //             right--;
    //         }
    //         if (isPal == 1) {
    //             s1 += word + " ";
    //         }

    //         System.out.println(s1);
    //     }
    // }
}
