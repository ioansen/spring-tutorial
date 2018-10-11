package uti.ro.java.tutorials;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Hello {

    private String message;

    public String getMessage() {
        return "Hello " + message;
    }

    public void setMessage(String message) {
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
