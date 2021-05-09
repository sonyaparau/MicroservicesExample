package com.example.microservice.converter;

import com.example.microservice.dto.UserDto;
import com.example.microservice.model.User;
import lombok.NonNull;
import lombok.experimental.UtilityClass;

/**
 * TODO
 * */
@UtilityClass
public class UserConverter {

    public static User convertDtoToEntity(@NonNull final UserDto userDto) {
        return User.builder()
//                .firstName(userDto.getFirstName())
//                .lastName(userDto.getLastName())
                .build();
    }

    public static UserDto convertEntityToDto(@NonNull final User user) {
        return UserDto.builder()
//                .firstName(user.getFirstName())
//                .lastName(user.getLastName())
                .build();
    }
}
