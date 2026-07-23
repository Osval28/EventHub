package co.com.osval.eventhub.Application.UseCase;

import co.com.osval.eventhub.Application.DTOs.LoginUserRequestDTO;
import co.com.osval.eventhub.Application.DTOs.UserResponseDTO;
import co.com.osval.eventhub.Application.Service.UserService;
import co.com.osval.eventhub.Domain.Exceptions.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class LoginUserUseCase {
    private UserService userService;

    public UserResponseDTO execute(LoginUserRequestDTO loginUserRequestDTO) {
        UserResponseDTO userResponseDTO = userService.loginUser(loginUserRequestDTO.getEmail(), loginUserRequestDTO.getPassword());
        return userResponseDTO;
    }
}
