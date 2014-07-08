package com.bangdj.stock.chartpattern.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bangdj.stock.chartpattern.domain.ChartPattern;
import com.bangdj.stock.chartpattern.service.SpecialPatternService;

@Controller 
/*  mvc에서 컨트롤러 클래스 
 */

@RequestMapping(value = "/chartpattern/sp")
public class SpecialPatternController {

		@Autowired 
		/* 변수타입과 일치하는 컨텍스트 내의 빈을 찾아 인트턴스 변수에 주입해준다. 의존성 주입을 위해서는 생성자나 setter가 
		 * 필요한데 이 어노테이션을 사용할 경우 업서도 가능하다. 
		 */
		private SpecialPatternService specialPatternService;	
	
        private static final Logger logger = LoggerFactory.getLogger(SpecialPatternController.class);

        
    	@RequestMapping("/form")
    	public String form(Model model){
    		
    		logger.debug("==>form()");
    	
    		return "stock/chartpattern/form";
    	}
        
        
        @RequestMapping(value = "/1", method = RequestMethod.POST)
        public String getUpTailSideBySideList(ChartPattern chartPattern) {
            
        	logger.debug("==>getUpTailSideBySideList()");
        	
        	System.out.println(chartPattern.getFromTrdDt());
        	System.out.println(chartPattern.getToTrdDt());
        	System.out.println(chartPattern.getSearchKeyWord());
        	
        	return "";
/*        	
        	List<HashMap<String, String>> rsList = specialPatternService.getUpTailSideBySideList();
                model.addAttribute("rsList", rsList);
                
                System.out.print(model.toString());
                
                return "myapp/sample/home";
*/
        }      
        

        
}