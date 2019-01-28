/**
 * Controller to control the User Application
 */
package com.stackroute.controller;

import com.stackroute.domain.User;
import com.stackroute.exceptions.UserAlreadyExistsException;
import com.stackroute.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@RestController
@RequestMapping(value="api/v1")
@Api(value="onlinestore", description="Operations pertaining to products in Online Store")
public class UserController extends ResponseEntityExceptionHandler {

    //A variable of type UserService
    UserService userService;

    //Autowired constructor
    @Autowired
    public UserController(UserService userService) {
        this.userService = UserService;
    }


    //Method to perform POST operation
    @PostMapping("User")
    public ResponseEntity<?> saveUser(@RequestBody User User) throws UserAlreadyExistsException{
        userService.saveUser(User);
        return new ResponseEntity<String>("Successfully Created", HttpStatus.CREATED);
    }

    //Method to perform GET operation
    @GetMapping("User")
    public ResponseEntity<?> getAllUsers() throws UserNotFoundException {
        return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);
    }

    //Method to perform PUT operation
    @PutMapping("User/{trackId}")
    public ResponseEntity<?> updateUser(@PathVariable int userId,@RequestBody User User) throws UserNotFoundException{
        userService.updateUser(trackId,User.getComment());
        return new ResponseEntity<String>("Successfully updated", HttpStatus.FOUND);
    }

    //Method to perform DELETE operation
    @DeleteMapping("User/{trackId}")
    public ResponseEntity<?> deleteUser(@PathVariable int userId) throws UserNotFoundException{
        userService.removeUser(userId);
        return new ResponseEntity<String>("Successfully Deleted", HttpStatus.ACCEPTED);
    }

    @GetMapping("User/{trackId}")
    public ResponseEntity<?> getById(@PathVariable int UserId) throws UserNotFoundException {
        return new ResponseEntity (userService.trackByTrackId(userId), HttpStatus.OK);
    }
    //Mehtod to track by name
    @GetMapping("Users/{trackName}")
    public ResponseEntity<?> getByName(@PathVariable String trackName) throws UserNotFoundException {
        return new ResponseEntity<List<User>>(userService.trackByTrackName(userName), HttpStatus.OK);
    }
}