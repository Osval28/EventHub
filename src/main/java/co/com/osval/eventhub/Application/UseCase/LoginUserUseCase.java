package co.com.osval.eventhub.Application.UseCase;

import co.com.osval.eventhub.Application.DTOs.UserResponseDTO;
import co.com.osval.eventhub.Application.Service.UserService;
import co.com.osval.eventhub.Domain.Exceptions.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class LoginUserUseCase {
    private UserService userService;

    public UserResponseDTO execute(String email, String password){
        UserResponseDTO userResponseDTO = userService.loginUser(email, password);
        if (userResponseDTO == null){
            throw new UserNotFoundException();
        } else {
            return userResponseDTO;
        }
    }
}
