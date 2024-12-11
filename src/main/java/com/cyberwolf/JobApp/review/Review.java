package com.cyberwolf.JobApp.review;

import com.cyberwolf.JobApp.company.Company;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Review {
    @Id //tells jpa to treat id as primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //this will tell it to autoincrement the id
    private Long id;
    private String title;
    private String description;
    private Double rating;
    //linking a review to a particular company
    @JsonIgnore  //to prevent infinite recursion when returning a Review
    @ManyToOne
    private Company company;

    public Review() {
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
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

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}
