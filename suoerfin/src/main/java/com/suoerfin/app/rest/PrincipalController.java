package com.suoerfin.app.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suoerfin.app.dao.EmpleadosDAO;
import com.suoerfin.app.dao.PersonasDAO;
import com.suoerfin.app.dao.TramitesDAO;
import com.suoerfin.app.entity.Tramite;

@RestController
@RequestMapping("/")
public class PrincipalController {
	
	@Autowired
	private TramitesDAO tramitesDAO;
	
	@Autowired
	private PersonasDAO personasDAO;
	
	@Autowired
	private EmpleadosDAO empleadosDAO;
	
	@GetMapping
	public ResponseEntity<List<Tramite>> getCustomer(){		
		List<Tramite> tramites = tramitesDAO.findAll();		
		return ResponseEntity.ok(tramites);		
	}
	
	@RequestMapping(value="{tramiteId}")
	public ResponseEntity<Tramite> getCustomerById(@PathVariable("tramiteId") Long tramiteId){
		
		Optional<Tramite> optTramite = tramitesDAO.findById(tramiteId);
		
		if(optTramite.isPresent()) {
			return ResponseEntity.ok(optTramite.get());
		}else {
			return ResponseEntity.noContent().build();
		}		
	}
	
	@PostMapping
	public ResponseEntity<Tramite> createTramite(@RequestBody Tramite tramite){
		Tramite newTramite = tramitesDAO.save(tramite);
		return ResponseEntity.ok(newTramite);
	}

}
