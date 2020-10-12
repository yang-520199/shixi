package com.example.shixi.controller;

import com.example.shixi.mapper.testMapper;
import com.example.shixi.model.Search;
import com.example.shixi.model.testData;
import com.example.shixi.utils.EcDtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
@RestController

public class TestController {
    @Autowired
    private testMapper testMapper;
    @CrossOrigin
    @RequestMapping("/tset")
    @ResponseBody
   public List<HashMap<String, Object>> barData(HttpServletRequest request){
        List<HashMap<String, Object>> bList = EcDtUtils.getBarRndVal();
        return bList;
    }
    @CrossOrigin
    @RequestMapping("/aa")
    @ResponseBody
    public List<testData> tset(){
        List<testData> list=testMapper.findByTime("2017-10-08");
        System.out.println(list.get(1).getReportTime());
        return list;
    }
    @CrossOrigin
    @RequestMapping("/testData")
    @ResponseBody
    public List<testData> list(HttpServletResponse response, @RequestParam("table_name") String table_name) throws Exception{
        List<testData> list=testMapper.findByName("V10000");
        System.out.println(table_name);
        return list;
    }
    @CrossOrigin
    @ResponseBody
    @PostMapping("showData")
    public List<testData> list(@RequestBody Search search, HttpServletResponse response) {
        List<testData> list=null;
        System.out.println(search.getSelectDate().length());
        System.out.println(search.getSelectArea()+"\n"+search.getSelectDate());
        if (search.getSelectDate()!=null&&search.getSelectDate().length()>0){
            list=testMapper.findByNameAndTime(search);
        }
        else {
            if (search.getSelectDate().length()>0){
                list=testMapper.findByTime(search.getSelectDate());
            }
            else {
                list=testMapper.findByName(search.getSelectArea());
            }
        }
        System.out.println(list);
        return list;
    }
}
