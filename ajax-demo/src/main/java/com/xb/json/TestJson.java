package com.xb.json;

import com.alibaba.fastjson.JSON;

public class TestJson {
    public static void main(String[] args) {
        String[] hobbies = {"宝箱","摩拉","好吃的"};
        //创建user对象
        User user = new User("派蒙", 17, hobbies);
        //将user对象转成json字符串
        String jsonString = JSON.toJSONString(user);
        System.out.println(jsonString);
        //将json字符串转成user对象
        User user1 = JSON.parseObject(jsonString, User.class);
        System.out.println(user1);
    }
}
