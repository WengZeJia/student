package com.wzj.ssm.test;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wzj.ssm.dao.modelMapper.ExamMapper;
import com.wzj.ssm.dao.modelMapper.SchoolMapper;
import com.wzj.ssm.dao.modelMapper.TeacherInfoMapper;
import com.wzj.ssm.entity.Exam;
import com.wzj.ssm.entity.School;
import com.wzj.ssm.entity.TeacherInfo;
import com.wzj.ssm.service.SchoolService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/spring.xml","classpath*:spring/springmvc.xml" })
public class SpringTest extends AbstractJUnit4SpringContextTests {
	@Resource
	private SchoolMapper schoolMapper;
	@Resource
	private SchoolService schoolService;
	@Resource
	private SqlSession sqlSession;
	
	@Resource
	private TeacherInfoMapper teacherInfoMapper;
	
	@Test
	public void test212() {
		ExamMapper mapper = sqlSession.getMapper(ExamMapper.class);
		//查询全部
		List<Exam> examList = mapper.select(new Exam());
		System.out.println(examList);
		//通用Example查询
//		Example example = new Example(Country.class);
//		example.createCriteria().andGreaterThan("id", 100);
//		countryList = mapper.selectByExample(example);
		
		
	}
	
	@Test
	public void testSchoolDaoInsert() {
		School school = new School();
		school.setSchoolName("九洲基小学");
		school.setSchoolType("gb");
		school.setDescription("垃圾学校");
		schoolMapper.insert(school);
	}
	
	@Test
	public void testSchoolDaoSel() {
		School school = schoolMapper.selectByPrimaryKey(1);
		System.out.println("id:" + school.getSchoolId() + "\tname:" + school.getSchoolName() + "\tschool_type:" + school.getSchoolType() + "\tdescription:" + school.getDescription());
	}
	
	@Test
	public void testSchoolDaoUpdate() {
		School school = schoolMapper.selectByPrimaryKey(1);
		school.setSchoolName("菊城小学");
		schoolMapper.updateByPrimaryKey(school);
	}
	
	@Test
	public void testSchoolServiceSel() {
		School school = schoolService.selectByPrimaryKey(1);
		System.out.println("id:" + school.getSchoolId() + "\tname:" + school.getSchoolName() + "\tschool_type:" + school.getSchoolType() + "\tdescription:" + school.getDescription());
	}
	
	@Test
	public void testTeacherInfoInsert() {
		TeacherInfo teacherInfo = new TeacherInfo();
		teacherInfo.setNumber("123");
		teacherInfo.setPassword("111");
		teacherInfoMapper.insert(teacherInfo);
		System.out.println("添加老师成功");
	}
	@Test
	public void testTeacherInfoSelectList() {
		TeacherInfo teacherInfo = new TeacherInfo();
		teacherInfo.setNumber("111");
		teacherInfo.setPassword("111");
		List<TeacherInfo> selectList = teacherInfoMapper.selectByRowBounds(null, new RowBounds(1, 1));
//		List<TeacherInfo> selectList = teacherInfoMapper.selectList();
//		List<TeacherInfo> selectList = teacherInfoMapper.selectAll();
		System.out.println(selectList);
	}
}