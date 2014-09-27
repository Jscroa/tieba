package sss.yyao.tieba.dao.tieba;

import java.util.List;

import sss.yyao.tieba.entity.TieBa;
import sss.yyao.tieba.exception.DAOException;

public class MySQLTieBaDAOImpl implements ITieBaDAO {

	@Override
	public List<TieBa> findTieBaByName(String name, int page, int pageSize) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findCountByName(String name)
			throws DAOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addTieBa(TieBa tieBa) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TieBa findTieBaById(int id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
