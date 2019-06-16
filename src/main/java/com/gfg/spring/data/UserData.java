package com.gfg.spring.data;

import com.gfg.spring.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserData {
    public static Map<Long, User> userMap=new HashMap<>();
    static {
        User user0=new User(0L,"Rod","Johnson");
        User user1=new User(1L,"Bill","Gates");
        User user2=new User(2L,"Sunder","Pichai");
        User user3=new User(3L,"Mukesh","Ambani");
        userMap.put(user0.getId(),user0);
        userMap.put(user1.getId(),user1);
        userMap.put(user2.getId(),user2);
        userMap.put(user3.getId(),user3);
    }
}
