package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.service.DbService;

@Controller
public class DbController {
    @Autowired
    DbService dbService;
     
    @RequestMapping("/")
    public @ResponseBody String root_test() throws Exception{  
        return "Hello World";
    }
 
    @RequestMapping("/db1")
    public @ResponseBody String db1() throws Exception{
        return dbService.getDb1Dual();
    }
     
    @RequestMapping("/db2")
    public @ResponseBody String db2() throws Exception{
        return dbService.getDb2Dual();
    }
    
    @RequestMapping("/transaction")
    public @ResponseBody String transaction() throws Exception{
    	
    	dbService.transactionTest(true);
    	
    	// rollback
    	System.out.println("- rollaback");    	
		dbService.transactionTest(false);
    	return "ok";
    }
}
