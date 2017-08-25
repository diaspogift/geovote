package com.geovote.controllers.webcontrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by elberto on 3/17/17.
 */
//@Controller
public class HomeComtroller {

    //@RequestMapping("/")
    public String homePage(){

        return "index";

    }
}
