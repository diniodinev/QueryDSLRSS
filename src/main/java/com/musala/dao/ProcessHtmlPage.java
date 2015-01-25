package com.musala.dao;

import org.apache.commons.validator.UrlValidator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import java.io.IOException;

/**
 * Created by Cannibal on 25.1.2015 г..
 */
public class ProcessHtmlPage {
    private static final Logger logger = LoggerFactory.getLogger(ProcessHtmlPage.class);

    /**
     * Return Document for the given link which has to be URL compatible, or
     * html String page which will be transformed to Document.
     *
     * @param link which has to be URL compatible
     * @return null if the URL is not valid
     * @throws IOException
     */
    private Document getDocument(final String link) throws IOException {
        if (!new UrlValidator().isValid(link)) {
            logger.warn("Link {} is not a valid URL", link);
            return null;
        }
        return Jsoup.connect(link).userAgent("Mozilla").get();
    }

    public String readNewsText(@Nonnull String newsUrl) throws IOException {
        return extractArticleInformation(getDocument(newsUrl), "asd");

    }

    protected String extractArticleInformation(final Document doc, String tagName) throws IOException {
        tagName = "#article_text";
        if (doc.select(tagName).first() != null) {
            return doc.select(tagName).first().text();
        } else {
            //TODO add meanigfyl logger
            logger.warn("For the specified document, there is no tag with name %s", tagName);
            return null;
        }

    }
}