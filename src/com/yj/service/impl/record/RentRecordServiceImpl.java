package com.yj.service.impl.record;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.yj.dao.BuyRecordDao;
import com.yj.dao.RentRecordDao;
import com.yj.domain.Container;
import com.yj.domain.Materials;
import com.yj.domain.Renter;
import com.yj.service.serviceInterface.RecordService;

public class RentRecordServiceImpl implements RecordService {

	//表中没有该renter
	public void addRenterBoth(Renter renter) {
		RentRecordDao dao = new RentRecordDao();
		dao.addRenterBoth(renter);
		
	}

	public boolean isRenterHas(String renterId) {
		// TODO Auto-generated method stub
		
		RentRecordDao dao = new RentRecordDao();
		return dao.isRenterHas(renterId);
		
	}

		public boolean isMaterBeRentByListId(String listId) {
		
		
		return new RentRecordDao().isMaterBeRentByListId(listId);
		
		
	
		
	}

	public boolean isRenterIdHas(String renterId) {
		return new RentRecordDao().isRenterIdHas(renterId);

		// TODO Auto-generated method stub

	}

	public void addRenter2mr(Renter renter) {
		// TODO Auto-generated method stub
		new RentRecordDao().addRenter2mr(renter);
		
	}

	public void setMStatus1ByListId(String listId) {
		new RentRecordDao().setMStatus1ByListId(listId);
		
	}

	

/*	public void addRenter2renter(Renter renter) {
		new RentRecordDao().addRenter2renter(renter);
	}
*/

	
}
