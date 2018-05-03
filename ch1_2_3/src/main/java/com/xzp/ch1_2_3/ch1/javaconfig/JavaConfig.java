package com.xzp.ch1_2_3.ch1.javaconfig;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 基于Java配置的方式，实现依赖注入
 */
@Configuration //1
public class JavaConfig {

    @Bean
    public FunctionService functionService(){
        return new FunctionService();
    }

    @Bean
    public UseFunctionService useFunctionService(){
        UseFunctionService useFunctionService = new UseFunctionService();
        useFunctionService.setFunctionService(functionService()); //3
        return useFunctionService;

    }

//	@Bean
//	public UseFunctionService useFunctionService(FunctionService functionService){//4
//		UseFunctionService useFunctionService = new UseFunctionService();
//		useFunctionService.setFunctionService(functionService);
//		return useFunctionService;
//	}
}