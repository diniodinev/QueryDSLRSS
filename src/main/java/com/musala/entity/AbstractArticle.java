package com.musala.entity;

import javax.annotation.Nonnull;
import javax.persistence.*;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Cannibal on 18.1.2015 г..
 */
@Entity
public abstract class AbstractArticle {

    @Id
    @Nonnull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createdDate", nullable = false)
    private Date createdDate;

    public AbstractArticle() {
    }

    @Nonnull
    public long getId() {
        return id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = Calendar.getInstance().getTime();
    }
}
