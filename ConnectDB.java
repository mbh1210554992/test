package com.liveramp;

import java.sql.*;

public class ConnectDB {
    private static String url="jdbc:mysql://localhost:3306/test01";
    private static String user="root";
    private static String password="123456";
    private static Connection conn;
    static{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn= DriverManager.getConnection(url,user,password);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * 查询每门课的平均分
     */
    public void selectAvg(){
        PreparedStatement ps=null;
        String sql="SELECT sc.cno,cname,AVG(score) AS avg FROM sc,course c where sc.cno=c.cno GROUP BY cno";

        try{
            ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            System.out.println("课程的平均分为：");
            while(rs.next()){
                int cno=rs.getInt("cno");
                String cname= rs.getString("cname");
                long score=rs.getLong("avg");
                System.out.println("课程名称："+cname+", 课程平均分："+score);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            if(null!=ps){
                try{
                    ps.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 网上找到一个case when then的sql语句可以实现分组后某些字段的查询
     *
     */
    public void selectInfo(){
        PreparedStatement ps=null;
        String sql="select sc.sno,sname,\n" +
                    "sum(case cname when 'math' then score else 0 end) as math,  \n" +
                    "sum(case cname when 'english' then score else 0 end) as english,\n" +
                    "sum(case cname when 'c++' then score else 0 end) as 'c++',\n" +
                    "sum(score) as total\n" +
                    "from stu,sc,course \n" +
                    "where stu.sno=sc.sno and sc.cno=course.cno \n" +
                    "group by sno,sname \n" +
                    "order by total desc";
        try{
            ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            System.out.println("\n学生的分数为：");
            while(rs.next()){
                int sno=rs.getInt("sno");
                String sname=rs.getString("sname");
                int math=rs.getInt("math");
                int english=rs.getInt("english");
                int c=rs.getInt("c++");
                int total=rs.getInt("total");
                System.out.println("学号:"+sno+" 姓名:"+sname+" math:"+math+" english:"+english+" c++"+c+" 总分为："+total);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            if(null!=ps){
                try{
                    ps.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }

    }

    public void close(){
        try{
            if(null!=conn) {
                conn.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

}


