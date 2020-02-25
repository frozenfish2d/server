package org.frozenfish.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Disease {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer diseaseId;
    private String diseaseName;

    public Disease() {
    }

    public Disease(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }
}
