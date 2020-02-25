package org.frozenfish.models;


import org.frozenfish.enums.States;
import org.frozenfish.enums.Role;

import javax.persistence.*;
import java.util.Set;

@Entity
public class UserServices {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userServiceId;
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @ElementCollection(targetClass = States.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "service_state", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> state;

    public UserServices() {
    }

    public UserServices(User user) {
        this.user = user;

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Role> getState() {
        return state;
    }

    public void setState(Set<Role> state) {
        this.state = state;
    }
}
