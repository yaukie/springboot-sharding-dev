package org.yaukie.demo.servlet;

import com.alibaba.druid.support.http.StatViewServlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * @Author: yuenbin
 * @Date :2020/3/2
 * @Time :10:35
 * @Motto: It is better to be clear than to be clever !
 * @Destrib:
 **/
@WebServlet(name = "druidStatServelt",urlPatterns = "/drd/*",initParams = {
        @WebInitParam(name="loginUsername",value="admin"),
        @WebInitParam(name="loginPassword",value="1"),
        @WebInitParam(name="allow",value="127.0.0.1")
},displayName = "druidWebServlet"
)
public class DruidStatWebServlet extends StatViewServlet {
}
