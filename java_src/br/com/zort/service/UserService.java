package br.com.zort.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zort.dao.ItemDAO;
import br.com.zort.dao.RobotDAO;
import br.com.zort.dao.SkillDAO;
import br.com.zort.dao.UserDAO;
import br.com.zort.model.Item;
import br.com.zort.model.Robot;
import br.com.zort.model.Skill;
import br.com.zort.model.User;
import br.com.zort.service.interfaces.IUserService;

@Service
public class UserService implements IUserService{
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private SkillDAO skillDAO;

	@Autowired
	private RobotDAO robotDAO;
	
	@Autowired
	private ItemDAO itemDAO;

	public User getUserByLoginAndPass(String login, String pass) {
		User u = userDAO.getUserByLoginAndPass(login, pass);
		if (u != null)
		{
			u.getRobot().getSkills().size();
			u.getItems().size();
		}
		return u;
	}

	public void saveUser(User user) {
		user.setRobot(createRobot());
		user.setMoney(1000);
		user = userDAO.addOrUpdate(user);
		createSkills(user);
	}
	
	private void createSkills(User user) {
		List<Skill> skills = new ArrayList<Skill>();
		
		Skill s1 = new Skill();
		s1.setAttack(20);
		s1.setCastTime(3);
		s1.setDefense(0);
		s1.setDelayTime(3);
		s1.setDescription("Golpe fraco");
		s1.setName("Golpe fraco");
		s1.setRobot(user.getRobot());
		
		Skill s2 = new Skill();
		s2.setAttack(35);
		s2.setCastTime(5);
		s2.setDefense(0);
		s2.setDelayTime(5);
		s2.setDescription("Golpe forte");
		s2.setName("Golpe forte");
		s2.setRobot(user.getRobot());
		
		skills.add(s1);
		skills.add(s2);
		
		skillDAO.saveOrUpdate(skills);
	}

	private Robot createRobot()
	{
		Robot r = new Robot();
		r.setHp(200);
		r.setImage("robo1");
		r.setLevel(1);
		
		return robotDAO.saveOrUpdate(r);
	}
	
	public List<Item> getStoreItems()
	{
		return itemDAO.getStoreItems();
	}
	public List<Item> getItemsByUser(User u)
	{
		return itemDAO.getItemByUser(u);
	}
	public Robot saveRobot(Robot r)
	{
		return robotDAO.saveOrUpdate(r);
	}
	public void buyItem(User u, Item i)
	{
		i.setIdNull();
		i.setUser(u);
		
		Integer newMoney = u.getMoney() - i.getPrice();
		u.setMoney(newMoney);
		
		itemDAO.saveOrUpdate(i);
		userDAO.addOrUpdate(u);
	}
	public void removeItemFromUser(Item i)
	{
		i.setUser(null);
		itemDAO.saveOrUpdate(i);
	}

	public User setUserLose(User u, Integer money) {
		u.setLoses(u.getLoses() + 1);
		u.setMoney(u.getMoney() - money);
		return userDAO.addOrUpdate(u);
	}

	public User setUserWin(User u, Integer money, Integer enemyLevel) {
		u.setWins(u.getWins() + 1);
		Random r = new Random(System.currentTimeMillis());
		money += r.nextInt(enemyLevel) * 100;
		u.setMoney(u.getMoney() + money);
		return userDAO.addOrUpdate(u);
	}
	
}
