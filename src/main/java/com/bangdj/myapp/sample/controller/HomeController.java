package com.bangdj.myapp.sample.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bangdj.myapp.sample.service.HomeService;

@Controller 
/*  mvc에서 컨트롤러 클래스 
 */

@RequestMapping(value = "/myapp")
public class HomeController {

		@Autowired 
		/* 변수타입과 일치하는 컨텍스스 내의 빈을 찾아 인트턴스 변수에 주입해준다. 의존성 주입을 위해서는 생성자나 setter가 
		 * 필요한데 이 어노테이션을 사용할 경우 업서도 가능하다. 
		 */
		private HomeService homeService;	
	
        private static final Logger logger = LoggerFactory.getLogger(HomeController.class);


        /**
         * Simply selects the home view to render by returning its name.
         */
        
        @RequestMapping(value = "/sample/home", method = RequestMethod.GET)
        public void home(Locale locale, Model model) {
        		logger.info("Welcome home! The client locale is {}.", locale);
                // 메시지 모델에 추가.
                String sMessage = "스프링+아이바티스 첫만남. I Love Spring Framework!";
                model.addAttribute("sMessage", sMessage);
                
                // 날짜 부분 출력 및 모델에 추가
                Date date = new Date();
                DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
                String formattedDate = dateFormat.format(date);
                model.addAttribute("serverTime", formattedDate);

                
                List<HashMap<String, String>> rsList = homeService.getHomeList();
                model.addAttribute("rs", rsList);
                
                //ModelAndView mav = new ModelAndView("myapp/sample/home", "model", model);
                
                System.out.print(model.toString());

        }      
        
        
/*        
        @RequestMapping(value = "/hello", method = RequestMethod.GET)
        public ModelAndView home(Locale locale, Model model) {
                
        		logger.info("Welcome home! The client locale is {}.", locale);
                // 메시지 모델에 추가.
                String sMessage = "스프링+아이바티스 첫만남. I Love Spring Framework!";
                model.addAttribute("sMessage", sMessage);
                
                // 날짜 부분 출력 및 모델에 추가
                Date date = new Date();
                DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
                String formattedDate = dateFormat.format(date);
                model.addAttribute("serverTime", formattedDate);

                
                List<HashMap<String, String>> rsList = homeService.getHomeList();
                model.addAttribute("rs", rsList);
                
                
                System.out.print(model.toString());
                

                // view에 모델 넘겨 넘겨
                ModelAndView mav = new ModelAndView("myapp/sample/home", "model", model);
                return mav;
        }
*/        
        
}