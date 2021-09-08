package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FirstWebTest {

	@RequestMapping("/guide")
	public String guide(Model model,
			@RequestParam(value = "name", required = false) String name) {
		model.addAttribute("guidance", "first mvc guest " + name);
		return "guide";
	}
	@GetMapping("/")
	public String introduction1(Model model,
		   @RequestParam(value = "name", required = false) String name) {
		return "introduction";
	}
	@PostMapping("/")
	public String introduction2(Model model,
		   @RequestParam(value = "name", required = false) String name) {
		model.addAttribute("name", name);
		return "guide";
	}
}
