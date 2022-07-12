package arrays;

import java.util.Arrays;
import java.util.List;

public class ArrayList {
    public static void main(String[] args) {
        System.out.println(reverseArray(Arrays.asList(4,3,2,1)));
    }

    public static List<Integer> reverseArray(List<Integer> a) {
        int lowest = 0;
        int highest = a.size() - 1;
        int temp = 0;

        while(lowest < highest){
            temp = a.get(lowest);
            a.set(lowest, a.get(highest));
            a.set(highest, temp);
            lowest++;
            highest--;
        }
        return a;
    }

}

