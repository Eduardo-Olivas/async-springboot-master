package com.async.controller;


import com.async.dao.CountriesDao;
import com.async.model.Countries;
import com.async.service.NotificationService;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

	
	private static Logger logJava = Logger.getLogger(NotificationController.class);
	
	@Autowired
	private CountriesDao dao;
	
    @Autowired
    private NotificationService notificationService;

    String info;
    
    @GetMapping("/getid")
    public String get(@RequestParam String ID) {
        notificationService.sendTextMessage(ID);
        logJava.info("GetBy ID ::");
        
        Countries Countries= dao.get(Integer.parseInt(ID));
        String Pais = Countries.toString();
        
        logJava.info(Pais);
        return Pais;
    }
    
    @GetMapping("/getall")
    public String getall() {
       
        logJava.info("GetALL ::");
        
        List<Countries> Countries= dao.list();
        String Paises = Countries.toString();
        
        logJava.info(Paises);
        return Paises;
    }
    
    
    @GetMapping("/insert")
    public String insert(@RequestParam String ID,@RequestParam String Name,@RequestParam String Capital,@RequestParam String Population,@RequestParam String LanguageID) {
    	logJava.info("insert ::");     
    	notificationService.sendInsertMessages(ID,Name,Capital,Population,LanguageID);
  
        Countries Countries = new Countries();
        Countries.setID(ID);
        Countries.setName(Name);
        Countries.setCapital(Capital);
        Countries.setPopulation(Integer.parseInt(Population));
        Countries.setLanguageID(Integer.parseInt(LanguageID));
        
        dao.save(Countries);      
        
        info = "insert successfully!!! : " + Thread.currentThread().getName();
        logJava.info(info);
        
        return info;
    }
    
    
    @GetMapping("/put")
    public String put(@RequestParam String ID,@RequestParam String Name,@RequestParam String Capital,@RequestParam String Population,@RequestParam String LanguageID) {
    	
    	logJava.info("update ::");     
    	notificationService.sendInsertMessages(ID,Name,Capital,Population,LanguageID);
  
        Countries Countries = new Countries();
        Countries.setID(ID);
        Countries.setName(Name);
        Countries.setCapital(Capital);
        Countries.setPopulation(Integer.parseInt(Population));
        Countries.setLanguageID(Integer.parseInt(LanguageID));
        
        dao.update(Countries);      
       
        info = "update successfully!!! "+ Thread.currentThread().getName();
        logJava.info(info);
        return info;
    }
    
    
    @GetMapping("/delete")
    public  String delete(@RequestParam String ID) {
        logJava.info("delete ::");
        
        notificationService.sendTextMessage(ID);
        
        dao.delete(Integer.parseInt(ID));       
        
        info = "Delete successfully!!! : " + Thread.currentThread().getName();
        logJava.info(info);
        
        return info;
    }
    
}
