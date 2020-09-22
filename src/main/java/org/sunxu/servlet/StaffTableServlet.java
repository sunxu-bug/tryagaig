package org.sunxu.servlet;

import com.alibaba.fastjson.JSONObject;
import org.sunxu.model.StaffTable;
import org.sunxu.service.StaffTableService;
import org.sunxu.service.impl.StaffTableServiceImpl;
import org.sunxu.utils.JsonUtils;
import org.sunxu.utils.SpringUtils;
import org.sunxu.utils.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/stafftable.ajax")
public class StaffTableServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        //接收参数
        String indexStr = request.getParameter("index");
        String account = request.getParameter("account");
        //校验参数
        int index=1;
        if(StringUtils.isNotEmpty(indexStr)){
            try{
                index = Integer.parseInt(indexStr);
            }catch(Exception e){
                index=1;
            }
        }
        //调用service
        StaffTableService sts = (StaffTableService) SpringUtils.getBean("staffTableService");
        List<StaffTable> list = sts.list(index,account);
        Integer max = sts.listCount(account);
//        System.out.println(list);
        //结果处理
        JSONObject data=new JSONObject();
        data.put("list",list);
        data.put("max",max);
        JsonUtils.outJson(data,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
