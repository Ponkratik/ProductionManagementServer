package by.b_p.productionmanagementserver.payload.request;

import by.b_p.productionmanagementserver.model.Department;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class SignupRequest {
    @NotBlank
    @Size(min = 3, max = 255)
    private String username;
    @NotBlank
    @Size(min = 3, max = 255)
    private String password;
    @NotBlank
    @Size(min = 3, max = 255)
    private String fio;
    @NotBlank
    private Department departmentByDepartmentId;
}