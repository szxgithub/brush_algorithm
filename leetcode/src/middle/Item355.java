package middle;

import java.util.*;

public class Item355 {



}

class Twitter{

    private class Tweet{
        // 推文id
        private int id;
        // 发文时间
        private int time;
        private Tweet next;

        public Tweet(int id, int time){
            this.id = id;
            this.time = time;
        }
    }

    private class User{
        private int id;
        private Set<Integer> followed;
        private Tweet head;

        public User(int userId){
            followed = new HashSet<>();
            this.id = userId;
            this.head = null;

        }

        public void follow(int userId){
            followed.add(userId);
        }

        public void unfollow(int userId){
            if (userId != this.id){
                followed.remove(userId);
            }
        }

        // 每发布一条推文，形成的链表是从头结点插入的
        public void post(int tweetId){
            Tweet tweet = new Tweet(tweetId, timestamp);
            timestamp++;
            tweet.next = head;
            head = tweet;
        }

    }

    private int timestamp = 0;
    // userId 与 User对象映射
    private HashMap<Integer,User> userMap;

    public Twitter(){
        this.userMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId){
        if (!userMap.containsKey(userId)){
            userMap.put(userId,new User(userId));
        }
        User user = userMap.get(userId);
        user.post(tweetId);
    }

    /*
    检索当前用户新闻推送中最近10条推文的id，包含用户自己的推文以及其关注的人的推文，
    推文按时间顺序由近到远
     */
    public List<Integer> getNewsFeed(int userId){
        List<Integer> res = new ArrayList<>();
        if (!userMap.containsKey(userId)){
            return res;
        }
        User user = userMap.get(userId);
        Set<Integer> followed = user.followed;
        // 按时间最新顺序进行排列
        // 初始容量大小为关注的用户数量加上自己
        PriorityQueue<Tweet> pq = new PriorityQueue<>(followed.size() + 1,(a, b) -> b.time - a.time);

        for (Integer followId : followed){
            // 每一个用户发表的推文都是链表结构
            Tweet tweet = userMap.get(followId).head;
            if (tweet == null){
                continue;
            }
            pq.add(tweet);
        }

        if (user.head != null){
            pq.add(user.head);
        }

        while (!pq.isEmpty()){
            if (res.size() == 10){
                break;
            }
            Tweet poll = pq.poll();
            res.add(poll.id);
            if (poll.next != null){
                pq.add(poll.next);
            }
        }

        return res;

    }

    public void follow(int followerId, int followeeId){
        if (!userMap.containsKey(followerId)){
            userMap.put(followerId,new User(followerId));
        }
        if (!userMap.containsKey(followeeId)){
            userMap.put(followeeId,new User(followeeId));
        }
        userMap.get(followerId).follow(followeeId);
    }

    public void unfollow(int followerId, int followeeId){
        if (userMap.containsKey(followerId)){
            User follower = userMap.get(followerId);
            follower.unfollow(followeeId);
        }
    }
}