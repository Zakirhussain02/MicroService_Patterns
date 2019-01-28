package com.stackroute.service;

import com.stackroute.domain.User;
import com.stackroute.exceptions.UserAlreadyExistsException;
import com.stackroute.exceptions.UserNotFoundException;

import java.util.List;

public interface UserService {
    public User saveUser(User muzix)throws UserAlreadyExistsException;
    public List<User> getAllUsers()throws UserNotFoundException;
    public User updateUser(int userId,String userName)throws UserNotFoundException;
    public List<User> removeUser(int UserId) throws UserNotFoundException;
    public User getByUserId(int UserId) throws UserNotFoundException;
    public Boolean validUserAge(int userId)throws UserNotFoundException;
}
