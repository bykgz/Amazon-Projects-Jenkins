package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;


import java.time.Duration;


public class Driver {
    private Driver(){
         /*
        SINGLETON PATTERN (Tekli kullanım) için gizli const.'ı private yaptık
         */
    };



    static WebDriver driver;


    /*
        Driver'i her çağırdığımızda yeni bir pencere açmamasi için bir if bloğu ile bu işi çözdük.
        if(driver == null) ile eğer driver'a değer atanmamış ise driver'a değerleri ata, tekrar driver
        çağrıldığında driver da değer olduğu için direk driver'i return et. Dolayısıyla driver'ı ikinci kez
        çağırdığımızda açık gördüğü browser da yani aynı sayfada belirtilen web sitene gider.
         */



    public static WebDriver getDriver() {
        if (driver == null ) {
            String browser = ConfigurationReader.getProperty("browser");

            if ("chrome".equals(browser)) {
                driver = new ChromeDriver();

            } else if ("chrome-headless".equals(browser)) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--window-size=1920,1080");
                driver = new ChromeDriver();
            }


            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driver;
    }














//    public static WebDriver getDriver() {
//        if (driver == null ) {                //eğer driver null ise yani başlatılmamışsa driveri başlat fakat başlatılmışsa yeniden yeni bir driver açma
//            // hali hazıda açılmış olan driverdan devam et demiş olduk,
//            //java da non-primitivlerin default değeri null dur --> hatırlatma !
//
//            switch (ConfigurationReader.getProperty("browser")){
//                case "chrome":
//                    driver = new ChromeDriver();
//                    break;
//                case "edge" :
//                    driver = new EdgeDriver();
//                    break;
//                case  "safari" :
//                    driver = new SafariDriver();
//                    break;
//                case  "firefox" :
//                    driver = new FirefoxDriver();
//                    break;
//
//                default:
//                    driver = new ChromeDriver();
//
//            }
//
//
//
//            driver.manage().window().maximize();
//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//        }
//        return driver;
//    }





    public static void closeDriver() {
        if (driver != null) {  //driver null a eşit değilse yani driver başlatılmışsa kapat , daha sonra tekrar driver ı null a eşitle
            driver.close();
            driver = null;
        }

        /*
            Driver'i direk kapatip tekrar bir sayfaya gitmek istersek hata alırız. Çünkü
        Driver'in yeniden oluşma şartı değer atanmamış olması. Close yaptıktan sonra driver hala
        değer atılı durumda gözükür dolayısıyla yeniden driver'ı oluşturabilmesi için yani getDriver()
        methodundaki oluşma şartına uyabilmesi için driver'i tekrar null' a eşitlememiz yani
        kapandıktan sonra boş olduğunu belirtmemiz gerekir
         */

    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }

    }

}