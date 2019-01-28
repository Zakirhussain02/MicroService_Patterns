package com.stackroute.service;

import com.stackroute.domain.User;
import com.stackroute.exceptions.UserAlreadyExistsException;
import com.stackroute.exceptions.UserNotFoundException;

import java.util.List;

public interface UserService {
    public User saveMuzix(User muzix)throws UserAlreadyExistsException;
    public List<User> getAllMuzixs()throws UserNotFoundException;
    public User updateMuzix(int trackId,String comment)throws UserNotFoundException;
    public List<User> removeMuzix(int trackId) throws UserNotFoundException;
    public User trackByTrackId(int trackId) throws UserNotFoundException;
    public List<User> trackByTrackName(String trackName)throws UserNotFoundException;
}
