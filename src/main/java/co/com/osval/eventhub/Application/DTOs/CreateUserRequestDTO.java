package co.com.osval.eventhub.Application.DTOs;

import lombok.Data;

@Data
public class CreateUserRequestDTO {
    private String name;
    private String email;
    private String password;
}
