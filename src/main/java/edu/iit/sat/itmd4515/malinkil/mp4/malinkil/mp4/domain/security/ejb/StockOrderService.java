/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.malinkil.mp4.malinkil.mp4.domain.security.ejb;

import edu.iit.sat.itmd4515.malinkil.mp4.malinkil.mp4.domain.entity.StockOrder;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mithun.alinkil
 */
@Stateless
public class StockOrderService {
    
    @PersistenceContext(unitName = "malinkilPU")
    private EntityManager em;
    
    public StockOrderService(){
        
    }
    
    public void create(StockOrder s){
        em.persist(s);
    }
    
    public List<StockOrder> findAll(String vendorId){
        return em.createNamedQuery("StockOrder.findAll", StockOrder.class).setParameter("vendorId", vendorId).getResultList();
    }
}
