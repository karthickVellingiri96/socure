package interview.socure;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        String[] inputs = {
                "Welcome To Java Programming Code",
                "Welcome To Java Programming",
                "b c b a",
                "aaaaa",
                "",
        };
        Solution solution = new Solution();
        for (String input: inputs) {
            System.out.println(solution.sortStringBasedOnLength(input));
        }
    }
    
}