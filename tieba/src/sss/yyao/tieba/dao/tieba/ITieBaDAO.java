package sss.yyao.tieba.dao.tieba;

import java.util.List;

import sss.yyao.tieba.entity.TieBa;
import sss.yyao.tieba.exception.DAOException;

public interface ITieBaDAO {

	List<TieBa> findTieBaByName(String name, int page, int pageSize) throws DAOException;

	int findCountByName(String name) throws DAOException;
	
	void addTieBa(TieBa tieBa) throws DAOException;
	
	TieBa findTieBaById(int id) throws DAOException;

}
