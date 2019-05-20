package br.edu.ifpb.pweb2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifpb.pweb2.dao.UserDAO;
import br.edu.ifpb.pweb2.model.User;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired	
	UserDAO userdao;
	
	@RequestMapping("/form")
	public String showForm() {
		return "form-login";
	}
	
	@RequestMapping("/valide")
	public String valide(String login, String senha, Model model) {
		User user = userdao.findByEmail(login);
		if(user != null && user.getSenha().equals(senha)) {
			model.addAttribute("login",login);
			model.addAttribute("user_name", user.getNome());
			return "eventos-list";
		}else {
			model.addAttribute("erro", "Login ou senha inv�lidos");
			return "form-login";
		}
	}

}
