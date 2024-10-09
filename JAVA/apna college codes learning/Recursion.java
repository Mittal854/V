// class Recursion{

//     public static int towerOfHanoi(int n,String src,String help,String dest)
//     {
//         if(n==1)
//         {
//             System.out.println("The disk no. "+n+" is transfered from "+src+" to "+dest);
//             return 1;
//         }
//         int count=0;
//         count+=towerOfHanoi(n-1, src, dest, help);
//         System.out.println("The disk no. " + n + " is transfered from " + src + " to " + dest);
//         count++;
//         count+=towerOfHanoi(n-1, help, src, dest);
//         return count;
//     }

//     public static void main(String args[])
//     {
//         Scanner sc=new Scanner(System.in);
//         int n=sc.nextInt();
//         int ans=towerOfHanoi(n,"S","H", "D");  // tc--O(2^n)
//         System.out.println(ans);
//         sc.close();
//     }
// }

//Reverse of String
// class Recursion{

//     public static void reverseString(String s,int n)
//     {
//         if(n==0)
//         {
//             return;
//         }
//         System.out.print(s.charAt(n-1));
//         reverseString(s, n-1);

//     }
//     public static void main(String args[])
//     {
//         Scanner sc=new Scanner(System.in);
//         String s=sc.nextLine();
//         reverseString(s, s.length());  //tc--O(n)
//         sc.close();
//     }
// }

//First & Last Occurenece
// class Recursion {

//     public static int first = -1;
//     public static int last = -1;

//     public static void occurenceOfElement(String s, char a, int i) {
//         if (i == s.length()) {
//             System.out.println("The first index is: "+first);
//             System.out.println("The last index is: "+last);
//             return;
//         }

//         if (s.charAt(i) == a) {
//             if (first == -1) {
//                 first = i;
//             } else {
//                 last = i;
//             }
//         }
//         occurenceOfElement(s, a, i + 1);

//     }

//     public static void main(String args[]) {
//         Scanner sc=new Scanner(System.in);
//         String str=sc.nextLine();
//         char a=sc.next().charAt(0);
//         occurenceOfElement(str,a,0);
//         sc.close();
//     }
// }

//Sorted Array
// class Recursion{
//     public static boolean isSorted(int arr[],int n)
//     {
//         if(n==arr.length-1)
//         {
//             return true;
//         }
//         if(arr[n]<arr[n+1])
//         {
//             return isSorted(arr, n+1);
//         }
//         else{
//             return false;
//         }
//     }
//     public static void main(String args[])
//     {
//         Scanner sc=new Scanner(System.in);
//         int n=sc.nextInt();
//         int arr[]=new int[n];
//         for(int i=0;i<n;i++)
//         {
//             arr[i]=sc.nextInt();
//         }
//         boolean sorted=isSorted(arr, 0);
//         if(sorted)
//         {
//             System.out.println("The array is strictly sorted");
//         }
//         else
//         {
//             System.out.println("The array is not sorted");
//         }
//         sc.close();
//     }
// }

//Remove duplicates
// class Recursion{
//     public static boolean[] alpha=new boolean[26];
//     public static void removeDuplicates(String s,int i,String newS)
//     {
//         if(i==s.length())
//         {
//             System.out.println(newS);
//             return;
//         }
//         char a=s.charAt(i);
//         if(alpha[a-'a'])
//         {
//             removeDuplicates(s, i+1, newS);
//         }
//         else{
//             newS+=a;
//             alpha[a-'a']=true;
//             removeDuplicates(s, i+1, newS);
//         }

//     }
//     public static void main(String[] args)
//     {
//         Scanner sc=new Scanner(System.in);
//         String s=sc.nextLine();
//         String newS="";
//         removeDuplicates(s, 0, newS);
//         sc.close();
//     }
// }

//SubStrings
// class Recursion{
//     public static void subStrings(String s,int i,String sub)
//     {
//         if(i==s.length())
//         {
//             System.out.println(sub);
//             return;
//         }
//         subStrings(s, i+1, sub+s.charAt(i));
//         subStrings(s, i+1, sub);
//     }
//     public static void main(String[] args)
//     {
//         Scanner sc=new Scanner(System.in);
//         String s=sc.nextLine();
//         subStrings(s, 0, "");
//         sc.close();
//     }
// }

