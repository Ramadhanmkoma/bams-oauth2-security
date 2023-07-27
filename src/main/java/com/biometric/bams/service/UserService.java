package com.biometric.bams.service;

import com.biometric.bams.enumeration.UserRole;
import com.biometric.bams.model.Role;
import com.biometric.bams.model.User;
import com.biometric.bams.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public User createUser(User user) {
        // Encode the password before saving it to the database
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        // Update other user details here as needed
        return userRepository.save(user);
    }

    public Collection<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) { return userRepository.findById(id); }

    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("In the user details service");
        if (!username.equals("Anonymous")) throw new UsernameNotFoundException("Not Anonymous");

        Set<Role> roles = new HashSet<>();
        roles.add(new Role(1L, UserRole.ROLE_ADMIN, "READ:STUDENTS"));
        return new User(1L, "Anonymous", "Hacker", "Anonymous", "anonymous@admin.com", passwordEncoder.encode("password"), "https://cdn-icons-png.flaticon.com/512/149/149071.png", roles);
    }
}
