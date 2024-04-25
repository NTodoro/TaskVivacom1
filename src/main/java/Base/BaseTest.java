package base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.File;
import java.io.IOException;



public class BaseTest {
    public static void main(String[] args) {
        BaseTest test = new BaseTest();
        test.setUp();
    }
    public void setUp() {
        // Затваряне на всички отворени браузъри и сесии
        WebDriver driver = null;
        if (driver != null) driver.quit();
        WebElement dropdownMenu;
        //1. Зареди URL https://www.vivacom.bg/bg/
    
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\ndtod\\IdeaProjects\\VivacomTask\\src\\Resources\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.get("https://www.vivacom.bg/bg");
            driver.manage().window().maximize();
            WebElement acceptButton = driver.findElement(By.linkText("ПРИЕМИ ВСИЧКИ"));
            acceptButton.click();
            driver.get("https://www.vivacom.bg/online/bg/shop/devices/listing?navigation=product-category-smart-mobile-phones");

             //Затварям - Влезте в профила си
        WebElement buttonElement = driver.findElement(By.xpath("/html/body/div[1]/button/em"));
        buttonElement.click();

            //Филтриране на устройствата по производител "APPLE"
            WebElement checkbox = driver.findElement(By.xpath("/html/body/div[22]/div/div/div/div[1]/div/div[2]/div[2]/label[1]/em"));
            checkbox.click();
            //4. Филтрирай устройствата по Цвят = BLUE
            //WebElement checkbox1 = driver.findElement(By.xpath("/html/body/div[22]/div/div/div/div[1]/div/div[4]/div[2]/label[1]/span[1]"));
            //checkbox1.click();
            driver.get("https://www.vivacom.bg/online/bg/shop/devices/listing?navigation=product-category-smart-mobile-phones&default-product-listing=5f6d616e7566616374757265723d4150504c45265f636f6c6f72732e636f6c6f723d424c554526");
            //5. Избери устройство „APPLE IPHONE 15 PLUS 128GB+ADAPTER“
            driver.get("https://www.vivacom.bg/online/bg/shop/devices/product-category-smart-mobile-phones/apple-iphone-15-plus-128gb-adapter?offer=epc_emj240105094151989465_so_waw240404165038355262");
            //Избирам отново цвят BLUE
        //WebElement radioButton = driver.findElement(By.xpath("/html/body/div[31]/div[1]/div/div[3]/div/div[2]/label[3]"));
        //radioButton.click();
            //6.?

        //7. Избери цена на устройство с план “Unlimited 300” и “еднократно плащане”.
        WebElement buttonElement101 = driver.findElement(By.xpath("//*[@id=\"relatedOfferDiv-epc_bew240105094214030522_so_pvw240404165038210468\"]/div[3]/div[2]/div[1]/label/span[2]"));
        buttonElement101.click();
            //Селектирам отново син цвят за покупка
            //WebElement radioButton1 = driver.findElement(By.xpath("/html/body/div[30]/div[1]/div/div[3]/div"));
            //radioButton1.click();

            //8. Маркитайте опцията „за клиент без Vivacom фиксирана услуга“ и натиснете бутона „Купи“
            WebElement buttonElement1 = driver.findElement(By.xpath("//*[@id=\"summaryBarPlanPriceSpanId\"]"));
            buttonElement1.click();
            WebElement buttonElement2 = driver.findElement(By.xpath("//*[@id=\"faciaDataHighResView\"]/div[4]/div[1]/button/span"));
            buttonElement2.click();
            //9. Верифицирай, че си в кошницата.
            // Вземане на екранна снимка
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Запазване на екранната снимка в проекта
            String screenshotPath = "screenshots/example.png";
            try {
                FileUtils.copyFile(screenshotFile, new File(screenshotPath));
                System.out.println("Екранната снимка е запазена успешно в проекта.");
            } catch (IOException e) {
                System.out.println("Грешка при запазване на екранната снимка: " + e.getMessage());
            }
            //10. Продължи с пазаруването.
            driver.get("https://www.vivacom.bg/online/bg/shop/devices/listing");
            //11. Избери „Устройства“ от главното меню и „Аксесоари“ от подменюто.
            driver.get("https://www.vivacom.bg/online/bg/shop/devices/listing?navigation=product-category-accessories");
            //12. Филтрирай аксесоарите по Производител = APPLE и Цена = над 40 лв.
            WebElement checkbox1 = driver.findElement(By.xpath("//*[@id=\"filter-manufacturer\"]/label[2]/em"));
            checkbox1.click();
            WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"filter-price\"]/label[3]/span[1]"));
            checkbox2.click();
            //13. Избери „APPLE iPhone 15 Plus FineWoven Taupe“
            driver.get("https://www.vivacom.bg/online/bg/shop/devices/product-category-accessories/apple-iphone-15-pro-finewoven-case-taupe?offer=epc_simfreedevice00000001_so_jee230921123929324872");
            //14. Добави продукта в кошницата.
            WebElement buttonElement5 = driver.findElement(By.xpath("//*[@id=\"faciaDataHighResView\"]/div[4]/div[1]/button/span"));
            buttonElement5.click();
            //15. Верифицирай, че си в кошницата.
            // Вземане на екранна снимка
            File screenshotFile2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Запазване на екранната снимка в проекта
            String screenshotPath2 = "screenshots/example2.png";
            try {
                FileUtils.copyFile(screenshotFile2, new File(screenshotPath2));
                System.out.println("Втората екранна снимка е запазена успешно в проекта.");
            } catch (IOException e) {
                System.out.println("Грешка при запазване на втората екранна снимка: " + e.getMessage());
            }
        //16. Провери общата сума за всички добавени устройства. Ако надвишава 1680 лв. премахни аксесоара.
        // Намирам елемента, който съдържа общата сума
        WebElement totalAmountElement = driver.findElement(By.xpath("//div[@class='row final-price']/span[2]"));
        // Извличам текста от елемента за обща сума
        String totalAmountText = totalAmountElement.getText();
        // Парсвам текста към числото
        double totalAmount = Double.parseDouble(totalAmountText.replaceAll("[^\\d.]", ""));
        // Проверка дали общата сума е над 1680 лева
        if (totalAmount > 1680) {
            // Ако общата сума е над 1680 лева, можем да премахнем един от артикулите
            WebElement removeButton = driver.findElement(By.xpath("//em[@class='vivacom-icons icon-close_x']"));
            removeButton.click();

            System.out.println("Артикулът е премахнат от кошницата, защото общата сума е над 1680 лева.");
        } else {
            System.out.println("Общата сума е под 1680 лева. Няма нужда да премахваме артикули.");
        }

        //17. Верифицирай, че бутоните „Поръчай като настоящ клиент“ и „Поръчай като нов клиент“ са неактивни.
        // Запазване на екранната снимка в проекта
        // Намиране на елемента с бутон, който искаме да верифицираме
        WebElement buttonElement17 = driver.findElement(By.xpath("//*[@id=\"shopping-cart-span\"]/div[1]/aside/div[1]/div/div[5]/div[2]/div/button"));

        // Проверка дали бутона е неактивен
        if (buttonElement17.getAttribute("disabled") != null) {
            System.out.println("Бутона „Поръчай като настоящ клиент“ е неактивен.");
        } else {
            System.out.println("Бутона „Поръчай като настоящ клиент“ е активен.");
        }
