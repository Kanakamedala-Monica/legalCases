package com.legalcases.service;

import java.util.List;
import java.util.Optional;

import com.legalcases.model.Case;

public interface LegalCaseService {
	Case getCaseById(long id);
    Case createCase(Case legalCase);
    Case updateCase(long id, Case updatedCase);
    String deleteCase(long id);
    List<Case> createCases(List<Case> legalCases);
    List<Case> searchByTitle(String title);
    List<Object[]> countByType();
    List<Case> filterByComplexity(String complexity);
    List<Case> filterByDuration(int duration);
    List<Case> getAllCases();
}

