package com.example.shixi.controller;

import com.example.shixi.mapper.testMapper;
import com.example.shixi.model.testData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
public class DetectionController {
    @Autowired
    private testMapper testMapper;
    @CrossOrigin
    @RequestMapping("/detection")
    @ResponseBody
    public List tset(HttpServletResponse response, @RequestParam("table_name") String table_name) throws Exception{
        List<testData> list=testMapper.detectionData(table_name);
//        System.out.println(table_name);
        String[] xarr = new String[list.size()];//为了保证不出现空指针
        Double[] yarr = new Double[list.size()];

        for (int i = 0 ; i < list.size(); i++) {
            xarr[i] = list.get(i).getReportTime().toString();//x轴的数据
            yarr[i] = (1.00*list.get(i).getT1()/100);//y轴的数据
        }
        List list2 = new ArrayList();
        list2.add(xarr);
        list2.add(yarr);
//        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxx");//写这个是为了自己在控制台检测咱们的异步交互是否是实时进行的,如果是,控制台会一直打印这个xxx
//        System.out.println(xarr.length);
        return list2;
    }
}
