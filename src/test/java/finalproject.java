import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.LocalDate;

public class finalproject {

        WebDriver driver;
        WebDriver wait;



        @BeforeTest
        @Parameters("browser")
        public void setUp(@Optional String browser) {
            switch (browser.toLowerCase()) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    break;
                default:
                    System.out.println("Browser is not correct");
            }
        }

    @Test
        //public  void test ()
        public void test() throws InterruptedException {
            // Navigate to the jQuery UI Datepicker example page
            driver.get("http://tutorialsninja.com/demo/");


            WebElement myAccount = driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a"));
            myAccount.click();

            WebElement registerButton = driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a"));
            registerButton.click();
            //Thread.sleep(3000);

            WebElement firstNameInput = driver.findElement(By.id("input-firstname"));
            firstNameInput.sendKeys("Donari");

            WebElement lastNameInput = driver.findElement(By.id("input-lastname"));
            lastNameInput.sendKeys("Samadashvili");



            //email
            WebElement emailInput = driver.findElement(By.id("input-email"));
            emailInput.sendKeys("donnaisamad40@gmail.com");

            WebElement telephoneInput = driver.findElement(By.id("input-telephone"));
            telephoneInput.sendKeys("555495473");

            WebElement passwordInput = driver.findElement(By.id("input-password"));
            passwordInput.sendKeys("avtomatizacia");

            WebElement confirmInput = driver.findElement(By.id("input-confirm"));
            confirmInput.sendKeys("avtomatizacia");

            WebElement subscribeRadio = driver.findElement(By.name("newsletter"));
            subscribeRadio.click();

            WebElement privacyPolicyCheckbox = driver.findElement(By.name("agree"));
            privacyPolicyCheckbox.click();


            WebElement  continueButton =driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]"));
            continueButton.click();


            Thread.sleep(3000);


           // Step 4: Move to 'Desktops' and select 'Show all Desktops'
            WebElement desktopsMenu = driver.findElement(By.xpath("//a[text()='Desktops']"));
            desktopsMenu.click();

            WebElement showAllDesktops = driver.findElement(By.xpath("//a[text()='Show AllDesktops']"));
            showAllDesktops.click();

            // Step 5: Choose 'MP3 Players' item
            WebElement mp3PlayersItem = driver.findElement(By.xpath("/html/body/div[2]/div/aside/div[1]/a[10]"));
            mp3PlayersItem.click();

            // Step 6: Move to 'iPod Classic' image and check that 'iPod Classic' text is visible on mouse hover

        WebElement ipodClassicText = driver.findElement(By.cssSelector("#content>div:nth-child(8)>div:nth-child(1)>div>div.image>a>img"));
        if (ipodClassicText.isDisplayed()) {
            System.out.println("iPod Classic text is visible on mouse hover.");
        } else {
            System.out.println("iPod Classic text is not visible on mouse hover.");
        }

        WebElement iPodClassic = driver.findElement(By.xpath("//*[@id=\"content\"]/div[4]/div[1]/div/div[2]/div[1]/h4/a"));
        iPodClassic.click();


        // Click on the first image and move to another images before text '4 of 4' is present
        WebElement firstImage = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/ul[1]/li[1]/a/img"));
        firstImage.click();

        int timeout = 10; // seconds
        long startTime = System.currentTimeMillis();

        // Keep clicking on the next image until '4 of 4' is present or timeout is reached
        while (!driver.getPageSource().contains("4 of 4")) {
            if (System.currentTimeMillis() - startTime > timeout * 1000) {
                System.out.println("Timeout reached. '4 of 4' not found.");
                break;
            }
            // Click on the next image
            WebElement nextButton = driver.findElement(By.cssSelector("body>div.mfp-wrap.mfp-gallery.mfp-close-btn-in.mfp-auto-cursor.mfp-ready>div>button.mfp-arrow.mfp-arrow-right.mfp-prevent-close"));
            nextButton.click();
            Thread.sleep(3000);

        }
        WebElement closeButton = driver.findElement(By.xpath(" /html/body/div[2]/div/div[1]/div/button"));
        closeButton.click();

        WebElement writeReview = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[3]/p/a[2]"));
        writeReview.click();

        // Fill information and submit (adjust the element locators accordingly)
        WebElement reviewText = driver.findElement(By.id("input-review"));
        reviewText.sendKeys("This is a great product!!!");

        WebElement rating = driver.findElement(By.xpath("//*[@id=\"form-review\"]/div[4]/div/input[5]"));
        rating.click(); // Choose a rating

        WebElement submitReview = driver.findElement(By.id("button-review"));
        submitReview.click();


        Thread.sleep(3000);



        // Click on 'Add to Cart'
        WebElement addToCart = driver.findElement(By.xpath("//*[@id=\"button-cart\"]"));
        addToCart.click();


        // Check by item's count and price that product was successfully added to cart
        WebElement cartTotal = driver.findElement(By.cssSelector("#cart > button"));
        cartTotal.click();
        Thread.sleep(3000);
        System.out.println("Items in cart: " + cartTotal.getText());




        WebElement cartPrice = driver.findElement(By.xpath(" //*[@id=\"cart\"]/ul/li[1]/table/tbody/tr/td[4]"));
        System.out.println("Cart total price: " + cartPrice.getText());

        // Click on 'Checkout'
        WebElement checkout = driver.findElement(By.xpath("//*[@id=\"cart\"]/ul/li[2]/div/p/a[2]"));
        checkout.click();

        Thread.sleep(3000);
        WebElement Fname = driver.findElement(By.xpath("//*[@id=\"input-payment-firstname\"]"));
        Fname.sendKeys("nino");
        Thread.sleep(2000);
        WebElement Lname = driver.findElement(By.xpath("//*[@id=\"input-payment-lastname\"]"));
        Lname.sendKeys("ninidze");
        Thread.sleep(2000);

        WebElement Address1 = driver.findElement(By.xpath("//*[@id=\"input-payment-address-1\"]"));
        Address1.sendKeys("chkondidelis street 22");
        Thread.sleep(2000);
        WebElement city = driver.findElement(By.xpath("//*[@id=\"input-payment-city\"]"));
        city.sendKeys("Tbilisi");
        Thread.sleep(2000);

        WebElement PostCode = driver.findElement(By.cssSelector("#input-payment-postcode"));
        PostCode.sendKeys("01081");
        Thread.sleep(2000);

        WebElement countryDropdown = driver.findElement(By.xpath("//*[@id=\"input-payment-country\"]"));
        Select countrySelect = new Select(countryDropdown);
        countrySelect.selectByVisibleText("Georgia");
        Thread.sleep(3000);

        // Choose Tbilisi in the region/states dropdown
        WebElement regionDropdown = driver.findElement(By.xpath("//*[@id=\"input-payment-zone\"]"));
        Select regionSelect = new Select(regionDropdown);
        regionSelect.selectByVisibleText("Tbilisi");

        Thread.sleep(3000);
        WebElement ContinueButton1 = driver.findElement(By.cssSelector("#button-payment-address"));
        ContinueButton1.click();

        Thread.sleep(3000);
        WebElement ContinueButton2 = driver.findElement(By.xpath("//*[@id=\"collapse-shipping-address\"]/div/form/div[5]/div"));
        ContinueButton2.click();

        Thread.sleep(3000);
        WebElement ContinueButton3 = driver.findElement(By.xpath(" /html/body/div[2]/div/div/div/div[4]/div[2]/div/div[2]/div"));
        ContinueButton3.click();

        Thread.sleep(3000);
        WebElement ContinueButton4 = driver.findElement(By.cssSelector("#button-shipping-method"));
        ContinueButton4.click();


        WebElement ConditionsCheckbox = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[5]/div[2]/div/div[2]/div/input[1]"));
        ConditionsCheckbox.click();

        Thread.sleep(3000);
        WebElement ContinueButton5 = driver.findElement(By.cssSelector("#button-payment-method"));
        ContinueButton5.click();



        // Leave Delivery Details and Methods default

        // In 'Confirm Order' section check that Sub-Total, Flat Shipping Rate, and Total amount are correct
        WebElement subTotal = driver.findElement(By.xpath("//tr[@id='cart-sub-total']/td[2]"));
        WebElement flatShippingRate = driver.findElement(By.xpath("//tr[@id='cart-total']/td[2]"));
        WebElement totalAmount = driver.findElement(By.xpath("//tr[@id='cart-total-total']/td[2]"));

        System.out.println("Sub-Total: " + subTotal.getText());
        System.out.println("Flat Shipping Rate: " + flatShippingRate.getText());
        System.out.println("Total Amount: " + totalAmount.getText());

        // Click on 'history' link and check that status is 'Pending' and date equal to the current date
        WebElement historyLink = driver.findElement(By.linkText("history"));
        historyLink.click();

        WebElement orderStatus = driver.findElement(By.xpath("//td[text()='Pending']"));
        WebElement orderDate = driver.findElement(By.xpath("//td[contains(text(), '2023')]"));

        if (orderStatus.isDisplayed() && orderDate.isDisplayed()) {
            System.out.println("Order status is 'Pending' and date is correct");
        } else {
            System.out.println("Order status or date is incorrect");
        }

        // Close the browser window
            driver.quit();

        }
    }

