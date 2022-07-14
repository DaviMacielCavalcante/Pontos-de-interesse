package com.poi.main.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
		List<POI> list = new ArrayList<>();
		for (POI poi : list) {
			if (x <= dMax && y <= dMax) {
				list.add(poi);
			}
		}
		return list;
	}
}
