/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.malinkil.mp4.malinkil.mp4.domain.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author mithun.alinkil
 */

@Entity
@Table(name = "STOCK_ORDER")
@NamedQuery(name = "StockOrder.findAll" , query = " select b from StockOrder b where b.vendorId = :vendorId")

public class StockOrder implements Serializable {
    
    private static final long serialVersionUID = 1l;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(name= "VENDOR_ID" , nullable = false , columnDefinition = "VARCHAR(40)", updatable=true)
    private String vendorId;
    
    @Column(name= "BOOK_NAME" , nullable = false , columnDefinition = "VARCHAR(40)", updatable=true)
    private String bookName;
    
    @Column(name= "BOOK_EDITION" , nullable = false , columnDefinition = "VARCHAR(40)", updatable=true)
    private String bookEdition;
    
    @Column(name= "QUANTITY" , nullable = false , columnDefinition = "INT", updatable=true)
    private int quantity;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookEdition() {
        return bookEdition;
    }

    public void setBookEdition(String bookEdition) {
        this.bookEdition = bookEdition;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
    
}
