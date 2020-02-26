package in.nit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nit.dao.IDocumentDao;
import in.nit.model.Document;
@Service
public class DocumentServiceImpl implements IDocumentService {
@Autowired
	IDocumentDao dao;
	@Override
	public Integer saveDocument(Document d) {
		
		return dao.saveDocument(d);
	}

}
