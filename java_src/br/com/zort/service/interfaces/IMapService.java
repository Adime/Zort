package br.com.zort.service.interfaces;


import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.zort.model.Map;

public interface IMapService {
	
	@Transactional(propagation = Propagation.REQUIRED)
	void addOrUpdate(Map map);

	@Transactional(readOnly = true)
	Map getMapById(Integer id);

}
