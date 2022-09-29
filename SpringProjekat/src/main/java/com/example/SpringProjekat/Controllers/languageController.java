package com.example.SpringProjekat.Controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.SpringProjekat.Model.Languange;
import com.example.SpringProjekat.Model.User;
import com.example.SpringProjekat.Model.Role;
import com.example.SpringProjekat.Service.LanguangeService;

@Controller
@RequestMapping("/jezici")
public class languageController {
	
	@Autowired
	LanguangeService languangeService;
	
	@GetMapping("")
	public ModelAndView stranicaSvihJezika(HttpSession sesija) {
		sesija.removeAttribute("ulogovan");
		List<Languange> sviJezici = languangeService.nadjiSveJezike();
		ModelAndView rezultat = new ModelAndView("sviJezici");
		rezultat.addObject("sviJezici",sviJezici);
		return rezultat;
	}
	
	@GetMapping("/StranicaJednogJezika")
	public ModelAndView stranicaJednogJezika(@RequestParam String imeJezika) {
		Languange zeljeni =  languangeService.nadjiJedanJezikPrekoImena(imeJezika);
		ModelAndView rezultat = new ModelAndView("jedanJezik");
		rezultat.addObject("mojJezik",zeljeni);
		return rezultat;
	}
	
	@GetMapping("/StranicaDodavanjaJezika")
	public ModelAndView stranicaDodavanjaJezika(HttpSession sesija) {
		User ulogovan = (User) sesija.getAttribute("korisnik");
		if(ulogovan.getUloga().equals(Role.Administrator)) {
			ModelAndView rezultat = new ModelAndView("dodavanjeJezika");
			return rezultat;
		}
		return null;
	}
	
	@PostMapping("/DodajJezik")
	public String upisivanjeJezikaUBazu(@RequestParam String imeJezika,@RequestParam String vrednost,HttpSession sesija) {
		Languange noviLanguange = new Languange();
		noviLanguange.setImeJezika(imeJezika);
		noviLanguange.setVrednost(vrednost);
		languangeService.sacuvajJezik(noviLanguange);
		sesija.removeAttribute("ulogovan");
		return "redirect:/jezici";
	}
	
	@GetMapping("/secure/svi")
	public ModelAndView sigurnaStranicaSvihJezika() {
		List<Languange> sviJezici = languangeService.nadjiSveJezike();
		boolean ulogovan = true;
		ModelAndView rezultat = new ModelAndView("sviJezici");
		rezultat.addObject("sviJezici",sviJezici);
		rezultat.addObject("ulogovan",ulogovan);
		return rezultat;
	}

}
