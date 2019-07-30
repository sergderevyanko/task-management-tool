package org.atomspace.taskmanager.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by sergey.derevyanko on 30.07.19.
 */
@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Project name is required")
    private String projectName;
    @NotBlank(message = "Project Identifier is required")
    @Size(min = 2, max = 5, message = "Please use 2 to 5 characters")
    @Column(updatable = false, unique = true)
    private String projectIdendifier;
    @NotBlank(message = "Project description is required")
    private String description;
    @JsonFormat( pattern = "yyyy-MM-dd")
    private Date startDate;
    @JsonFormat( pattern = "yyyy-MM-dd")
    private Date endDate;
    @JsonFormat( pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdAt;
    @JsonFormat( pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatedAt;

    public Project() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectIdendifier() {
        return projectIdendifier;
    }

    public void setProjectIdendifier(String projectIdendifier) {
        this.projectIdendifier = projectIdendifier;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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

    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }


}