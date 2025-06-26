package com.springsecuritylearning.service.imp;

import com.springsecuritylearning.entity.User;
import com.springsecuritylearning.repository.UserRepository;
import com.springsecuritylearning.service.UserService;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Data
@Setter
@Getter
public class UserServiceImp implements UserService {
    UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Override
    public User createUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
