/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.cdac.hcdc.tet.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Jyoti
 */
@Entity
@Table(name="sense")
public class Sense implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

     @Column(name="meaning")
    private String meaning;
    
    @ManyToOne
    @JoinColumn(name="verse_id")
    private Verse vDetails;

    @Column(name="user_name")
    private String username;
    
    @Column(name="likes")
    private int like;
    
    @Column(name="unlikes")
    private int unlike;
    
    @OneToMany(mappedBy="cDetails",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Comments> comment = new ArrayList<>();
    
    public Sense() {
    }

    public Sense(String meaning, String username) {
        this.meaning = meaning;
        this.username = username;
    }

    public Sense(String meaning, String username, int like, int unlike) {
        this.meaning = meaning;
        this.username = username;
        this.like = like;
        this.unlike = unlike;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    
    public Verse getvDetails() {
        return vDetails;
    }

    public void setvDetails(Verse vDetails) {
        this.vDetails = vDetails;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Comments> getComment() {
        return comment;
    }

    public void setComment(List<Comments> comment) {
        this.comment = comment;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getUnlike() {
        return unlike;
    }

    public void setUnlike(int unlike) {
        this.unlike = unlike;
    }



  
    @Override
    public String toString() {
        return "in.cdac.hcdc.tet.Models.Sense[ id=" + id + " ]";
    }
}
