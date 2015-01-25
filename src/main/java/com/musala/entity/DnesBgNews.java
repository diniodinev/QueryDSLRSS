package com.musala.entity;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import javax.persistence.*;
import java.util.Date;

/**
 * Created by Cannibal on 18.1.2015 г..
 */

@Entity
public class DnesBgNews extends BaseKeyEntity {
    private static final long serialVersionUID = -679074804392634141L;
    @Nonnull
    @Column(name = "newsId", nullable = false)
    private long newsId;

    @Nonnull
    @Column(name = "title", nullable = false)
    private String title;

    @CheckForNull
    @Column(name = "description", nullable = true)
    private String description;

//    @CheckForNull
//    @Column(name = "keyWords", nullable = true)
//    private List<String> keyWords;

    @Nonnull
    @Lob
    @Column(name = "content")
    private String newsContent;

    @CheckForNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "publicationDate", nullable = true)
    private Date publicationDate;


    public DnesBgNews() {
    }

    @Nonnull
    public long getNewsId() {
        return newsId;
    }

    public void setNewsId(@Nonnull long newsId) {
        this.newsId = newsId;
    }

    @Nonnull
    public String getTitle() {
        return title;
    }

    public void setTitle(@Nonnull String title) {
        this.title = title;
    }

    @CheckForNull
    public String getDescription() {
        return description;
    }

    public void setDescription(@CheckForNull String description) {
        this.description = description;
    }

    @Nonnull
    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(@Nonnull String newsContent) {
        this.newsContent = newsContent;
    }

    @CheckForNull
    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(@CheckForNull Date publicationDate) {
        this.publicationDate = publicationDate;
    }
}
