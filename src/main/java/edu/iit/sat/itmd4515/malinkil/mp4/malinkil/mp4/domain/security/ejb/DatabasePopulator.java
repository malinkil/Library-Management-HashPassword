/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.malinkil.mp4.malinkil.mp4.domain.security.ejb;

import edu.iit.sat.itmd4515.malinkil.mp4.malinkil.mp4.domain.entity.BookMovementDetailsNew;
import edu.iit.sat.itmd4515.malinkil.mp4.malinkil.mp4.domain.entity.StockOrder;
import edu.iit.sat.itmd4515.malinkil.mp4.malinkil.mp4.domain.security.UserEntity;
import java.util.GregorianCalendar;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author mithun.alinkil
 */
@Singleton
@Startup
public class DatabasePopulator {
    
    public DatabasePopulator(){
        
    }
    
    @EJB
    private UserBean userBean;
    
    @EJB
    private BookMovementBean booksBean;
    
    @EJB
    private StockOrderBean stockBean;
    
    @PostConstruct
    private void populateDatabase(){
        
        UserEntity u1 = new UserEntity();
        u1.setUserId("uid1");
        u1.setUserName("Mith");
        u1.setPassword("Mith");
        u1.setUserType("vendor");
        
        UserEntity u2 = new UserEntity();
        u2.setUserId("uid2");
        u2.setUserName("Mithun");
        u2.setPassword("Mithun");
        u2.setUserType("customer");
        
        UserEntity u3 = new UserEntity();
        u3.setUserId("uid3");
        u3.setUserName("ABC");
        u3.setPassword("ABC");
        u3.setUserType("ADMIN");
        
        BookMovementDetailsNew b = new BookMovementDetailsNew();
        b.setBookId(1);
        b.setBookName("Advance Java");
        b.setUserId("uid2");
        b.setBookTakenDate(new GregorianCalendar(2015,4,2).getTime());
        b.setBookReturnDate(new GregorianCalendar(2015,4,10).getTime());
        b.setOverDueDays(4);
        
        
        BookMovementDetailsNew b1 = new BookMovementDetailsNew();
        b1.setBookId(1);
        b1.setBookName("Advance Database Management");
        b1.setUserId("uid2");
        b1.setBookTakenDate(new GregorianCalendar(2015,4,6).getTime());
        b1.setBookReturnDate(new GregorianCalendar(2015,4,16).getTime());
        b1.setOverDueDays(2);
        
        
        StockOrder s = new StockOrder();
        s.setVendorId("uid1");
        s.setBookName("Basics of Php");
        s.setBookEdition("XYZ-2010");
        s.setQuantity(3);
        
        StockOrder s1 = new StockOrder();
        s1.setVendorId("uid1");
        s1.setBookName("Basics of .Net");
        s1.setBookEdition("LMN-2010");
        s1.setQuantity(5);
        
        
        userBean.create(u1);
        userBean.create(u2);     
        userBean.create(u3);
        
        booksBean.create(b);
        booksBean.create(b1);
        
        stockBean.create(s);
        stockBean.create(s1);
    }
    
}
    