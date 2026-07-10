package co.com.osval.eventhub.Application.DTOs;

import lombok.Data;

import java.util.UUID;
@Data
public class UserResponseDTO {
    private UUID id;
    private String name;
    private String email;

    public UserResponseDTO(UUID id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
