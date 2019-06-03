package pl.polsl.bookstore.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="role")
public class Role {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_role")
    private long idRole;

    @Column(name="role")
    private String role;

    @OneToMany(mappedBy="roleU",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Users> users;

    public long getIdRole() {
        return idRole;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


}
