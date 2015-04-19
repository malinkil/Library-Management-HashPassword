/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.malinkil.mp4.malinkil.mp4.domain.security.ejb;

import edu.iit.sat.itmd4515.malinkil.mp4.malinkil.mp4.domain.security.UserEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mithun.alinkil
 */
@Stateless
public class UserService extends AbstractService<UserEntity> {
    
    @PersistenceContext(unitName = "malinkilPU")
    private EntityManager em;
    
    public UserService(){
        super(UserEntity.class);
    }
    
    @Override
    public List<UserEntity> findAll(){
        return getEntityManager().createNamedQuery("UserEntity.findAll", UserEntity.class).getResultList();
    }
    
    public UserEntity findByUsername(String userName){
        return em.createNamedQuery("UserEntity.findByUserName", UserEntity.class).setParameter("userName", userName).getSingleResult();
    }
}
