package org.yaukie.demo.autocode.controller;

import org.apache.shardingsphere.api.hint.HintManager;
import org.yaukie.api.constant.PageResult;
import org.yaukie.api.constant.BaseResult;

import lombok.extern.slf4j.Slf4j;
import org.yaukie.demo.autocode.service.api.TOrderService;
import org.yaukie.demo.autocode.model.TOrder;
import org.yaukie.demo.autocode.model.TOrderExample;
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

import java.util.List;

/**
 * @author: yuenbin
 * @create: 2020/03/29 21/19/735
 **/
@RestController
@RequestMapping(value = "/op/torder/")
@Api(value = "TOrder控制器", description = "TOrder管理")
@Slf4j
public class TOrderController {
    private static final Logger log = LoggerFactory.getLogger(TOrderController.class);

    @Autowired
    private TOrderService tOrderService;

    @GetMapping(value = "/listPage")
    @ApiOperation("获取列表")
    public BaseResult getOrderPageList(
            @RequestParam(value = "offset", required = false) String offset,
            @RequestParam(value = "limit", required = false) String limit,
            @RequestParam(value = "search", required = false) String search) {
        TOrderExample tOrderExample = new TOrderExample();
//    if(StringUtils.isNotBlank(search)){
//        tOrderExample.createCriteria().andUserIdEqualTo(search);
//    }
        List<TOrder> tOrderList = this.tOrderService.selectByExample(tOrderExample);
        Integer number = tOrderList.size();
        PageResult pageResult = new PageResult();
        pageResult.setRows(tOrderList);
        pageResult.setTotal(number);
        return BaseResult.success(pageResult);
    }

    @GetMapping(value = "/get/{id}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "string", paramType = "header")
    })
    @ApiOperation("获取信息")
    public BaseResult getOrder(@PathVariable String id) {
        TOrder tOrder = this.tOrderService.selectByPrimaryKey(Integer.parseInt(id));
        return BaseResult.success(tOrder);
    }

    @PostMapping(value = "/add")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "tOrder" + "", value = "tOrder" + "",
                    required = true, dataTypeClass = TOrder.class),
    })
    @ApiOperation("新增")
    public BaseResult addOrder(@RequestParam("orderId")String orderId,
                               @RequestParam("userId")String userId,
                               @RequestParam("orderName")String orderName,
                               @RequestParam("orderType")String orderType) {

        /**演示强制路由 hint 自定义分片策略,,*/
        HintManager hintManager =  HintManager.getInstance();
        hintManager.addTableShardingValue("t_order", 3L);//按照t_order 对2取余分片
        hintManager.addDatabaseShardingValue("t_order", 3L);//按照t_order 对2取余分表
        TOrder tOrder = new TOrder();
        tOrder.setOrderId(Integer.parseInt(orderId));
        tOrder.setUserId(Integer.parseInt(userId));
        tOrder.setOrderType(orderType);
        tOrder.setOrderName(orderName);
        this.tOrderService.insertSelective(tOrder);
        return BaseResult.success();
    }

    @PostMapping(value = "/update")
    @ApiOperation("更新")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "tOrder" + "", value = "tOrder" + "",
                    required = true, dataTypeClass = TOrder.class),
    })
    public BaseResult updateOrder(@RequestBody @Validated TOrder tOrder, BindingResult BindingResult) {
        if (BindingResult.hasErrors()) {
            return this.getErrorMessage(BindingResult);
        }

        TOrderExample tOrderExample = new TOrderExample();
        tOrderExample.createCriteria().andIdEqualTo(tOrder.getId());
        this.tOrderService.updateByExampleSelective(tOrder, tOrderExample);
        return BaseResult.success();
    }

    @GetMapping(value = "/delete/{id}")
    @ApiOperation("删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "string"),
    })
    public BaseResult deleteOrder(@PathVariable String id) {
        TOrderExample tOrderExample = new TOrderExample();
        // tOrderExample.createCriteria().andIdEqualsTo(id);
        this.tOrderService.deleteByExample(tOrderExample);
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
