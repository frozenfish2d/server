package org.frozenfish.models;

import javax.persistence.*;

@Entity
public class UserPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userPositionId;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;
    @ManyToOne(fetch = FetchType.EAGER)
    private Position position;

    public UserPosition() {
    }

    public UserPosition(User user, Position position) {
        this.user = user;
        this.position = position;
    }

    public User getDoctor() {
        return user;
    }

    public void setDoctor(User user) {
        this.user = user;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
