/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.malinkil.mp4.malinkil.mp4.domain.security;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import org.apache.commons.codec.digest.DigestUtils;
/**
 *
 * @author mithun.alinkil
 */

@Entity
@Table(name = "USER_INFO")

    @NamedQueries({
    @NamedQuery(name ="UserEntity.findAll" , query = "select u from UserEntity u"),
    @NamedQuery(name = "UserEntity.findByUserName" , query = "select b from UserEntity b where b.userName = :userName")
})
public class UserEntity implements Serializable {
    
    private static final long serialVersionUID = 1l;
    
    public UserEntity(){
        
    }
    
    @Id
    private String userId;
    private String userName;
    private String password;
    private String userType;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }
    
    

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
 
    public UserEntity(String userName ,String password){
        this.userName = userName;
        this.password = password;
    }
    
      @PrePersist
      @PreUpdate
      private void hashPassword(){
          String digestPassword = DigestUtils.md5Hex(this.password);
          this.password = digestPassword;
          
      }
}
