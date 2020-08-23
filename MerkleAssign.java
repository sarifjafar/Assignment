import java.util.*;
import java.io.*;

public class MerkleAssign {
    public static void main(String[] args) {
        List<List<String>> totalPartitions = new ArrayList<>();
        
        //To take input from console, uncomment these two line
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // String s = br.readLine();

        //Comment this line, if you are taking input from console
        String s = "BorrowOrRob";

        //Pass the string to the functions, it will return List<List<String>> 
        // with all the palindromic partitions of the string

        totalPartitions = doPartitions(s);
        
        // Printing the palindromic partitions
        for (List<String> partitions : totalPartitions) {
            StringBuilder word = new StringBuilder();
            for (String p : partitions) {
                word.append(p+" ");
            }
            System.out.println(word.toString());
        }
    }

    // it return List of List of string containing all palindrome partitions.
    private static List<List<String>> doPartitions(String s) {
        List<List<String>> result = new ArrayList<>();

        backtrack(s, 0, new ArrayList<>(), result);

        return result;
    } 

    // It checks if current paritition from start is palindrome or not.
    // If it is a palindrome then, it will add it to the list and again recur for remaining string
    private static void backtrack(String s, int start, List<String> tempList, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i < s.length(); i++) {
                if (isPalindrome(s, start, i)) { // Checking if current partition is Palindrome or not.
                    tempList.add(s.substring(start, i + 1));
                    backtrack(s, i + 1, tempList, result);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }

    // If string is palindrome then return True otherwise False
    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (Character.toLowerCase(s.charAt(left++)) != Character.toLowerCase(s.charAt(right--))) {
                return false;
            }
        }

        return true;
    }
}