package by.b_p.productionmanagementserver.payload.response;

import by.b_p.productionmanagementserver.model.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class JwtResponse {
    private String token;
    private final String type = "Bearer";
    private String username;
    private Department departmentByDepartmentId;
}