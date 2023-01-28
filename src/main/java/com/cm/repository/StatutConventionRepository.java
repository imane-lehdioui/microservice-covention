package com.cm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cm.entity.StatutConvention;

@Repository
public interface StatutConventionRepository extends JpaRepository<StatutConvention, Long> {

	public List<StatutConvention> findByOrderByIdDesc();
}
