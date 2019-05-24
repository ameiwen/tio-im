package com.yaa.tio.tioim.db;

import com.google.common.base.Optional;
import com.yaa.tio.tioim.web.model.Account;

import java.util.List;

/**
 * 数据库操作接口
 * @author yangjian
 * @since 18-4-10
 */
public interface DBAccess {


//---------------------------------------------------用户相关操作
	/**
	 * 获取用户UID
	 * @param username
	 * @param password
	 * @return
	 */
	String getAccountUid(String username,String password);

	/**
	 * 添加一个用户
	 * @param account
	 * @return
	 */
	boolean putAccount(Account account);


	/**
	 * 获取指定的用户
	 * @param uid
	 * @return
	 */
	Account getAccount(String uid);

	/**
	 * 获取用户列表
	 * @return
	 */
	List<Account> listAccounts();

	/**
	 * 关闭数据库
	 */
	void closeDB();


	/**
	 * 往数据库添加|更新一条数据
	 * @param key
	 * @param value
	 * @return
	 */
	boolean put(String key, Object value);

	/**
	 * 获取某一条指定的数据
	 * @param key
	 * @return
	 */
	Optional<Object> get(String key);

	/**
	 * 删除一条数据
	 * @param key
	 * @return
	 */
	boolean delete(String key);

	/**
	 * 根据前缀搜索
	 * @param keyPrefix
	 * @return
	 */
	<T> List<T> seekByKey(String keyPrefix);

}
