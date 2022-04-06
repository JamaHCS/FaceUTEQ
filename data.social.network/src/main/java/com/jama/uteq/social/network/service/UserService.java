package com.jama.uteq.social.network.service;

import com.jama.uteq.social.network.entities.User;
import com.jama.uteq.social.network.dto.PageDTO;
import com.jama.uteq.social.network.dto.UserDTO;
import org.springframework.data.domain.Pageable;

public interface UserService {

    User getUser(Long id);

    UserDTO getUserById(Long id);

    UserDTO getUserByEmail(String email);

    PageDTO<UserDTO> findAllPageable(Long id, Pageable pageable);

    PageDTO<UserDTO> findAllWithSearch(Long id, String search, Pageable pageable);

    void createUser(UserDTO userDTO);

    void updatePassword(String password, Long id);

    void updateUser(UserDTO userDTO);

    void updateUserImage(UserDTO userDTO, String fileName);

    void makeUserAdmin(Long userId);

    void blockUser(Long userId);
}
