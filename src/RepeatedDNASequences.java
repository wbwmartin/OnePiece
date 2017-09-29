import java.util.*;

//All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
//
//        Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
//
//        For example,
//
//        Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
//
//        Return:
//        ["AAAAACCCCC", "CCCCCAAAAA"].

public class RepeatedDNASequences {

    public static List<String> findRepeatedDnaSequences(String s) {
        Set<Integer> hash = new HashSet<>();
        Set<String> dna = new HashSet<>();
        for (int i = 9; i < s.length(); i++) {
            String subString = s.substring(i - 9, i + 1);
            int encoded = encode(subString);
            if (hash.contains(encoded)) {
                dna.add(subString);
            } else {
                hash.add(encoded);
            }
        }
        return new ArrayList<>(dna);
    }

    private static int encode(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                sum = sum * 4;
            } else if (s.charAt(i) == 'C') {
                sum = sum * 4 + 1;
            } else if (s.charAt(i) == 'G') {
                sum = sum * 4 + 2;
            } else {
                sum = sum * 4 + 3;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(findRepeatedDnaSequences(s)); // ["AAAAACCCCC", "CCCCCAAAAA"]
    }
}
