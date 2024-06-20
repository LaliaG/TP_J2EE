package org.example.tp_j2ee.service;

import org.example.tp_j2ee.exception.NotFoundException;
import org.example.tp_j2ee.exception.UserAlreadyExists;
import org.example.tp_j2ee.exception.WrongPasswordException;
import org.example.tp_j2ee.model.User;
import org.example.tp_j2ee.repository.UserRepository;

public class UserService {
    private UserRepository userRepository = new UserRepository();

    public User signUp(String username, String password){
        User user = new User(username,password);
        User userFound = userRepository.findByUsernamePassword(username, password);
        if(userFound == null){
            return userRepository.add(user);
        }else {
            throw new UserAlreadyExists("User already exist !!!");
        }
    }

    public User signIn(String username, String password){
        User userFound = userRepository.findByUsernamePassword(username, password);
        if(userFound != null){
            if(password.equals(userFound.getPassword())){
                return userFound;
            }else {
                throw new WrongPasswordException("Wrong password");
            }
        }else {
            throw new UserAlreadyExists("User not found");
        }
    }

    public User findById(int id){
        User userFound = userRepository.finfById(id);
        if(userFound != null){
            return userFound;
        }else {
            throw new NotFoundException("User not found !!!");
        }

    }


}
