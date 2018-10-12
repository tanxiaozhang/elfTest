package com.wux.rcb.elf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@MapperScan("com.wux.rcb.elf.biz.dao")
public class ElfApplication  {

	public static void main(String[] args) {
		SpringApplication.run(ElfApplication.class, args);
	}
}
