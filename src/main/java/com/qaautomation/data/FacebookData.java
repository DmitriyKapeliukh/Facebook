package com.qaautomation.data;

import org.testng.annotations.DataProvider;

/**
 * Created by Dmytro_Kapeliukh on 4/9/17.
 */
public class FacebookData{
        @DataProvider(name = "pages")
        public static Object[][] pages(){
            return new Object[][]{
                    {"https://www.facebook.com", "Добро пожаловать на Фейсбук - заходите, регистрируйтесь и находите друзей."},
                    {"www.google.com", "Google"},
                    {"www.yahoo.com", "Yahoo"}
            };
        }

        @DataProvider(name = "login")
        public static Object[][] login(){
            return new Object[][]{
                    {"mr.auto.qa@gmail.com", "mrautoqa12345", null},
                    {"adasda", "12345", "Вы ввели неверный пароль. Забыли пароль?"}
            };
        }

    @DataProvider(name = "signup")
    public static Object[][] signup(){
        return new Object[][]{
                {"QA", "Automan", "mr.auto.qa@gmail.com"},
                {"$%^&", "%^&**((", "mr.auto.qa@gmail.com"},
                {"131231", "42424323", "mr.auto.qa@gmail.com"}
        };
    }
}
