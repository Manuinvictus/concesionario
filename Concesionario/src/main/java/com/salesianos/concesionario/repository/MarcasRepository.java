package com.salesianos.concesionario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.salesianos.concesionario.model.CochePorMarca;
import com.salesianos.concesionario.model.Marca;

@Repository
public interface MarcasRepository extends JpaRepository<Marca, Long>{
	
	// Esta query no debe solo mostrar los datos, también debe cargarlos en nuestro objeto CochePorMarca,
	// mediante el builder de este.
	@Query("SELECT new CochePorMarca(c.idcoche, c.modelo, m.nombremarca, c.anyofabricacion, c.precio, c.moneda, v.nombre, v.apellidos, v.cargo) "
		 + " FROM Coche c, Marca m, Vendedor v"
		 + " WHERE c.idmarca=m.idmarca "
		 + " AND c.idvendedor=v.idvendedor "
		 + " AND UPPER(m.nombremarca) LIKE ?1% "
		 + " ORDER BY m.idmarca, c.modelo ASC ")
	List<CochePorMarca> cochesPorMarca(String modelo);

	@Query(value = "SELECT * "
				 + " FROM marcas m "
				 + " WHERE m.idmarca = :id "
				 + " ORDER BY m.nombremarca ASC "
				 , nativeQuery = true)
	List<Marca> findByID(@Param("id") long idmarca);
	
	@Query(value = "SELECT * "
				 + " FROM marcas m "
				 + " WHERE m.nombremarca = :nombremarca "
				 + " ORDER BY m.nombremarca ASC "
				 , nativeQuery = true)
	List<Marca> findByNombre(@Param("nombremarca") String nombremarca);

	@Query("SELECT m "
		 + " FROM Marca m "
		 + " WHERE m.patrimonio > :patrimonio "
		 + " ORDER BY m.nombremarca ASC ")
	List<Marca> findByPatrimonio(@Param("patrimonio") int patrimonio);
}