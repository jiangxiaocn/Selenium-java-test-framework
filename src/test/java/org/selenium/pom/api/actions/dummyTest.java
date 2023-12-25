package org.selenium.pom.api.actions;

import org.selenium.pom.objects.User;
import org.selenium.pom.utils.FakerUtils;

public class dummyTest {
    public static void main (String[] args){
        String username = "demouser"+new FakerUtils().generateRandomNumber();
        //new SignUpApi().getAccount();
        User user = new User().setUsername(username).setPassword("demopwd")
                .setEmail(username+"@askomdch.com");
        SignUpApi signUpApi = new SignUpApi();
        System.out.println(signUpApi.register(user));
    }

}
