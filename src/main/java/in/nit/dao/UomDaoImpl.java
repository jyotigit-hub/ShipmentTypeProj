package in.nit.dao;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.model.Uom;
@Repository
public class UomDaoImpl implements IUomDao {
	@Autowired
HibernateTemplate ht;
	@Override
	public Integer saveUom(Uom uom) {
		
		return (Integer) ht.save(uom);
	}
@Override
public List<Uom> getAllUom() {
	List<Uom> list=ht.loadAll(Uom.class);
	Collections.sort(list,(o1,o2)->o1.getUomID()-o2.getUomID());
	return list;
}
@Override
public void deleteUom(Integer id) {
	ht.delete(new Uom(id));
	
}
}
