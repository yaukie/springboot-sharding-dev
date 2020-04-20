package org.yaukie.demo.autocode.vo.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
* 列表实体类
* 根据需要删减无效参数
* @author: yuenbin
* @create: 2020/03/30 09/45/603
**/
@Data
public class TEncryptOrderResponseVO {

    @ApiModelProperty(value = "")
    private Integer id;

    @ApiModelProperty(value = "")
    private String userId;

    @ApiModelProperty(value = "")
    private String userDecrypt;

    @ApiModelProperty(value = "")
    private String userEncrypt;

    @ApiModelProperty(value = "")
    private String userAssisted;

    @ApiModelProperty(value = "")
    private Date createdTime;

    @ApiModelProperty(value = "")
    private Date updateTime;
}
