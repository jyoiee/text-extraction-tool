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
@Table(name = "chapter")
public class Chapter implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "chapter_id")
    private Long chapterId;

    @Column(name = "chapter_name")
    private String name;

    @Column(name = "chapter_number")
    private int chapNo;

    @Column(name = "url")
    private String url;

    @Type(type = "text")
    @Column(name = "full_content")
    private String fullContent;

    @ManyToOne
    @JoinColumn(name="literature_id")
    private Literature lDetails;
    
    @OneToMany(mappedBy="CDetails",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<SubChapters> sub_chapters = new ArrayList<>();

   
    
    public Chapter() {
    }

    public Chapter(String name, int chapNo, String url, String fullContent) {
        this.name = name;
        this.chapNo = chapNo;
        this.url = url;
        this.fullContent = fullContent;
       
    }

    
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getChapterId() {
        return chapterId;
    }

    public void setChapterId(Long chapterId) {
        this.chapterId = chapterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChapNo() {
        return chapNo;
    }

    public void setChapNo(int chapNo) {
        this.chapNo = chapNo;
    }

    public String getFullContent() {
        return fullContent;
    }

    public void setFullContent(String fullContent) {
        this.fullContent = fullContent;
    }

     public Literature getlDetails() {
        return lDetails;
    }

    public void setlDetails(Literature lDetails) {
        this.lDetails = lDetails;
    }

 
    public List<SubChapters> getSub_chapters() {
        return sub_chapters;
    }

    public void setSub_chapters(List<SubChapters> sub_chapters) {
        this.sub_chapters = sub_chapters;
    }

    
       public void addSubChapters(SubChapters s)
    {
        s.setCDetails(this);
        sub_chapters.add(s);      
    }
     @Override
    public String toString() {
        return "Chapter{" + "chapterId=" + chapterId + ", name=" + name + ", chapNo=" + chapNo + ", fullContent=" + fullContent + '}';
    }
}
