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
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.ManyToOne;

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
    
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "projects_users", 
        joinColumns = @JoinColumn(name = "project_id"), 
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> users;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="userLead_id")
    private User userLead ;
    
    public Project() {
        
    }
	

}
