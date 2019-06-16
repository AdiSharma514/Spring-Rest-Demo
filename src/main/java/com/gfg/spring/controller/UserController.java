package com.gfg.spring.controller;

import com.gfg.spring.data.UserData;
import com.gfg.spring.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    Map<Long, User> userMap= UserData.userMap;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        List<User> users=new ArrayList<>();
        for(Map.Entry<Long,User> entry:userMap.entrySet()){
            User user=entry.getValue();
            users.add(user);
        }
        return users;
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") Long id){
        if(userMap.containsKey(id)){
            return userMap.get(id);
        }
        return null;
    }

    @PostMapping("/user")
    public Boolean createUser(@RequestBody User user){
        Long id=user.getId();
        if(!userMap.containsKey(id)){
            userMap.put(id,user);
            return true;
        }
        return false;
    }

    @DeleteMapping("/user/{id}")
    public Boolean deleteUser(@PathVariable("id") Long id){
        if(userMap.containsKey(id)){
            userMap.remove(id);
            return true;
        }
        return false;
    }

    @PutMapping("/user")
    public User updateUser(@RequestBody User user){
        Long id=user.getId();
        if(userMap.containsKey(id)){
            userMap.put(id,user);
            return userMap.get(id);
        }
        return null;
    }
}
