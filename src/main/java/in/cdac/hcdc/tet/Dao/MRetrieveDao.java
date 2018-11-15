/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.cdac.hcdc.tet.Dao;

import in.cdac.hcdc.tet.Models.Chapter;
import in.cdac.hcdc.tet.Models.Speakers;
import in.cdac.hcdc.tet.Models.SubChapters;
import in.cdac.hcdc.tet.Models.Verse;
import java.util.List;
import java.util.Map;

/**
 *
 * @author hcdc-pc15
 */
public interface MRetrieveDao {

    public List<Chapter> getChapters(Long id);

    public List<Verse> getContent(Long id, Long speakerId);

    public List<Chapter> getChapterContent(Long id);

    public List<SubChapters> getSubChapterNames(Long chapterId);

    public Map<Long, String> getSpeakers(Long subchapterId);

    public List<String> getverses(Long chapterId);

    public Map<Long, List<Verse>> getVersesWithMetadata(Long speakerId, Long chapterId);

    public List<Speakers> getTotalSpeakers(int pageid,int total);
    
     public List<Verse> getCharacterWiseContents(Long speakerId );
     
         public List<Verse> getCharWiseContent(Long speakerId,int pageid,int total);
         
         public List<Verse> getverse(Long chapterId);
         
     public List<Verse> pagination(Long SubchapterId, int pageid, int total);
}
