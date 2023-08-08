package com.woromedia.api.task.service.impl;

import com.woromedia.api.task.entity.Role;
import com.woromedia.api.task.entity.User;
import com.woromedia.api.task.payload.SignUpDTO;
import com.woromedia.api.task.repository.RoleRepository;
import com.woromedia.api.task.repository.UserRepository;
import com.woromedia.api.task.service.UserService;
import com.woromedia.api.task.utils.TableConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void saveUser(SignUpDTO signUpDTO) {
        Role role = roleRepository.findByName(TableConstants.ADMIN);

        if (role == null) {
            role = new Role(TableConstants.ADMIN);
            roleRepository.save(role);
        }

        // Create a new HashSet and add the role to it
        Set<Role> roles = new HashSet<>();
        roles.add(role);

        User user = new User(signUpDTO.getUsername(), signUpDTO.getEmail(),
                passwordEncoder.encode(signUpDTO.getPassword()),
                roles);

        userRepository.save(user);
    }


    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}