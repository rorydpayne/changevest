package com.change.changevest.web.ui;

import com.change.changevest.web.application.UserService;
import com.change.changevest.web.domain.model.User;
import com.change.changevest.web.domain.model.exception.VerificationTokenExpiredException;
import com.change.changevest.web.domain.model.exception.VerificationTokenInvalidException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MessageSource messages;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public @ResponseBody User registerUserAccount(@RequestBody UserDTO signupReq,
                             BindingResult result, WebRequest req, Errors errors) {

            return userService.createUserAccount(signupReq, req.getLocale(), req.getContextPath());
        }

    @RequestMapping(value = "/registrationConfirm", method = RequestMethod.GET)
    public String confirmRegistration(WebRequest req, Model model, @RequestParam("token") String token) {
        try {
            userService.confirmRegistration(token);
        } catch (VerificationTokenInvalidException e) {
            String message = messages.getMessage("message.invalidToken", null, req.getLocale());
            model.addAttribute("message", message);
            return "redirect:/badUser.html?lang=" + req.getLocale().getLanguage();
        } catch (VerificationTokenExpiredException e) {
            String messageValue = messages.getMessage("message.expired", null, req.getLocale());
            model.addAttribute("message", messageValue);
            return "redirect:/badUser.html?lang=" + req.getLocale().getLanguage();
        }
        String messageValue = messages.getMessage("message.registrationConfirmSuccess", null, req.getLocale());
        model.addAttribute("message", messageValue);
        return "redirect:/registrationConfirmSuccess.html?lang=" + req.getLocale().getLanguage();
    }
}
