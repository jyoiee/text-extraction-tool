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
@Table(name="language")
public class Language implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="language_id")
    private Long id;
   
    @Column(name="Language_name")
    private String lang;
    
    @Column(name="Lang_en_name")
    private String lang_english;

    public Language() {
    }

    
    public Language(String lang, String lang_english) {
        this.lang = lang;
        this.lang_english = lang_english;
    }
    
    @OneToMany(mappedBy="language",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Literature> literature = new ArrayList<>();

     public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }


    public String getLang_english() {
        return lang_english;
    }

    public void setLang_english(String lang_english) {
        this.lang_english = lang_english;
    }

    public List<Literature> getLiterature() {
        return literature;
    }

    public void setLiterature(List<Literature> literature) {
        this.literature = literature;
    }
   
   public void addLanguage(Literature lit)
    {
        lit.setLanguage(this);
        literature.add(lit);
        
    }
    @Override
    public String toString() {
        return "in.cdac.hcdc.tet.Models.Language[ id=" + id + " ]";
    }
    
}
