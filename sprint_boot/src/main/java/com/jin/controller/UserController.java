package com.jin.controller;

import com.jin.entity.dto.UserDto;
import com.jin.entity.vo.ResultVo;

import com.jin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户控制层
 */
@RestController
@RequestMapping("/user")
public class UserController {

    // 引入service层
    @Autowired
    UserService userService;

    /**
     * 根据条件获取用户数量
     */
    @GetMapping("/getUserNums")
    public ResultVo getUserNums(UserDto userDto){
        return userService.getUserNums(userDto);
    }

    /**
     * 根据条件获取用户详情
     */
    @GetMapping("/getUserDetails")
    public ResultVo getUserDetails(UserDto userDto){
        return userService.getUserDetails(userDto);
    }

    /**
     * 新增用户信息的方法
     */
    @PostMapping("/setUserInfo")
    public ResultVo setUserInfo(@RequestBody(required = false) UserDto userDto){
        return userService.setUserInfo(userDto);
    }

    /**
     * 更新用户信息的方法
     */
    @PutMapping("/updateUserInfo")
    public ResultVo updateUserInfo(@RequestBody(required = false) UserDto userDto){
        return userService.updateUserInfo(userDto);
    }

    /**
     * 删除用户信息的方法
     */
    @DeleteMapping("/deleteUserInfo")
    public  ResultVo deleteUserInfo(Integer id){
        return userService.deleteUserInfo(id);
    }

    /**
     * 批量删除用户信息的方法
     */
    @DeleteMapping("/batchDeleteUserInfo")
    public  ResultVo batchDeleteUserInfo(@RequestParam(value = "idList",required = false) List<Integer> idList){
        return userService.batchDeleteUserInfo(idList);
    }

    /**
     * 通过MuBatis-plus来批量获取用户信息
     */
    @GetMapping("/batchGetUserInfo")
    public ResultVo batchGetUserInfo(){
        return userService.batchGetUserInfo();
    }

    /**
     * 根据用户id查询有关的产品信息
     * 1、根据userId查询对应的订单id
     * 2、根据订单id查询与之有关的产品id
     * 3、根据产品id查询对应的产品信息
     */
    @GetMapping("/getProductInfoByUserId")
    public ResultVo getProductInfoByUserId(@RequestParam(value = "id",required = false) Integer userId){
        return userService.getProductInfoByUserId(userId);
    }
}
