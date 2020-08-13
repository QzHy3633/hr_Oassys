package com.hr.controller;


import com.hr.entity.AoaAttendsList;
import com.hr.entity.AoaStatusList;
import com.hr.service.AoaAttendsListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/AoaAttendsList")
public class AoaAttendsListController {

    @Autowired
    private AoaAttendsListService aoaAttendsListService;

    @RequestMapping("querylist")
    public String querylist(ModelMap map){

        List<AoaAttendsList> alist = aoaAttendsListService.querylistaoaattend();

        map.addAttribute("alist",alist);

        /*
        for (AoaAttendsList aoaAttendsList : alist){


            System.out.println(aoaAttendsList);

        }
        */

        int count = aoaAttendsListService.countaoaendslist();
        map.addAttribute("count",count);
        //System.out.println(count);
        return "attendceview";
    }

    @RequestMapping("deleaoa")
    public String deleaoa(int aid){


        aoaAttendsListService.deleaoa(aid);

        return "redirect:/AoaAttendsList/querylist";
    }

    @RequestMapping("queryid")
    public  String queryid(int aid ,ModelMap map){


        AoaAttendsList aoaAttendsList = aoaAttendsListService.queryid(aid);

        map.addAttribute("aoa",aoaAttendsList);

        //System.out.println(aoaAttendsList+"================");

        //获取所有的考勤状态
        List<AoaStatusList> slist = aoaAttendsListService.querystatu();

        map.addAttribute("slist",slist);
        return "attendceedit";
    }

    @RequestMapping("likeaoa")
    public  String  likeaoa(AoaAttendsList aoaAttendsList,ModelMap map){


          //System.out.println(userName);

        List<AoaAttendsList> alist = aoaAttendsListService.likeaoa(aoaAttendsList);

          //System.out.println(alist);

        map.addAttribute("alist",alist);

        return "attendceview";
    }

    //修改考勤信息
    @RequestMapping("updaoa")
    public String updaoa(AoaAttendsList aoaAttendsList){


        aoaAttendsListService.updaoalist(aoaAttendsList);

        return "redirect:/AoaAttendsList/querylist";

    }
//==========================================================================================================================================
    //查询考勤周报表
    @RequestMapping("queryweeklyreport")
    public String queryweeklyreport(ModelMap map){

        List<AoaAttendsList> aoalist = aoaAttendsListService.queryweeklyreport();

        map.addAttribute("aoalist",aoalist);

        return "attendceweektable";
    }

    //点击查询每周的报表数据
    @ResponseBody
    @RequestMapping("queraoatime")
    public List<AoaAttendsList> queraoatime(Date start,Date end){

        //System.out.println(start + "==" + end );
        /*Map<String,Object> map = new HashMap<>();
        map.put("start",start);
        map.put("end",end);
        System.out.println(map+"=============");*/
        List<AoaAttendsList>  aoalist = aoaAttendsListService.queraoatime(start,end);
       /* for (AoaAttendsList aoaAttendsList : aoalist){


            System.out.println(aoaAttendsList);

        }*/
        return aoalist;
    }
}
