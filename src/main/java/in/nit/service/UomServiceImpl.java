package in.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IUomDao;
import in.nit.model.Uom;
@Service
public class UomServiceImpl implements IUomService {
	
@Autowired
private IUomDao dao;
@Transactional
	@Override
	public Integer saveUom(Uom uom) {
		return dao.saveUom(uom);
	}
@Transactional(readOnly = true)
@Override
	public List<Uom> getAllUom() {
		return dao.getAllUom();
	}
@Transactional

@Override
	public void deleteUom(Integer id) {
		dao.deleteUom(id);
		
	}
}
