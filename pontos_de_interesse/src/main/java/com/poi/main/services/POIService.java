package com.poi.main.services;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.management.InvalidAttributeValueException;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poi.main.entities.POI;
import com.poi.main.repositories.POIRepository;

@Service
public class POIService {

	@Autowired
	private POIRepository repo;
	
	public POI findById(Integer id) {
		Optional<POI> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + 
		id + ", Tipo: " + POI.class.getName(), null));
	}
	
	public List<POI> findAll(){
		return repo.findAll();
	}
	
	public List<POI> findCoord(Integer x, Integer y, Integer dMax){
		List<POI> list = repo.findAll();
		List<POI> fList = new ArrayList<>();		
		for (POI poi : list) {
			if (poi.getCx() <= x + dMax && poi.getCy() <= y + dMax) {
				fList.add(poi);
			}
		}
		return fList;
	}
	
	public POI insert(POI poi) {
		return repo.save(poi);
	}
	
	public POI update(Integer id, POI poi) throws InvalidAttributeValueException {
		POI obj = findById(id);
		updateData(obj, poi);
		return repo.save(obj);
	}

	private void updateData(POI obj, POI poi) throws InvalidAttributeValueException {
		obj.setId(poi.getId());
		obj.setNome(poi.getNome());
		obj.setCx(poi.getCx());
		obj.setCy(poi.getCy());
	}
}
