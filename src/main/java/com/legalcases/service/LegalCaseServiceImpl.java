package com.legalcases.service;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.legalcases.model.Case;
import com.legalcases.repo.CaseRepository;

@Service
public class LegalCaseServiceImpl implements LegalCaseService {

    @Autowired
    private CaseRepository legalCaseRepository;

    @Override
    public Case getCaseById(long id) {
        return legalCaseRepository.findById(id).orElse(null);
    }

    @Override
    public Case createCase(Case legalCase) {
        return legalCaseRepository.save(legalCase);
    }
    
    @Override
    public Case updateCase(long id, Case updatedCase) {
        if (legalCaseRepository.existsById(id)) {
            updatedCase.setId(id);
            return legalCaseRepository.save(updatedCase);
        } else {
            return null;
        }
    }

    @Override
    public String deleteCase(long id) {
        if (legalCaseRepository.existsById(id)) {
            legalCaseRepository.deleteById(id);
            return "Case with ID " + id + " deleted successfully.";
        } else {
            return "Case with ID " + id + " not found.";
        }
    }

    @Override
    public List<Case> createCases(List<Case> legalCases) {
        return legalCaseRepository.saveAll(legalCases);
    }

    @Override
    public List<Case> searchByTitle(String title) {
        return legalCaseRepository.findByTitleContainingIgnoreCase(title);
    }

    @Override
    public List<Object[]> countByType() {
        return legalCaseRepository.countCasesByType();
    }

    @Override
    public List<Case> filterByComplexity(String complexity) {
        return legalCaseRepository.findByComplexity(complexity);
    }

    @Override
    public List<Case> filterByDuration(int durationInDays) {
        return legalCaseRepository.findAll().stream()
                .filter(c -> ChronoUnit.DAYS.between(c.getStartDate(), c.getEndDate()) <= durationInDays)
                .collect(Collectors.toList());
    }

    @Override
    public List<Case> getAllCases() {
        return legalCaseRepository.findAll();
    }
}