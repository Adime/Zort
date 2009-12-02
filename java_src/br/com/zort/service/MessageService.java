package br.com.zort.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zort.dao.MessageDAO;
import br.com.zort.model.Message;
import br.com.zort.service.interfaces.IMessageService;

@Service
public class MessageService implements IMessageService {
	
	@Autowired
	private MessageDAO messageDAO;
	
	/* (non-Javadoc)
	 * @see br.com.zort.service.IMessageService#addOrUpdate(br.com.zort.model.Message)
	 */
	public void addOrUpdate(String dest, String orig, String message)
	{
		Message m = new Message();
		m.setDest(dest);
		m.setOrig(orig);
		m.setMessage(message);
		
		messageDAO.addOrUpdate(m);
	}
	
	/* (non-Javadoc)
	 * @see br.com.zort.service.IMessageService#getMessageByUserName(java.lang.String)
	 */
	public List<Message> getMessageByUserName(String userName)
	{
		List<Message> messages = messageDAO.getMessagesByUserName(userName);
		
		for (Message m : messages)
		{
			messageDAO.delete(m);
		}
		
		return messages;
	}
	
	/* (non-Javadoc)
	 * @see br.com.zort.service.IMessageService#delete(br.com.zort.model.Message)
	 */
	public void delete(Message m)
	{
		messageDAO.delete(m);
	}

}
