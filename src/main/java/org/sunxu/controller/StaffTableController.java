package org.sunxu.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.sunxu.model.StaffTable;
import org.sunxu.service.StaffTableService;
import org.sunxu.utils.SpringUtils;

import java.util.List;

@Controller
public class StaffTableController {
    @RequestMapping("/stafftable.ajax")
    @ResponseBody
    public String list(String account, Integer index) {
        // 校验参数
        if (index == null) {
            index = 1;
        }

        // 调用Service
        StaffTableService sts = (StaffTableService) SpringUtils.getBean("accountService");
        List<StaffTable> list = sts.list(index, account);
        Integer max = sts.listCount(account);

        // 结果处理
        JSONObject data = new JSONObject();
        data.put("list", list);
        data.put("max", max);

        return data.toJSONString();
    }
    @RequestMapping("/stafftable-save.ajax")
    @ResponseBody
    public String save(StaffTable st) {
        System.out.println(st.toString());

        JSONObject data = new JSONObject();
        data.put("type", true);
        return data.toJSONString();
    }
}
