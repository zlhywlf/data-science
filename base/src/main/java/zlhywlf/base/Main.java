package zlhywlf.base;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import zlhywlf.base.demo.IFacade;
import zlhywlf.base.demo.model.CalData;
import zlhywlf.base.demo.model.ResData;

import javax.annotation.Resource;

/**
 * @author zlhywlf
 */
@Configuration
@ComponentScan("zlhywlf")
public class Main {

    @Resource(name="facade01")
    IFacade<CalData, ResData> com;



    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        Main bean = context.getBean(Main.class);
        CalData data = new CalData("test", 123.33);
        System.out.println(bean.com.apply(data));


        context.close();

    }

}
