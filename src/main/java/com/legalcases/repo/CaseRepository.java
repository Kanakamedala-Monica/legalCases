package com.legalcases.repo;

import com.legalcases.model.Case;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CaseRepository extends JpaRepository<Case, Long> {
	List<Case> findByTitleContainingIgnoreCase(String title);

    @Query("SELECT c.type, COUNT(c) FROM Case c GROUP BY c.type")
    List<Object[]> countCasesByType();

    List<Case> findByComplexity(String complexity);
	
}
