INSERT INTO `biletdb`.`roller` (`id`, `isim`) VALUES ('1', 'kullanici');
INSERT INTO `biletdb`.`roller` (`id`, `isim`) VALUES ('2', 'admin');

INSERT INTO `biletdb`.`urunler` (`id`, `isim`, `ucret`) VALUES ('1', 'tost', '10');
INSERT INTO `biletdb`.`urunler` (`id`, `isim`, `ucret`) VALUES ('2', 'elma', '3');
INSERT INTO `biletdb`.`urunler` (`id`, `isim`, `ucret`) VALUES ('3', 'armut', '2');
INSERT INTO `biletdb`.`urunler` (`id`, `isim`, `ucret`) VALUES ('4', 'corba', '8');
INSERT INTO `biletdb`.`urunler` (`id`, `isim`, `ucret`) VALUES ('5', 'anayemek', '19');

INSERT INTO `biletdb`.`ucaklar` (`id`, `hostes_sayisi`, `isim`, `km_basina_bakim_maliyeti`, `pilot_sayisi`) VALUES ('1', '2', 'hj-432', '100', '2');
INSERT INTO `biletdb`.`ucaklar` (`id`, `hostes_sayisi`, `isim`, `km_basina_bakim_maliyeti`, `pilot_sayisi`) VALUES ('2', '2', 'fg-987', '150', '3');
INSERT INTO `biletdb`.`ucaklar` (`id`, `hostes_sayisi`, `isim`, `km_basina_bakim_maliyeti`, `pilot_sayisi`) VALUES ('3', '6', 'ht-453', '250', '5');
INSERT INTO `biletdb`.`ucaklar` (`id`, `hostes_sayisi`, `isim`, `km_basina_bakim_maliyeti`, `pilot_sayisi`) VALUES ('4', '3', 'fr-987', '200', '4');

INSERT INTO `biletdb`.`havayollari` (`id`, `isim`) VALUES ('1', 'turk hava yollari');
INSERT INTO `biletdb`.`havayollari` (`id`, `isim`) VALUES ('2', 'alman hava yollari');
INSERT INTO `biletdb`.`havayollari` (`id`, `isim`) VALUES ('3', 'italya hava yollari');

INSERT INTO `biletdb`.`kuponlar` (`id`, `indirim_miktari`, `isim`, `yuzdeli_indirim_mi`, `havayolu_id`) VALUES ('1', '20', 'bedava1', true, '1');
INSERT INTO `biletdb`.`kuponlar` (`id`, `indirim_miktari`, `isim`, `yuzdeli_indirim_mi`, `havayolu_id`) VALUES ('2', '10', 'bedava2', true, '2');

INSERT INTO `biletdb`.`havalimanlari` (`id`, `adres`, `aktif_mi`, `isim`, `sehir`) VALUES ('3', 'efwfw', true, 'wdewd', 'edwde');
INSERT INTO `biletdb`.`havalimanlari` (`id`, `adres`, `aktif_mi`, `isim`, `sehir`) VALUES ('1', 'sda', true, 'asdad', 'asdda');
INSERT INTO `biletdb`.`havalimanlari` (`id`, `adres`, `aktif_mi`, `isim`, `sehir`) VALUES ('2', 'adasd', true, 'adsad', 'asddad');

INSERT INTO `biletdb`.`takvimler` (`id`, `aktif_mi`, `kalkis_zamaný`, `varis_zamani`) VALUES ('1', true, '2019-10-27', '2019-10-27');
INSERT INTO `biletdb`.`takvimler` (`id`, `aktif_mi`, `kalkis_zamaný`, `varis_zamani`) VALUES ('2', true, '2019-10-27', '2019-10-27');
INSERT INTO `biletdb`.`takvimler` (`id`, `aktif_mi`, `kalkis_zamaný`, `varis_zamani`) VALUES ('3', true, '2019-10-28', '2019-10-28');
INSERT INTO `biletdb`.`takvimler` (`id`, `aktif_mi`, `kalkis_zamaný`, `varis_zamani`) VALUES ('4', true, '2019-10-29', '2019-10-29');
INSERT INTO `biletdb`.`takvimler` (`id`, `aktif_mi`, `kalkis_zamaný`, `varis_zamani`) VALUES ('5', true, '2019-10-30', '2019-10-30');
INSERT INTO `biletdb`.`takvimler` (`id`, `aktif_mi`, `kalkis_zamaný`, `varis_zamani`) VALUES ('6', true, '2019-10-31', '2019-10-31');

