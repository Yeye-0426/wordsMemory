package jdbc.dao;

import java.util.List;

import jdbc.entity.User;

public interface UserDao {
	public boolean login(String userEmail, String userPassword);
	public boolean register(User user);
	public List<User> listAll();
	public boolean adduser(User user);
	public boolean deleteuser(Integer user_id);
	public boolean updateuser(User user);
	public User finduserById(Integer user_id);
	public User finduserByEmail(String user_email);
	
}
