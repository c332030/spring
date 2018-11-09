package c332030.passport.controller;

import c332030.passport.spring.Close;
import c332030.utils.data.constant.ConstantWeb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName MainController
 * @Description
 * @Author c332030
 * @Date 2018/10/30 20:23
 * @Version 1.0
 */
@Controller
public class MainController extends LController {

    @RequestMapping(value = "/")
    public String main() {
        if(!isLogin()) {
            return ConstantWeb.Html.Login;
        }
        return ConstantWeb.Html.Index;
    }

    @Autowired
    private Close close;

    @RequestMapping(value = "Close")
    public String Close() {
        close.start();
        return ConstantWeb.Html.Close;
    }
}