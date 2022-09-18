package member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


@Repository
public class MemberDAO {
	@Autowired @Qualifier("hanul") private SqlSession sql;
	
	// 회원정보 1건 != 회원정보 리스트 
	// ObjectVO  != Collection
	public MemberVO login(MemberVO vo) {
		return sql.selectOne("member.login" , vo);// id와 pw 두개의 변수를 하나로 묶어서 로그인시 확인
	}
	
}
