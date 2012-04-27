package com.kevinpotgieter.web.dtos;

import com.kevinpotgieter.web.validation.groups.MinimalUserValidation;
import org.hibernate.validator.constraints.*;
import org.springframework.stereotype.Component;

import javax.validation.constraints.AssertTrue;
import javax.validation.groups.Default;

/**
 * Created by IntelliJ IDEA.
 * User: kevinpotgieter
 * Date: 23/04/2012
 * Time: 08:37
 * To change this template use File | Settings | File Templates.
 */
public class UserDTO {

    @NotBlank(message = "Username must be supplied.", groups = {Default.class, MinimalUserValidation.class})
    @Length(min = 6, message = "Username must be at least 6 characters long.")
    private String username;

    @NotBlank(message = "Password must be supplied.", groups = {Default.class, MinimalUserValidation.class})
    private String password;
    private String confirmPassword;

    @NotBlank(message = "Email Address must be supplied.")
    private String emailAddress;
    private String confirmEmailAddress;

    @NotBlank(message = "First Name must be supplied.")
    private String firstName;

    @AssertTrue(message = "Passwords must match", groups = {Default.class, MinimalUserValidation.class})
    public boolean isPasswordTheSame(){
        if (this.password != null) {
            return this.password.equals(this.confirmPassword);
        }
        return true;
    }

    private String lastName;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getConfirmEmailAddress() {
        return confirmEmailAddress;
    }

    public void setConfirmEmailAddress(String confirmEmailAddress) {
        this.confirmEmailAddress = confirmEmailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
