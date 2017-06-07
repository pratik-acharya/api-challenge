package com.disney.studios.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pratik Acharya on 6/6/2017.
 */
@Entity
public class Breed {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(unique = true)
    private String name;
    @OneToMany(mappedBy = "breed", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Picture> pictures = new ArrayList<>();

    public Breed(){};

    public Breed(String breed) {
        this.name = breed;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Breed{");
        sb.append("breed='").append(name).append('\'');
        sb.append(", pictures=").append(pictures);
        sb.append('}');
        return sb.toString();
    }
}
