package net.chmilevfa.blog.service.impl;

import net.chmilevfa.blog.model.User;
import net.chmilevfa.blog.repository.UserRepository;
import net.chmilevfa.blog.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * TODO description
 *
 * @author chmilevfa
 * @since 05.09.18
 */
@Service
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}
