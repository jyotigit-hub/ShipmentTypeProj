package in.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IshipmentTypeDao;
import in.nit.model.ShipmentType;

@Service
public class ShipmentTypeServiceImpl implements IShipmentTypeService {
	@Autowired
	IshipmentTypeDao dao;

	@Transactional
	@Override
	public Integer saveShipmentType(ShipmentType sp) {

		return dao.saveShipmentType(sp);
	}

	@Transactional(readOnly = true)
	@Override
	public List<ShipmentType> getAllShipmentType() {

		return dao.getAllShipmentType();
	}

	@Transactional
	@Override
	public void deleteShipmentType(Integer id) {
		dao.deleteShipmentType(id);

	}
	
@Transactional(readOnly = true)
	@Override
	public ShipmentType getOneShipmentType(Integer id) {
		// TODO Auto-generated method stub
		return dao.getOneShipmentType(id);
	}
@Transactional
	@Override
	public void updateShipmentType(ShipmentType st) {
		dao.updateShipmentType(st);
		
	}
}
