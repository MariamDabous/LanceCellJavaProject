package com.rrmm.lancecell.models;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Table(name="projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message="Title is required!")
    @Size(min=3, max=30, message="Title must be between 3 and 30 characters")
    private String title;
    @NotEmpty(message="description is required!")
    @Size(min=3, max=30, message="description must be between 3 and 250 characters")
    private String description ;
    @Future(message="Date must be in Future")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dueDate ;
  
    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
    private List<Programmer> programmmers;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "projects_languages", 
            joinColumns = @JoinColumn(name = "project_id"), 
            inverseJoinColumns = @JoinColumn(name = "language_id")
        )
    private List<Language> languages;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="owner_id")
    private Owner owner;
    
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "requests", 
            joinColumns = @JoinColumn(name = "project_id"), 
            inverseJoinColumns = @JoinColumn(name = "programmer_id")
        )
    private List<Programmer> requests;
    
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    @NotNull
    private ProjectCategory category;

	@PrePersist
	 protected void onCreate(){
	     this.createdAt = new Date();
	 }
	 @PreUpdate
	 protected void onUpdate(){
	     this.updatedAt = new Date();
	 }
    
    public Project() {
        
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Programmer> getProgrammmers() {
		return programmmers;
	}

	public void setProgrammmers(List<Programmer> programmmers) {
		this.programmmers = programmmers;
	}
	

	public List<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public List<Programmer> getRequests() {
		return requests;
	}

	public void setRequests(List<Programmer> requests) {
		this.requests = requests;
	}
	public ProjectCategory getCategory() {
		return category;
	}
	public void setCategory(ProjectCategory category) {
		this.category = category;
	}
    
    
	

}
