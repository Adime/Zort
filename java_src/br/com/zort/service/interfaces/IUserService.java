package br.com.zort.service.interfaces;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.zort.model.Item;
import br.com.zort.model.User;

public interface IUserService {
	
	@Transactional(propagation = Propagation.REQUIRED)
	void saveUser(User user);
	
	@Transactional(readOnly = true)
	User getUserByLoginAndPass(String login, String pass);

	@Transactional(readOnly = true)
	List<Item> getStoreItems();
}