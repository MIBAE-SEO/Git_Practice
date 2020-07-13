package kr.co.sol.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import kr.co.sol.admin.dao.OrderMgrDAO;
import kr.co.sol.admin.service.OrderMgrService;
import kr.co.sol.shop.dto.OrderDTO;

public class OrderMgrServiceImpl implements OrderMgrService{
	
	@Autowired  
	OrderMgrDAO orderMgrDao;


	@Override
	public List<OrderDTO> getOrders(OrderDTO odto) {
		return orderMgrDao.getOrders(odto);
	}

}
