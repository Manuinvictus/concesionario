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
				 + " FROM spells sp "
				 + " WHERE sp.idspell = :id "
				 + " ORDER BY sp.spellname ASC "
		 , nativeQuery = true)
	List<Vendedor> findByID(@Param("id") long id);

	@Query("SELECT sp "
		 + " FROM Spell sp "
		 + " WHERE sp.damage > :dmg "
		 + " ORDER BY sp.spellname ASC ")
	List<Vendedor> findByDmg(@Param("dmg") int dmg);
	
	@Query(value = "SELECT * "
			 	 + " FROM spells sp "
			 	 + " WHERE sp.level >= ?1 "
			 	 + " ORDER BY sp.spellname ASC "
		 , nativeQuery = true)
	List<Vendedor> findByLevel(int lvl);
}