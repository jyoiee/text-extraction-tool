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
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="author_id")
    private Long authorid;

    @Column(name="author_name")
    private String name;

    @OneToMany(mappedBy="autherDetails",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Literature> literature = new ArrayList<>();
    
    public Author() {
    }

    
    public Author(String name) {
        this.name = name;
    }
   
    public Long getAuthorId() {
        return authorid;
    }

    public void setAuthorId(Long authorid) {
        this.authorid = authorid;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public List<Literature> getLiterature() {
        return literature;
    }

    public void setLiterature(List<Literature> literature) {
        this.literature = literature;
    }

    public void addLiterature(Literature lit)
    {
        lit.setAutherDetails(this);
        literature.add(lit);
        
    }
    
    @Override
    public String toString() {
        return "Auther{" + "authorid=" + authorid + ", name=" + name + ", " + '}';
    }    
}
