package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.example.dao1.Db1Mapper;
import com.example.dao2.Db2Mapper;

@Service
public class DbService {
	@Autowired
    Db1Mapper db1Mapper;
	
    @Autowired
    Db2Mapper db2Mapper;
 
    /* select dual */
    public String getDb1Dual() throws Exception{
        return db1Mapper.getDb1Dual();
    }
 
    /* select dual */
    public String getDb2Dual() throws Exception{
        return db2Mapper.getDb2Dual();
    }
    
    @Transactional
    public void transactionTest(boolean exceptionFlag ) {
    	db1Mapper.insertMember("test");
    	System.out.println("db1 count=" + db1Mapper.getCount());
    	
    	db1Mapper.insertMember("test");
    	System.out.println("db2 count=" + db1Mapper.getCount());
    	
    	if( exceptionFlag ){
    		TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();    		
    	}
    }
}
