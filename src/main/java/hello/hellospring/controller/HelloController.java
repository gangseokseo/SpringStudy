package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("hello") //
    public String hello(Model model){
        //웹어플리케이션에서 /hello 라 하면 위 메서드 호출
            model.addAttribute("data", "어렵네!!"); //model (MVC 중 M)
            return "hello"; //resources - template -> hello 로 찾아가서 렌더링해라(화면을 실행시켜라)
    }

    @GetMapping("hell-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){//외부에서에서 파라미터를 받는다
                                                                        // (model에 담아야 view에서  렌더링할때 쓰인다)
        model.addAttribute("name", name);
        return "hello-template";
    }
}
