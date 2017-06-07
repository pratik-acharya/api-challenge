package com.disney.studios.domain;

import javax.persistence.*;

/**
 * Created by Pratik Acharya on 6/6/2017.
 */

@Entity
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    private User user;
    @ManyToOne
    private  Picture  picture;
    @Enumerated(value = EnumType.STRING)
    private VoteType voteType;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public VoteType getVoteType() {
        return voteType;
    }

    public void setVoteType(VoteType voteType) {
        this.voteType = voteType;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Vote{");
        sb.append("id=").append(id);
        sb.append(", user=").append(user);
        sb.append(", picture=").append(picture);
        sb.append(", voteType=").append(voteType);
        sb.append('}');
        return sb.toString();
    }
}
