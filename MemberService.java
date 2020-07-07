package kr.co.sm.member.service;

import java.util.Map;

import kr.co.sm.member.dto.MemberDTO;
import kr.co.sm.member.dto.PageDTO;

public interface MemberService {

		public int joinMember(MemberDTO mdto, PageDTO pdto);
		public Map<String, Object> memberList(MemberDTO mdto, PageDTO pdto);
		public int idCheck(String userid);
		public MemberDTO memInfo(MemberDTO mdto);
		public void memDelete(MemberDTO mdto);
		
		
}
