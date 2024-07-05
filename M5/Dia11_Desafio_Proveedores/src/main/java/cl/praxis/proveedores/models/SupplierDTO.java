package cl.praxis.proveedores.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SupplierDTO {
    public int id;
    public String name;
    public String rut;
    public String address;
    public String email;
    public int phone;
    public String contact;
    public int contactPhone;
    public boolean isActive;
}
