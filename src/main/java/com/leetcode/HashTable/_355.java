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
 *ע���пյȲ�����������get,put����ʱ,�����Լ���ע�Լ����Լ�ȡ���Լ��Ĳ���
 *�ܼ��ٲ����ͼ��ٲ���������С���Ѳ���ʱ
 *��Ҫ�������ȼ���������ΪС���ѣ�����ѣ�������ˡ��漰��add poll����������Ѹ�������
 *����ѣ�
 *size=10,[22,...,5]    �����ʱ���ģ��ϵģ�  ʱ��С�ģ��µģ�
 *����һ�����ģ�add X��
 *[X,22,...,5]
 *��Ҫpoll������Զ��������ߵ�
 *��X�������׸�
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

    // ��Ҫ�����ݽṹ��һЩ����
    private static int timeStamp;
    private int feedMaxNum;
    private Map<Integer, Set<Integer>> followees; // �û�ID����ע�����ˣ�Ӧ�ð������Լ���
    private Map<Integer, List<Tweet>> tweets; // �û�ID������������

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
        // ��Ҫ����tweets.put��ע��userId�Ƿ����
        if (!tweets.containsKey(userId)) {
            tweets.put(userId, new LinkedList<>());
            // ��ע�Լ�
            follow(userId, userId);
        }
        // �²�������ģ������б����ǰ��
        tweets.get(userId).add(0, new Tweet(tweetId, timeStamp++));

    }

    // ��ȡ�Լ���ע���˵�ǰ10�������
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> feedheap = new PriorityQueue<>(20,
                new Comparator<Tweet>() {
                    @Override
                    public int compare(Tweet t1, Tweet t2) {
                        return -(t1.timePosted - t2.timePosted);
                    }
                });
        if (followees.get(userId) != null) {
            // ��get������һ��Ҫ�ǵ��п�ORZ
            for (int followeeId : followees.get(userId)) { // �����ҹ�ע���˵��б�
                // �ҹ�ע���˵���������
                List<Tweet> followeeTweets = tweets.get(followeeId);
                // ����Ҳ��,�ҹ�ע����û��������
                if (followeeTweets == null)
                    continue;
                for (Tweet tweet : followeeTweets) {
                    // С���ѻ�û����
                    if (feedheap.size() < feedMaxNum) {
                        feedheap.add(tweet);
                    } else {
                        // ����Ҳ�����Ż���,���ı������е�����Ļ��磬������ˣ�����TLE
                        if (tweet.timePosted > feedheap.peek().timePosted) {
                            feedheap.add(tweet); // С�����Զ�������
                            feedheap.poll();
                        }
                    }
                }

            }
        }
        // ת��LIST
        List<Integer> list = new LinkedList<>();
        while (!feedheap.isEmpty()) {
            list.add(feedheap.poll().tweetId);
        }

        return list;
    }

    // ������ң��ұ�����Ҫ��ע����
    public void follow(int followerId, int followeeId) {
        if (!followees.containsKey(followerId))
            followees.put(followerId, new HashSet<Integer>());
        followees.get(followerId).add(followeeId);
    }

    //�Լ�����ȡ���Լ�������
    public void unfollow(int followerId, int followeeId) {
        if (followees.containsKey(followerId) && followerId != followeeId) {
            followees.get(followerId).remove(followeeId);
        }

    }

}
