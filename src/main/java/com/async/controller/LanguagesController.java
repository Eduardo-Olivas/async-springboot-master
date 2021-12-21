package com.async.controller;


import com.async.dao.LanguagesDao;
import com.async.model.Languages;
import com.async.service.NotificationService;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LanguagesController {

	
	private static Logger logJava = Logger.getLogger(LanguagesController.class);
	
	@Autowired
	private LanguagesDao dao;
	
    @Autowired
    private NotificationService notificationService;

    String info;
    
    @GetMapping("/getid")
    public String get(@RequestParam String ID) {
        notificationService.sendTextMessage(ID);
        logJava.info("GetBy ID ::");
        
        Languages Languages= dao.get(Integer.parseInt(ID));
        String Lenguaje = Languages.toString();
        
        logJava.info(Lenguaje);
        return Lenguaje;
    }
    
    @GetMapping("/getall")
    public String getall() {
       
        logJava.info("GetALL ::");
        
        List<Languages> Languages= dao.list();
        String Paises = Languages.toString();
        
        logJava.info(Paises);
        return Paises;
    }
    
    
    @GetMapping("/insert")
    public String insert(@RequestParam String ID,@RequestParam String Name) {
    	logJava.info("insert ::");     
    	//notificationService.sendInsertMessages(ID,Name);
  
        Languages Languages = new Languages();
        Languages.setID(Integer.parseInt(ID));
        Languages.setName(Name);
        
        dao.save(Languages);      
        
        info = "insert successfully!!! : " + Thread.currentThread().getName();
        logJava.info(info);
        
        return info;
    }
    
    
    @GetMapping("/put")
    public String put(@RequestParam String ID,@RequestParam String Name) {
    	
    	logJava.info("update ::");     
    	//notificationService.sendInsertMessages(ID,Name,Capital,Population,LanguageID);
  
        Languages Languages = new Languages();
        Languages.setID(Integer.parseInt(ID));
        Languages.setName(Name);

        dao.update(Languages);      
       
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
