package br.com.zort.service.interfaces;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.zort.model.Message;

public interface IMessageService {

	@Transactional(propagation = Propagation.REQUIRED)
	public abstract void addOrUpdate(String dest, String orig, String message);
	
	@Transactional(propagation = Propagation.REQUIRED)
	public abstract List<Message> getMessageByUserName(String userName);
	
	@Transactional(propagation = Propagation.REQUIRED)
	public abstract void delete(Message m);

}