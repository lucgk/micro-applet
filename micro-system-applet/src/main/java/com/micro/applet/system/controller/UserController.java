package com.micro.applet.system.controller;

import com.micro.applet.system.entity.UserInfo;
import com.micro.applet.system.service.UserService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * User 管理
 *
 * @author liuhui
 * @version 1.0, 2021/1/19 18:38
 */

@Slf4j
@Api(value = "/api/user",tags = {"UserController"})
@Controller
@RequestMapping("/api/user/")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/saveUser",method = RequestMethod.PUT)
    @ApiOperation(value = "Find purchase order by ID",notes = "For valid response try integer IDs with value <= 5 or > 10. Other values will generated exceptions",
            response = String.class)
    @ApiResponses({ @ApiResponse(code = 400, message = "Invalid Order") })
    public String saveUser(@ApiParam(value = "Created user object", required = true) UserInfo userInfo){
        log.info("UserController saveUser");
        userService.saveUser(userInfo);

        return "SUCCESS";
    }

    @DeleteMapping("/deleteById")
    public String deleteUser(@RequestParam(value = "id 标识",required = true) Long id){
        userService.deleteUser(id);
        return "SUCCESS";
    }

    @GetMapping("pageQuery")
    public List<UserInfo> pageQuery(){

        return null;
    }

}
