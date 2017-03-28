package com.example.dao2;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface Db2Mapper {
	@Select("SELECT count(*) FROM MEMBER")
	public String getCount();

	@Insert("INSERT INTO MEMBER (NAME) VALUES (#{name})")
	public void insertMember(String name);
	
	public String getDb2Dual() throws Exception;
	public void createTbl();
}
