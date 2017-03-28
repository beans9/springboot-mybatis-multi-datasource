package com.example.dao1;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface Db1Mapper {
	@Select("SELECT count(*) FROM MEMBER")
	public String getCount(); 
	
	@Insert("INSERT INTO MEMBER (NAME) VALUES (#{name})")
	public void insertMember(String name);
	
	public String getDb1Dual() throws Exception;
	public void createTbl();
}
