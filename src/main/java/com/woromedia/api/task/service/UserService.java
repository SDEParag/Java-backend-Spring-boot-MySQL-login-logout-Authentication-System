package com.woromedia.api.task.service;

import com.woromedia.api.task.entity.User;
import com.woromedia.api.task.payload.SignUpDTO;

public interface UserService {
    void saveUser(SignUpDTO signUpDTO);

    User findUserByEmail(String email);


}
