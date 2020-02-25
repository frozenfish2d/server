package org.frozenfish.models;

import javax.persistence.*;

@Entity
public class UserSpecialization {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userSpecializationId;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;
    @ManyToOne(fetch = FetchType.EAGER)
    private Specialization specialization;

    public UserSpecialization() {
    }

    public UserSpecialization(User user, Specialization specialization) {
        this.user = user;
        this.specialization = specialization;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }
}
