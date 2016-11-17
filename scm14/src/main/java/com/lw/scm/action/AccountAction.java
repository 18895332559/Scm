package com.lw.scm.action;

import com.lw.scm.bean.Account;
import com.lw.scm.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by lw on 2016/11/17.
 */
@Controller
@RequestMapping("/account")
public class AccountAction extends BaseAction {

    @Resource
    private AccountService accountService;

    @RequestMapping("/login")
    public String login(Account account, HttpServletRequest request, HttpSession session) {
        Account loginAccount = accountService.login(account);
        if (loginAccount != null) {
            //存入session
            session.setAttribute("account", loginAccount);
            return "forward:/WEB-INF/main/main.jsp";
        } else {
            request.setAttribute("msg", "用户名或密码错误");
            return "forward:/login.jsp"; // 注意：这里和new ModelAndView类似
        }

    }

}
