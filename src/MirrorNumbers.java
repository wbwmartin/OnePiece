import java.util.HashMap;
import java.util.Map;

//A mirror number is a number that looks the same when rotated 180 degrees (looked at upside down).
//
//        Write a function to determine if a number is mirror. The number is represented as a string.
//
//
//        Example
//        For example, the numbers "69", "88", and "818" are all mirror numbers.
//        Given num = "69" return true
//        Given num = "68" return false

public class MirrorNumbers {

    public static boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap<>();
        map.put('6', '9');
        map.put('9', '6');
        map.put('0', '0');
        map.put('1', '1');
        map.put('8', '8');
        int left = 0, right = num.length() - 1;
        while (left <= right) {
            if (!map.containsKey(num.charAt(left)) || map.get(num.charAt(left)) != num.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isStrobogrammatic("69")); // true
        System.out.println(isStrobogrammatic("68")); // false
    }
}
