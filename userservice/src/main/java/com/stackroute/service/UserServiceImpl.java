package com.stackroute.service;

import com.stackroute.domain.User;
import com.stackroute.exceptions.UserAlreadyExistsException;
import com.stackroute.exceptions.UserNotFoundException;
import com.stackroute.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public User saveUser(User user) throws UserAlreadyExistsException {
        if(userRepository.existsById(user.getUserId())){
            throw new UserAlreadyExistsException("User already exists");
        }
        User savedUser = userRepository.save(user);
        if(savedUser==null){
            throw new UserAlreadyExistsException("User already exists");
        }
        return savedUser;
    }

    @Override
    public List<User> getAllUsers() throws UserNotFoundException {
        if (userRepository.findAll().isEmpty()) {
            throw new UserNotFoundException("No users available");
        }
        return userRepository.findAll();
    }

    @Override
    public User updateUser(int userId, String userName) throws UserNotFoundException {
        if (userRepository.findById(userId).isEmpty()) {
            throw new UserNotFoundException("User not found to update");
        }
        Optional<User> user = userRepository.findById(userId);
        User user1 = user.get();
        user1.setUserName(userName);
        User savedUser = userRepository.save(user1);
        return savedUser;
    }

    @Override
    public List<User> removeUser(int userId) throws UserNotFoundException {
        if(!userRepository.existsById(userId)){
            throw new UserNotFoundException("User not found");
        }
        userRepository.deleteById(userId);
        return userRepository.findAll();
    }

    @Override
    public User getByUserId(int userId) throws UserNotFoundException {
        if (userRepository.findById(userId).isEmpty()) {
            throw new UserNotFoundException("User not found to update");
        }
        Optional<User> user1 = userRepository.findById(userId);
        User user = user1.get();
        return user;
    }

    @Override
    public Boolean validUserAge(int userId) throws UserNotFoundException {
        if (userRepository.findById(userId).isEmpty()) {
            throw new UserNotFoundException("User not found to update");
        }
        Optional<User> user1 = userRepository.findById(userId);
        User user =user1.get();
        LocalDate today = LocalDate.now();
        Period period = Period.between(user.getUserDOB(), today);
        if (period.getYears()>=18){
            return true;
        }
        else {
            return false;
        }
    }
}
