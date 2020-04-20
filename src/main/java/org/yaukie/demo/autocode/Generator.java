package org.yaukie.demo.autocode;

import org.yaukie.api.util.GeneratorUtil;

/**
 * @Author: yuenbin
 * @Date :2020/3/15
 * @Time :20:25
 * @Motto: It is better to be clear than to be clever !
 * @Destrib:
 **/
public class Generator {

    public static void main(String[] args) {
        GeneratorUtil.generator("jdbc:mysql://localhost:3306/encrypt",
                "root",
                "root",
                "com.mysql.jdbc.Driver",
                "org.yaukie.demo.autocode",
                "id",
                "t_encrypt_order"
        );
    }

}
