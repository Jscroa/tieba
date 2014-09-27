package sss.yyao.tieba.dao.attentionTieBas;

import java.util.List;

import sss.yyao.tieba.entity.TieBa;
import sss.yyao.tieba.exception.DAOException;

public interface IAttentionTieBasDAO {
	
	void addAttentionTieBas(Integer selfID, Integer tieBaID) throws DAOException;
	
	List<TieBa> findAttentionTieBas(Integer selfID, Integer page, Integer pageSize) throws DAOException;
	
	Integer findCountOfAttentionTieBas(Integer selfID) throws DAOException;
	
	boolean checkAttention(Integer selfID, Integer tieBaID)throws DAOException;
	
}
