package br.com.zort.service.interfaces;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import br.com.zort.model.Tile;

public interface ITileService {
	
	@Transactional(readOnly = true)
	List<Tile> getAllTiles();
	
}
