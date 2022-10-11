package com.alvas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alvas.dto.Person;
import com.alvas.service.PersonService;

@Controller
public class PersonController {

	@Autowired
	PersonService pService;

	@RequestMapping("/loadperson")
	public ModelAndView Loadperson() {
		ModelAndView modelAndView = new ModelAndView("saveperson.jsp");
		modelAndView.addObject("person", new Person());
		return modelAndView;
	}
	@RequestMapping("/saveperson")
	public ModelAndView saveperson(@ModelAttribute Person p) {
		Person p2 = pService.saveperson(p);
		ModelAndView modelAndView = new ModelAndView("comman.jsp");
		if (p2 != null) {
			modelAndView.addObject("msg", "Person SAVED Successfully");
		} else {
			modelAndView.addObject("msg", "FAILED TO SAVE PERSON ");
		}
		return modelAndView;
	}

	@RequestMapping("/loaddelete")
	public ModelAndView Loaddelete() {
		ModelAndView modelAndView = new ModelAndView("deleteperson.jsp");
		modelAndView.addObject("person", new Person());
		return modelAndView;
	}

	@RequestMapping("/delete")
	public ModelAndView delete(@RequestParam(name = "id") int id) {
		boolean b = pService.delete(id);
		if (b) {
			ModelAndView modelAndView = new ModelAndView("viewall");
			return modelAndView;

		} else {
			ModelAndView modelAndView = new ModelAndView("comman.jsp");
			modelAndView.addObject("msg", "Deletion failed");
			return modelAndView;
		}

	}

	@RequestMapping("/viewall")
	public ModelAndView getAllPerson() {
		List<Person> persons = pService.getAllPersons();

		ModelAndView modelAndView = new ModelAndView("DisplayAll.jsp");
		modelAndView.addObject("persons", persons);
		return modelAndView;
	}

	@RequestMapping("/update")
	public ModelAndView Update(@RequestParam(name = "id") int id) {

		ModelAndView modelAndView = new ModelAndView("update.jsp");
		Person person = pService.getPersonById(id);
		modelAndView.addObject("person", person);
		return modelAndView;

	}

	@RequestMapping("/updateperson")
	public ModelAndView updateperson(@ModelAttribute Person p) {
		Person p2 = pService.updatePerson(p,p.getId());
		if (p2!= null) {
			ModelAndView modelAndView = new ModelAndView("viewall");
			return modelAndView;
		} 
		else {
			ModelAndView modelAndView = new ModelAndView("comman.jsp");
			modelAndView.addObject("msg", "NO person To Update");

			return modelAndView;
		}

	}

}
