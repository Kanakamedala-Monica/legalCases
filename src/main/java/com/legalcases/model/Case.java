package com.legalcases.model;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name="LegalCase")
public class Case {
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
    private String title;
    private String type;
    private String complexity;
    private LocalDate startDate;
    private LocalDate endDate;
    private String description;
    //Constructor
    //Getters and Setters
    
    public Case() {}
    
    
	public Case(long id, String title, String type, String complexity, LocalDate startDate, LocalDate endDate,
			String description) {
		super();
		this.id = id;
		this.title = title;
		this.type = type;
		this.complexity = complexity;
		this.startDate = startDate;
		this.endDate = endDate;
		this.description = description;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getComplexity() {
		return complexity;
	}
	public void setComplexity(String complexity) {
		this.complexity = complexity;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
    
    
}
