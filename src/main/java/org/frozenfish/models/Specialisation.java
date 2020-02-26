package org.frozenfish.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Specialisation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer specializationId;
    private String specialisationName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<UserSpecialisation> userSpecialisationSet;

    public Specialisation() {

    }

    public Specialisation(String specialisationName, Set<UserSpecialisation> userSpecialisationSet) {
        this.specialisationName = specialisationName;
        this.userSpecialisationSet = userSpecialisationSet;
    }

    public Integer getSpecializationId() {
        return specializationId;
    }

    public void setSpecializationId(Integer specializationId) {
        this.specializationId = specializationId;
    }

    public String getSpecialisationName() {
        return specialisationName;
    }

    public void setSpecialisationName(String specialisationName) {
        this.specialisationName = specialisationName;
    }

    public Set<UserSpecialisation> getUserSpecialisationSet() {
        return userSpecialisationSet;
    }

    public void setUserSpecialisationSet(Set<UserSpecialisation> userSpecialisationSet) {
        this.userSpecialisationSet = userSpecialisationSet;
    }
}
