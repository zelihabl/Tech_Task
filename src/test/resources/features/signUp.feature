@3
Feature:Kullanici 2NTECH sitesinde bulunan basvuru formunu başaralı bir şekilde gönderebilmelidir
  Scenario: TC03_Basvuru_formu_basarili_bir_sekilde_gönderilmeli
    Given Kullanici "https://app.forceget.com/system/account/register" gider
    When Kullanici FirstName inputuna "bir isim" girer
    And Kullanici LastName inptuna "bir soyisim" girer
    And Kullanici Cauntry dropdownundan bir ülke seçer
    And Kullanici MobileNumber inbutuna "bir cep telefon numarası" girer
    And Kullanici Campany inputuna "Forceget" girer
   And Kullanici Email inputuna "rock.sanjeev@filesaved.org" girer
    And Kullanici bir Title seçer
    And Kullanici Password "Asd*1234" girer
    And Kullanici ConfirmPassword "Asd*1234" girer

