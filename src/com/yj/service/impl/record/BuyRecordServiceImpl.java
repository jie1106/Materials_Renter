package com.yj.service.impl.record;





import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.yj.dao.BuyRecordDao;
import com.yj.domain.Container;
import com.yj.domain.Materials;
import com.yj.service.serviceInterface.RecordService;

public class BuyRecordServiceImpl implements RecordService {

	public void add(Container container) {
		BuyRecordDao buyRecordDao = new BuyRecordDao();
		buyRecordDao.add(container);
		
	}

	public Container findContainerByListId(String listId) {
	return new BuyRecordDao().findContainerByListId(listId);
	}



}
