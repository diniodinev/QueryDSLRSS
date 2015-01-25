package com.musala.entity;

import javax.annotation.Nonnull;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Cannibal on 18.1.2015 г..
 */
@Embeddable
public class AbstractBaseEntity implements Serializable {
    private static final long serialVersionUID = 1881568474980982116L;

    @Nonnull
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createdDate", nullable = false)
    private Date createdDate = generateDate();

    public AbstractBaseEntity() {
    }

    @Nonnull
    public long getId() {
        return id;
    }

    public void setId(@Nonnull long id) {
        this.id = id;
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
}
