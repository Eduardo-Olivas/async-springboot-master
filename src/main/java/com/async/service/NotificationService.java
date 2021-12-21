package com.async.service;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;



import java.util.concurrent.TimeUnit;

@Service
public class NotificationService {

	private static Logger logJava = Logger.getLogger(NotificationService.class);
	
    @Async
    public void sendTextMessage(String mobile) {

        // dummy logic to call 3rd party services
        sleep(2);
        logJava.info("called 3rd party to send text message : " + Thread.currentThread().getName());
        logJava.info(10 / 0);

    }

    @Async
    public void sendInsertMessages(String ID,String Name,String Capital,String Population,String LanguageID) {

        // dummy logic to call 3rd party services
        sleep(2);
        logJava.info("ID: "+ID+" Name: "+Name+" Capital: "+Capital+" Population: "+Population+" LanguageID: "+LanguageID);
        
        logJava.info("called 3rd party to send text message : " + Thread.currentThread().getName());
        logJava.info(10 / 0);

    }


    private void sleep(int args) {
        try {
            TimeUnit.SECONDS.sleep(args);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
