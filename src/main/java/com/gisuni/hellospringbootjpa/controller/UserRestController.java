package com.gisuni.hellospringbootjpa.controller;

import com.gisuni.hellospringbootjpa.model.User;
import com.gisuni.hellospringbootjpa.servers.UserRestServer;
import com.gisuni.hellospringbootjpa.utils.Response;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/rest")
public class UserRestController {

    @Resource
    UserRestServer userRestServer;

    @ApiOperation("新增用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "用户", defaultValue = "null")
    })
    @PostMapping("/users")
    public Response saveUser(@RequestBody User user) {
        log.info("saveUser" + user);
        userRestServer.saveUser(user);
        return Response.success();
    }

    @ApiOperation("根据id删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "ID", defaultValue = "1")
    })
    @DeleteMapping("/users/{id}")
    public Response deleteUser(@PathVariable Long id) {
        log.info("deleteUser" + id);
        userRestServer.deleteUser(id);
        return Response.success();
    }

    @ApiOperation("根据id更新")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "ID", defaultValue = "1"),
            @ApiImplicitParam(name = "user", value = "用户", defaultValue = "null")
    })
    @PutMapping("/users/{id}")
    public Response updateUser(@PathVariable Long id ,@RequestBody User user) {
        if(user.getId() == null){
            //TODO 抛出一个自定义的异常
            return Response.success();
        }else{
            log.info("updateUser" + id + user);
            userRestServer.updateUser(id, user);
            return Response.success();
        }

    }

    @ApiOperation("根据id获取")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "ID", defaultValue = "1")})
    @GetMapping("/users/{id}")
    public Response getUser(@PathVariable Long id) {
        log.info("getUser" + id);
        return Response.success(userRestServer.getUser(id));
    }

    @ApiOperation("获取所以用户")
    @GetMapping("/users")
    public Response getAll() {
        log.info("getAll");
        return Response.success(userRestServer.getAll());
    }
}
