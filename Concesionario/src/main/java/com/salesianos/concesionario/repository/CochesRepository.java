package com.salesianos.concesionario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.salesianos.concesionario.model.Coche;

@Repository
public interface CochesRepository extends JpaRepository<Coche, Long>{

	List<Coche> findByOrderByFullnameAsc();

	List<Coche> findByOrderByFullnameDesc();

	@Query("SELECT c "
		 + " FROM Coche c "
		 + " WHERE c.idcoche = :id "
		 + " ORDER BY c.modelo ASC ")
	List<Coche> findByID(@Param("id") long id);
	
	@Query("SELECT c "
		 + " FROM Coche c "
		 + " WHERE c.anyofabricacion = :year "
		 + " ORDER BY c.modelo ASC ")
	List<Coche> findByYear(@Param("year") int year);
	
	@Query("SELECT c "
		 + " FROM Coche c "
		 + " WHERE c.idmarca = :id "
		 + " ORDER BY c.modelo ASC ")
	List<Coche> findByIdMarca(@Param("idmarca") int idmarca);
	
	@Query(value = "SELECT * "
 	 	 + " FROM coches c "
 	 	 + " WHERE precio = :precio "
 	 	 + " ORDER BY c.modelo ASC "
		 , nativeQuery = true)
	List<Coche> findByPrecio(int precio);
}