/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.malinkil.mp4.malinkil.mp4.domain.security.ejb;

import edu.iit.sat.itmd4515.malinkil.mp4.malinkil.mp4.domain.entity.BookMovementDetailsNew;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mithun.alinkil
 */
@Stateless
public class BookMovementBean {
    
    @PersistenceContext(unitName = "malinkilPU")
    private EntityManager em;
    
    public BookMovementBean(){
        
    }
    
    public void create(BookMovementDetailsNew p){
        em.persist(p);
    }
    
    public List<BookMovementDetailsNew>findAll(String userId){
        return em.createNamedQuery("BookMovementDetailsNew.findAll", BookMovementDetailsNew.class).setParameter("userId",userId).getResultList();
    }
}
