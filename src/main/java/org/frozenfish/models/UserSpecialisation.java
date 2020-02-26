package org.frozenfish.models;

import javax.persistence.*;

@Entity
public class UserSpecialisation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userSpecializationId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "specialisation_id")
    private Specialisation specialisation;

    public UserSpecialisation() {
    }

    public UserSpecialisation(User user, Specialisation specialisation) {
        this.user = user;
        this.specialisation = specialisation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Specialisation getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(Specialisation specialisation) {
        this.specialisation = specialisation;
    }
}
