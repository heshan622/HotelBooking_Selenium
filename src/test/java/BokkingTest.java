import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import org.testng.annotations.Test;

public class BokkingTest {

    ExtentReports extent = ExtentReportManager.getReportInstance();
    ExtentTest test = extent.createTest("Hotel Booking Test", "Automates hotel booking on PHPTravels");


    @Test
    public void hotelBookingTest() throws InterruptedException {

        //Open chrome
        WebDriver driver = new ChromeDriver();
        test.log(Status.INFO, "Browser launched");
        driver.manage().window().maximize();

        //Go to PHPTravels
        driver.get("https://phptravels.net/");

        //Select Hotel
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html[1]/body[1]/header[1]/div[1]/div[2]/div[1]/ul[1]/li[2]/a[1]")).click();

        //Click Search By City
        Thread.sleep(1000);
        WebElement dropDown1 = driver.findElement(By.xpath("html[1]/body[1]/main[1]/section[1]/section[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/span[1]/span[1]/span[1]/span[1]"));
        dropDown1.click();

        //Select Location
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html[1]/body[1]/span[1]/span[1]/span[2]/ul[1]/div[1]/div[1]/div[1]/strong[1]/small[1]")).click();

        //Click check_in and set Check_in Date
        Thread.sleep(1000);
        driver.findElement(By.id("checkin")).click();
        Thread.sleep(1000);
        String selectedDate = null;
        while (true){
            selectedDate = driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[5]/div[1]/table/thead/tr[1]/th[2]")).getText();
            if (selectedDate.equalsIgnoreCase("August 2025")){
                break;
            }
            driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[5]/div[1]/table/thead/tr[1]/th[3]")).click();
        }
        driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[5]/div[1]/table/tbody/tr[4]/td[1]")).click();

        //Set Checkout Date
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[6]/div[1]/table/tbody/tr[4]/td[7]")).click();

        //Click Travellers and room
        Thread.sleep(1000);
        WebElement dropDown2 = driver.findElement(By.xpath("//*[@id=\"hotels-search\"]/div/div[4]/div/div/div/a"));
        dropDown2.click();

        //Set Room
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html[1]/body[1]/main[1]/section[1]/section[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/*[name()='svg'][1]")).click();

        //Set Adults
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html[1]/body[1]/main[1]/section[1]/section[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/*[name()='svg'][1]")).click();

        //Set Childs
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html[1]/body[1]/main[1]/section[1]/section[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/*[name()='svg'][1]")).click();

        //Set Child Age
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html[1]/body[1]/main[1]/section[1]/section[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/ol[1]/li[1]/div[1]/div[1]/div[1]/select[1]")).click();

        //Set Age
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//option[@value='6'])[1]")).click();

        //Click Nationality
        Thread.sleep(1000);
        WebElement dropDown4 = driver.findElement(By.xpath("//*[@id=\"nationality\"]"));
        dropDown4.click();

        //Set US
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"nationality\"]/option[237]")).click();

        //Click search Button
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"hotels-search\"]/div/div[5]/button")).click();

        //Select 5Star
        Thread.sleep(1000);
        WebElement radioBtn = driver.findElement(By.xpath("//*[@id='starRating5']"));
        radioBtn.click();

        //Select Hotel
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html[1]/body[1]/main[1]/section[1]/div[2]/div[1]/div[2]/div[1]/ul[1]/li[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/a[1]")).click();

        //Select Single Room
        Thread.sleep(1000);
        // Locate the button
        WebElement bookNowButton = driver.findElement(By.xpath("//*[@id='rooms']/div/div/div[2]/div[1]/div/div/table/tbody/tr/td[6]/button"));
        // Scroll to the button
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bookNowButton);
        // Optional: wait a bit for smooth scroll effect (not required)
        Thread.sleep(300);
        // Click the button
        bookNowButton.click();

        Thread.sleep(1000);
        driver.findElement(By.xpath("/html[1]/body[1]/main[1]/div[2]/form[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]")).click();

        try {
            test.log(Status.INFO, "Filling out the booking form...");

            // PERSONAL INFORMATION
            Thread.sleep(1000);
            WebElement firstName = driver.findElement(By.name("user[first_name]"));
            firstName.sendKeys("John");
            test.log(Status.INFO, "Entered first name: John");

            Thread.sleep(1000);
            WebElement lastName = driver.findElement(By.name("user[last_name]"));
            lastName.sendKeys("Doe");
            test.log(Status.INFO, "Entered last name: Doe");

            Thread.sleep(1000);
            WebElement email = driver.findElement(By.name("user[email]"));
            email.sendKeys("john.doe@example.com");
            test.log(Status.INFO, "Entered email: john.doe@example.com");

            Thread.sleep(1000);
            WebElement phone = driver.findElement(By.name("user[phone]"));
            phone.sendKeys("1234567890");
            test.log(Status.INFO, "Entered phone number: 1234567890");

            Thread.sleep(1000);
            WebElement address = driver.findElement(By.name("user[address]"));
            address.sendKeys("123 Main Street, Los Angeles");
            test.log(Status.INFO, "Entered address");

            // SCROLL TO ADULT SECTION
            Thread.sleep(1000);
            WebElement adult1FirstName = driver.findElement(By.xpath("/html[1]/body[1]/main[1]/div[2]/form[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/input[1]"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", adult1FirstName);
            Thread.sleep(200);
            adult1FirstName.click();
            test.log(Status.INFO, "Scrolled to adult section and clicked");

            // ADULT 1
            Thread.sleep(1000);
            new Select(driver.findElement(By.name("title_1"))).selectByVisibleText("Mr");
            driver.findElement(By.name("firstname_1")).sendKeys("John");
            driver.findElement(By.name("lastname_1")).sendKeys("Doe");
            test.log(Status.INFO, "Filled Adult 1 details");

            // ADULT 2
            Thread.sleep(1000);
            new Select(driver.findElement(By.name("title_2"))).selectByVisibleText("Mrs");
            driver.findElement(By.name("firstname_2")).sendKeys("Mary");
            driver.findElement(By.name("lastname_2")).sendKeys("Smith");
            test.log(Status.INFO, "Filled Adult 2 details");

            // ADULT 3
            Thread.sleep(1000);
            new Select(driver.findElement(By.name("title_3"))).selectByVisibleText("Mr");
            driver.findElement(By.name("firstname_3")).sendKeys("James");
            driver.findElement(By.name("lastname_3")).sendKeys("Brown");
            test.log(Status.INFO, "Filled Adult 3 details");

            // CHILD 1
            Thread.sleep(1000);
            driver.findElement(By.name("child_firstname_1")).sendKeys("Emily");
            driver.findElement(By.name("child_lastname_1")).sendKeys("Doe");
            test.log(Status.INFO, "Filled Child 1 details");

            // SELECT PAY LATER OPTION
            Thread.sleep(1000);
            WebElement payLater = driver.findElement(By.xpath("/html[1]/body[1]/main[1]/div[2]/form[1]/section[1]/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/ul[1]/div[1]/label[3]/div[1]/div[1]"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", payLater);
            Thread.sleep(500);
            payLater.click();
            test.log(Status.INFO, "Selected 'Pay Later' payment method");

            // AGREE TO TERMS
            Thread.sleep(1000);
            WebElement termsCheckbox = driver.findElement(By.xpath("/html[1]/body[1]/main[1]/div[2]/form[1]/section[1]/div[1]/div[1]/div[1]/div[5]/div[1]/div[1]/div[1]/input[1]"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", termsCheckbox);
            Thread.sleep(500);
            if (!termsCheckbox.isSelected()) {
                termsCheckbox.click();
                test.log(Status.INFO, "Accepted terms and conditions");
            }

            // CLICK CONFIRM BOOKING
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id='booking']")).click();
            test.log(Status.PASS, "Clicked 'Confirm Booking' button");

        } catch (Exception e) {
            test.log(Status.FAIL, "Test failed: " + e.getMessage());
        }

        finally {
            // Close the browser
            Thread.sleep(6000);
            test.log(Status.INFO, "Closing browser");
            extent.flush();// save_report
            driver.quit();

        }

    }
}
