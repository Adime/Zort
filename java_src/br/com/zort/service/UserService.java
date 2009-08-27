package br.com.zort.service;

import java.util.ArrayList;
import java.util.List;

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
		user = userDAO.addUser(user);
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
		r.setLevel(0);
		
		return robotDAO.saveOrUpdate(r);
	}
	
	public List<Item> getStoreItems()
	{
		return itemDAO.getStoreItems();
	}
	public Robot saveRobot(Robot r)
	{
		return robotDAO.saveOrUpdate(r);
	}
	
}
