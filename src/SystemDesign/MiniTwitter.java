package SystemDesign;

import java.util.*;

//      Implement a simple twitter. Support the following method:
//
//        postTweet(user_id, tweet_text). Post a tweet.
//        getTimeline(user_id). Get the given user's most recently 10 tweets posted by himself, order by timestamp from most recent to least recent.
//        getNewsFeed(user_id). Get the given user's most recently 10 tweets in his news feed (posted by his friends and himself). Order by timestamp from most recent to least recent.
//        follow(from_user_id, to_user_id). from_user_id followed to_user_id.
//        unfollow(from_user_id, to_user_id). from_user_id unfollowed to to_user_id.
//        Have you met this question in a real interview? Yes
//        Example
//        postTweet(1, "LintCode is Good!!!")
//        >> 1
//        getNewsFeed(1)
//        >> [1]
//        getTimeline(1)
//        >> [1]
//        follow(2, 1)
//        getNewsFeed(2)
//        >> [1]
//        unfollow(2, 1)
//        getNewsFeed(2)
//        >> []

public class MiniTwitter {

    public static class Tweet {
        public int id;
        public int user_id;
        public String text;

        public static Tweet create(int user_id, String tweet_text) {
            // This will create a new tweet object,
            // and auto fill id

            return new Tweet();
        }
    }

    private class Node implements Comparable<Node> {
        public int order;
        public Tweet tweet;

        public Node(int order, Tweet tweet) {
            this.order = order;
            this.tweet = tweet;
        }

        public int compareTo(Node other) {
            return other.order - this.order;
        }
    }

    private Map<Integer, Set<Integer>> friends;
    private Map<Integer, List<Node>> users_tweets;
    private int order;

    private List<Node> getLastTen(List<Node> temp) {
        int last = Math.min(10, temp.size());
        return temp.subList(temp.size() - last, temp.size());
    }

    private List<Node> getFirstTen(List<Node> temp) {
        int last = Math.min(10, temp.size());
        return temp.subList(0, last);
    }

    public MiniTwitter() {
        // do intialization if necessary
        this.friends = new HashMap<>();
        this.users_tweets = new HashMap<>();
        this.order = 0;
    }

    /*
     * @param user_id: An integer
     * @param tweet_text: a string
     * @return: a tweet
     */
    public Tweet postTweet(int user_id, String tweet_text) {
        // write your code here
        Tweet tweet = Tweet.create(user_id, tweet_text);
        if (!users_tweets.containsKey(user_id)) {
            users_tweets.put(user_id, new ArrayList<>());
        }
        order++;
        users_tweets.get(user_id).add(new Node(order, tweet));
        return tweet;
    }

    /*
     * @param user_id: An integer
     * @return: a list of 10 new feeds recently and sort by timeline
     */
    public List<Tweet> getNewsFeed(int user_id) {
        // write your code here
        List<Node> temp = new ArrayList<>();
        if (users_tweets.containsKey(user_id)) {
            temp.addAll(getLastTen(users_tweets.get(user_id)));
        }
        if (friends.containsKey(user_id)) {
            for (int user : friends.get(user_id)) {
                if (users_tweets.containsKey(user)) {
                    temp.addAll(getLastTen(users_tweets.get(user)));
                }
            }
        }
        Collections.sort(temp);
        List<Tweet> res = new ArrayList<>();
        temp = getFirstTen(temp);
        for (Node node : temp) {
            res.add(node.tweet);
        }
        return res;
    }

    /*
     * @param user_id: An integer
     * @return: a list of 10 new posts recently and sort by timeline
     */
    public List<Tweet> getTimeline(int user_id) {
        // write your code here
        List<Node> temp = new ArrayList<>();
        if (users_tweets.containsKey(user_id)) {
            temp.addAll(getLastTen(users_tweets.get(user_id)));
        }
        Collections.sort(temp);
        List<Tweet> res = new ArrayList<>();
        temp = getFirstTen(temp);
        for (Node node : temp) {
            res.add(node.tweet);
        }
        return res;
    }

    /*
     * @param from_user_id: An integer
     * @param to_user_id: An integer
     * @return: nothing
     */
    public void follow(int from_user_id, int to_user_id) {
        // write your code here
        if (!friends.containsKey(from_user_id)) {
            friends.put(from_user_id, new HashSet<>());
        }
        friends.get(from_user_id).add(to_user_id);
    }

    /*
     * @param from_user_id: An integer
     * @param to_user_id: An integer
     * @return: nothing
     */
    public void unfollow(int from_user_id, int to_user_id) {
        // write your code here
        if (friends.containsKey(from_user_id)) {
            friends.get(from_user_id).remove(to_user_id);
        }
    }
}
