package hr;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class HrDAO {
	@Autowired @Qualifier("hr") private SqlSession sql;
	
	
	public void test() {
		System.out.println(sql.selectOne("hr.test"));
	}
	public List<HrVO> getList(String keyword){
		return sql.selectList("hr.list",keyword);
	}
	
	
}
