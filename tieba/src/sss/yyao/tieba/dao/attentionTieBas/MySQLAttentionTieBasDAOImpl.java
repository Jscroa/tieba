package sss.yyao.tieba.dao.attentionTieBas;

import java.util.List;

import sss.yyao.tieba.entity.TieBa;
import sss.yyao.tieba.exception.DAOException;

public class MySQLAttentionTieBasDAOImpl implements IAttentionTieBasDAO {

	@Override
	public void addAttentionTieBas(Integer selfID, Integer tieBaID)
			throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TieBa> findAttentionTieBas(Integer selfID,
			Integer page, Integer pageSize) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer findCountOfAttentionTieBas(Integer selfID)
			throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkAttention(Integer selfID, Integer tieBaID)
			throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

}
