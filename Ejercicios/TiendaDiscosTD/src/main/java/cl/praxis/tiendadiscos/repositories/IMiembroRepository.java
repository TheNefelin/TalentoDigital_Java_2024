package cl.praxis.tiendadiscos.repositories;

import cl.praxis.tiendadiscos.entities.Miembro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMiembroRepository extends JpaRepository<Miembro, Integer> {
    @Query("SELECT m FROM Miembro m JOIN m.ventas v WHERE v.sucursal.id = :idSucursal AND m.membresia.id = :idMembresia")
    List<Miembro> findAllByIdSucursalAndIdMembresia(@Param("idSucursal") int idSucursal, @Param("idMembresia") int idMembresia);
}
