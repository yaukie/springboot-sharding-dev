package org.yaukie.demo.autocode.controller;

import org.yaukie.api.constant.PageResult;
import org.yaukie.api.constant.BaseResult;

import lombok.extern.slf4j.Slf4j;
import org.yaukie.demo.autocode.service.api.TEncryptOrderService;
import org.yaukie.demo.autocode.model.TEncryptOrder;
import org.yaukie.demo.autocode.model.TEncryptOrderExample;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;

import java.util.Date;
import java.util.List;

/**
 * @author: yuenbin
 * @create: 2020/03/30 09/45/603
 * 数据脱敏演示
 **/
@RestController
@RequestMapping(value = "/op/tencryptorder/")
@Api(value = "TEncryptOrder控制器", description = "TEncryptOrder管理")
@Slf4j
public class TEncryptOrderController {
    private static final Logger log = LoggerFactory.getLogger(TEncryptOrderController.class);

    @Autowired
    private TEncryptOrderService tEncryptOrderService;

    @GetMapping(value = "/listPage")
    @ApiOperation("获取列表")
    public BaseResult getEncryptPageList(
            @RequestParam(value = "offset", required = false) String offset,
            @RequestParam(value = "limit", required = false) String limit,
            @RequestParam(value = "search", required = false) String search) {
        TEncryptOrderExample tEncryptOrderExample = new TEncryptOrderExample();
//    if(StringUtils.isNotBlank(search)){
//        tEncryptOrderExample.createCriteria().andUserIdEqualTo(search);
//    }
        List<TEncryptOrder> tEncryptOrderList = this.tEncryptOrderService.selectByExample(tEncryptOrderExample);
        Integer number = tEncryptOrderList.size();
        PageResult pageResult = new PageResult();
        pageResult.setRows(tEncryptOrderList);
        pageResult.setTotal(number);
        return BaseResult.success(pageResult);
    }

    @GetMapping(value = "/get/{id}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "string", paramType = "header")
    })
    @ApiOperation("获取信息")
    public BaseResult getEncrypt(@PathVariable String id) {
        TEncryptOrder tEncryptOrder = this.tEncryptOrderService.selectByPrimaryKey(Integer.parseInt(id));
        return BaseResult.success(tEncryptOrder);
    }

    @PostMapping(value = "/add")
    @ApiOperation("新增")
    public BaseResult addEncrypt(
            @RequestParam("userId")String userId,
            @RequestParam("userDecrypt")String userDecrypt,
            @RequestParam("userEncrypt")String userEncrypt,
            @RequestParam("userAssisted")String userAssisted
    ) {

        TEncryptOrder tEncryptOrder = new TEncryptOrder() ;
        tEncryptOrder.setUserId(userId);
        tEncryptOrder.setUserDecrypt(userDecrypt);
        tEncryptOrder.setUserEncrypt(userEncrypt);
        tEncryptOrder.setUserAssisted(userAssisted);
        tEncryptOrder.setCreatedTime(new Date());
        tEncryptOrder.setUpdateTime(new Date());
        return BaseResult.success(this.tEncryptOrderService.insertSelective(tEncryptOrder));
    }

    @PostMapping(value = "/update")
    @ApiOperation("更新")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "tEncryptOrder" + "", value = "tEncryptOrder" + "",
                    required = true, dataTypeClass = TEncryptOrder.class),
    })
    public BaseResult updateEncrypt(@RequestBody @Validated TEncryptOrder tEncryptOrder, BindingResult BindingResult) {
        if (BindingResult.hasErrors()) {
            return this.getErrorMessage(BindingResult);
        }

        TEncryptOrderExample tEncryptOrderExample = new TEncryptOrderExample();
        tEncryptOrderExample.createCriteria().andIdEqualTo(tEncryptOrder.getId());
        this.tEncryptOrderService.updateByExampleSelective(tEncryptOrder, tEncryptOrderExample);
        return BaseResult.success();
    }

    @GetMapping(value = "/delete/{id}")
    @ApiOperation("删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "string"),
    })
    public BaseResult deleteEncrypt(@PathVariable String id) {
        TEncryptOrderExample tEncryptOrderExample = new TEncryptOrderExample();
        // tEncryptOrderExample.createCriteria().andIdEqualsTo(id);
        this.tEncryptOrderService.deleteByExample(tEncryptOrderExample);
        return BaseResult.success();
    }

    public BaseResult getErrorMessage(BindingResult BindingResult) {
        String errorMessage = "";
        for (ObjectError objectError : BindingResult.getAllErrors()) {
            errorMessage += objectError.getDefaultMessage();
        }
        return BaseResult.fail(errorMessage);
    }
}
