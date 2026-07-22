package co.com.osval.eventhub.Infrastructure.Security;

import lombok.Value;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.security.Keys;
@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expiration}")
    private Long jwtExpiration;

}
