package org.yaukie.demo.filter;

import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * @Author: yuenbin
 * @Date :2020/3/2
 * @Time :10:35
 * @Motto: It is better to be clear than to be clever !
 * @Destrib:
 **/
@WebFilter(displayName = "druidStatViewFilter",filterName = "druidStatViewFilter",initParams = {
       @WebInitParam(name="exclusions",value="*.js,*.gif,*.jpg,*.png,*.css,*.ico,/drd/*")
},urlPatterns = "/sharding/*")
public class DruidStatWebFilter extends WebStatFilter {

}
