package in.nit.dao;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.model.Document;
@Repository
public class DocumentDaoImpl implements IDocumentDao {
	@Autowired
HibernateTemplate ht;
	@Transactional
	@Override
	public Integer saveDocument(Document d) {
		
		return (Integer) ht.save(d);
	}

}
