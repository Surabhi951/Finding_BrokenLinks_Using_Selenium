package com.bridgelabz.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class BrokenLinkPage {

    WebDriver driver;

    public BrokenLinkPage(WebDriver driver) {
        this.driver = driver;
    }

    public void automatePage() {
        List<WebElement> links = driver.findElements(By.tagName("a"));

        int resCode = 200;
        int brokenLinksCount = 0;

        System.out.println("Total links on page : " +links.size());

        for(WebElement element : links){
            String url = element.getAttribute("href");
            try {
                URL link = new URL(url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) link.openConnection();
                httpURLConnection.setRequestMethod("HEAD");
                httpURLConnection.connect();

                resCode = httpURLConnection.getResponseCode();

                if (resCode >= 400){
                System.out.println(url +" - "+ "is broken link");
                brokenLinksCount++;
                }
                else {
                    System.out.println(url + resCode+" - "+ "is valid link");
                }

            }catch (MalformedURLException e){

            }catch (Exception e){

            }
        }
        System.out.println("Total broken links" +brokenLinksCount);
    }
}
