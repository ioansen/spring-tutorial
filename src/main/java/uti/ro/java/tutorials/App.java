package uti.ro.java.tutorials;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import uti.ro.java.tutorials.configs.AppSpringConfig;
import uti.ro.java.tutorials.hello.Hello;
import uti.ro.java.tutorials.jdbcex.Employee;
import uti.ro.java.tutorials.jdbcex.EmpJDBCTemplate;
import uti.ro.java.tutorials.jdbcex.JDBCConfig;
import uti.ro.java.tutorials.texteditor.TextEditor;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("uti.ro.java.tutorials")
public class App {

    public static void main(String[] args){
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(App.class);

        context.start();
        Hello halo = context.getBean(Hello.class);
        System.out.println(halo.getMessage());
        halo.setMessage("raza");
        System.out.println(halo.getMessage());

        Hello helloToo = context.getBean(Hello.class);
        System.out.println(helloToo.getMessage()); //still raza cuz of scope singleton default
        helloToo.setMessage("back to happy");
        System.out.println(halo.getMessage());

        TextEditor te = context.getBean(TextEditor.class);
        te.spellCheck();

        CustomEventPublisher cvp = context.getBean(CustomEventPublisher.class);
        cvp.publish();
        cvp.publish();

        /*EmpJDBCTemplate ejdbct = context.getBean(EmpJDBCTemplate.class); //i cannot understand the error
        ejdbct.create(new Employee("Liviu", "Larnaca", 2500, "dr", "nada"));
        ejdbct.create(new Employee("Lira", "Dita", 9500, "dr", "nada"));
        for(Employee e: ejdbct.listEmployees()){
            System.out.println(e);
        }

        ejdbct.update(15, new Employee("Grija", "Larnaca", 2500, "dr", "nada"));*/

       /* for(int i = 20; i < 40; i++){
            ejdbct.delete(i);
        }*/
        context.registerShutdownHook(); //shutdown so we can see destroy methods
        context.stop();
    }
}
