package c332030.common.controller;

import c332030.utils.controller.AbstractController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName MainRestController
 * @Description TODO
 * @Author c332030
 * @Date 2018/11/13 17:19
 * @Version 1.0
 */
@RestController
public class MainRestController extends AbstractController {

    @RequestMapping("getip")
    public String ip() {


        return null;
    }
}
