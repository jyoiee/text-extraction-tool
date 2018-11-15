/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.cdac.hcdc.tet.controller;

import in.cdac.hcdc.tet.Models.Speakers;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Harshada
 */
@Controller
public class AnyWhereSearchController {

    @Autowired
    private SessionFactory sf;

    @Transactional
    public void indexSpeakers() throws Exception {
        try {
            Session session = sf.getCurrentSession();

            FullTextSession fullTextSession = Search.getFullTextSession(session);
            fullTextSession.createIndexer().startAndWait();
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional
    public List<Speakers> searchForSpeakers(String searchText) throws Exception {
        try {
            Session session = sf.getCurrentSession();

            FullTextSession fullTextSession = Search.getFullTextSession(session);

            QueryBuilder qb = fullTextSession.getSearchFactory()
                    .buildQueryBuilder().forEntity(Speakers.class).get();

            org.apache.lucene.search.Query query = qb
                    .keyword().onFields("name")
                    .matching(searchText)
                    .createQuery();

            org.hibernate.Query hibQuery
                    = fullTextSession.createFullTextQuery(query, Speakers.class);

            List<Speakers> results = hibQuery.list();
            return results;
        } catch (Exception e) {
            throw e;
        }
    }
}
