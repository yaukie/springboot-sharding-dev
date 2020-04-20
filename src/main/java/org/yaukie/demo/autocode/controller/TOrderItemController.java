package org.yaukie.demo.autocode.controller;

 import org.yaukie.api.constant.PageResult;
import org.yaukie.api.constant.BaseResult;

import lombok.extern.slf4j.Slf4j;
import org.yaukie.demo.autocode.service.api.TOrderItemService;
import org.yaukie.demo.autocode.model.TOrderItem;
import org.yaukie.demo.autocode.model.TOrderItemExample;
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
@RequestMapping(value = "/op/torderitem/")
@Api(value = "TOrderItem控制器", description = "TOrderItem管理")
@Slf4j
public class TOrderItemController {
    private static final Logger log = LoggerFactory.getLogger(TOrderItemController.class);

    @Autowired
    private TOrderItemService tOrderItemService;

    @GetMapping(value = "/listPage")
    @ApiOperation("获取列表")
     public BaseResult getOrderPageList(
                                        @RequestParam(value = "offset",required = false)String offset,
                                        @RequestParam(value = "limit",required = false)String limit,
                                         @RequestParam(value = "search",required = false)String search) {
TOrderItemExample tOrderItemExample = new TOrderItemExample();
//    if(StringUtils.isNotBlank(search)){
//        tOrderItemExample.createCriteria().andUserIdEqualTo(search);
//    }
     List<TOrderItem> tOrderItemList = this.tOrderItemService.selectByExample(tOrderItemExample);
                Integer number = tOrderItemList.size();
                PageResult pageResult = new PageResult();
                pageResult.setRows(tOrderItemList );
                pageResult.setTotal(number);
                return  BaseResult.success(pageResult);
                }

                @GetMapping(value = "/get/{id}")
                    @ApiImplicitParams({
                    @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "string",paramType = "header")
                    })
               @ApiOperation("获取信息")
                public BaseResult getOrder(@PathVariable String id) {
                TOrderItem tOrderItem = this.tOrderItemService.selectByPrimaryKey(Integer.parseInt(id));
                    return BaseResult.success(tOrderItem);
                    }

                    @PostMapping(value = "/add")
                    @ApiImplicitParams({
                    @ApiImplicitParam(name = "tOrderItem"+"", value = "tOrderItem"+"",
                    required = true,dataTypeClass =TOrderItem.class),
                    })
                    @ApiOperation("新增")
                    public BaseResult addOrder(@RequestBody @Validated TOrderItem tOrderItem, BindingResult BindingResult) {
                        if (BindingResult.hasErrors()) {
                        return this.getErrorMessage(BindingResult);
                        }
                        this.tOrderItemService.insertSelective(tOrderItem);
                        return BaseResult.success();
                        }

                        @PostMapping(value = "/update")
                        @ApiOperation("更新")
                        @ApiImplicitParams({
                        @ApiImplicitParam(name = "tOrderItem"+"", value = "tOrderItem"+"",
                            required = true,dataTypeClass =TOrderItem.class),
                        })
                        public BaseResult updateOrder(@RequestBody @Validated TOrderItem tOrderItem, BindingResult BindingResult) {
                            if (BindingResult.hasErrors()) {
                            return this.getErrorMessage(BindingResult);
                            }

                            TOrderItemExample tOrderItemExample = new TOrderItemExample();
                            tOrderItemExample.createCriteria().andIdEqualTo(tOrderItem.getId());
                            this.tOrderItemService.updateByExampleSelective(tOrderItem,tOrderItemExample);
                            return BaseResult.success();
                            }

                            @GetMapping(value = "/delete/{id}")
                            @ApiOperation("删除")
                              @ApiImplicitParams({
                            @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "string" ),
                            })
                            public BaseResult deleteOrder(@PathVariable String id) {
                                TOrderItemExample tOrderItemExample = new  TOrderItemExample();
                               // tOrderItemExample.createCriteria().andIdEqualsTo(id);
                                this.tOrderItemService.deleteByExample(tOrderItemExample);
                                return BaseResult.success();
                                }

                                public BaseResult getErrorMessage(BindingResult BindingResult){
                                    String errorMessage = "";
                                    for (ObjectError objectError : BindingResult.getAllErrors()) {
                                    errorMessage += objectError.getDefaultMessage();
                                    }
                                    return BaseResult.fail(errorMessage);
                                    }
        }