INSERT INTO `biletdb`.`seferler` (`id`, `aktif_pasif_et`, `isim`, `kapi_no`, `km`, `inis_havalimani_id`, `havayolu_id`, `kalkis_havalimani_id`, `takvim_id`, `ucak_id`) VALUES ('1', true, 'tj-uyr', '23', '2000', '1', '2', '2', '1', '1');
INSERT INTO `biletdb`.`seferler` (`id`, `aktif_pasif_et`, `isim`, `kapi_no`, `km`, `inis_havalimani_id`, `havayolu_id`, `kalkis_havalimani_id`, `takvim_id`, `ucak_id`) VALUES ('2', true, 'tj-uyr', '24', '2500', '2', '3', '1', '2', '2');
INSERT INTO `biletdb`.`seferler` (`id`, `aktif_pasif_et`, `isim`, `kapi_no`, `km`, `inis_havalimani_id`, `havayolu_id`, `kalkis_havalimani_id`, `takvim_id`, `ucak_id`) VALUES ('3', true, 'tj-uyr', '22', '1000', '3', '1', '3', '3', '3');
INSERT INTO `biletdb`.`seferler` (`id`, `aktif_pasif_et`, `isim`, `kapi_no`, `km`, `inis_havalimani_id`, `havayolu_id`, `kalkis_havalimani_id`, `takvim_id`, `ucak_id`) VALUES ('4', true, 'tj-uyr', '21', '2000', '2', '3', '1', '2', '2');
INSERT INTO `biletdb`.`seferler` (`id`, `aktif_pasif_et`, `isim`, `kapi_no`, `km`, `inis_havalimani_id`, `havayolu_id`, `kalkis_havalimani_id`, `takvim_id`, `ucak_id`) VALUES ('5', true, 'tj-uyr', '20', '2000', '4', '2', '2', '3', '1');
INSERT INTO `biletdb`.`seferler` (`id`, `aktif_pasif_et`, `isim`, `kapi_no`, `km`, `inis_havalimani_id`, `havayolu_id`, `kalkis_havalimani_id`, `takvim_id`, `ucak_id`) VALUES ('6', true, 'tj-uyr', '19', '3000', '1', '1', '3', '4', '4');

INSERT INTO `biletdb`.`koltuklar` (`id`, `isim`, `koltuk_ucreti`, `sinif`, `sefer_id`) VALUES ('1', '2b', '80', 'normal', '1');
INSERT INTO `biletdb`.`koltuklar` (`id`, `isim`, `koltuk_ucreti`, `sinif`, `sefer_id`) VALUES ('2', '1b', '160', 'busines', '1');
INSERT INTO `biletdb`.`koltuklar` (`id`, `isim`, `koltuk_ucreti`, `sinif`, `sefer_id`) VALUES ('3', '2b', '80', 'normal', '2');
INSERT INTO `biletdb`.`koltuklar` (`id`, `isim`, `koltuk_ucreti`, `sinif`, `sefer_id`) VALUES ('4', '3b', '80', 'normal', '1');
INSERT INTO `biletdb`.`koltuklar` (`id`, `isim`, `koltuk_ucreti`, `sinif`, `sefer_id`) VALUES ('5', '1b', '160', 'busines', '3');
INSERT INTO `biletdb`.`koltuklar` (`id`, `isim`, `koltuk_ucreti`, `sinif`, `sefer_id`) VALUES ('6', '2b', '80', 'normal', '4');



INSERT INTO `biletdb`.`kisiler` (`id`, `aktif_mi`, `dogum_tarihi`, `email`, `isim`, `soyisim`, `tc`, `tel`) VALUES ('1', true, '2000-02-01', 'asdad@sad.com', 'abdullah', 'can', '12345445567', '5442145654');
INSERT INTO `biletdb`.`kisiler` (`id`, `aktif_mi`, `dogum_tarihi`, `email`, `isim`, `soyisim`, `tc`, `tel`) VALUES ('2', true, '2001-01-01', 'aikkd@sad.com', 'erdem', 'yan', '12345436567', '5432145654');
INSERT INTO `biletdb`.`kisiler` (`id`, `aktif_mi`, `dogum_tarihi`, `email`, `isim`, `soyisim`, `tc`, `tel`) VALUES ('3', true, '1969-02-01', 'rafe@sad.com', 'mert', 'gül', '12345434566', '5432148554');
INSERT INTO `biletdb`.`kisiler` (`id`, `aktif_mi`, `dogum_tarihi`, `email`, `isim`, `soyisim`, `tc`, `tel`) VALUES ('4', true, '1989-03-01', 'ferfefe@sad.com', 'hamza', 'ileri', '12387434567', '5447145654');


INSERT INTO `biletdb`.`kullanicilar` (`sifre`, `kisi_id`) VALUES ('wedwde', '1');
INSERT INTO `biletdb`.`kullanicilar` (`sifre`, `kisi_id`) VALUES ('wedwd', '2');


INSERT INTO `biletdb`.`musteriler` (`kisi_id`) VALUES ('1');
INSERT INTO `biletdb`.`musteriler` (`kisi_id`) VALUES ('2');
INSERT INTO `biletdb`.`musteriler` (`kisi_id`) VALUES ('3');
INSERT INTO `biletdb`.`musteriler` (`kisi_id`) VALUES ('4');




INSERT INTO `biletdb`.`biletler` (`id`, `aktif_mi`, `koltuk_no`, `pnr`, `toplam_tutar`, `ödendi_mi`, `koltuk_id`, `musteri_id`, `sefer_id`) VALUES ('1', true, '-', 'adfasffafsf', '100', true, '1', '3', '1');
INSERT INTO `biletdb`.`biletler` (`id`, `aktif_mi`, `koltuk_no`, `pnr`, `toplam_tutar`, `ödendi_mi`, `koltuk_id`, `musteri_id`, `sefer_id`) VALUES ('2', true, '-', 'sadasdasd', '100', true, '2', '2', '2');
INSERT INTO `biletdb`.`biletler` (`id`, `aktif_mi`, `koltuk_no`, `pnr`, `toplam_tutar`, `ödendi_mi`, `koltuk_id`, `musteri_id`, `sefer_id`) VALUES ('3', true, '-', 'aasdasdad', '100', true, '3', '3', '3');
INSERT INTO `biletdb`.`biletler` (`id`, `aktif_mi`, `koltuk_no`, `pnr`, `toplam_tutar`, `ödendi_mi`, `koltuk_id`, `musteri_id`, `sefer_id`) VALUES ('4', true, '-', 'adasdwdsa', '100', true, '4', '4', '1');



