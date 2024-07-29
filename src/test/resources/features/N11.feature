@smoke
Feature: N11 Web Sitesine Gitme
  @anasayfayaGit
  Scenario: N11 web sitesine gitmek istiyorum.
    Given Kullanıcı Anasayfaya gider.
    When Ana sayfanın yüklendiği doğrulanır.
    And Kullanıcı ana sayfada Giriş Yap butonunu bulur ve tıklar.
    And Giriş sayfasının yüklendiği doğrulanır.
    And Kullanıcı giriş yap sayfasında kullanıcı adı alanına geçerli bir kullanıcı adı girer.
    And Kullanıcı giriş yap sayfasında şifre alanına geçerli bir şifre girer.
    And Kullanıcı Giriş Yap butonuna tıklar.
    And Kullanıcının hesabına başarıyla giriş yapıldığı doğrulanır.
    Then Kullanıcı ana sayfada istediği işlemi gerçekleştirir.
    And İşlemin başarıyla tamamlandığı doğrulanır.

    @urunEkleme
    Scenario: Urun ekleme
      Given Kullanıcı Anasayfaya gider.
      When Ana sayfanın yüklendiği doğrulanır.
      And Kullanıcı ana sayfada Giriş Yap butonunu bulur ve tıklar.