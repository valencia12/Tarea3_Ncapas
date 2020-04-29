package com.uca.capas.tarea3.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@RequestMapping("/ingresar")
	public ModelAndView ingresar() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("ingresar");
		return mav;
	}

	@RequestMapping("/alumno")
	public ModelAndView alumno(
			@RequestParam String name, 
			@RequestParam String lastname,
			@RequestParam String born,
			@RequestParam String place,
			@RequestParam String college,
			@RequestParam String tel,
			@RequestParam String phone) throws ParseException {
		
		ModelAndView mav = new ModelAndView();
		
		ArrayList<String> arrayError = new ArrayList<String>();
		
		if(name.length() > 25 || name.length() < 1) {
			
			arrayError.add("La longitud debe de ser menor que 25 y mayor 1");
		}
		if(lastname.length() > 25 || lastname.length() < 1) {
			
			arrayError.add("la longitud debe ser mayor a 1 y menor a 25");
		}
		
		System.out.println(born);
		
		if(compararFecha(born)){
			arrayError.add("la longitud debe ser mayor al 1 de enero del 2003");

		}

		if(place.length() > 25 || place.length() < 1) {

			arrayError.add("la longitud debe ser mayor a 1 y menor a 25");
		}

		if(college.length() > 100 || college.length() < 1) {

			arrayError.add("la longitud del  debe ser mayor a 1 y menor a 25");
		}
		if(tel.length() != 8) {
			arrayError.add("la longitud debe tener 8 digitos!");

		}
		if(phone.length() != 8) {
			arrayError.add("la longitud debe tener 8 digitos!");
		}
		
		if(arrayError.isEmpty()){
			mav.setViewName("AcessoC");
		}else {
			mav.addObject("req", arrayError);
			mav.setViewName("AcessoD");
			}
			return mav;
		}




		public boolean compararFecha(String fecha1) throws ParseException {
			String fechaMin = "2003-01-01";
			SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd"); 
			
			Date fechaEntrada1 = formateador.parse(fecha1);
			Date fechaEntrada2 = formateador.parse(fechaMin);
			
			if(fechaEntrada1.before(fechaEntrada2)) {
				return true;
			}else {
				return false;
			}  
		}
	}