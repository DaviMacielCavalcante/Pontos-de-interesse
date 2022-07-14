package com.poi.main.resources;

import java.net.URI;
import java.util.List;

import javax.management.InvalidAttributeValueException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.poi.main.entities.POI;
import com.poi.main.resources.utils.URL;
import com.poi.main.services.POIService;

@RestController
@RequestMapping("/poi")
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
	
	@RequestMapping(value = "/c" , method = RequestMethod.GET)
	public ResponseEntity<List<POI>> findByCoord(
			@RequestParam(value = "cx", defaultValue = "") String x,
			@RequestParam(value = "cy", defaultValue = "") String y,
			@RequestParam(value = "dMax", defaultValue = "") String dMax){
		
		Integer xDecoded = URL.decodeParam(x);
		Integer yDecoded = URL.decodeParam(y);
		Integer dMaxDecoded = URL.decodeParam(dMax);
		
		List<POI> list = service.findCoord(xDecoded, yDecoded, dMaxDecoded);
		return ResponseEntity.ok().body(list);
	}	
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody POI poi){
		poi = service.insert(poi);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(poi.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody POI poi, @PathVariable Integer id) throws InvalidAttributeValueException{
		 poi.setId(id);
		 poi = service.update(id, poi);
		 return ResponseEntity.noContent().build();
	}
}
