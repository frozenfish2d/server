package org.frozenfish.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class SickLeave {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer sickLeaveId;
    private Date sickLeaveStart;
    private Date sickLeaveEnd;

    public SickLeave() {
    }

    public SickLeave(Date sickLeaveStart, Date sickLeaveEnd) {
        this.sickLeaveStart = sickLeaveStart;
        this.sickLeaveEnd = sickLeaveEnd;
    }

    public Date getSickLeaveStart() {
        return sickLeaveStart;
    }

    public void setSickLeaveStart(Date sickLeaveStart) {
        this.sickLeaveStart = sickLeaveStart;
    }

    public Date getSickLeaveEnd() {
        return sickLeaveEnd;
    }

    public void setSickLeaveEnd(Date sickLeaveEnd) {
        this.sickLeaveEnd = sickLeaveEnd;
    }
}
