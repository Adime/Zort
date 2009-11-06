package br.com.zort.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zort.dao.TileDAO;
import br.com.zort.model.Tile;
import br.com.zort.service.interfaces.ITileService;

@Service
public class TileService implements ITileService {

	@Autowired
	private TileDAO tileDAO;
	
	public List<Tile> getAllTiles() {
		return tileDAO.getAllTiles();
	}
	
}
