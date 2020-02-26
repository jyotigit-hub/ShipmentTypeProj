package in.nit.dao;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.model.OrderMethod;
@Repository
public class OrderMethodDaoImpl implements IOrderMethodDao {
@Autowired
HibernateTemplate ht;
	@Override
	public Integer saveOrderMethod(OrderMethod om) {
		
		return (Integer) ht.save(om);
	}

	@Override
	public List<OrderMethod> getAllOrderMethod() {
		List<OrderMethod> list=ht.loadAll(OrderMethod.class);
		Collections.sort(list, (o1,o2)->o1.getOrdId()-o2.getOrdId());
		return list;
	}

	@Override
	public void deleteOrderMethod(Integer id) {
		OrderMethod om=new OrderMethod();
		om.setOrdId(id);
		ht.delete(om);
		
	}
	@Override
		public OrderMethod getOneOrderMethod(Integer id) {
			
			return ht.get(OrderMethod.class, id);
		}

	@Override
	public void updateOrderMethod(OrderMethod om) {
		ht.update(om);
		
	}


}
