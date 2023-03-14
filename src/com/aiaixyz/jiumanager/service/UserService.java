package com.aiaixyz.jiumanager.service;

import com.aiaixyz.jiumanager.entity.po.User;
import com.aiaixyz.jiumanager.entity.vo.RespBean;

/**
 * author LeeC
 * since JDK 1.8
 * date 2023/3/11
 */
public interface UserService extends BaseService<User>{

    RespBean getUsernameById(int id);
}
