package song.type.night.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import song.type.night.dao.imp.CartDAOImp;
import song.type.night.vo.Cart;

@Service
public class CartService {
	@Autowired
	private CartDAOImp dao;
	
	//카트에 상품 있는지 받아오기
	public int countCartItem(Cart c) {
		return dao.countCartItem(c);
	}
	
	//카트에 들어 있는 상품 업데이트
	public void updateCartItem(Cart c) {
		dao.updateCart(c);
	}
	
	//카트에 상품 추가
	public void insertCartItem(Cart c) {
		dao.insertCart(c);
	}
	
	//카트 총 가격 합
	public float totalPrice(int uid) {
		return dao.sumPrice(uid);
	}
	
	//장바구니와 아이템이 조인된 결과를 리턴
	public List<Map<String, Object>> totalCartItem(int uid){
		return dao.selectCartItemList(uid);
	}
	
	//장바구니에서 물건 삭제
	public void deleteCart(Cart c) {
		dao.deleteCart(c);
	}

}
