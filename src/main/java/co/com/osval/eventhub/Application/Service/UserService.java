package co.com.osval.eventhub.Application.Service;

import co.com.osval.eventhub.Application.DTOs.CreateUserRequestDTO;
import co.com.osval.eventhub.Application.DTOs.UserResponseDTO;
import co.com.osval.eventhub.Domain.Models.Role;
import co.com.osval.eventhub.Domain.Models.User;
import co.com.osval.eventhub.Infrastructure.Repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Boolean isUserAlreadyRegistered(CreateUserRequestDTO createUserRequestDTO) {
        return userRepository.existsByEmail(createUserRequestDTO.getEmail());
    }

    public UserResponseDTO registerUser(CreateUserRequestDTO createUserRequestDTO) {
        User user = new User(createUserRequestDTO.getName(), createUserRequestDTO.getEmail(),
                passwordEncoder.encode(createUserRequestDTO.getPassword()), List.of(Role.Attendee));
        User createdUser = userRepository.save(user);
        return new UserResponseDTO(createdUser.getId(), createdUser.getName(), createdUser.getEmail());
    }

    public UserResponseDTO loginUser(String email, String password) {
        User user = userRepository.findByEmail(email).orElse(null);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return new UserResponseDTO(user.getId(), user.getName(), user.getEmail());
        } else {
            return null;
        }
    }


}
