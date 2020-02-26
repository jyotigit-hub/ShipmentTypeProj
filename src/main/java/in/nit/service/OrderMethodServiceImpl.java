package in.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IOrderMethodDao;
import in.nit.model.OrderMethod;
@Service
public class OrderMethodServiceImpl implements IOrderMethodService {
    @Autowired
	IOrderMethodDao dao;
    @Transactional
	@Override
	public Integer saveOrderMethod(OrderMethod om) {
		// TODO Auto-generated method stub
		return dao.saveOrderMethod(om);
	}
@Transactional(readOnly = true)
	@Override
	public List<OrderMethod> getAllOrderMethod() {
		// TODO Auto-generated method stub
		return dao.getAllOrderMethod();
	}
@Transactional
	@Override
	public void deleteOrderMethod(Integer id) {
		dao.deleteOrderMethod(id);		
	}
@Transactional(readOnly = true)
@Override
public OrderMethod getOneOrderMethod(Integer id) {
	// TODO Auto-generated method stub
	return dao.getOneOrderMethod(id);
}
@Transactional
@Override
public void updateOrderMethod(OrderMethod om) {
	dao.updateOrderMethod(om);
}

}
