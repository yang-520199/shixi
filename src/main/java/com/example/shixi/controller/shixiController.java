package com.example.shixi.controller;

import com.example.shixi.mapper.testMapper;
import com.example.shixi.model.Search;
import com.example.shixi.model.testData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class shixiController {
    @Autowired
    private testMapper testMapper;
    @CrossOrigin
    @ResponseBody
    @PostMapping("result")

    public List<HashMap<String, Integer>> list(@RequestBody Search search,HttpServletResponse response) throws Exception{
        List<testData> list2=testMapper.findByColumn(search);
        System.out.println(search.getSelectKind()+"\n"+search.getSelectDate()+"\n"+search.getSelectArea());
        List<HashMap<String, Integer>> list1=new ArrayList<>();

        if (search.getSelectKind().equals("T1")){
            for (int i = 0; i <list2.size() ; i++) {
                HashMap<String, Integer> val=new HashMap<>();
                val.put("name",i);
                val.put("value",list2.get(i).getT1());
                list1.add(val);
            }
        } else {
            if (search.getSelectKind().equals("T2")){
                for (int i = 0; i <list2.size() ; i++) {
                    HashMap<String, Integer> val=new HashMap<>();
                    val.put("name",i);
                    val.put("value",list2.get(i).getT2());
                    list1.add(val);
                }
            }else {
                if (search.getSelectKind().equals("T3")){
                    for (int i = 0; i <list2.size() ; i++) {
                        HashMap<String, Integer> val=new HashMap<>();
                        val.put("name",i);
                        val.put("value",list2.get(i).getT3());
                        list1.add(val);
                    }
                }
                else {
                    for (int i = 0; i <list2.size() ; i++) {
                        HashMap<String, Integer> val=new HashMap<>();
                        val.put("name",i);
                        val.put("value",list2.get(i).getT4());
                        list1.add(val);
                    }
                }
            }

        }
        return list1;
    }
}
