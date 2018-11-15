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

@Entity
@Table(name="sub_chapters")
public class SubChapters implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Sub_chapter_name")
    private String sname;
    
    @Column(name = "Sub_chapter_number")
    private int subchapNo;
    
    @ManyToOne
    @JoinColumn(name="chapter_id")
    private Chapter CDetails;

    @OneToMany(mappedBy="subchapterno",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Verse> verse_list = new ArrayList<>();
      
    public SubChapters() {
    }

    public SubChapters(String sname, int subchapNo) {
        this.sname = sname;
        this.subchapNo = subchapNo;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getSubchapNo() {
        return subchapNo;
    }

    public void setSubchapNo(int subchapNo) {
        this.subchapNo = subchapNo;
    }

    public Chapter getCDetails() {
        return CDetails;
    }

    public void setCDetails(Chapter CDetails) {
        this.CDetails = CDetails;
    }

    public List<Verse> getVerse_list() {
        return verse_list;
    }

    public void setVerse_list(List<Verse> verse_list) {
        this.verse_list = verse_list;
    }

    
       public void addVerses(Verse s)
    {
        s.setSubchapterno(this);
        verse_list.add(s);      
    }
    
    @Override
    public String toString() {
        return "in.cdac.hcdc.tet.Models.SubChapters[ id=" + id + " ]";
    }
    
}
