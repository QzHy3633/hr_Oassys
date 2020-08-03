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
        return "attendceview";
    }

}
