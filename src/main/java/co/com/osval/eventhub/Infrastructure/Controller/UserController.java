package co.com.osval.eventhub.Infrastructure.Controller;

import co.com.osval.eventhub.Application.DTOs.CreateUserRequestDTO;
import co.com.osval.eventhub.Application.DTOs.LoginUserRequestDTO;
import co.com.osval.eventhub.Application.UseCase.LoginUserUseCase;
import co.com.osval.eventhub.Application.UseCase.RegisterUserUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {

    private RegisterUserUseCase registerUserUseCase;
    private LoginUserUseCase  loginUserUseCase;

    @PostMapping("/api/users")
    public ResponseEntity<?> createUser(@RequestBody CreateUserRequestDTO createUserRequestDTO){
        var userResponse = registerUserUseCase.execute(createUserRequestDTO);
        return ResponseEntity.ok(userResponse);
    }

    @PostMapping("/api/auth/login")
    public ResponseEntity<?> login(@RequestBody LoginUserRequestDTO loginUserRequestDTO){
        var userResponse = loginUserUseCase.execute(loginUserRequestDTO);
        return ResponseEntity.ok(userResponse);
    }

    @GetMapping("/api/users")
    public ResponseEntity<?> getUsers(){
        return ResponseEntity.ok("Hello World");
    }
}
