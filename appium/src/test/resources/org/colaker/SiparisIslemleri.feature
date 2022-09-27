Feature: SiparisIslemleri

  Scenario: Kadin Siyah Corap Siparisi
    * a101Logo elementi görünene kadar beklenir
    * hamburgerMenu objesine tıklanır
    * giyimVeAksesuarMenu objesine tıklanır
    * kadinIcGiyimMenu objesine tıklanır
    * dizaltiCorapMenu objesine tıklanır
    * urunlerListesiSayfaBasligi objesinin değerinin 'Dizaltı Çorap' değerini içerdiği kontrol edilir
    * filtreBtn objesine tıklanır
    * filtreEkrani elementi görünene kadar beklenir
    * siyahRenkFiltre elementi görünene kadar max '10' defa ekranı yukarı kaydır
    * siyahRenkFiltre objesine tıklanır
    * ilkUrun objesine tıklanır
    * urunAdi objesinin değerinin 'Siyah' değerini içerdiği kontrol edilir
    * sepeteEkleBtn objesine tıklanır
    * sepeteEklendiPopup elementi görünene kadar beklenir
    * sepeteGitBtn objesine tıklanır
    * sepetimSayfaBasligi objesinin değerinin 'Sepetim' değerini içerdiği kontrol edilir
    * sepetiOnaylaBtn objesine tıklanır
    * uyeOlmadanDevamEtBtn objesine tıklanır
    * ePosta alanına 'otomasyondemo101@gmail.com' değeri yazılır
    * kvkkCheck objesine tıklanır
    * gonderBtn objesine tıklanır
    * cookiesOnayBtn objesine tıklanır
    * yeniAdresOlustur objesine tıklanır
    * adresBasligi alanına 'Ev' değeri yazılır
    * ad alanına 'Muhammed Ali' değeri yazılır
    * soyad alanına 'Çolaker' değeri yazılır
    * cepTelefonu alanına '5550000505' değeri yazılır
    * il listesinden 'AMASYA' değeri seçilir
    * 1 kere ekranı yukarı kaydır
    * ilce listesinden 'SULUOVA' değeri seçilir
    * 1 kere ekranı yukarı kaydır
    * mahalle listesinden 'BİR EYLÜL MAH' değeri seçilir
    * adres alanına 'Bağlar cad' değeri yazılır
    * adresKaydetBtn objesine tıklanır
    * 1 kere ekranı yukarı kaydır
    * ilkKargo objesine tıklanır
    * kaydetVeDevamEt objesine tıklanır
    * masterpassIleOdemeAlani objesinin bulunduğu kontrol edilir