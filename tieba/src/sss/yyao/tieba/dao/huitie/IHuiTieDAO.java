package sss.yyao.tieba.dao.huitie;

import java.util.List;

import sss.yyao.tieba.entity.HuiTie;
import sss.yyao.tieba.exception.DAOException;

public interface IHuiTieDAO {

	List<HuiTie> findHuiTies(int tieBaId, int tieZiId, int page, int pageSize) throws DAOException;
	
	int findCount(int tieBaId, int tieZiId) throws DAOException;
	
	void addHuiTie(int tieBaId, int tieZiId, HuiTie huiTie) throws DAOException;
	
	int findCountNotfinf(int tieBaId, int tieZiId) throws DAOException;
	
	List<HuiTie> findFinf(int tieBaId, int tieZiId, int finfTieId) throws DAOException;
	
	int findFinfCount (int tieBaId, int tieZiId, int finfTieId) throws DAOException;
	
}
