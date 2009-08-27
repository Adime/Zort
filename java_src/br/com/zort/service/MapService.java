package br.com.zort.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zort.dao.MapDAO;
import br.com.zort.model.Map;
import br.com.zort.model.MapTile;
import br.com.zort.service.interfaces.IMapService;

@Service
public class MapService implements IMapService {

	@Autowired
	private MapDAO mapDAO;

	public void addOrUpdate(Map map) {
		for (MapTile mt : map.getTiles())
		{
			mt.setMap(map);
			if (mt.getTeleport() != null)
			{
				mt.getTeleport().setTile(mt);
			}
		}
		mapDAO.addOrUpdate(map);
	}

	public Map getMapById(Integer id) {
		return mapDAO.getMapById(id);
	}
}
