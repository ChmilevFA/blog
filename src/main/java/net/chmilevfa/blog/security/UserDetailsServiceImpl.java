package net.chmilevfa.blog.security;

import net.chmilevfa.blog.model.User;
import net.chmilevfa.blog.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Optional;

/**
 * Implementation of {@link UserDetailsService} for authentication in Spring Security.
 *
 * @author chmilevfa
 * @since 08.09.18
 */
@Component("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    /** Default role for authenticated users. */
    private static final String DEFAULT_USER_ROLE = "User";

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            return new org.springframework.security.core.userdetails.User(
                    user.getUsername(),
                    user.getPassword(),
                    Collections.singletonList(new SimpleGrantedAuthority(DEFAULT_USER_ROLE))
            );
        }
        throw new UsernameNotFoundException("User with username " + username + " not found");
    }
}
