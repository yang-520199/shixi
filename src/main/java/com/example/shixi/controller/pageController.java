package com.example.shixi.controller;

import com.example.shixi.mapper.testMapper;
import com.example.shixi.model.Pager;
import com.example.shixi.model.Search;
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
    @CrossOrigin
    @RequestMapping("/testPage")
    @ResponseBody
    public List<testData> list1(HttpServletResponse response, @RequestParam("table_name") String table_name) throws Exception{
        List<testData> list=testMapper.findByName("V10000");
        System.out.println(table_name);
        return list;
    }
    @CrossOrigin
    @PostMapping("/page")
    @ResponseBody
    List<testData> list(HttpServletResponse response, @RequestBody Pager pager){
        System.out.println(pager.getBegin()+"\t"+pager.getEnd()+"\t"+pager.getSelectDate()+"\t"+pager.getSelectArea());
        List<testData> list=null;

        if (pager.getSelectDate().length()>0){
            list=testMapper.findPage1(pager);
        }
        else {
            list=testMapper.findPage(pager);
        }

        return list;
    }
    @PostMapping("/pageCount")
    @CrossOrigin
    @ResponseBody
    public List<pagCount> list(HttpServletResponse response, @RequestBody Search search){
        List<pagCount> list1=null;
        System.out.println(search.getSelectArea());
        if (search.getSelectDate().length()>0){
            List<Integer> list=testMapper.findPageCount1(search);
            System.out.println(list.get(0));
            pagCount pagecount=new pagCount();
            pagecount.setPageCount(list.get(0)+1);
            System.out.println(list.get(0)+1);
            list1=new ArrayList<>();
            list1.add(pagecount);
        }
        else {
            List<Integer> list=testMapper.findPageCount(search.getSelectArea());
            System.out.println(list.get(0));
            pagCount pagecount=new pagCount();
            pagecount.setPageCount(list.get(0)+1);
            System.out.println(list.get(0)+1);
            list1=new ArrayList<>();
            list1.add(pagecount);

        }

        return list1;

    }
}
