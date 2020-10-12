package com.example.shixi.controller;

import java.net.UnknownHostException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class test {
    public static void main(String args[]) throws UnknownHostException{

        try{
//           int page;
//            Scanner scanner=new Scanner(System.in);
//            System.out.println("请输入查询页数：");
//            page=scanner.nextInt();

//            int begin=(page-1)*10+1;
//            int end=page*10;
//            System.out.println(begin+"\t"+end);
            List<HashMap<Integer, Integer>> list1=new ArrayList<>();
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con=null;
            con= DriverManager.getConnection("jdbc:sqlserver://111.198.53.100:30018;DatabaseName=SYRLGL","test","quickdev789");
//            String sql="select   *   from\n" +
//                    "    (select   *,   ROW_NUMBER()   OVER   (order   by   ReportTime)   AS   ROWNUM   from  V10000 ) t\n" +
//                    "where   ROWNUM   between ? and ?";
            String sql="select top 10 ReportTime from V10000";
            PreparedStatement stm=con.prepareStatement(sql);
            ResultSet resultSet=stm.executeQuery();
            HashMap<String, Integer> map=new HashMap<>();
            while (resultSet.next()){
                System.out.println(resultSet.getDate(1));
                Timestamp ts=resultSet.getTimestamp(1);
                SimpleDateFormat spd=new SimpleDateFormat("YYYY-MM-dd HH:mm:ss.ms");
                String str=spd.format(ts);
                map.put(str,1);
                System.out.println(str);
            }
            System.out.println(map);
        } catch (Exception e) {
            System.out.println("连接失败!");
            e.printStackTrace();
        }


    }
}
