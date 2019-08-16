package com.controller;


import com.entity.Msg;
import com.entity.QueryVo;
import com.entity.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.ArrayList;
import java.util.List;

/**
 * Create by mysteriousTime
 * time on 2019/8/13  14:42
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index(Model model) {
        List<User> acc = userService.selectAllUsers();
        System.out.println(acc);
        model.addAttribute("Acclist", acc);
        return  "list";
    }


    @RequestMapping("/edit")
    public String edit(Integer id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "update";

    }

    @RequestMapping("/update")
    public String update(User user, Model model) {
        if (userService.updateUser(user) > 0) {
            return "forward:/";
        }
        model.addAttribute("msg", "修改失败");
        return "forward:/";
    }

    @RequestMapping("/addUser")
    public String addUser(User user,Model model){
        if(userService.addUser(user)>0){
            return "forward:/";
        }
        model.addAttribute("msg", "添加失败");
        return "forward:/";
    }
    @RequestMapping("/delete")
    public String delete(Integer id, Model model) {

        if (userService.delUser(id) > 0) {
            return "forward:/";
        }
        model.addAttribute("msg", "删除失败");
        return "forward:/";
    }

//    @RequestMapping("/batchDelete")
//    public String deleteAll(QueryVo queryVo) {
//        List<User> users = queryVo.getUsers();
//        for (User user : users) {
//            userService.delUser(user.getId());
//        }
//        return "forward:/";
//
//    }
    //批量删除
    @RequestMapping("/batchDelete")
    @ResponseBody
    public Msg batchDelete(String ids){
        //批量删除
        List<Integer> del_ids = new ArrayList<>();
        String[] str_ids = ids.split("-");
        //组装id的集合
        for (String string : str_ids) {
            del_ids.add(Integer.parseInt(string));
        }
        userService.deleteBatch(del_ids);
        return  Msg.success();
    }

    @RequestMapping("/batchUpdate")
    @ResponseBody
    public String updateAll(QueryVo queryVo) {
        List<User> users = queryVo.getUsers();
        for (User user : users) {
            userService.updateUser(user);
        }
        return "forward:/";
    }
    @RequestMapping("/users")
    @ResponseBody
    public Msg getUsers(@RequestParam(value = "pn", defaultValue = "1") Integer pn){
        // 引入PageHelper分页插件
        // 在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn, 4);
        // startPage后面紧跟的这个查询就是一个分页查询
        List<User> users = userService.selectAllUsers();
        // 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
        // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
        PageInfo page = new PageInfo(users, 3);
        return  Msg.success().add("pageInfo",page);

    }
}