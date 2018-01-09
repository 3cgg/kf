package test.me.libme.module.kafka;

import me.libme.module.kafka.fn.logger.ReadLogger2File;

/**
 * Created by J on 2018/1/9.
 */
public class TestReadLogger2File {


    public static void main(String[] args) throws Exception {

        new ReadLogger2File()
                .args(args)
                .start();


    }


}
