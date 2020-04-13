package com.leecode.algorithm._355;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近十条推文。你的设计需要支持以下的几个功能：
 *
 *
 * 	postTweet(userId, tweetId): 创建一条新的推文
 * 	getNewsFeed(userId): 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。推文必须按照时间顺序由最近的开始排序。
 * 	follow(followerId, followeeId): 关注一个用户
 * 	unfollow(followerId, followeeId): 取消关注一个用户
 *
 *
 * 示例:
 *
 * Twitter twitter = new Twitter();
 *
 * // 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
 * twitter.postTweet(1, 5);
 *
 * // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
 * twitter.getNewsFeed(1);
 *
 * // 用户1关注了用户2.
 * twitter.follow(1, 2);
 *
 * // 用户2发送了一个新推文 (推文id = 6).
 * twitter.postTweet(2, 6);
 *
 * // 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
 * // 推文id6应当在推文id5之前，因为它是在5之后发送的.
 * twitter.getNewsFeed(1);
 *
 * // 用户1取消关注了用户2.
 * twitter.unfollow(1, 2);
 *
 * // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
 * // 因为用户1已经不再关注用户2.
 * twitter.getNewsFeed(1);
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-twitter
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Twitter {
    Map<Integer, List<Integer>> followMap = new HashMap<>();
    LinkedList<UserTweet> userTweets = new LinkedList<>();

    /** Initialize your data structure here. */
    public Twitter() {}

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        userTweets.addFirst(new UserTweet(userId, tweetId));
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> followIdList = followMap.get(userId);
        if(followIdList == null){
            followIdList = Collections.emptyList();
        }
        List<Integer> tempList = followIdList;
        return userTweets.stream().filter(userTweet ->
                        userTweet.userId == userId || tempList.contains(userTweet.userId)
        ).limit(10).collect(ArrayList::new, (list, userTweet) -> {
            list.add(userTweet.tweetId);
        }, (list, returnList) -> {});
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        List<Integer> followIdList = followMap.get(followerId);
        if(followIdList == null){
            followIdList = new ArrayList<>();
            followMap.put(followerId, followIdList);
            followIdList.add(followeeId);
        }else {
            if(!followIdList.contains(followeeId)){
                followIdList.add(followeeId);
            }
        }
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        List<Integer> followIdList = followMap.get(followerId);
        if(followIdList != null){
            followIdList.remove(Integer.valueOf(followeeId));
        }
    }

    public static void main(String[] args) {
        Twitter t = new Twitter();
        t.postTweet(1, 5);
        System.out.println(t.getNewsFeed(1));
        t.follow(1, 2);
        t.postTweet(2, 6);
        System.out.println(t.getNewsFeed(1));
        t.unfollow(1, 2);
        System.out.println(t.getNewsFeed(1));
    }

}

class UserTweet{
    int userId;
    int tweetId;
    public UserTweet(int userId, int tweetId){
        this.userId=userId;
        this.tweetId=tweetId;
    }
}