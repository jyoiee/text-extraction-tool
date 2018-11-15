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
import javax.persistence.Index;
import javax.persistence.Table;
import org.hibernate.annotations.Type;

/**
 *
 * @author hcdc-pc15
 */
@Entity
@Table(name = "dictionary",
        indexes = {
            @Index(name = "moolshabd_index", columnList = "moolshabd", unique = false),
            @Index(name = "meaning_index", columnList = "meaning", unique = false)})
public class Dictionary implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Type(type = "text")
    @Column(name = "head_word_type")
    private String headWordType;

    @Type(type = "text")
    @Column(name = "moolshabd")
    private String dictionaryEntry;

    @Type(type = "text")
    @Column(name = "dictionary_entry_with")
    private String dictionaryEntryWith;

    @Type(type = "text")
    @Column(name = "pos_tag")
    private String postag;

    @Type(type = "text")
    @Column(name = "grammatical_info")
    private String grammaticalInfo;

    @Type(type = "text")
    @Column(name = "etymology")
    private String etymology;

    @Type(type = "text")
    @Column(name = "meaning")
    private String meaning;

    @Type(type = "text")
    @Column(name = "hindi_gender")
    private String hindiGender;

    @Type(type = "text")
    @Column(name = "illustration_reference")
    private String illustration;

    @Type(type = "text")
    @Column(name = "extra_info")
    private String extraInfo;

    public Dictionary() {

    }

    public Dictionary(String headWordType, String dictionaryEntry, String dictionaryEntryWith, String postag, String grammaticalInfo, String etymology, String meaning, String hindiGender, String illustration, String extraInfo) {
        this.headWordType = headWordType;
        this.dictionaryEntry = dictionaryEntry;
        this.dictionaryEntryWith = dictionaryEntryWith;
        this.postag = postag;
        this.grammaticalInfo = grammaticalInfo;
        this.etymology = etymology;
        this.meaning = meaning;
        this.hindiGender = hindiGender;
        this.illustration = illustration;
        this.extraInfo = extraInfo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHeadWordType() {
        return headWordType;
    }

    public void setHeadWordType(String headWordType) {
        this.headWordType = headWordType;
    }

    public String getDictionaryEntry() {
        return dictionaryEntry;
    }

    public void setDictionaryEntry(String dictionaryEntry) {
        this.dictionaryEntry = dictionaryEntry;
    }

    public String getDictionaryEntryWith() {
        return dictionaryEntryWith;
    }

    public void setDictionaryEntryWith(String dictionaryEntryWith) {
        this.dictionaryEntryWith = dictionaryEntryWith;
    }

    public String getPostag() {
        return postag;
    }

    public void setPostag(String postag) {
        this.postag = postag;
    }

    public String getGrammaticalInfo() {
        return grammaticalInfo;
    }

    public void setGrammaticalInfo(String grammaticalInfo) {
        this.grammaticalInfo = grammaticalInfo;
    }

    public String getEtymology() {
        return etymology;
    }

    public void setEtymology(String etymology) {
        this.etymology = etymology;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getHindiGender() {
        return hindiGender;
    }

    public void setHindiGender(String hindiGender) {
        this.hindiGender = hindiGender;
    }

    public String getIllustration() {
        return illustration;
    }

    public void setIllustration(String illustration) {
        this.illustration = illustration;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dictionary)) {
            return false;
        }
        Dictionary other = (Dictionary) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dictionary{" + "id=" + id + ", headWordType=" + headWordType + ", dictionaryEntry=" + dictionaryEntry + ", dictionaryEntryWith=" + dictionaryEntryWith + ", postag=" + postag + ", grammaticalInfo=" + grammaticalInfo + ", etymology=" + etymology + ", meaning=" + meaning + ", hindiGender=" + hindiGender + ", illustration=" + illustration + ", extraInfo=" + extraInfo + '}';
    }

}
