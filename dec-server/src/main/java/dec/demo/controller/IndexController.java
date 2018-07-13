package dec.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/index")
public class IndexController {
    @Value("${dec-name}")
    private String name;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String index(){
        return name;
    }

    @GetMapping("/page")
    public String indexPage(){
        return "index";
    }
}
