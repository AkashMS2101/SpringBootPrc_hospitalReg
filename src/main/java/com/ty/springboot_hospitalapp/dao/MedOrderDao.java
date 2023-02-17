package com.ty.springboot_hospitalapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_hospitalapp.dto.Hospital;
import com.ty.springboot_hospitalapp.dto.MedOrder;
import com.ty.springboot_hospitalapp.repo.MedOrderRepo;

@Repository
public class MedOrderDao {
	
	@Autowired
	private MedOrderRepo medOrderRepo;
	
	public MedOrder saveMedOrder(MedOrder medOrder) {
		return medOrderRepo.save(medOrder);
	}
	
	public MedOrder updateMedOrder(MedOrder medOrder,int mid) {
		MedOrder medOrder2 = medOrderRepo.findById(mid).get();
		if(medOrder2!=null) {
			medOrder.setMedOrder_id(mid);
			medOrder.setEncounter(medOrder2.getEncounter());
			return medOrderRepo.save(medOrder);
		}else {
			return null;
		}
	}
	public MedOrder deleteMedOrder(int mid) {
		if(medOrderRepo.findById(mid).isPresent()) {
			MedOrder medOrder = medOrderRepo.findById(mid).get();
			medOrderRepo.delete(medOrder);
			return medOrder;
		}else {
			return null;
		}
	}
	
	public MedOrder getMedOrderById(int mid) {
		if(medOrderRepo.findById(mid).isPresent()) {
			return medOrderRepo.findById(mid).get();
		}else {
			return null;
		}
	}
	
	public List<MedOrder> getAllMedOrder() {
		return medOrderRepo.findAll();
	}
}
