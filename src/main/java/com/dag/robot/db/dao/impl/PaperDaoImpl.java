package com.dag.robot.db.dao.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.dag.robot.db.dao.PaperDao;
import com.dag.robot.entities.Expert;
import com.dag.robot.entities.Paper;
import com.dag.robot.entities.RelExpertPaper;
import com.dag.robot.entities.RelPaperJournal;
import com.dag.robot.utils.EntitiesForListUtil;
import com.dag.robot.web.bean.ExpertForList;
import com.dag.robot.web.bean.Page;
import com.dag.robot.web.bean.PaperForList;

@Repository("paperDao")
public class PaperDaoImpl extends BaseDao implements PaperDao {

	@Override
	public void addPaper(Paper paper) {
		save(paper);
	}

	@Override
	public void updatePaper(Paper paper) {
		update(paper);
	}

	@Override
	public Paper getById(int paperId) {
		return get(Paper.class,paperId);
	}

	@Override
	public List<Paper> getAllPapers() {
		return getAll("Paper");
	}

	@Override
	public void deletePaper(Paper paper) {
		
		Iterator<?> iterator;

		Set<RelExpertPaper> relExpertPapers = paper.getRelExpertPapers();		
		iterator = relExpertPapers.iterator();
		while(iterator.hasNext()){
			RelExpertPaper relExpertPaper = (RelExpertPaper) iterator.next();
			delete(relExpertPaper);
		}
		
		Set<RelPaperJournal> relPaperJournals = paper.getRelPaperJournals();
		iterator = relPaperJournals.iterator();
		while (iterator.hasNext()) {
			RelPaperJournal relPaperJournal = (RelPaperJournal) iterator.next();
			delete(relPaperJournal);
		}
		
		delete(paper);
	}

	@Override
	public Page<PaperForList> page(int pageSize, int currenPage) {

		Query query = query("select count(*) from Paper");
		Long totalCount =  (Long) query.uniqueResult();
		Page<PaperForList> page = new Page<PaperForList>(currenPage, pageSize, totalCount);
		page.init();
		query = query("from Paper");
		query.setFirstResult((currenPage-1) * pageSize);
		query.setMaxResults(pageSize);
		List<Paper> papers = query.list();
		List<PaperForList> paperForLists = EntitiesForListUtil.paperForLists(papers);
		page.setList(paperForLists);
		return page;
	}
	
}
