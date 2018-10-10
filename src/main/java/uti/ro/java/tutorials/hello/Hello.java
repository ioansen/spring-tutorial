package uti.ro.java.tutorials.hello;

import uti.ro.java.tutorials.annotations.Timed;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Hello {

    private String message;

    public String getMessage() {
        return "Hello " + message;
    }

    @Timed
    public void setMessage(String message) {
        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.getMessage();
            e.printStackTrace();
        }
        this.message = message;
    }

    @PostConstruct
    public void init(){
        message = "happy";
        System.out.println("[INIT METHOD EXAMPLE]: Bean " + this.getClass().getSimpleName() + " is going through init.");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("[DESTROY METHOD EXAMPLE]: Bean " + this.getClass().getSimpleName() + " will destroy now thank you");
    }
}
