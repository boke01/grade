package com.vz04.grade.controller.login;

import com.vz04.grade.pojo.login.AccountBean;
import com.vz04.grade.pojo.msg.Msg;
import com.vz04.grade.service.login.LoginService;
import com.vz04.grade.util.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 登录相关的Controller
 *
 * @author vz04
 * @date 7/27/2019 1:13 PM
 **/
@RestController
@RequestMapping("/user")
public class LoginController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LoginService loginService;

    /**
     * 验证账号是否存在，验证密码是否正确,如果验证通过将用户的accountId，classesId，identity 放入session中
     *
     * @date 3:29 PM 7/27/2019
     * @param account 使用accountNumber password两个字段来接收账号和密码
     * @param session 获取session
     * @return Msg
     */
    @PostMapping("/login")
    public Msg login(@RequestBody AccountBean account, HttpSession session) {
        Map<String, Object> map = loginService.loginCheck(account.getAccountNumber(), account.getPassword());
        String message = (String) map.get("message");
        if (message.equals(Constant.LOGIN_SUCCESS)) {
            session.setAttribute("accountId",map.get("accountId"));
            session.setAttribute("classesId",map.get("classesId"));
            session.setAttribute("identity",map.get("identity"));
            return new Msg().setMsg(Constant.SUCCESS,map.get("message").toString(),null);
        }else {
            return new Msg().setMsg(Constant.DEFEATED,map.get("message").toString(),null);
        }
    }

    /**
     * 退出登录清除session中的值
     * 如果identity的值为空则代表用户为登录
     *
     * @date 3:28 PM 7/27/2019
     * @param session 获取session
     * @return Msg
     */
    @PostMapping("/logout")
    public Msg logout(HttpSession session) {
        System.out.println("test");
        Object identity = session.getAttribute("identity");
        if (identity != null) {
            session.removeAttribute("accountId");
            session.removeAttribute("classesId");
            session.removeAttribute("identity");
            session.invalidate();
            return new Msg().setMsg(Constant.SUCCESS,Constant.EXIT_SUCCESS,null);
        }
        return new Msg().setMsg(Constant.DEFEATED,Constant.PLEASE_LOGIN,null);
    }

    /**
     * 修改学生班级id的接口
     * 此接口仅学生登录可用
     *
     * @date 5:25 PM 7/31/2019
     * @param accountBean 使用 classesId
     * @param session 账号id
     * @return Msg
     */
    @PostMapping("alter")
    public Msg alterClassesIdInAccountId(@RequestBody AccountBean accountBean,HttpSession session) {
        Object identity = session.getAttribute("identity");
        if (identity == null) {
            return new Msg().setMsg(Constant.DEFEATED,Constant.PLEASE_LOGIN,null);
        }
        if (identity.equals(1)) {
            Integer accountId = (Integer) session.getAttribute("accountId");
            boolean b = loginService.alterClassesIdInAccountId(accountId, accountBean.getClassesId());
            if (b){
                log.info("用户："+accountId+" 将班级ID修改为："+accountBean.getClassesId());
                return new Msg().setMsg(Constant.SUCCESS,Constant.ALTER_OPERATION_SUCCESSFUL,null);
            }else {
                return new Msg().setMsg(Constant.DEFEATED,Constant.ALTER_OPERATION_DEFEATED,null);
            }
        }else {
            return new Msg().setMsg(Constant.UNAUTHORIZED,Constant.HAVE_NO_RIGHT,null);
        }
    }
}
