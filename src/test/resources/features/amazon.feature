Feature: US01_Amazon_Task
  @Amazon_US_01
  Scenario: TC01_Amazon_Urun_Arama_Sepete_Ekleme

    Given Kullanici Amazon anasayfasina gider
    When Giris yap sekmesine tiklar
    And Gecerli kullanici adini girer
    And Devam et butonuna tiklar
    And Gecerli password bilgisini girer
    And Giris yap butonuna tiklar
    And Kullanici arama kutusuna herhangi bir gecerli veri girisi yapar
    And Kullanici arama sonuclarini fiyati dusukten yuksege siralar
    And Kullanici fiyati en dusuk olan urune tiklar
    And Kullanici urunu sepete ekler
    Then Kullanici urunun sepete eklendigini dogrular








