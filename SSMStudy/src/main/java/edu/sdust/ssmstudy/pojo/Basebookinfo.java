package edu.sdust.ssmstudy.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "basebookinfo")
public class Basebookinfo {
    @Id
    @Column(name = "BID")
    private String bid;

    @Column(name = "BNAME")
    private String bname;

    @Column(name = "AUTHOR")
    private String author;

    @Column(name = "PUBLICATION")
    private Date publication;

    @Column(name = "PRICE")
    private Double price;

    @Column(name = "PUBLISHINGCOMPANY")
    private String publishingcompany;

    /**
     * @return BID
     */
    public String getBid() {
        return bid;
    }

    /**
     * @param bid
     */
    public void setBid(String bid) {
        this.bid = bid == null ? null : bid.trim();
    }

    /**
     * @return BNAME
     */
    public String getBname() {
        return bname;
    }

    /**
     * @param bname
     */
    public void setBname(String bname) {
        this.bname = bname == null ? null : bname.trim();
    }

    /**
     * @return AUTHOR
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    /**
     * @return PUBLICATION
     */
    public Date getPublication() {
        return publication;
    }

    /**
     * @param publication
     */
    public void setPublication(Date publication) {
        this.publication = publication;
    }

    /**
     * @return PRICE
     */
    public Double getPrice() {
        return price;
    }

    /**
     * @param price
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * @return PUBLISHINGCOMPANY
     */
    public String getPublishingcompany() {
        return publishingcompany;
    }

    /**
     * @param publishingcompany
     */
    public void setPublishingcompany(String publishingcompany) {
        this.publishingcompany = publishingcompany == null ? null : publishingcompany.trim();
    }
}