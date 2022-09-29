package com.example.SpringProjekat.Controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.SpringProjekat.Model.User;
import com.example.SpringProjekat.Model.Role;
import com.example.SpringProjekat.Service.UserService;

@Controller
@RequestMapping("/korisnici")
public class userController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/login")
	public String proveriLogin(@RequestParam String korisnickoIme,@RequestParam String lozinka,HttpSession sesija) {
		
		User nadjeni = userService.nadjiJednogKorisnika(korisnickoIme);
		if(nadjeni == null) {
			return "redirect:/jezici";   //Napisati stranicu sa svim jezicima
		}
		if(lozinka.equals(nadjeni.getLozinka())) {
			if(nadjeni.getUloga().equals(Role.Administrator)) {
				sesija.setAttribute("korisnik", nadjeni);
				return "redirect:/jezici/StranicaDodavanjaJezika";  //Napisati stranicu na kojoj se upisuju jezici
			}
			else {
				return "redirect:/jezici"; //Napisati stranicu koja vraca sigurnu stranicu svih jezika
			}
		}
		
		return "redirect:/korisnici/greska";
		
		
	}
	
	
	@GetMapping("/greska")
	public ModelAndView stranicaGreske() {
		ModelAndView rezultat = new ModelAndView("stranicaGreske");
		return rezultat;
	}

}
