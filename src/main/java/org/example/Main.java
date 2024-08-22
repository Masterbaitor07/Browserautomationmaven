
package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.setProperty("WebDriver.chrome.driver", "chromedriver-win64.zip");
        //System.setProperty("WebDriver.edge.driver", "C:\\Users\\anshulr\\Downloads\\edgedriver_win64.zip");
//        Chrome options = new ChromeOptions();
        WebDriver driver = new ChromeDriver();


        List<String> countries = List.of("usa", "india", "pakistan", "china");
        try {
            for (String country : countries) {
                try {
                    driver.get("https://www.google.com/");



                    // driver.wait(10000);
                    WebElement searchBox = driver.findElement(By.name("q"));
                    // driver.wait(10000);
                    String query = "When is independence day for " + country + "?";
                    searchBox.clear();
                    searchBox.sendKeys(query);
                    searchBox.submit();
                    // Wait for the results to load
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

                    // Wait for the results to load
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                    // Thread.sleep(1000000);// Increased wait time


                    // Find the result element

                    WebElement result = driver.findElement(By.className("kp-header"));
                    System.out.println("Independence day for " + country + ": " + result.getText());




                } catch (Exception e) {
                    System.out.println("error occured" + country + ":" + e.getMessage());
                }


            }
        }
        finally {
            driver.quit();
        }



        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.


    }
}