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
import org.hibernate.annotations.Type;

@Entity
@Table(name = "verses")
public class Verse implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="verse_no")
    private int VerseNo;

    @Column(name="verse_content")
    @Type(type = "text")
    private String verseContent;

    @ManyToOne
    @JoinColumn(name="speaker_id")
    private Speakers sDetails;
    
    @ManyToOne
    @JoinColumn(name="chapter_no")
    private SubChapters subchapterno;

    @OneToMany(mappedBy="vDetails",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Sense> sense = new ArrayList<>();
    
    public Verse() {
    }

    public Verse(int VerseNo, String verseContent) {
        this.VerseNo = VerseNo;
        this.verseContent = verseContent;
        
    }

    public int getVerseNo() {
        return VerseNo;
    }

    public void setVerseNo(int VerseNo) {
        this.VerseNo = VerseNo;
    }

    public SubChapters getSubchapterno() {
        return subchapterno;
    }

    public void setSubchapterno(SubChapters subchapterno) {
        this.subchapterno = subchapterno;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVerseContent() {
        return verseContent;
    }

    public void setVerseContent(String verseContent) {
        this.verseContent = verseContent;
    }

    public Speakers getsDetails() {
        return sDetails;
    }

    public void setsDetails(Speakers sDetails) {
        this.sDetails = sDetails;
    }

    public List<Sense> getSense() {
        return sense;
    }

    public void setSense(List<Sense> sense) {
        this.sense = sense;
    }


    @Override
    public String toString() {
        return "in.cdac.hcdc.tet.Models.Verses[ id=" + id + " ]";
    }

}
