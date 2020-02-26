package org.frozenfish.models;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Set;

@Entity
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer recordId;
    private Date recordDate;
    private Time recordTime;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<UserRecord> userRecordSet;

    public Record() {
    }

    public Record(Date recordDate, Time recordTime, Set<UserRecord> userRecordSet) {
        this.recordDate = recordDate;
        this.recordTime = recordTime;
        this.userRecordSet = userRecordSet;
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    public Time getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Time recordTime) {
        this.recordTime = recordTime;
    }

    public Set<UserRecord> getUserRecordSet() {
        return userRecordSet;
    }

    public void setUserRecordSet(Set<UserRecord> userRecordSet) {
        this.userRecordSet = userRecordSet;
    }
}
