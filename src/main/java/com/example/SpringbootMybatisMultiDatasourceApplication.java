package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.dao1.Db1Mapper;
import com.example.dao2.Db2Mapper;

@SpringBootApplication
public class SpringbootMybatisMultiDatasourceApplication implements CommandLineRunner{
	@Autowired
	private Db1Mapper db1Mapper;
	
	@Autowired
	private Db2Mapper db2Mapper;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootMybatisMultiDatasourceApplication.class, args);
	}
	
	@Override
    public void run(String... args) throws Exception {
        System.out.println("table create");
		db1Mapper.createTbl();
        db2Mapper.createTbl();
        
        System.out.println("table search");
        System.out.println("db1 count=" + db1Mapper.getCount());
        System.out.println("db2 count=" + db2Mapper.getCount());
    }
}
