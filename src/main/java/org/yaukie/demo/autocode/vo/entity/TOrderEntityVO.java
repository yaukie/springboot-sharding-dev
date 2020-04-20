
package org.yaukie.demo.autocode.vo.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
* 实体类
* 根据需要删减无效参数
* @author: yuenbin
* @create: 2020/03/29 21/19/735
**/
@Data
public class TOrderEntityVO {

    @ApiModelProperty(value = "")
    private Integer id;

    @ApiModelProperty(value = "")
    private Integer orderId;

    @ApiModelProperty(value = "")
    private Integer userId;

    @ApiModelProperty(value = "")
    private String orderName;

    @ApiModelProperty(value = "")
    private String orderType;

    @ApiModelProperty(value = "")
    private Date createdTime;

    @ApiModelProperty(value = "")
    private Date updateTime;
}
