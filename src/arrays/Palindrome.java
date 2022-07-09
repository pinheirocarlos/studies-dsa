package arrays;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(solve(""));
    }

    public static boolean solve(String s){
        if(s.isBlank()) return false;

        int lowest = s.charAt(0);
        int highest = s.charAt(s.length() - 1);

        //Possui tempo de complexidade linear O(N)
        while(lowest < highest){
            if (s.charAt(lowest) != s.charAt(highest)) return false;
            lowest++;
            highest--;
        }
        return true;
    }
}
