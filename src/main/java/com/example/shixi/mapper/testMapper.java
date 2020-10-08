package com.example.shixi.mapper;

import com.example.shixi.model.Search;
import com.example.shixi.model.testData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface testMapper {
    List<testData> findAll();
    List<testData> findByName(String table_name);
    List<testData> findByTime(String date);
    List<testData> findByNameAndTime(Search search);
    List<testData> findByColumn(Search search);
    List<testData> findByColumnAndArea(Search search);
}