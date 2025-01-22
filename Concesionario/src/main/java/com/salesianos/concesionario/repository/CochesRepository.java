package com.salesianos.concesionario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.salesianos.concesionario.model.Coche;
<<<<<<< HEAD
=======
import com.salesianos.concesionario.model.Vendedor;
>>>>>>> origin/Sheyla

@Repository
public interface CochesRepository extends JpaRepository<Coche, Long>{

	List<Coche> findByOrderByFullnameAsc();

	List<Coche> findByOrderByFullnameDesc();

<<<<<<< HEAD
	@Query("SELECT st "
		 + " FROM Student st "
		 + " WHERE st.idstudent = :id "
		 + " ORDER BY st.fullname ASC ")
	List<Coche> findByID(@Param("id") long id);
	
	@Query("SELECT st "
		 + " FROM Student st "
		 + " WHERE YEAR(st.matriculationdate) = :year "
		 + " ORDER BY st.fullname ASC ")
	List<Coche> findByYear(@Param("year") int year);
=======
	@Query("SELECT c "
		 + " FROM coches c "
		 + " WHERE c.idcoche = :id "
		 + " ORDER BY c.modelo ASC ")
	List<Coche> findByID(@Param("id") long id);
	
	@Query("SELECT c "
		 + " FROM coches c "
		 + " WHERE c.anyofabricacion = :year "
		 + " ORDER BY c.modelo ASC ")
	List<Coche> findByYear(@Param("year") int year);
	
	@Query("SELECT c "
			 + " FROM coches c "
			 + " WHERE c.idmarca = :id "
			 + " ORDER BY c.modelo ASC ")
		List<Coche> findByIdMarca(@Param("idmarca") int idmarca);
>>>>>>> origin/Sheyla
	
	@Query(value = "SELECT * "
		 	 	 + " FROM coches c "
		 	 	 + " WHERE precio = :precio "
		 	 	 + " ORDER BY c.modelo ASC "
		 , nativeQuery = true)
<<<<<<< HEAD
	List<Coche> findByBirthYear(int year);
=======
	List<Coche> findByPrecio(int precio);
>>>>>>> origin/Sheyla
}