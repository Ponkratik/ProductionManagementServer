package by.b_p.productionmanagementserver.payload.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class SigninRequest {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}