// Намиране на елемента с бутон, който искаме да верифицираме
        WebElement buttonElement20 = driver.findElement(By.xpath("//*[@id=\"shopping-cart-span\"]/div[1]/aside/div[1]/div/div[5]/div[3]/div/button"));

        // Проверка дали бутона е неактивен
        if (buttonElement.getAttribute("disabled") != null) {
            System.out.println("Бутона „Поръчай като нов клиент“ е неактивен.");
        } else {
            System.out.println("Бутона „Поръчай като нов клиент“ е активен.");
        }
        //18. Верифицирай, че checkbox-a “Общи условия за мобилни услуги” е наличен и го маркирай.
        // Проверка дали checkbox е наличен
        WebElement checkbox18 = driver.findElement(By.xpath("/html/body/span[1]/div[1]/aside/div[1]/div/div[5]/div[1]/div[1]/label/em"));
        if (checkbox18.isDisplayed()) {
            System.out.println("Чекбоксът е наличен на страницата.");
        } else {
            System.out.println("Чекбоксът не е наличен на страницата.");
        }
        // Маркиране на checkbox
        WebElement checkbox181 = driver.findElement(By.xpath("/html/body/span[1]/div[1]/aside/div[1]/div/div[5]/div[1]/div[1]/label/em"));
        checkbox181.click();

        //19. Премахни добавените в кошницата продукти.
        WebElement checkbox19 = driver.findElement(By.xpath("/html/body/span/div[1]/section/div/div[2]/div[1]/form/button/em"));
        checkbox19.click();
        WebElement checkbox191 = driver.findElement(By.xpath("/html/body/span/div[1]/section/div/div[2]/div[2]/form/button/em"));
        checkbox191.click();

        /*20. Верифицирай, че следното съобщение излиза на екрана – „ Вижте актуалните ни оферти
        и изберете най-подходящата за вас. Ако искате да разгледате предходно добавени
        продукти, натиснете "Вход". “*/
        // Намирам елемента, който съдържа съобщението
        WebElement messageElement = driver.findElement(By.xpath("/html/body/span/div[1]/div/div/section/div/div/p"));

        // Вземам текста на елемента
        String messageText = messageElement.getText();

        // Проверявам дали текстът съдържа желаното съобщение
        if (messageText.contains("Вижте актуалните ни оферти и изберете най-подходящата за вас. Ако искате да разгледате предходно добавени продукти, натиснете \"Вход\".")) {
            System.out.println("Съобщението е на екрана: " + messageText);
        } else {
            System.out.println("Съобщението не е на екрана или текстът е различен.");
        }

            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            driver.quit();
        }
    }

