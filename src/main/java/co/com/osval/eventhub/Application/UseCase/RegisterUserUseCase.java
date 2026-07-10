package co.com.osval.eventhub.Application.UseCase;

import co.com.osval.eventhub.Application.DTOs.CreateUserRequestDTO;
import co.com.osval.eventhub.Application.DTOs.UserResponseDTO;
import co.com.osval.eventhub.Application.Service.UserService;
import co.com.osval.eventhub.Domain.Exceptions.UserAlreadyExistsException;
import org.springframework.stereotype.Component;

@Component
public class RegisterUserUseCase {
    private final UserService userService;
    public RegisterUserUseCase(UserService userService) {
        this.userService = userService;
    }

    public UserResponseDTO execute(CreateUserRequestDTO createUserRequestDTO) {
        //Lógica de validación de datos
        if (userService.isUserAlreadyRegistered(createUserRequestDTO)){
            throw new UserAlreadyExistsException();
        } else {
            return userService.registerUser(createUserRequestDTO);
        }
    }

}
