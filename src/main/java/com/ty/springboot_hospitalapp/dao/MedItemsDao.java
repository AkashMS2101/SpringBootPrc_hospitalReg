package com.ty.springboot_hospitalapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_hospitalapp.dto.Hospital;
import com.ty.springboot_hospitalapp.dto.MedItems;
import com.ty.springboot_hospitalapp.repo.MedItemsRepo;

@Repository
public class MedItemsDao {

	@Autowired
	private MedItemsRepo medItemsRepo;
	
	public MedItems saveMedItem(MedItems items) {
		return medItemsRepo.save(items);
	}
	
	public MedItems updatemedItems(MedItems items,int mid) {
		if(medItemsRepo.findById(mid).isPresent()) {
			items.setBill_id(medItemsRepo.findById(mid).get().getBill_id());
			items.setMedOrder(medItemsRepo.findById(mid).get().getMedOrder());
			return medItemsRepo.save(items);
		}else {
			return null;
		}
	}
	
	public MedItems deleteMeditems(int mid) {
		if(medItemsRepo.findById(mid).isPresent()) {
			MedItems items = medItemsRepo.findById(mid).get();
			medItemsRepo.delete(items);
			return items;
		}else {
			return null;
		}
	}
	
	public MedItems getMeditems(int mid) {
		if(medItemsRepo.findById(mid).isPresent()) {
			return medItemsRepo.findById(mid).get();
		}else {
			return null;
		}
	}
	
	public List<MedItems> getAllMedItems() {
		return medItemsRepo.findAll();
	}
}
