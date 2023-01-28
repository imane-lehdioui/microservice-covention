package com.cm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cm.entity.Convention;

@Repository
public interface ConventionRepository extends JpaRepository<Convention, Long> {

	public List<Convention> findByOrderByIdDesc();
	
	public List<Convention> findByIdAssociationOrderByIdDesc(long id);

	@Query("select count(c.id) from Convention c where c.idAssociation  = ?1")
	long countConventionByassosation(long id);

	void deleteByIdAssociation (String id);
}
