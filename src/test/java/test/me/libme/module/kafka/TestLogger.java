package test.me.libme.module.kafka;

import org.slf4j.Logger;

import java.util.Random;

/**
 * Created by J on 2018/1/10.
 */
public class TestLogger {

    private Logger logger;

    public TestLogger(Logger logger) {
        this.logger = logger;
    }

    private String MSG_FORMAT="==%s==>%s";

    Random random=new Random(9999);
    
    public void logData(){

        long start=System.nanoTime();

        logger.debug(String.format(MSG_FORMAT,"debug",String.valueOf(random.nextFloat())));
        logger.info(String.format(MSG_FORMAT,"info",String.valueOf(random.nextFloat())));
        logger.error(String.format(MSG_FORMAT,"error",String.valueOf(random.nextFloat())));
        logger.warn(String.format(MSG_FORMAT,"warning",String.valueOf(random.nextFloat())));

        long end=System.nanoTime();

        System.out.println("Time from "+start+" to "+end);

    }


}
