package nl.remideboer.springbootbare;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@PropertySource("classpath:homepage.properties") // voor andere bestanden dan application.properties
public class HomeController {
    
    @Autowired
    private Environment env;
    
    @RequestMapping("/")
    public String home(Map<String, Object> model){
        model.put("title", env.getProperty("homepage.title"));
        model.put("url", env.getProperty("homepage.url"));
        return "home"; 
    }
    
}
