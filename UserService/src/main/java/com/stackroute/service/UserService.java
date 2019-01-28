package com.stackroute.service;

import com.stackroute.domain.User;
import com.stackroute.exceptions.UserAlreadyExistsException;
import com.stackroute.exceptions.UserNotFoundException;

import java.util.List;

public interface UserService {
    public User saveUser(User muzix)throws UserAlreadyExistsException;
    public List<User> getAllUsers()throws UserNotFoundException;
    public User updateUser(int trackId,String comment)throws UserNotFoundException;
    public List<User> removeUser(int trackId) throws UserNotFoundException;
    public User getByUserId(int trackId) throws UserNotFoundException;
    public List<User> getByUserName(String trackName)throws UserNotFoundException;
}
