/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.cdac.hcdc.tet.Models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Jyoti
 */
@Entity
@Table(name="comments")
public class Comments implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

  @Column(name="user_name")
  private String username;
      
    @Column(name="comment")
    private String comment;
    
    @ManyToOne
    @JoinColumn(name="sense_id")
    private Sense cDetails;

    public Comments() {
    }

    public Comments(String username, String comment) {
        this.username = username;
        this.comment = comment;
    }

  
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

 
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Sense getcDetails() {
        return cDetails;
    }

    public void setcDetails(Sense cDetails) {
        this.cDetails = cDetails;
    }


    @Override
    public String toString() {
        return "in.cdac.hcdc.tet.Models.Comments[ id=" + id + " ]";
    }
    
}
