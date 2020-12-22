package com.leetcode.HashTable;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/*
 *注意判空等操作！！！在get,put方法时,还有自己关注自己，自己取消自己的操作
 *能减少操作就减少操作，比如小根堆插入时
 *主要错误：优先级队列设立为小跟堆，大根堆，我想错了。涉及到add poll方法，大根堆根本不行
 *大根堆：
 *size=10,[22,...,5]    左边是时间大的（老的）  时间小的（新的）
 *新来一条推文，add X后
 *[X,22,...,5]
 *主要poll方法永远弹出最左边的
 *把X弹出，白搞
 *
 *
 * */
public class _355 {

    static class Tweet {
        public int tweetId;
        public int timePosted;

        public Tweet(int tweetId, int timePosted) {
            this.tweetId = tweetId;
            this.timePosted = timePosted;
        }
    }

    // 需要的数据结构和一些变量
    private static int timeStamp;
    private int feedMaxNum;
    private Map<Integer, Set<Integer>> followees; // 用户ID，关注他的人（应该包括他自己）
    private Map<Integer, List<Tweet>> tweets; // 用户ID，他发的推文

    // init data strcture
    public _355() {
        timeStamp = 0;
        feedMaxNum = 10;
        followees = new HashMap<>();
        tweets = new HashMap<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        // 主要就是tweets.put，注意userId是否存在
        if (!tweets.containsKey(userId)) {
            tweets.put(userId, new LinkedList<>());
            // 关注自己
            follow(userId, userId);
        }
        // 新插入的推文，放在列表的最前面
        tweets.get(userId).add(0, new Tweet(tweetId, timeStamp++));

    }

    // 获取自己关注的人的前10早的推文
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> feedheap = new PriorityQueue<>(20,
                new Comparator<Tweet>() {
                    @Override
                    public int compare(Tweet t1, Tweet t2) {
                        return -(t1.timePosted - t2.timePosted);
                    }
                });
        if (followees.get(userId) != null) {
            // 有get操作，一定要记得判空ORZ
            for (int followeeId : followees.get(userId)) { // 遍历我关注的人的列表
                // 我关注的人的所有推文
                List<Tweet> followeeTweets = tweets.get(followeeId);
                // 这里也是,我关注的人没发过推文
                if (followeeTweets == null)
                    continue;
                for (Tweet tweet : followeeTweets) {
                    // 小根堆还没满，
                    if (feedheap.size() < feedMaxNum) {
                        feedheap.add(tweet);
                    } else {
                        // 这里也可以优化下,发的比我已有的最早的还早，别进来了，避免TLE
                        if (tweet.timePosted > feedheap.peek().timePosted) {
                            feedheap.add(tweet); // 小根堆自动排序了
                            feedheap.poll();
                        }
                    }
                }

            }
        }
        // 转成LIST
        List<Integer> list = new LinkedList<>();
        while (!feedheap.isEmpty()) {
            list.add(feedheap.poll().tweetId);
        }

        return list;
    }

    // 左边是我，右边是我要关注的人
    public void follow(int followerId, int followeeId) {
        if (!followees.containsKey(followerId))
            followees.put(followerId, new HashSet<Integer>());
        followees.get(followerId).add(followeeId);
    }

    //自己不能取关自己！！！
    public void unfollow(int followerId, int followeeId) {
        if (followees.containsKey(followerId) && followerId != followeeId) {
            followees.get(followerId).remove(followeeId);
        }

    }

}
