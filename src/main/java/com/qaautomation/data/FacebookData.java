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
}
