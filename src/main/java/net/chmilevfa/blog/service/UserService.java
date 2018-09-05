package net.chmilevfa.blog.service;

import net.chmilevfa.blog.model.User;

import java.util.Optional;

/**
 * TODO description
 *
 * @author chmilevfa
 * @since 05.09.18
 */
public interface UserService {

    /**  */
    Optional<User> findByUsername(String username);

    /**  */
    Optional<User> findByEmail(String email);

    /**  */
    User save(User user);
}
