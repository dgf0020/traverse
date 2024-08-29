package com.traverse.www.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.traverse.www.vo.PlaceVO;

@Mapper
public interface AccommodationDAO {
	@Select("select * from accomm order by areacode")
	List<PlaceVO> selectAll();
	
  @Select("select * from accomm where title LIKE CONCAT('%', #{title}, '%')")
  List<PlaceVO> selectByTitle(String title);
  
  @Select("select * from accomm where areacode = #{areacode}")
  List<PlaceVO> selectByAreaCode(String areaCode);
	
  @Select("select DISTINCT areacode from accomm order by areacode")
  List<String> selectAllAreaCodes();
}
