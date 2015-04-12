/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.malinkil.mp4.malinkil.mp4.domain.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author mithun.alinkil
 */

@Entity
@Table(name = "BOOK_MOVEMENT_DETAILS_INFO")
@NamedQuery(name= "BookMovementDetailsNew.findAll", query ="select b from BookMovementDetailsNew b where b.userId = :userId ")
public class BookMovementDetailsNew implements Serializable {
    
    public BookMovementDetailsNew(){}
    
    private static final long serialVersionUID = 1l;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "BOOK_ID" ,nullable = false , columnDefinition = "INT" , updatable = true)
    private int bookId;
    
    @Column(name = "USER_ID" ,nullable = false , columnDefinition = "VARCHAR(40)" , updatable = true)
    private String userId;
    
    @Column(name = "TAKEN_DATE" ,nullable = false ,  updatable = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date bookTakenDate;
    
    
    @Column(name = "RETURN_DATE" ,nullable = false ,  updatable = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date bookReturnDate;
    
    @Column(name = "OVERDUE_DAYS" ,nullable = false , columnDefinition = "INT" , updatable = true)
    private int overDueDays;
    
    @Column(name = "BOOK_NAME" ,nullable = false , columnDefinition = "VARCHAR(40)" , updatable = true)
    private String bookName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getBookTakenDate() {
        return bookTakenDate;
    }

    public void setBookTakenDate(Date bookTakenDate) {
        this.bookTakenDate = bookTakenDate;
    }

    public Date getBookReturnDate() {
        return bookReturnDate;
    }

    public void setBookReturnDate(Date bookReturnDate) {
        this.bookReturnDate = bookReturnDate;
    }

    public int getOverDueDays() {
        return overDueDays;
    }

    public void setOverDueDays(int overDueDays) {
        this.overDueDays = overDueDays;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    
    
    
    
}
