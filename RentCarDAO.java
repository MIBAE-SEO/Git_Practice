package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class RentCarDAO {

	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	//커넥션풀을 이용한 데이터 베이스 연결
	
	public void getCon() {
	
		try {
			
			Context initctx = new InitialContext();
			Context envctx = (Context) initctx.lookup("java:comp/env");
			DataSource ds = (DataSource) envctx.lookup("jdbc/pool");
			con=ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	//최신순 3대의 자동차를 리턴
	public Vector<CarListBean> getSelectCar(){
		
		//리턴타입설정
		Vector<CarListBean> v = new Vector<>();
		getCon();
		
		
		try {
			
			String sql = "select * from rentcar order by no desc";
			pstmt = con.prepareStatement(sql);
			
			//쿼리 실행 후 결과를 리턴받음
			rs = pstmt.executeQuery();
			int count = 0;
			while(rs.next()) {
				
				CarListBean bean = new CarListBean();
					bean.setNo(rs.getInt(1));
					bean.setName(rs.getString(2));
					bean.setCategory(rs.getInt(3));
					bean.setPrice(rs.getInt(4));
					bean.setUsepeople(rs.getInt(5));
					bean.setCompany(rs.getString(6));
					bean.setImg(rs.getString(7));
					bean.setInfo(rs.getString(8));
					
					//벡터에 bean클래스 저장
					v.add(bean);
					count++;
					if(count > 2)break; //반복문 탈출 
				}
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return v;
	}
	
	//카테고리별 자동차 리스트를 저장하는 메소드
	public Vector<CarListBean> getCategoryCar(int cate){
		
		Vector<CarListBean> v = new Vector<>();
		//데이터를 저장할 빈 클래스 선언
		
		CarListBean bean = null;
		getCon();
		
		try {
			String sql = "select * from rentcar where category=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cate);
			rs=pstmt.executeQuery();
			
			//반복문을 돌면서 데이터를 저장
			while(rs.next()) {
				//데이터를 저장할 빈클래스 생성
					bean = new CarListBean();
					bean.setNo(rs.getInt(1));
					bean.setName(rs.getString(2));
					bean.setCategory(rs.getInt(3));
					bean.setPrice(rs.getInt(4));
					bean.setUsepeople(rs.getInt(5));
					bean.setCompany(rs.getString(6));
					bean.setImg(rs.getString(7));
					bean.setInfo(rs.getString(8));
					
					//벡터에 bean클래스 저장
					v.add(bean);
				}
				con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			return v;
	}
	
	
	// 전체 차량을 검색하는 메소드
	
	public Vector<CarListBean> getAllCar(){
	
	
	Vector<CarListBean> v = new Vector<>();
	//데이터를 저장할 빈 클래스 선언
	
	CarListBean bean = null;
	getCon();
	
	try {
		String sql = "select * from rentcar";
		pstmt = con.prepareStatement(sql);
		rs=pstmt.executeQuery();
		
		//반복문을 돌면서 데이터를 저장
		while(rs.next()) {
			//데이터를 저장할 빈클래스 생성
				bean = new CarListBean();
				bean.setNo(rs.getInt(1));
				bean.setName(rs.getString(2));
				bean.setCategory(rs.getInt(3));
				bean.setPrice(rs.getInt(4));
				bean.setUsepeople(rs.getInt(5));
				bean.setCompany(rs.getString(6));
				bean.setImg(rs.getString(7));
				bean.setInfo(rs.getString(8));
				
				//벡터에 bean클래스 저장
				v.add(bean);
			}
			con.close();
		
	} catch (Exception e) {
		e.printStackTrace();
	}
		return v;
	
}
	
	//하나의 자동차 정보를 리턴하는 메소드
	public CarListBean getOneCar(int no){ 
		
		//리턴타입 선언
		CarListBean bean = new CarListBean();
		getCon();
		
		try {
			String sql = "select * from rentcar where no =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				//데이터를 저장할 빈클래스 생성
					bean.setNo(rs.getInt(1));
					bean.setName(rs.getString(2));
					bean.setCategory(rs.getInt(3));
					bean.setPrice(rs.getInt(4));
					bean.setUsepeople(rs.getInt(5));
					bean.setCompany(rs.getString(6));
					bean.setImg(rs.getString(7));
					bean.setInfo(rs.getString(8));
					
				}
				con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}
	
	
	//회원정보가 있는지를 비교 (기존의 Member2테이블 이용)
	public int getMember(String id, String pass) {
		
		int result =0; //0이면 회원 없음
		getCon();
		
		
		try {
			String sql = "select count(*) from member2 where id=? and password1=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pass); 
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				result=rs.getInt(1); //0또는 1이 저장됨
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	

	//하나의 예약정보를 저장하는 메소드
	public void setReserveCar(CarReserveBean bean) {
		getCon();
		
		try {
			String sql = "insert into carreserve values(reserve_seq.NEXTVAL,?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, bean.getNo());
			pstmt.setString(2, bean.getId());
			pstmt.setInt(3, bean.getQty());
			pstmt.setInt(4, bean.getDday());
			pstmt.setString(5, bean.getRday());
			pstmt.setInt(6, bean.getUsein());
			pstmt.setInt(7, bean.getUsewifi());
			pstmt.setInt(8, bean.getUsenavi());
			pstmt.setInt(9, bean.getUseseat());
			
			pstmt.executeUpdate();
			
			con.close();
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
