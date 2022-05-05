package by.b_p.productionmanagementserver.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "userId")
    private long userId;
    @Basic
    @Column(name = "username")
    private String username;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "fio")
    private String fio;
    @ManyToOne
    @JoinColumn(name = "departmentID", referencedColumnName = "departmentId")
    private Department departmentByDepartmentId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(fio, user.fio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, username, password, fio);
    }
}
