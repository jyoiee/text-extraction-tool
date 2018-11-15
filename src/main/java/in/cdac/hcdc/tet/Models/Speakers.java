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
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="speakers")
public class Speakers implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "speaker_name")
    private String name;
    
     @OneToMany(mappedBy="sDetails",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Verse> verses = new ArrayList<>();

    public Speakers() {
        
    }
    
      public Speakers(String name) {
        this.name = name;
    }
 
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Verse> getVerses() {
        return verses;
    }

    public void setVerses(List<Verse> verses) {
        this.verses = verses;
    }

   
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



       public void addVerses(Verse v)
    {
        v.setsDetails(this);
        verses.add(v);      
    }
    @Override
    public String toString() {
        return "in.cdac.hcdc.tet.Models.Speakers[ id=" + id + " ]";
    }
    
}
