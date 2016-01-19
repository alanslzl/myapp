package com.app.test;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.myapp.app.entity.Permission;
import com.myapp.app.entity.Role;
import com.myapp.app.entity.User;
import com.myapp.app.service.IBaseService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config/spring-core.xml","classpath:spring-config/mvc/springmvc.xml"})
@TransactionConfiguration(transactionManager="txManager",defaultRollback=false)
public class test extends AbstractTransactionalJUnit4SpringContextTests{

    @Resource(name="baseService")
    private IBaseService baseService;
    
    @Test
    public void initPermission() throws Exception{
        List<Permission> list = new ArrayList<Permission>();
        
        Permission pmss1 = new Permission();
        pmss1.setName("新建用户");
        pmss1.setDescription("新建用户");
        pmss1.setPermission("user:create");
        
        Permission pmss2 = new Permission();
        pmss2.setName("编辑用户");
        pmss2.setDescription("编辑用户");
        pmss2.setPermission("user:edit");
        
        Permission pmss3 = new Permission();
        pmss3.setName("删除用户");
        pmss3.setDescription("删除用户");
        pmss3.setPermission("user:delete");
        
        Permission pmss4 = new Permission();
        pmss4.setName("审核用户");
        pmss4.setDescription("审核用户");
        pmss4.setPermission("user:audit");
        
        list.add(pmss1);
        list.add(pmss2);
        list.add(pmss3);
        list.add(pmss4);
        
        for(Permission pms : list){
            baseService.save(pms);
        }
    }
    
    @Test
    public void initAdminRole() throws Exception{
        List<Permission> list = new ArrayList<Permission>();
        list = (List<Permission>)baseService.getAll(Permission.class);
        
        Role role = new Role();
        role.setName("administrator");
        role.setDescription("系统管理员角色");
        role.setPmss(list);
        baseService.save(role);
    }
    
    @Test
    public void initAdminUser(){
        List<Role> list = new ArrayList<Role>();
        String jpql = "from Role as o where o.name=?";
        list = baseService.getByJpql(jpql, "administrator");
        User user = new User();
        user.setAccount("admin");
        user.setPassword("123456");
        user.setNickname("july");
        user.setRoles(list);
        baseService.save(user);
    }
}