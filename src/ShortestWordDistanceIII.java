//This is a follow up of Shortest Word Distance. The only difference is now word1 could be the same as word2.
//
//        Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
//
//        word1 and word2 may be the same and they represent two individual words in the list.
//
//        For example, Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
//
//        Given word1 = “makes”, word2 = “coding”, return 1. Given word1 = "makes", word2 = "makes", return 3.
//
//        Note: You may assume word1 and word2 are both in the list.

public class ShortestWordDistanceIII {

    public static int shortestWordDistance(String[] words, String word1, String word2) {
        int index1 = -1;
        int index2 = -1;
        int distance = Integer.MAX_VALUE;
        int turn = 0;
        int inc = (word1.equals(word2) ? 1 : 0);
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(word1) && turn % 2 == 0){
                index1 = i;
                if(index2 != -1) {
                    distance = Math.min(distance, index1 - index2);
                }
                turn += inc;
            } else if(words[i].equals(word2)){
                index2 = i;
                if(index1 != -1){
                    distance = Math.min(distance, index2 - index1);
                }
                turn += inc;
            }
        }
        return distance;
    }

    // unit test
    public static void main(String[] args) {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        System.out.println(shortestWordDistance(words, "makes", "makes")); // 3
    }
}
