package com.firsrApi.Api.APP;


import com.firsrApi.Api.APP.Exception.UserNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.PrimitiveIterator;

@Service
public class UsetService {
    private Map<Integer,User> UserDb = new HashMap<>();

    Logger logger = LoggerFactory.getLogger(UsetService.class);

    public User createUser(User user){

        //create logger
        logger.info("creating user");

        System.out.println(user.getEamil());
        UserDb.putIfAbsent(user.getId(), user);
        return user;
    }

    public User updateUser(User user) {
        if(UserDb.containsKey(user.getId()))
            //throw new IllegalAccessError("user with id " + user.getId() + "does not exist");
            throw new UserNotFoundException("user with id " + user.getId() + "does not exist");
        UserDb.put(user.getId(),user);
        return user;
    }

    public boolean deleteUser(int id) {
        if(!UserDb.containsKey(id)){
            return false;
        }
        UserDb.remove(id);
        return true;
    }

    public User getUserById(int id) {
        return UserDb.get(id);
    }
}
