package dec.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;

@Controller
public class IndexController {

    public static void main(String[] args) {
        String s = "123123";
        boolean empty = StringUtils.isEmpty(s);
        System.out.println(empty);
    }
}
