package com.entity;

import java.util.List;

/**
 * @author yyh
 * @date 2019/8/7-10:35
 */
public class QueryVo {
    private int[]ids;

    private List<User> users;

    public int[] getIds() {
        return ids;
    }

    public void setIds(int[] ids) {
        this.ids = ids;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
