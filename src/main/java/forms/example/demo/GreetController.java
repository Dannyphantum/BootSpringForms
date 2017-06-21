package forms.example.demo;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/greet")
public class GreetController {

	@Autowired
	private GreetRepository greetRepository;
	
	@GetMapping(path="/add")
	public @ResponseBody String addNewGreet(@RequestParam String content){
		
		Greeting g = new Greeting();
		g.setContent(content);
		greetRepository.save(g);
		return "Saved";
	}
	
}
