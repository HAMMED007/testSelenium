package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\adewu\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://dinner-international.onrender.com/login");
        WebElement usernameField = driver.findElement(By.id("email"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.xpath("/html/body/div/section/div/div/div/div/div[2]/form/button"));
        usernameField.sendKeys("sparktechhu@protonmail.com");
        passwordField.sendKeys("12345678");
        loginButton.click();

        Thread.sleep(2000);

        // Check if the login was successful
        WebElement loggedInUser = driver.findElement(By.xpath("/html/body/div/header/div/div/div/div[3]/div/h5"));
        boolean isLoggedIn = loggedInUser.isDisplayed();

        if (isLoggedIn) {
            System.out.println("Login successful");
        } else {
            System.out.println("Login failed");

        }


        driver.quit();



    }
    public static void registerUser(WebDriver driver, String username, String email, String password) throws InterruptedException {
        // Registration fields
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement emailField = driver.findElement(By.id("email"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement registerButton = driver.findElement(By.xpath("/html/body/div/section/div/div/div/div/div[2]/form/button"));

        // Enter registration details
        usernameField.sendKeys(username);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);

        // Submit registration form
        registerButton.click();

        Thread.sleep(2000);

        // Check if the registration was successful
        WebElement registeredUser = driver.findElement(By.xpath("/html/body/div/header/div/div/div/div[3]/div/h5"));
        boolean isRegistered = registeredUser.isDisplayed();

        if (isRegistered) {
            System.out.println("Registration successful");
        } else {
            System.out.println("Registration failed");
        }
    }
}