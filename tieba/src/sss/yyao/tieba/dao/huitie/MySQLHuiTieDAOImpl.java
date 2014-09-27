package sss.yyao.tieba.dao.huitie;

import java.util.List;

import sss.yyao.tieba.entity.HuiTie;

public class MySQLHuiTieDAOImpl implements IHuiTieDAO {

	@Override
	public List<HuiTie> findHuiTies(int tieBaId, int tieZiId, int page,
			int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findCount(int tieBaId, int tieZiId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addHuiTie(int tieBaId, int tieZiId, HuiTie huiTie) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int findCountNotfinf(int tieBaId, int tieZiId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<HuiTie> findFinf(int tieBaId, int tieZiId, int finfTieId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findFinfCount(int tieBaId, int tieZiId, int finfTieId) {
		// TODO Auto-generated method stub
		return 0;
	}


}
