package sss.yyao.tieba.dao.tiezi;

import java.util.List;

import sss.yyao.tieba.entity.TieZi;
import sss.yyao.tieba.exception.DAOException;

public class MySQLTieZiDAOImpl implements ITieZiDAO {

	@Override
	public List<TieZi> findTieZiList(int tieBaId, int page, int pageSize)
			throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findCountByTieBaId(int tieBaId) throws DAOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addTieZi(int tieBaId, TieZi tieZi) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TieZi findTieZiById(int tieBaId, int tieZiId) {
		// TODO Auto-generated method stub
		return null;
	}

}
