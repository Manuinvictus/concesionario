package com.salesianos.concesionario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.salesianos.concesionario.model.Vendedor;

@Repository
public interface VendedoresRepository extends JpaRepository<Vendedor, Long>{

	@Query(value = "SELECT * "
				 + " FROM vendedores v "
				 + " WHERE v.idvendedor = :id "
				 + " ORDER BY v.nombre ASC "
				 , nativeQuery = true)
	List<Vendedor> findByID(@Param("id") long id);
}