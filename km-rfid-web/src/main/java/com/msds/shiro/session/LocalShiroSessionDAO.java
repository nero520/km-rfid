package com.msds.shiro.session;   

import java.io.Serializable;
import java.util.Collection;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 创建时间：2014-10-20 下午2:20:00 
 * 项目名称：car_zone_web 
 * @author lizhe  
 * @version 1.0   
 * @since JDK 1.6.0_21  
 */
@Service
public class LocalShiroSessionDAO extends AbstractSessionDAO{

	@Autowired
	private LocalSessionManaer localSessionManaer;
	
	public LocalSessionManaer getLocalSessionManaer() {
		return localSessionManaer;
	}

	public void setLocalSessionManaer(LocalSessionManaer localSessionManaer) {
		this.localSessionManaer = localSessionManaer;
	}
	
	
    @Override  
    public void update(Session session) throws UnknownSessionException {  
    	getLocalSessionManaer().saveSession(session);  
    }  
  
    @Override  
    public void delete(Session session) {  
        if (session == null) {   
            return;  
        }  
        Serializable id = session.getId();  
        if (id != null)  
        	getLocalSessionManaer().deleteSession(id);  
    }  
  
    @Override  
    public Collection<Session> getActiveSessions() {  
        return getLocalSessionManaer().getAllSessions();  
    }  
  
    @Override  
    protected Serializable doCreate(Session session) {  
        Serializable sessionId = this.generateSessionId(session);  
        this.assignSessionId(session, sessionId);  
        getLocalSessionManaer().saveSession(session);  
        return sessionId;  
    }  
  
    @Override  
    protected Session doReadSession(Serializable sessionId) {  
        return getLocalSessionManaer().getSession(sessionId);  
    }  

}
  
