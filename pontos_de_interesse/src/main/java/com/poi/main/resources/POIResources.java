package com.poi.main.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poi.main.entities.POI;
import com.poi.main.services.POIService;

@RestController
@RequestMapping("/pois")
public class POIResources {

	@Autowired
	private POIService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<POI> find(@PathVariable Integer id){
		POI poi = service.findById(id);
		return ResponseEntity.ok().body(poi);
	}	
	
	@RequestMapping(value = "/all" ,method = RequestMethod.GET)
	public ResponseEntity<List<POI>> findAll(){
		List<POI> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value = "/coord" ,method = RequestMethod.GET)
	public ResponseEntity<List<POI>> findByCoord(
			@RequestParam(value = "cx", defaultValue = "") Integer x,
			@RequestParam(value = "cy", defaultValue = "") Integer y,
			@RequestParam(value = "dMax", defaultValue = "") Integer dMax){
		List<POI> list = service.findCoord(x, y, dMax);
		return ResponseEntity.ok().body(list);
	}	
}
