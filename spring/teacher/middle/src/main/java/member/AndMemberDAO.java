package member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


@Repository
public class AndMemberDAO {
	@Autowired @Qualifier("hanul") private SqlSession sql;
	
	// 회원정보 1건 != 회원정보 리스트 
	// ObjectVO  != Collection
	public AndMemberVO login(AndMemberVO vo, String social) {
		if(social.equals("Y")) {
			return sql.selectOne("andmember.sociallogin" , vo);
		}else {
			return sql.selectOne("andmember.login" , vo);
		}

	}

	public int join(AndMemberVO joinInfo) {
		return sql.insert("andmember.join" , joinInfo);
	}
	
}
