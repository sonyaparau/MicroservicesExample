package com.example.microservice.service;


import com.example.microservice.converter.UserConverter;
import com.example.microservice.dto.UserDto;
import com.example.microservice.model.User;
import com.example.microservice.repo.UserRepository;
import com.example.microservice.utils.MessageSender;
import com.example.microservice.utils.Messages;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * TODO
 * */
@Service
@Transactional
@AllArgsConstructor(onConstructor_ = @Autowired)
public class UserService {

//    private final UserRepository userRepository;

//    public void addUser(@NonNull final UserDto userDto) {
//        userRepository.save(UserConverter.convertDtoToEntity(userDto));
//        MessageSender.sendMessage(Messages.USER_ADDED);
//    }
//
//    public void deleteUser(@NonNull final Long id) {
//        Optional<User> user = userRepository.findById(id);
//        if (user.isPresent()) {
//            userRepository.delete(user.get());
//            MessageSender.sendMessage(Messages.USER_DELETED);
//
//        } else {
//            MessageSender.sendMessage(Messages.USER_NOT_DELETED);
//        }
//    }

    public String findUser(@NonNull final Long id) {
        MessageSender.sendMessage(Messages.USER_FOUND);
        return "Hi, " + id;
//        Optional<User> user = userRepository.findById(id);
//        if (user.isPresent()) {
//            MessageSender.sendMessage(Messages.USER_FOUND);
//            return UserConverter.convertEntityToDto(user.get());
//        } else {
//            MessageSender.sendMessage(Messages.USER_NOT_FOUND);
//            return null;
//        }
    }
}
