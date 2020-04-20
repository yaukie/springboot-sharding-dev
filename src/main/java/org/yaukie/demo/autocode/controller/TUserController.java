package org.yaukie.demo.autocode.controller;

 import org.yaukie.api.constant.PageResult;
import org.yaukie.api.constant.BaseResult;

import lombok.extern.slf4j.Slf4j;
import org.yaukie.demo.autocode.service.api.TUserService;
import org.yaukie.demo.autocode.model.TUser;
import org.yaukie.demo.autocode.model.TUserExample;
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
@RequestMapping(value = "/op/tuser/")
@Api(value = "TUser控制器", description = "TUser管理")
@Slf4j
public class TUserController {
    private static final Logger log = LoggerFactory.getLogger(TUserController.class);

    @Autowired
    private TUserService tUserService;

    @GetMapping(value = "/listPage")
    @ApiOperation("获取列表")
     public BaseResult getUserPageList(
                                        @RequestParam(value = "offset",required = false)String offset,
                                        @RequestParam(value = "limit",required = false)String limit,
                                         @RequestParam(value = "search",required = false)String search) {
TUserExample tUserExample = new TUserExample();
//    if(StringUtils.isNotBlank(search)){
//        tUserExample.createCriteria().andUserIdEqualTo(search);
//    }
     List<TUser> tUserList = this.tUserService.selectByExample(tUserExample);
                Integer number = tUserList.size();
                PageResult pageResult = new PageResult();
                pageResult.setRows(tUserList );
                pageResult.setTotal(number);
                return  BaseResult.success(pageResult);
                }

                @GetMapping(value = "/get/{id}")
                    @ApiImplicitParams({
                    @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "string",paramType = "header")
                    })
               @ApiOperation("获取信息")
                public BaseResult getUser(@PathVariable String id) {
                TUser tUser = this.tUserService.selectByPrimaryKey(Integer.parseInt(id));
                    return BaseResult.success(tUser);
                    }

                    @PostMapping(value = "/add")
                    @ApiImplicitParams({
                    @ApiImplicitParam(name = "tUser"+"", value = "tUser"+"",
                    required = true,dataTypeClass =TUser.class),
                    })
                    @ApiOperation("新增")
                    public BaseResult addUser(@RequestBody @Validated TUser tUser, BindingResult BindingResult) {
                        if (BindingResult.hasErrors()) {
                        return this.getErrorMessage(BindingResult);
                        }
                        this.tUserService.insertSelective(tUser);
                        return BaseResult.success();
                        }

                        @PostMapping(value = "/update")
                        @ApiOperation("更新")
                        @ApiImplicitParams({
                        @ApiImplicitParam(name = "tUser"+"", value = "tUser"+"",
                            required = true,dataTypeClass =TUser.class),
                        })
                        public BaseResult updateUser(@RequestBody @Validated TUser tUser, BindingResult BindingResult) {
                            if (BindingResult.hasErrors()) {
                            return this.getErrorMessage(BindingResult);
                            }

                            TUserExample tUserExample = new TUserExample();
                            tUserExample.createCriteria().andIdEqualTo(tUser.getId());
                            this.tUserService.updateByExampleSelective(tUser,tUserExample);
                            return BaseResult.success();
                            }

                            @GetMapping(value = "/delete/{id}")
                            @ApiOperation("删除")
                              @ApiImplicitParams({
                            @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "string" ),
                            })
                            public BaseResult deleteUser(@PathVariable String id) {
                                TUserExample tUserExample = new  TUserExample();
                               // tUserExample.createCriteria().andIdEqualsTo(id);
                                this.tUserService.deleteByExample(tUserExample);
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
