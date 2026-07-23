package co.com.osval.eventhub.Infrastructure.Security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

    public String generateToken(UserDetails userDetails) {
        // Implement your JWT token generation logic here
        return "generated-jwt-token";
    }
    public Boolean validateToken(String token, String email) {
        // Implement your JWT token validation logic here
        return true;
    }
    public String extractEmail(String token) {
        // Implement your JWT token email extraction logiic here
        return "extracted-email-from-token";
    }

}
