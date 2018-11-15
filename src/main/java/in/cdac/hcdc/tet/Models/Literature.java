package in.cdac.hcdc.tet.Models;

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
@Table(name = "literature")
public class Literature {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="literature_id")
    private Long LiteratureID;
    
    
    @Column(name="title")
    private String title;
     
    @ManyToOne
    @JoinColumn(name="auther_id")
    private Author autherDetails;
    
   @ManyToOne
    @JoinColumn(name="language_id")
    private Language language;

   
    @OneToMany(mappedBy="lDetails",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Chapter> chapters = new ArrayList<>();
    
    public Literature() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getLiteratureID() {
        return LiteratureID;
    }

    public void setLiteratureID(Long LiteratureID) {
        this.LiteratureID = LiteratureID;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

     public Author getAutherDetails() {
        return autherDetails;
    }

    public void setAutherDetails(Author autherDetails) {
        this.autherDetails = autherDetails;
    }

    
    
    public List<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }
    
     public void addChapters(Chapter c)
    {
        c.setlDetails(this);
        chapters.add(c);
        
    }
    @Override
    public String toString() {
        return "Literature{" + "LiteratureID=" + LiteratureID + ", title=" + title + '}';
    }


    
}
