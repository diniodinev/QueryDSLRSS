package com.musala.entity;

import javax.annotation.Nonnull;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Cannibal on 18.1.2015 г..
 */
@MappedSuperclass
public class BaseKeyEntity implements Serializable {
    private static final long serialVersionUID = 1881568474980982116L;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createdDate", nullable = false)
    @Nonnull
    private Date createdDate = generateDate();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "lastModified", nullable = false)
    @Nonnull
    private Date lastModified = new Date();

    public BaseKeyEntity() {
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date generateDate() {
        return Calendar.getInstance().getTime();
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }
}
