package br.com.zort.service.interfaces;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.zort.model.Item;
import br.com.zort.model.Robot;
import br.com.zort.model.User;

public interface IUserService {
	
	@Transactional(propagation = Propagation.REQUIRED)
	void saveUser(User user);
	
	@Transactional(readOnly = true)
	User getUserByLoginAndPass(String login, String pass);

	@Transactional(readOnly = true)
	List<Item> getStoreItems();
	
	@Transactional(propagation = Propagation.REQUIRED)
	Robot saveRobot(Robot r);
	
	@Transactional(readOnly = true)
	List<Item> getItemsByUser(User u);

	@Transactional(readOnly = true)
	Item getItemById(Integer id);

	@Transactional(propagation = Propagation.REQUIRED)
	void buyItem(User u, Item i);
	
	@Transactional(propagation = Propagation.REQUIRED)
	void removeItemFromUser(Item i);

	@Transactional(propagation = Propagation.REQUIRED)
	User setUserWin(User u, Integer money, Integer enemyLevel);

	@Transactional(propagation = Propagation.REQUIRED)
	User setUserLose(User u, Integer money);
	
	@Transactional(propagation = Propagation.REQUIRED)
	void retrieveItem(User u, Item i);
	
	@Transactional(propagation = Propagation.REQUIRED)
	String enviaSMS(User u, String destin, String message) throws Exception;

	@Transactional(propagation = Propagation.REQUIRED)
	void sendItemToUser(Integer itemId, String userName);
	
	@Transactional(readOnly = true)
	void sendMessage(User u, String destName, String msg);
}
