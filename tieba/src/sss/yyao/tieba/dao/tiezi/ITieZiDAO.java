package sss.yyao.tieba.dao.tiezi;

import java.util.List;

import sss.yyao.tieba.entity.TieZi;
import sss.yyao.tieba.exception.DAOException;

public interface ITieZiDAO {
	
	List<TieZi> findTieZiList(int tieBaId, int page, int pageSize) throws DAOException;
	
	int findCountByTieBaId(int tieBaId) throws DAOException;
	
	void addTieZi(int tieBaId, TieZi tieZi) throws DAOException;
	
	TieZi findTieZiById(int tieBaId, int tieZiId) throws DAOException;
	
}
