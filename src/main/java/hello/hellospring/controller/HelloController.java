package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        //웹어플리케이션에서 /hello 라 하면 위 메서드 호출(동일한 경로 호출)
        model.addAttribute("data", "어렵다!!"); //model (MVC 중 M)
        return "hello"; //resources - template -> hello 로 찾아가서 렌더링해라(화면을 실행시켜라)
    }

    //MVC와 템플릿 엔진
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String data, Model model) {//@RequestParam 외부에서 파라미터를 받는다
        // (model에 담아야 view에서  렌더링할때 쓰인다)
        model.addAttribute("name", data); //키밸류값 넣고 그다음 model에 담긴다.
        //http://localhost:8080/hello-mvc?name=spring!  리퀘스트파람 매개변수 name, String data 변수 data = spring!
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody //http 의 body (응답바디) 부분에 data를 직접 넣어주겠다(문자내용 직접 반환)
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name; //"hello spring" //html 거치지 않고 바로 내려버린다 . 템플릿 엔진하고는 다르다. 쓸일 없다
    }

    //API방식. data 호출, json 구조

    //순서???
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("what") String name) {
        Hello hello = new Hello();
        hello.setNameTest("12313231"); //setName -> 파라미터로 넘어온 name 을 넣어본다.
        hello.setTest("122313231");
        return hello; //객체 반환(json)
    }

    //static class -> 클래스안에 또 클래스를 사용할 수 있다
    static class Hello {  //객체
        private String name; //key는 name? valu는 spring!!
        private String test;


        //getter setter 를 왜 사용할까?
        //자바 빈(JavaBean) 표준방식 = 프로퍼티 접근방식.
        // private 으로 외부에서 사용할수 없으니 라이브러리같은데서 사용하거나 할때 밑의 메서드를 사용해 접근한다
        public String getNameTest() {
            return name;
        }

        public void setNameTest(String name) {
            this.name = name;
        }

        public String getTest() {
            return name;
        }

        public void setTest(String name) {
            this.name = name;
        }
    }
}
