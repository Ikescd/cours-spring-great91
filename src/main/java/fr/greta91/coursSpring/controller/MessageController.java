package fr.greta91.coursSpring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.greta91.coursSpring.model.Message;
import fr.greta91.coursSpring.service.MessageService;

@Controller
public class MessageController {
	
	@Autowired
	MessageService messageService;
	
	@GetMapping("/messages")
	public String list(Model model) {
		List<String> list = new ArrayList<String>();
		list.add("Message 1");
		list.add("Message 2");
		list.add("Message 3");
		model.addAttribute("messages", list );
		//on renvoie le nom de la vue (fichier jsp)
		return "messages/list";
	}
	
	//url : /messages/12, /messages/13...
	@GetMapping("/messages/{id}")
	public ModelAndView show(ModelAndView mv, @PathVariable(value = "id") int idMessage) {
		//Spring récupère le param id et le connvertit en entier et l'affecte à la variable idMessage
		mv.setViewName("messages/show");//le nom du fichier jsp
		mv.addObject("message", "voici le message avec l'id : "+ idMessage);//les données
		return mv;
	}
	
	//url : /messages/update?id=12, /messages/update?id=45, ...
	@GetMapping("/messages/update")
	public ModelAndView update(ModelAndView mv, @RequestParam(value = "id", required = false, defaultValue = "1") int idMessage) {
		//Spring récupère le param id et le connvertit en entier et l'affecte à la variable idMessage
		Message m = new Message(idMessage, "mon message");
		mv.setViewName("messages/update");//le nom du fichier jsp
		mv.addObject("message", m);//les données
		return mv;
	}
	
	@PostMapping("/messages/update")
	public ModelAndView add(ModelAndView mv, @Valid Message message, BindingResult br) {
		if(!br.hasErrors()) {
			messageService.update();
			mv.setViewName("redirect:/messages");//réponse 302
		}
		else {
			mv.setViewName("messages/update");
			mv.addObject("message", message);
		}
		return mv;
	}
	
	@GetMapping("/messages/add")
	public ModelAndView showAddForm(ModelAndView mv) {
		mv.setViewName("messages/add");
		return mv;
	}
	
	@PostMapping("/messages/add")
	public ModelAndView add(ModelAndView mv, @RequestParam(value="message") String message) {
		Message m = new Message(message);
		boolean valide = m.validate();
		if(valide) {
			messageService.save();
			mv.setViewName("redirect:/messages");//réponse 302
		}
		else {
			mv.setViewName("messages/add");
			mv.addObject("erreur", "message ne peut pas être vide!");
		}
		return mv;
	}
}
