package com.ohgiraffers.viewresolver;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/*")
public class ResolverController {
    /* 설명.
     *  ViewResolver 인터페이스를 구현한 thymeleafViewResolver가 현재 처리하게 된다.(예제 기준)
     *  접두사(prefix): resources/templates/
     *  접미사(suffix): .html
     *  핸들러 메소드가 반환하는 문자열은 ViewResolver로 향하게 되고 'redirect:'가 들어간 문자열의 경우에는 접두사와
     *  접미사가 추가되지 않는다.
     */

    @GetMapping("string")
    public String stringReturning(Model model){
        model.addAttribute("forwardMessage", "문자열로 뷰 이름 반환");

        return "result";
    }

    @GetMapping("string-redirect")
    public String stringRedirect(Model model){
        /* 설명. redirect 되어 요청이 왔을 때 model에 담긴 값은 응답되는 view의 재료로 사용하진 못한다.(model을 이용하면 model에 담긴 값이 전달되지 않는다.) */
        model.addAttribute("message1", "문자열로 뷰 이름 반환하여 리다이렉트");

        // :이후 "/" 요청을 다시 하도록 전달
        /* 설명. MainController의 핸들러 메소드로 재요청 */
        return "redirect:/";
    }

    @GetMapping("string-redirect-attr")
    public String stringRedirectFlashAttribute(RedirectAttributes rttr){
        /* 설명. 스프링부트에서 리다이렉트 시에 값이 전달되게 하고 싶다면 RedirectAttributes를 활용한다. */
        /* 설명. 추가로, 내부적으로는 HttpSession을 활용하기 때문에 flashAttribute의 키 값이 기존 session의 키 값과 중복되면 안된다. */
        rttr.addFlashAttribute("flashMessage", "리다이렉트 attribute 전달");
        return "redirect:/";
    }

    /* 설명. forward를 통한 화면의 재료는 model, redirect를 통한 화면의 재료는 RedirectAttributes */

    @GetMapping("modelandview")
    public ModelAndView modelAndViewTest(ModelAndView mv){
        mv.addObject("forwardMessage", "ModelAndView를 이용한 forward");
        mv.setViewName("result");

        return mv;
    }

    @GetMapping("modelandview-redirect")
    public ModelAndView modelAndViewRedirect(ModelAndView mv){
        mv.addObject("message2", "ModelAndView를 이용한 redirect");
        mv.setViewName("redirect:/");

        return mv;
    }

    @GetMapping("modelandview-redirect-attr")
    public ModelAndView modelAndViewRedirectFlashAttribute(ModelAndView mv, RedirectAttributes rttr){
        rttr.addFlashAttribute("flashMessage2", "ModelAndView를 이용한 redirect attr");
        mv.setViewName("redirect:/");

        return mv;
    }
}
