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
public class UserService implements IUserService {
	
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
		user.setRobot(updateRobot(user.getRobot()));
		user.setMoney(1000);
		user = userDAO.addOrUpdate(user);
		createSkills(user);
	}
	
	private void createSkills(User user) {
		List<Skill> skills = new ArrayList<Skill>();
		
		Skill s1 = new Skill();
		s1.setType("Attack");
		s1.setValue(20);
		s1.setCastTime(3);
		s1.setDelayTime(3);
		s1.setDescription("Golpe fraco");
		s1.setName("Golpe fraco");
		s1.setRobot(user.getRobot());
		
		Skill s2 = new Skill();
		s2.setType("Attack");
		s2.setValue(35);
		s2.setCastTime(5);
		s2.setDelayTime(5);
		s2.setDescription("Golpe forte");
		s2.setName("Golpe forte");
		s2.setRobot(user.getRobot());

		Skill s3 = new Skill();
		s3.setType("Heal");
		s3.setValue(50);
		s3.setCastTime(5);
		s3.setDelayTime(25);
		s3.setDescription("Heal Fraco");
		s3.setName("Heal Fraco");
		s3.setRobot(user.getRobot());
		
		skills.add(s1);
		skills.add(s2);
		skills.add(s3);
		
		skillDAO.saveOrUpdate(skills);
	}

	private Robot updateRobot(Robot r)
	{
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
	public void retrieveItem(User u, Item i)
	{
		i.setUser(u);
		itemDAO.saveOrUpdate(i);
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
		u = updateExpAndHpAndLevel(u, enemyLevel);
		robotDAO.saveOrUpdate(u.getRobot());
		
		u.setMoney(u.getMoney() + money);
		
		return userDAO.addOrUpdate(u);
	}
	
	protected User updateExpAndHpAndLevel(User u, Integer enemyLevel)
	{
		Robot r = u.getRobot();
		Integer exp = r.getExperience() + getExp(r.getLevel(), enemyLevel);
		if (exp > r.getLevel() * 100)
		{
			exp = 0;
			r.setLevel(r.getLevel()+1);
			r.setHp(r.getHp()+25);
		}
		r.setExperience(exp);
		u.setRobot(r);
		return u;
	}
	
	protected Integer getExp(Integer level, Integer enemyLevel)
	{
		return level * enemyLevel;
	}
}
