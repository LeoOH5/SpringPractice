package hello.hello_spring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")  // 주소창에 /hello로 요청이 들어오면 아래로 실행
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello";  // recources/templates에 있는 hello.html 찾아서 실행
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){ // name이라는 파라미터를 받는다
        model.addAttribute("name" , name); // "name"은 key값 name이 value이다
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // html body를 의미하는게 아닌 http의 응답 body부에 return의 데이터를 직접 넣어준다는 의미이다
    public String helloString(@RequestParam("name") String name){
        return "hello" + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){ //hello class 사용
        Hello hello = new Hello();
        hello.setName(name);
        return hello; // hello 객체를 넘김
    }

    // hello class 선언
    static class Hello {
        private String name; // 여기까지 하고 command n => getter and setter 검색 후 사용하면 아래 자동완성

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
