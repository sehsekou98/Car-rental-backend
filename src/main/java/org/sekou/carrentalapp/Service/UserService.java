package org.sekou.carrentalapp.Service;


import org.sekou.carrentalapp.CarModel.User;
import org.sekou.carrentalapp.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(User user) {
        Optional<User> existing = userRepository.findByEmail(user.getEmail());
        if (existing.isPresent()) {
            throw new RuntimeException("Email already exists");
        }
        return userRepository.save(user);
    }
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
