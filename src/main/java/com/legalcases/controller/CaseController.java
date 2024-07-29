package com.legalcases.controller;

import com.legalcases.model.Case;
import com.legalcases.service.LegalCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/cases")
public class CaseController {

    @Autowired
    private LegalCaseService caseService;

    @GetMapping
    public List<Case> getAllCases() {
        return caseService.getAllCases();
    }

    @GetMapping("/{id}")
    public Case getCaseById(@PathVariable long id) {
        return caseService.getCaseById(id);
    }

    @PostMapping
    public Case createCase(@RequestBody Case legalCase) {
        return caseService.createCase(legalCase);
    }
    
    @PostMapping("/bulk")
    public List<Case> createCases(@RequestBody List<Case> cases) {
        return caseService.createCases(cases);
    }

    @PutMapping("/{id}")
    public Case updateCase(@PathVariable long id, @RequestBody Case updatedCase) {
        return caseService.updateCase(id, updatedCase);
    }

    @DeleteMapping("/{id}")
    public void deleteCase(@PathVariable long id) {
        caseService.deleteCase(id);
    }

    @GetMapping("/search")
    public List<Case> searchCasesByTitle(@RequestParam String title) {
        return caseService.searchByTitle(title);
    }

    @GetMapping("/countByType")
    public List<Object[]> countByType() {
        return caseService.countByType();
    }

    @GetMapping("/filterByComplexity")
    public List<Case> filterByComplexity(@RequestParam String complexity) {
        return caseService.filterByComplexity(complexity);
    }

    @GetMapping("/filterByDuration")
    public List<Case> filterByDuration(@RequestParam int duration) {
        return caseService.filterByDuration(duration);
    }
}