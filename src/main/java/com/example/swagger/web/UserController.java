package com.example.swagger.web;

import com.example.swagger.domain.User;
import com.example.swagger.result.GlobalErrorInfoEnum;
import com.example.swagger.result.GlobalErrorInfoException;
import com.example.swagger.result.ResultBody;
import com.example.swagger.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "用户Controller")
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService cityService;

    @ApiOperation(value = "获取用户信息", notes = "根据用户id获取用户信息")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Long", paramType = "path")
    @GetMapping("/{id}")
    @ResponseBody
    public ResultBody getUserById(@PathVariable(value = "id") Long id) {
        System.out.println("id=" + id);
        User userById = cityService.getUserById(id);
        if (userById != null) {
            ResultBody resultBody = new ResultBody(userById);
            return resultBody;
        }
        User user = new User();
        user.setDescription("没有找到这个人");
         return new ResultBody(user);
    }

    @ApiOperation(value = "获取用户列表", notes = "获取用户列表")
    @GetMapping("/list")
    @ResponseBody
    public ResultBody getUserList() throws GlobalErrorInfoException {
        List<User> userList = cityService.getUserList();
        if (userList == null || userList.size() == 0) {
            throw new GlobalErrorInfoException(GlobalErrorInfoEnum.NOT_FOUND);
        }
        ResultBody resultBody = new ResultBody(userList);
        return resultBody;
    }


    @ApiOperation(value = "新增用户", notes = "根据用户实体创建用户")
    @ApiImplicitParam(name = "user", value = "用户实体", required = true, dataType = "User")
    @PostMapping("/add")
    @ResponseBody
    public ResultBody addUser(@RequestBody User user) {
        Long aLong = cityService.addUser(user);
        System.out.println("Long==" + aLong);
        Map<String, Object> map = new HashMap<>();
        map.put("result", "新增用户成功");
        ResultBody resultBody = new ResultBody(map);
        return resultBody;
    }

    @ApiOperation(value = "删除用户", notes = "根据用户id删除用户")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Long", paramType = "path")
    @DeleteMapping("/{id}")
    @ResponseBody
    public ResultBody deleteUser(@PathVariable(value = "id") Long id) {
        Long aLong = cityService.deleteUser(id);
        System.out.println("along=" + aLong);
        System.out.println("删除掉的id=" + id);
        Map<String, Object> map = new HashMap<>();
        map.put("result", "删除成功");
        ResultBody resultBody = new ResultBody(map);
        return resultBody;
    }

    @ApiOperation(value = "更新用户", notes = "根据用户id更新用户")
    @ApiImplicitParams(@ApiImplicitParam(name = "user", value = "用户实体", required = true, dataType = "User"))
    @PutMapping("/{id}")
    @ResponseBody
    public ResultBody updateUser(@RequestBody User user) {
        System.out.println(user.toString());
        Long aLong = cityService.updateUser(user);
        System.out.println("aLong=" + aLong);
        Map<String, Object> map = new HashMap<>();
        map.put("result", "更新成功");
        ResultBody resultBody = new ResultBody(map);
        return resultBody;
    }

}
