package in.nit.dao;


import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.model.ShipmentType;
@Repository
public class ShipmentTypeDaoImpl implements IshipmentTypeDao {
	@Autowired
	HibernateTemplate ht;

	@Override
	public Integer saveShipmentType(ShipmentType sp) {
		return (Integer) ht.save(sp);
		
	}
	@Override
	public List<ShipmentType> getAllShipmentType() {
		
		 List<ShipmentType> list=ht.loadAll(ShipmentType.class);
		Collections.sort(list,(o1,o2)->o1.getShipId()-o2.getShipId());
		 return list;
	}
@Override
public void deleteShipmentType(Integer id) {
	ht.delete(new ShipmentType(id));

}
@Override
public ShipmentType getOneShipmentType(Integer id) {
	
	return ht.get(ShipmentType.class, id);
}
@Override
public void updateShipmentType(ShipmentType st) {
ht.update(st);
	
}
}
