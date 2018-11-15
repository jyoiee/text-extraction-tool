/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.cdac.hcdc.tet.Service;

import in.cdac.hcdc.tet.Dao.MRetrieveDao;
import in.cdac.hcdc.tet.Models.Chapter;
import in.cdac.hcdc.tet.Models.Speakers;
import in.cdac.hcdc.tet.Models.SubChapters;
import in.cdac.hcdc.tet.Models.Verse;
import java.util.List;
import java.util.Map;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hcdc-pc15
 */
@Service
@Transactional
public class MRetrieveServiceImpl implements MRetrieveService {

    @Autowired
    private MRetrieveDao dao;

    @Override
    public List<Chapter> getChapters(Long id) {
        List<Chapter> chapters = dao.getChapters(id);

        return chapters;
    }

    @Override
    public List<Verse> getContent(Long id, Long speakerId) {

        List<Verse> verses = dao.getContent(id, speakerId);

        return verses;
    }

    @Override
    public List<Chapter> getChapterContent(Long id) {
        List<Chapter> chapters = dao.getChapterContent(id);
        return chapters;

    }

    @Override
    public List<SubChapters> getSubChapterNames(Long chapterId) {
        List<SubChapters> subch = dao.getSubChapterNames(chapterId);
        
        return subch;
    }

    @Override
    public Map<Long, String> getSpeakers(Long subchapterId) {
        Map<Long, String> speakers = dao.getSpeakers(subchapterId);
        return speakers;
    }

    @Override
    public List<String> getverses(Long chapterId) {
        List<String> verses = dao.getverses(chapterId);
        return verses;

    }
@Override
    public List<Verse> getverse(Long chapterId)
    {
        List<Verse> verses = dao.getverse(chapterId);
        return verses;
    
    }

    @Override
    public Map<Long, List<Verse>> getVersesWithMetadata(Long speakerId, Long chapterId) {
        Map<Long, List<Verse>> mVerses = dao.getVersesWithMetadata(speakerId, chapterId);

        return mVerses;
    }

    @Override
    public List<Speakers> getTotalSpeakers(int pageid,int total) {
       List<Speakers> speakers = dao.getTotalSpeakers(pageid,total);
       return speakers;
    }
    
    @Override
     public List<Verse> getCharacterWiseContents(Long speakerId )
     {
         List<Verse> verses = dao.getCharacterWiseContents(speakerId);
         
         return verses;
     }
     
     @Override
    public List<Verse> pagination(Long SubchapterId, int pageid, int total) {
      return dao.pagination(SubchapterId, pageid, total);
    }

    @Override
    public List<Verse> getCharWiseContent(Long speakerId, int pageid, int total) {
        return dao.getCharWiseContent(speakerId, pageid, total);
    }
}
