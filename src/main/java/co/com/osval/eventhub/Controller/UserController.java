package co.com.osval.eventhub.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/api/users")
    public ResponseEntity<?> getUsers(){
        return ResponseEntity.ok("Hello World");
    }
    @PostMapping("/api/users")
    public ResponseEntity<?> createUser(){
        return ResponseEntity.ok("User created");
    }

}
