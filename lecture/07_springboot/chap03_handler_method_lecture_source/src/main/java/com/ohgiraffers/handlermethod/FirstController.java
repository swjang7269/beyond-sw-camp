package com.ohgiraffers.handlermethod;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/first")
public class FirstController {
    /* 설명. 핸들러 메소드에서 반환형이 없을 경우 요청경로를 반환한다.(요청경로가 즉, view의 경로 및 이름)*/
    @GetMapping("/regist")
//    public String regist() {
//        // return "src/main/resources/template/first/regist.html;
//        return "/first/regist";
//    }
    public void regist() {} // 요청 경로와 매핑 경로 동일한 경우 반환형 없이 가능(요청 자체가 반환 경로가 되도록)

    /* 설명. request는 사용자의 입력값(parameter)를 담는 용도로쓰고 Model은 백엔드에서 동적 메시지를 만들 때 사용하는 용도 */
    @PostMapping("/regist")
    public String registMenu(HttpServletRequest request, Model model) {
        String name = request.getParameter("name");
        System.out.println("name = " + name);

        int price = Integer.parseInt(request.getParameter("price"));
        int categoryCode = Integer.parseInt(request.getParameter("categoryCode"));

        /* 설명. 비즈리스 로직 이후 DB에 inser를 성공하고 돌아왔다고 가정 */
        String message = name +"을(를) 신규 메뉴 목록의 " + categoryCode + "번 카테고리에 " + price + "원으로 등록하였습니다.";
        model.addAttribute("message", message);

        return "/first/messagePrinter";
    }

    @GetMapping("modify")
    public void modify(){}

    /* 설명.
     *  request의 parameter로 넘어오는 값들의 key값과 일치하는 변수명(어노테이션 생략 가능)을 작성하고 @RequestParam
     *  어노테이션을 적용하면 알아서 값을 꺼내고 해당 매개변수의 자료형에 맞게 변환까지 해 준다.
     *
     * 설명.
     *  1. defaultValue: 사용자의 입력값이 없거나("") request의 parameter 키 값이 일치하지 않는 매개변수 사용 시
     *                  매개변수가 가질 기본 default값을 작성
     *  2. name: request parameter의 키 값과 다른 매개변수 명을 사용하고 싶을 때 request parameter의 키 값을 작성한다.
     */
    // 사용자의 입력을 키값을 이용해 원하는 변수에 담아줄 수 있다.(키 값과 받을 변수가 동일한 경우 생략 가능)
    // 넘어온 parameter의 키값과 핸들러 매소드의 매개변수 이름이 같은 경우 생략 가능
    @PostMapping("modify1")
    public String modify1(Model model, @RequestParam(name="name", defaultValue="디폴트") String modifyName, /* @RequestParam(name="modifyPrice") */ int modifyPrice) {

        /* 설명. 넘어온 데이터를 이용하여 update를 하고 성공했다고 가정 */

        String message = modifyName + "메뉴의 가격을 " + modifyPrice + "원으로 변경";
        model.addAttribute("message", message);

        return "first/messagePrinter";
    }

    // map으로 파라미터를 한 번에 전달 받을 수 있다.
    @PostMapping("modify2")
    public String modify2(Model model, @RequestParam Map<String, String> parameterMap) {
        String modifyName = parameterMap.get("name");
        int modifyPrice = Integer.parseInt(parameterMap.get("modifyPrice"));

        String message = modifyName + "메뉴의 가격을 " + modifyPrice + "원으로 변경";
        model.addAttribute("message", message);

        return "first/messagePrinter";
    }

    @GetMapping("search")
    public void search(){}
}
