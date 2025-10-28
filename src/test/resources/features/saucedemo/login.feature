Feature: Login ke SauceDemo
  Sebagai user
  Saya ingin login ke aplikasi SauceDemo
  Agar saya bisa mengakses halaman produk

  @Positive
  Scenario: Login dengan kredensial valid
    Given pengguna membuka halaman login SauceDemo
    When pengguna login dengan username "standard_user" dan password "secret_sauce"
    Then pengguna berhasil masuk ke halaman utama

  @Negative
  Scenario Outline: Login dengan kredensial tidak valid
    Given pengguna membuka halaman login SauceDemo
    When pengguna login dengan username "<username>" dan password "<password>"
    Then sistem menampilkan pesan error login

    Examples:
      | username       | password     | errorMessage                                                        |
      | standard_user  | secret100    | Epic sadface: Username and password do not match any user in this service |
      | standard_us    | secret_sauce | Epic sadface: Username and password do not match any user in this service |
      | dirwanUhuy     | secret_sa    | Epic sadface: Username and password do not match any user in this service |
      | standard_user  |              | Epic sadface: Password is required                                  |
      |                | secret_sauce | Epic sadface: Username is required                                  |