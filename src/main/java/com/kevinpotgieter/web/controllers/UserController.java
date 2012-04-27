package com.kevinpotgieter.web.controllers;

import com.kevinpotgieter.web.dtos.UserDTO;
import com.kevinpotgieter.web.validation.groups.MinimalUserValidation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * Created by IntelliJ IDEA.
 * User: kevinpotgieter
 * Date: 19/04/2012
 * Time: 08:20
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class UserController {

    @RequestMapping(value = "/new-user.html", method = RequestMethod.GET)
    public String getUserInputForm(Model model){
        model.addAttribute("userDTO", new UserDTO());

        return "user-details";

    }

    @RequestMapping(value="/add-user-full.html", method = RequestMethod.POST)
    public String createNewUserWithFullValidation(@Valid UserDTO userDTO, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "user-details";
        }

        model.addAttribute("successMessage", "User details passed all the full validations.");
        return "user-details";
    }

    @RequestMapping(value="/add-user-partial.html", method = RequestMethod.POST)
    public String createNewUserWithPartialValidation(@Validated(value = MinimalUserValidation.class) UserDTO userDTO, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "user-details";
        }

        model.addAttribute("successMessage", "User details passed all the full validations.");
        return "user-details";
    }





}
