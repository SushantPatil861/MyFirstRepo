package demo;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.support.GenericXmlApplicationContext;

import demo.beans.Customer;
import demo.repo.WalletRepo;
import demo.repo.WalletRepoImpl;
import demo.service.WalletService;
import demo.service.WalletServiceImpl;


public class App {
    public static void main( String[] args ){
    	GenericXmlApplicationContext ctx= new GenericXmlApplicationContext("beanConfig.xml");
    	WalletService service=ctx.getBean("service",WalletService.class);
    	Customer c= service.createAccount("Sagar","9850276767", new BigDecimal(2000));
        
        System.out.println("==============================================");
        System.out.println("Create Account returned :: ");
        System.out.println(c);
        System.out.println();
        System.out.println("==============================================");
        
        System.out.println("Show balance returned :: ");
        System.out.println(service.showBalance("9850276767"));
        System.out.println();
        System.out.println("==============================================");
        
        System.out.println("Deposit returned :: ");
        System.out.println(service.depositAmount("9850276767", new BigDecimal(1500)));
        System.out.println();
        System.out.println("==============================================");
        
        System.out.println("Fund Transfer returned :: ");
        service.createAccount("Renu", "9604744104",new BigDecimal(5000));
        System.out.println(service.fundTransfer("9850276767", "9604744104", new BigDecimal(1500)));
        System.out.println(service.showBalance("9604744104"));
        System.out.println("==============================================");
        
    }
}