//Keypad Problem
// class Recursion {
//     public static String[] keypad = { " ", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "xw", "yz" };

//     public static void printComb(String s, int i, String comb) {
//         if (i == s.length()) {
//             System.out.println(comb);
//             return;
//         }
//         char pos = s.charAt(i);
//         String mapping = keypad[pos - '0'];
//         for (int j = 0; j < mapping.length(); j++) {
//             printComb(s, i + 1, comb + mapping.charAt(j));
//         }

//     }
//     public static void main(String[] args)
//     {
//         Scanner sc=new Scanner(System.in);
//         String s=sc.nextLine();
//         printComb(s, 0, "");
//         sc.close();
//     }

// }

//Permutation of String
// import java.util.*;

// class Recursion {
//     public static void printPermutation(String s, String perm) {   //tc -- 0(n!)

//         if (s.length() == 0) {
//             System.out.println(perm);
//             return;
//         }
//         for (int i = 0; i < s.length(); i++) {
//             String newS = s.substring(0, i) + s.substring(i + 1);
//             printPermutation(newS, perm + s.charAt(i));
//         }

//     }

//     public static void main(String[] args) {
//         try (Scanner sc = new Scanner(System.in)) {
//             String s = sc.nextLine();
//             printPermutation(s, "");
//         }
//     }
// }

//Total paths in a maze
// import java.util.Scanner;
// class Recursion {

//     public static void pathMaze(int i, int j, int m, int n, String path) {
//         if (i == m || j == n) {
//             return;
//         }
//         if (i == m - 1 && j == n - 1) {
//             System.out.println(path);
//             return;
//         }
//         pathMaze(i + 1, j, m, n, path + "D");
//         pathMaze(i, j + 1, m, n, path + "R");

//     }

//     public static void main(String[] args) {
//         try (Scanner sc = new Scanner(System.in)) {
//             int m = sc.nextInt();
//             int n = sc.nextInt();
//             pathMaze(0, 0, m, n, "");
//             // System.out.println(totalPath);
//         }
//     }
// }

//Tiles placement
// import java.util.*;
// class Recursion{
//     public static int placeTiles(int n,int m)
//     {
//         if(n==m){
//             return 2;
//         }
//         if(n<m)
//         {
//             return 1;
//         }
//         int vertical=placeTiles(n-m, m);
//         int horizontal=placeTiles(n-1, m);

//         return vertical+horizontal;
//     }
//     public static void main(String[] args)
//     {
//         Scanner sc=new Scanner(System.in);
//         int n=sc.nextInt();
//         int m=sc.nextInt();
//         int ways=placeTiles(n, m);
//         System.out.println(ways);
//         sc.close();
//     }
// }

//Inviting people
// import java.util.*;

// class Recursion {
//     public static int peopleInvitation(int n) {
//         if (n <= 1) {
//             return 1;
//         }
//         int single = peopleInvitation(n - 1);
//         int pair = (n - 1) * peopleInvitation(n - 2);

//         return single + pair;
//     }

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int ways = peopleInvitation(n);
//         System.out.println(ways);
//         sc.close();

//     }
// }

//Subsets
// import java.util.*;

// class Recursion {

//     public static void printSubSet(ArrayList<Integer> subset) {
//         for (int i = 0; i < subset.size(); i++) {
//             System.out.print(subset.get(i) + " ");
//         }
//         System.out.println();
//     }

//     public static void subSets(int n, ArrayList<Integer> subset) { // tc--0(2^n)

//         if (n == 0) {
//             printSubSet(subset);
//             return;
//         }

//         subset.add(n);
//         subSets(n - 1, subset);

//         subset.remove(subset.size() - 1);
//         subSets(n - 1, subset);
//     }

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         ArrayList<Integer> subset = new ArrayList<>();
//         int n = sc.nextInt();
//         subSets(n, subset);
//         sc.close();
//     }

// }