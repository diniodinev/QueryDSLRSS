package com.musala.entity;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import javax.persistence.*;
import java.util.Date;

/**
 * Created by Cannibal on 18.1.2015 г..
 */

@Entity
public class DnesBgNews {
    @Nonnull
    @Column(name = "newsId", nullable = false)
    private long newsId;

    @Nonnull
    @Column(name = "title", nullable = false)
    private String title;

    @CheckForNull
    @Column(name = "description", nullable = true)
    private String description;

    @Id
    private AbstractArticle abstractArticle;

//    @CheckForNull
//    @Column(name = "keyWords", nullable = true)
//    private List<String> keyWords;

    @Nonnull
    @Lob
    @Column(name = "content")
    private String newsContent;

    @CheckForNull
    @Column(name = "authorName", nullable = true)
    private String authorName;

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

//    @CheckForNull
//    public List<String> getKeyWords() {
//        return keyWords;
//    }
//
//    public void setKeyWords(@CheckForNull List<String> keyWords) {
//        this.keyWords = keyWords;
//    }

    @Nonnull
    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(@Nonnull String newsContent) {
        this.newsContent = newsContent;
    }

    @CheckForNull
    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(@CheckForNull String authorName) {
        this.authorName = authorName;
    }

    @CheckForNull
    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(@CheckForNull Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public AbstractArticle getAbstractArticle() {
        return abstractArticle;
    }

    public void setAbstractArticle(AbstractArticle abstractArticle) {
        this.abstractArticle = abstractArticle;
    }
}
