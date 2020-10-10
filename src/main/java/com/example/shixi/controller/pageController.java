package com.example.shixi.controller;

import com.example.shixi.mapper.testMapper;
import com.example.shixi.model.Pager;
import com.example.shixi.model.pagCount;
import com.example.shixi.model.testData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
public class pageController {
    @Autowired
    private testMapper testMapper;
//    @CrossOrigin
//    @RequestMapping("/testPage")
//    @ResponseBody
//    public List<testData> list(HttpServletResponse response, @RequestParam("table_name") String table_name) throws Exception{
//        List<testData> list=testMapper.findByName("V10000");
//        System.out.println(table_name);
//        return list;
//    }
    @CrossOrigin
    @PostMapping("/page")
    @ResponseBody
    List<testData> list(HttpServletResponse response, @RequestBody Pager pager){
        System.out.println(pager.getBegin()+"\t"+pager.getEnd());
        List<testData> list=testMapper.findPage(pager);
        return list;
    }
    @RequestMapping("pageCount")
    @CrossOrigin
    @ResponseBody
    public List<pagCount> list(HttpServletResponse response,@RequestParam("table_name") String table_name){
        List<Integer> list=testMapper.findPageCount(table_name);
        System.out.println(list.get(0));
        pagCount pagecount=new pagCount();
        pagecount.setPageCount(list.get(0));
        List<pagCount> list1=new ArrayList<>();
        list1.add(pagecount);
        return list1;

    }
}
