package org.frozenfish.models;

import javax.persistence.*;

@Entity
public class UserDisease {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userDiseaseId;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;
    @ManyToOne(fetch = FetchType.EAGER)
    private SickLeave sickLeave;


    public UserDisease() {
    }

    public UserDisease(User user, SickLeave sickLeave) {

        this.user = user;
        this.sickLeave = sickLeave;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public SickLeave getSickLeave() {
        return sickLeave;
    }

    public void setSickLeave(SickLeave sickLeave) {
        this.sickLeave = sickLeave;
    }
}
