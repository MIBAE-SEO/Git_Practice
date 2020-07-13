package kr.co.sol.admin.service;

import java.util.List;

import kr.co.sol.shop.dto.OrderDTO;

public interface OrderMgrService {

	List<OrderDTO> getOrders(OrderDTO odto); 

}
