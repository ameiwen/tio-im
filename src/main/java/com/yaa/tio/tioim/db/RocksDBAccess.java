package com.yaa.tio.tioim.db;

import com.google.common.base.Optional;
import com.yaa.tio.tioim.conf.RocksDbProperties;
import com.yaa.tio.tioim.conf.TioProperties;
import com.yaa.tio.tioim.web.model.Account;
import com.yaa.tio.tioim.util.SerializeUtils;
import org.rocksdb.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * RocksDB 操作封装
 */
@Component
public class RocksDBAccess implements DBAccess {

	static Logger logger = LoggerFactory.getLogger(RocksDBAccess.class);

	/**
	 * 存储用户信息 前缀
	 */
	public static final String ACCOUNT_BUCKET_PREFIX = "accounts_";

	/**
	 * 存储用户UID
	 */
	public static final String ACCOUNT_UID_PREFIX = "uids_";



	private RocksDB rocksDB;

	@Autowired
	private RocksDbProperties rocksDbProperties;

	@Autowired
	private TioProperties tioProperties;


	public RocksDBAccess() {
		//
	}

	/**
	 * 初始化RocksDB
	 */
	@PostConstruct
	public void initRocksDB() {

		try {
			//如果数据库路径不存在，则创建路径
			File directory = new File(System.getProperty("user.dir")+"/"+rocksDbProperties.getDataDir());
			if (!directory.exists()) {
				directory.mkdirs();
			}
			rocksDB = RocksDB.open(new Options().setCreateIfMissing(true), rocksDbProperties.getDataDir());
		} catch (RocksDBException e) {
			e.printStackTrace();
		}
	}



//----------------------------------用户相关操作
	@Override
	public String getAccountUid(String username, String password) {
		Optional<Object> object = this.get(ACCOUNT_UID_PREFIX + username + password);
		if (object.isPresent()) {
			return (String) object.get();
		}
		return null;
	}

	@Override
	public boolean putAccount(Account account) {
		if(this.put(ACCOUNT_BUCKET_PREFIX + account.getUid(), account)){
			return this.put(ACCOUNT_UID_PREFIX + account.getUsername() + account.getPassword(), account.getUid());
		}
		return false;
	}

	@Override
	public Account getAccount(String uid) {
		Optional<Object> object = this.get(ACCOUNT_BUCKET_PREFIX + uid);
		if (object.isPresent()) {
			return (Account) object.get();
		}
		return null;
	}

	@Override
	public List<Account> listAccounts() {
		List<Object> objects = seekByKey("");
		List<Account> accounts = new ArrayList<>();
		for (Object o : objects) {
			accounts.add((Account) o);
		}
		return accounts;
	}



	@Override
	public void closeDB() {
		if (null != rocksDB) {
			rocksDB.close();
		}
	}

	@Override
	public boolean put(String key, Object value) {
		try {
			rocksDB.put(key.getBytes(), SerializeUtils.serialize(value));
			return true;
		} catch (Exception e) {
			if (logger.isDebugEnabled()) {
				logger.error("ERROR for RocksDB : {}", e);
			}
			return false;
		}
	}

	@Override
	public Optional<Object> get(String key) {
		try {
			return Optional.of(SerializeUtils.unSerialize(rocksDB.get(key.getBytes())));
		} catch (Exception e) {
			if (logger.isDebugEnabled()) {
				logger.error("ERROR for RocksDB : {}", e);
			}
			return Optional.absent();
		}
	}

	@Override
	public boolean delete(String key) {
		try {
			rocksDB.delete(key.getBytes());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public <T> List<T> seekByKey(String keyPrefix) {
		ArrayList<T> ts = new ArrayList<>();
		RocksIterator iterator = rocksDB.newIterator(new ReadOptions());
		byte[] key = keyPrefix.getBytes();
		for (iterator.seek(key); iterator.isValid(); iterator.next()) {
			ts.add((T) SerializeUtils.unSerialize(iterator.value()));
		}
		return ts;
	}
}
