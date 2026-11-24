class Twitter {
    class Tweet {
        int tweetId;
        int time;
        Tweet(int tId, int time) {
            this.tweetId = tId;
            this.time = time;
        }
    }
    HashMap<Integer, Set<Integer>> userToFollower;
    HashMap<Integer, List<Tweet>> userToTweet;
    int time;
    public Twitter() {
        time = 0;
        userToFollower = new HashMap<>();
        userToTweet = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if (!userToTweet.containsKey(userId)) {
            List<Tweet> temp = new ArrayList<>();
            temp.add(new Tweet(tweetId, time++));
            userToTweet.put(userId, temp);
        } else {
            List<Tweet> temp = userToTweet.get(userId);
            temp.add(new Tweet(tweetId, time++));
            userToTweet.put(userId, temp);
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.time, a.time));
        // Add own tweets in PQ
        List<Tweet> ownTweets = userToTweet.get(userId);
        if (ownTweets != null) {
            for(int i=0;i<ownTweets.size();i++) {
                pq.add(ownTweets.get(i));
            }
        }
        // Add followers tweets
        if (userToFollower.get(userId) != null) {
            for (Integer followeeId: userToFollower.get(userId)) {
                List<Tweet> followeeTweets = userToTweet.get(followeeId);
                for(int i=0;i<followeeTweets.size();i++) {
                    pq.add(followeeTweets.get(i));
                }
            }
        }
        //Pop out Top 10 tweets for feed
        List<Integer> ans = new ArrayList<>();
        int k = 10;
        while (k > 0 && pq.size() != 0) {
            Tweet tweet = pq.poll();
            ans.add(tweet.tweetId);
            k--;
        }
        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        Set<Integer> temp = new HashSet<Integer>();
        if(!userToFollower.containsKey(followerId)) {
            temp.add(followeeId);
            userToFollower.put(followerId, temp);
        } else {
            temp = userToFollower.get(followerId);
            temp.add(followeeId);
            userToFollower.put(followerId, temp);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (!userToFollower.containsKey(followerId)) {
            return;
        } else {
            Set<Integer> set = userToFollower.get(followerId);
            set.remove(followeeId);
            userToFollower.put(followerId, set);
        }
    }
}
