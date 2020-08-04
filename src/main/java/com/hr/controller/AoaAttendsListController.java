package com.hr.controller;


import com.hr.entity.AoaAttendsList;
import com.hr.service.AoaAttendsListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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

}
