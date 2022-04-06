package com.jama.uteq.social.network.converters;

import com.jama.uteq.social.network.constants.Gender;
import com.jama.uteq.social.network.dto.UserDTO;
import com.jama.uteq.social.network.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDtoToUserConverter implements Converter<UserDTO, User> {

    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public User convert(UserDTO userDTO) {
        User.UserBuilder builder = User.builder()
                                       .id(userDTO.getId())
                                       .email(userDTO.getEmail())
                                       .firstName(userDTO.getFirstName())
                                       .lastName(userDTO.getLastName())
                                       .phone(userDTO.getPhone())
                                       .sex(Gender.getGenderByName(userDTO.getSex()))
                                       .image(userDTO.getImage())
                                       .dob(userDTO.getDob()).isProfessor(userDTO.getIsProfessor());

        if (userDTO.getPassword() != null)
            builder.password(passwordEncoder.encode(userDTO.getPassword()));

        builder.isProfessor(userDTO.getIsProfessor());

        System.out.println(builder.build().toString());

        return builder.build();
    }
}
