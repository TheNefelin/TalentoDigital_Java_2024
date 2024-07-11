package cl.praxis.mvc.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CarDTO {
    private int id;
    private String name;
    private String url;
    private int idSuppliers;
}
