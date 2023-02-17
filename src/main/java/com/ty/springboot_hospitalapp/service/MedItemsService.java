package com.ty.springboot_hospitalapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.ty.springboot_hospitalapp.dao.MedItemsDao;
import com.ty.springboot_hospitalapp.dao.MedOrderDao;
import com.ty.springboot_hospitalapp.dto.Branch;
import com.ty.springboot_hospitalapp.dto.MedItems;
import com.ty.springboot_hospitalapp.dto.MedOrder;
import com.ty.springboot_hospitalapp.exception.MedItemsNotFoundException;
import com.ty.springboot_hospitalapp.exception.MedOrderNotFoundException;
import com.ty.springboot_hospitalapp.util.ResponseStructure;

@Service
public class MedItemsService {
	
	@Autowired
	private MedItemsDao medItemsDao;
	
	@Autowired
	private MedOrderDao medOrderDao;
	
	public ResponseEntity<ResponseStructure<MedItems>> save(MedItems items,int mid) {
		MedOrder medOrder = medOrderDao.getMedOrderById(mid);
		ResponseStructure<MedItems> structure = new ResponseStructure<>();
		if(medOrder!=null) {
			items.setMedOrder(medOrder);
			medItemsDao.saveMedItem(items);
			structure.setData(items);
			structure.setMessage("saved");
			structure.setStatus(HttpStatus.CREATED.value());
			
			return new ResponseEntity<ResponseStructure<MedItems>>(structure,HttpStatus.CREATED);
		}else {
			throw new MedOrderNotFoundException("MedOrder not found for the given id "+mid+" to add medItem");
		}
	}
	
	public ResponseEntity<ResponseStructure<MedItems>> update(MedItems items,int mid) {
		MedItems medItems = medItemsDao.updatemedItems(items, mid);
		ResponseStructure<MedItems> structure = new ResponseStructure<>();
		if(medItems!=null) {
			structure.setData(medItems);
			structure.setMessage("updated");
			structure.setStatus(HttpStatus.CREATED.value());
			
			return new ResponseEntity<ResponseStructure<MedItems>>(structure,HttpStatus.CREATED);
		}else {
			throw new MedItemsNotFoundException("MedItems not found for the given id"+mid+" to update");
		}
	}
	
	public ResponseEntity<ResponseStructure<MedItems>> delete(int mid){
		MedItems medItems = medItemsDao.deleteMeditems(mid);
		ResponseStructure<MedItems> structure = new ResponseStructure<>();
		if(medItems!=null) {
			structure.setData(medItems);
			structure.setMessage("deleted");
			structure.setStatus(HttpStatus.OK.value());
			
			return new ResponseEntity<ResponseStructure<MedItems>>(structure,HttpStatus.OK);
		}else {
			throw new MedItemsNotFoundException("MedItems not found for the given id"+mid+" to delete");
		}
	}
	
	public ResponseEntity<ResponseStructure<MedItems>> get(int mid){
		MedItems medItems = medItemsDao.getMeditems(mid);
		ResponseStructure<MedItems> structure = new ResponseStructure<>();
		if(medItems!=null) {
			structure.setData(medItems);
			structure.setMessage("found");
			structure.setStatus(HttpStatus.FOUND.value());
			
			return new ResponseEntity<ResponseStructure<MedItems>>(structure,HttpStatus.FOUND);
		}else {
			throw new MedItemsNotFoundException("MedItems not found for the given id"+mid);
		}
	}
	
	public List<MedItems> getAll(){
		return medItemsDao.getAllMedItems();
	}
}
