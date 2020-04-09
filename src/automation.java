import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class automation {
    SoftAssert softAssertion;
    AndroidDriver<AndroidElement> ad;
    @BeforeClass
    public void Initialize() throws MalformedURLException {
        softAssertion = new SoftAssert();

        DesiredCapabilities dc = new DesiredCapabilities();

        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        dc.setCapability("platformName", "android");
        dc.setCapability("appPackage", "com.example.surveyapp");
        dc.setCapability("appActivity", "com.example.surveyapp.MainActivity");

        ad = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), dc);
    }

    @AfterMethod
    public void terminate() throws IOException {
        ad.resetApp();
    }
    @Test
    public void testCase1(){

        ad.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        MobileElement el1 = (MobileElement) ad.findElementById("com.example.surveyapp:id/name_field");
        el1.sendKeys("Sila");
        MobileElement el2 = (MobileElement) ad.findElementById("com.example.surveyapp:id/surname_field");
        el2.sendKeys("Inci");
        MobileElement el3 = (MobileElement) ad.findElementById("com.example.surveyapp:id/city_field");
        el3.sendKeys("Ankara");
        MobileElement el4 = (MobileElement) ad.findElementById("com.example.surveyapp:id/female");
        el4.click();
        MobileElement el5 = (MobileElement) ad.findElementById("com.example.surveyapp:id/date_button");
        el5.click();
        MobileElement el6 = (MobileElement) ad.findElementByAccessibilityId("01 January 1900");
        el6.click();
        MobileElement el7 = (MobileElement) ad.findElementById("android:id/button1");
        el7.click();
        MobileElement el8 = (MobileElement) ad.findElementById("com.example.surveyapp:id/occupation_field");
        el8.sendKeys("Student");
        MobileElement el9 = (MobileElement) ad.findElementById("com.example.surveyapp:id/button");
        el9.click();

        Assert.assertEquals(ad.findElementById("com.example.surveyapp:id/submission_result").getText(), "Successful Submission");
    }

    @Test
    public void testCase2() {
        /*
        TEST CASE 2 FAILED SUBMISSION: EMPTY NAME
        */
        //ad.resetApp();
        ad.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        MobileElement el2 = (MobileElement) ad.findElementById("com.example.surveyapp:id/surname_field");
        el2.sendKeys("Inci");
        MobileElement el3 = (MobileElement) ad.findElementById("com.example.surveyapp:id/city_field");
        el3.sendKeys("Ankara");
        MobileElement el4 = (MobileElement) ad.findElementById("com.example.surveyapp:id/female");
        el4.click();
        MobileElement el5 = (MobileElement) ad.findElementById("com.example.surveyapp:id/date_button");
        el5.click();
        MobileElement el6 = (MobileElement) ad.findElementByAccessibilityId("01 January 1900");
        el6.click();
        MobileElement el7 = (MobileElement) ad.findElementById("android:id/button1");
        el7.click();
        MobileElement el8 = (MobileElement) ad.findElementById("com.example.surveyapp:id/occupation_field");
        el8.sendKeys("Student");
        MobileElement el9 = (MobileElement) ad.findElementById("com.example.surveyapp:id/button");
        el9.click();

        Assert.assertEquals(ad.findElementById("com.example.surveyapp:id/submission_result").getText(), "Name can be empty");
    }

    @Test
    public void testCase3() {
        /*
        TEST CASE 3 FAILED SUBMISSION: EMPTY SURNAME
        */
        ad.resetApp();
        ad.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        MobileElement el1 = (MobileElement) ad.findElementById("com.example.surveyapp:id/name_field");
        el1.sendKeys("Sila");
        MobileElement el3 = (MobileElement) ad.findElementById("com.example.surveyapp:id/city_field");
        el3.sendKeys("Ankara");
        MobileElement el4 = (MobileElement) ad.findElementById("com.example.surveyapp:id/female");
        el4.click();
        MobileElement el5 = (MobileElement) ad.findElementById("com.example.surveyapp:id/date_button");
        el5.click();
        MobileElement el6 = (MobileElement) ad.findElementByAccessibilityId("01 January 1900");
        el6.click();
        MobileElement el7 = (MobileElement) ad.findElementById("android:id/button1");
        el7.click();
        MobileElement el8 = (MobileElement) ad.findElementById("com.example.surveyapp:id/occupation_field");
        el8.sendKeys("Student");
        MobileElement el9 = (MobileElement) ad.findElementById("com.example.surveyapp:id/button");
        el9.click();

        Assert.assertEquals(ad.findElementById("com.example.surveyapp:id/submission_result").getText(), "Surname can not be empty");

    }

    @Test
    public void testCase4() {
        /*
        TEST CASE 4 FAILED SUBMISSION: NAME SHOULD ONLY CONTAIN LETTERS
        */
        ad.resetApp();
        ad.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        MobileElement el1 = (MobileElement) ad.findElementById("com.example.surveyapp:id/name_field");
        el1.sendKeys("193983");
        MobileElement el2 = (MobileElement) ad.findElementById("com.example.surveyapp:id/surname_field");
        el2.sendKeys("Inci");
        MobileElement el3 = (MobileElement) ad.findElementById("com.example.surveyapp:id/city_field");
        el3.sendKeys("Ankara");
        MobileElement el4 = (MobileElement) ad.findElementById("com.example.surveyapp:id/female");
        el4.click();
        MobileElement el5 = (MobileElement) ad.findElementById("com.example.surveyapp:id/date_button");
        el5.click();
        MobileElement el6 = (MobileElement) ad.findElementByAccessibilityId("01 January 1900");
        el6.click();
        MobileElement el7 = (MobileElement) ad.findElementById("android:id/button1");
        el7.click();
        MobileElement el8 = (MobileElement) ad.findElementById("com.example.surveyapp:id/occupation_field");
        el8.sendKeys("Student");
        MobileElement el9 = (MobileElement) ad.findElementById("com.example.surveyapp:id/button");
        el9.click();

        Assert.assertEquals(ad.findElementById("com.example.surveyapp:id/submission_result").getText(), "Name should only contain English letters");
    }

    @Test
    public void testCase5() {
        /*
        TEST CASE 5 FAILED SUBMISSION: CITY SHOULD ONLY CONTAIN ENGLISH LETTERS
        */
        ad.resetApp();
        ad.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        MobileElement el1 = (MobileElement) ad.findElementById("com.example.surveyapp:id/name_field");
        el1.sendKeys("Sila");
        MobileElement el2 = (MobileElement) ad.findElementById("com.example.surveyapp:id/surname_field");
        el2.sendKeys("Inci");
        MobileElement el3 = (MobileElement) ad.findElementById("com.example.surveyapp:id/city_field");
        el3.sendKeys("çankaya");
        MobileElement el4 = (MobileElement) ad.findElementById("com.example.surveyapp:id/female");
        el4.click();
        MobileElement el5 = (MobileElement) ad.findElementById("com.example.surveyapp:id/date_button");
        el5.click();
        MobileElement el6 = (MobileElement) ad.findElementByAccessibilityId("01 January 1900");
        el6.click();
        MobileElement el7 = (MobileElement) ad.findElementById("android:id/button1");
        el7.click();
        MobileElement el8 = (MobileElement) ad.findElementById("com.example.surveyapp:id/occupation_field");
        el8.sendKeys("Student");
        MobileElement el9 = (MobileElement) ad.findElementById("com.example.surveyapp:id/button");
        el9.click();

        Assert.assertEquals(ad.findElementById("com.example.surveyapp:id/submission_result").getText(), "City should only contain English letters");
    }

}
