package arrays;

import java.sql.SQLOutput;
import java.util.Arrays;

public class Anagramas {
    public static void main(String[] args) {
        char[] a = {'f','a','l'};
        char[] b = {'l','f','a'};

        System.out.println(solve(a,b));
        System.out.println("Carlos".toCharArray());
    }

    public static boolean solve(char[] a, char[] b){
        if(a.length != b.length) return false;

        //Este é um dos maiores "gargalos" da complexidade do software
        //possui a complexidade O(NLogN)
        Arrays.sort(a);
        Arrays.sort(b);

        for(int i=0;i<a.length;i++){
            if(a[i] != b[i]) return false;
        }

        return true;

    }
}
