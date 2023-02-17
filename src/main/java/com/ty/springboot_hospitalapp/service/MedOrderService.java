package com.ty.springboot_hospitalapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hospitalapp.dao.EncounterDao;
import com.ty.springboot_hospitalapp.dao.MedOrderDao;
import com.ty.springboot_hospitalapp.dto.Branch;
import com.ty.springboot_hospitalapp.dto.MedOrder;
import com.ty.springboot_hospitalapp.exception.EncounterNotFoundException;
import com.ty.springboot_hospitalapp.exception.MedOrderNotFoundException;
import com.ty.springboot_hospitalapp.util.ResponseStructure;

@Service
public class MedOrderService {
	
	@Autowired
	private MedOrderDao medOrderDao;
	
	@Autowired
	private EncounterDao encounterDao;
	
	public ResponseEntity<ResponseStructure<MedOrder>> save(MedOrder medOrder,int eid) {
		medOrder.setEncounter(encounterDao.getEncounterByid(eid));
		MedOrder medOrder2 = medOrderDao.saveMedOrder(medOrder);
		ResponseStructure< MedOrder> structure = new ResponseStructure<>();
		if(encounterDao.getEncounterByid(eid)!=null) {
			medOrder.setEncounter(encounterDao.getEncounterByid(eid));
			structure.setData(medOrder2);
			structure.setMessage("saved");
			structure.setStatus(HttpStatus.CREATED.value());
			
			return new ResponseEntity<ResponseStructure<MedOrder>>(structure,HttpStatus.CREATED);
		}else {
			throw new EncounterNotFoundException("Encounter not found for given id "+eid+" to add MedOrder");
		}
	}
	
	public ResponseEntity<ResponseStructure<MedOrder>> update(MedOrder medOrder,int mid) {
		MedOrder medOrder2 = medOrderDao.updateMedOrder(medOrder, mid);
		ResponseStructure< MedOrder> structure = new ResponseStructure<>();
		if(medOrderDao.getMedOrderById(mid)!=null) {
			structure.setData(medOrder2);
			structure.setMessage("updated");
			structure.setStatus(HttpStatus.CREATED.value());
			
			return new ResponseEntity<ResponseStructure<MedOrder>>(structure,HttpStatus.OK);
		}else {
		
			throw new MedOrderNotFoundException("MedOrder not found for given id "+mid+" to update");
		}
	}

	public ResponseEntity<ResponseStructure<MedOrder>> delete(int mid) {
		MedOrder medOrder2 = medOrderDao.deleteMedOrder(mid);
		ResponseStructure< MedOrder> structure = new ResponseStructure<>();
		if(medOrder2!=null) {
			structure.setData(medOrder2);
			structure.setMessage("deleted");
			structure.setStatus(HttpStatus.OK.value());
			
			return new ResponseEntity<ResponseStructure<MedOrder>>(structure,HttpStatus.OK);
		}else {
		
			throw new MedOrderNotFoundException("MedOrder not found for given id "+mid+" to delete");
		}
	} 
	
	public ResponseEntity<ResponseStructure<MedOrder>> get(int mid) {
		MedOrder medOrder2 = medOrderDao.getMedOrderById(mid);
		ResponseStructure< MedOrder> structure = new ResponseStructure<>();
		if(medOrder2!=null) {
			structure.setData(medOrder2);
			structure.setMessage("found");
			structure.setStatus(HttpStatus.OK.value());
			
			return new ResponseEntity<ResponseStructure<MedOrder>>(structure,HttpStatus.OK);
		}else {
		
			throw new MedOrderNotFoundException("MedOrder not found for given id "+mid);
		}
	} 
	
	public List<MedOrder> getAll(){
		return medOrderDao.getAllMedOrder();
	}
}
