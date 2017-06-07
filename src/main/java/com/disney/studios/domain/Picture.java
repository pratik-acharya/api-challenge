package com.disney.studios.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pratik Acharya on 6/6/2017.
 */
@Entity
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String url;
    @JsonIgnore
    @ManyToOne
    private Breed breed;
    @JsonIgnore
    @OneToMany(mappedBy = "picture")
    private List<Vote> votes = new ArrayList<>();

    private int upVotes;

    private int downVotes;

    public Picture(){};

    public Picture(String url, Breed breed) {
        this.url = url;
        this.breed = breed;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Breed getBreed() {
        return breed;
    }

    public void setBreed(Breed breed) {
        this.breed = breed;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    public int getUpVotes() {
        return upVotes;
    }

    public void setUpVotes(int upVotes) {
        this.upVotes = upVotes;
    }

    public int getDownVotes() {
        return downVotes;
    }

    public void setDownVotes(int downVotes) {
        this.downVotes = downVotes;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Picture{");
        sb.append("id=").append(id);
        sb.append(", url='").append(url).append('\'');
//        sb.append(", dog=").append(breed);
//        sb.append(", votes=").append(votes);
//        sb.append(", upVotes=").append(upVotes);
//        sb.append(", downVotes=").append(downVotes);
        sb.append('}');
        return sb.toString();
    }
}
