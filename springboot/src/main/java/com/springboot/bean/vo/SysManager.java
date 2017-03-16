package com.springboot.bean.vo;

/**
 * 
 * @ClassName: SysManager
 * @Description: 管理员持久化对象
 * @author chenjl
 * @date 2017-3-16 下午11:24:45
 * 
 */
public class SysManager {
	private String id;// id
	private String username; // 姓名
	private String password; // 密码

	public SysManager() {
		super();
	}

	public SysManager(String id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
