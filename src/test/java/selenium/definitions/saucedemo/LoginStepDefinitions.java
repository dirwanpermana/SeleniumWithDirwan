package selenium.definitions.saucedemo;

import com.demo.pageobjects.saucedemo.Logincuy;
import org.openqa.selenium.By;
import org.junit.Assert;
import io.cucumber.java.en.*;
import com.demo.base.BaseTestSauceDemo;

public class LoginStepDefinitions extends BaseTestSauceDemo {

    Logincuy loginPage;

    @Given("pengguna membuka halaman login SauceDemo")
    public void pengguna_membuka_halaman_login_saucedemo() {
        setUp();
        loginPage = new Logincuy(driver);
        driver.get("https://www.saucedemo.com/");
        String loginLogo = driver.findElement(By.className("login_logo")).getText();
        System.out.println("Halaman Login: " + loginLogo);
    }

    @When("pengguna login dengan username {string} dan password {string}")
    public void pengguna_login_dengan_username_dan_password(String username, String password) {
        loginPage.loginApplication(username, password);
    }

    @Then("pengguna berhasil masuk ke halaman utama")
    public void pengguna_berhasil_masuk_ke_halaman_utama() {
        String homeTitle = driver.findElement(By.className("app_logo")).getText();
        Assert.assertEquals("Swag Labs", homeTitle);
        System.out.println("Login Berhasil - Halaman: " + homeTitle);
    }

    @Then("sistem menampilkan pesan error login")
    public void sistem_menampilkan_pesan_error_login() {
        boolean errorTampil = driver.findElement(By.cssSelector(".error-message-container")).isDisplayed();
        Assert.assertTrue("Tidak ada pesan error yang muncul!", errorTampil);
        System.out.println("Pesan error login tampil.");
        tearDown();

    }
}
