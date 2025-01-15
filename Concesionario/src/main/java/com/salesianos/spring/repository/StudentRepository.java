package com.salesianos.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.salesianos.spring.model.Spell;
import com.salesianos.spring.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

	List<Student> findByOrderByFullnameAsc();

	List<Student> findByOrderByFullnameDesc();

	@Query("SELECT st "
		 + " FROM Student st "
		 + " WHERE st.idstudent = :id "
		 + " ORDER BY st.fullname ASC ")
	List<Student> findByID(@Param("id") long id);
	
	@Query("SELECT st "
		 + " FROM Student st "
		 + " WHERE YEAR(st.matriculationdate) = :year "
		 + " ORDER BY st.fullname ASC ")
	List<Student> findByYear(@Param("year") int year);
	
	@Query(value = "SELECT * "
		 	 	 + " FROM students st "
		 	 	 + " WHERE YEAR(st.birthdate) >= ?1 "
		 	 	 + " ORDER BY st.fullname ASC "
		 , nativeQuery = true)
	List<Student> findByBirthYear(int year);
}