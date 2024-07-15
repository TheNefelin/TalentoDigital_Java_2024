package cl.praxis.mvc.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.management.relation.Role;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
    private int id;
    private String email;
    private String password;
    private String password2;
    private String name;
    private String nick;
    private int weight;
    private Date date_create;
    private Date date_update;
    private AddressDTO address;
    private RolDTO rol;
    private CarDTO car;
    private SupplierDTO supplier;
}
