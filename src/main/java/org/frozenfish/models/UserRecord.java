package org.frozenfish.models;

import org.frozenfish.enums.States;
import org.frozenfish.enums.Role;

import javax.persistence.*;
import java.util.Set;

@Entity
public class UserRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userRecordId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "record_id")
    private Record record;

    @ElementCollection(targetClass = States.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "record_state", joinColumns = @JoinColumn(name = "user_record_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> state;

    public UserRecord() {
    }

    public UserRecord(User user, Record record) {
        this.user = user;
        this.record = record;
    }

    public Integer getUserRecordId() {
        return userRecordId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }

    public Set<Role> getState() {
        return state;
    }

    public void setState(Set<Role> state) {
        this.state = state;
    }
}
