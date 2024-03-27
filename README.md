# Enoca Spring Boot Project

Bu proje, müşteri (customer), sepet (cart), sepet içeriği (cartItem), sipariş (order) ve ürün (product) gibi temel domain sınıflarını içeren bir Spring Boot uygulamasıdır.

## Domain Sınıfları

### 1. Customer (Müşteri)
- Müşteri bilgilerini temsil eden bir entity sınıfıdır.
- Müşteri adı, e-posta adresi, adresi gibi bilgileri içerir.
- Müşterinin sepetleri (carts) ve siparişleri (orders) vardır.

### 2. Cart (Sepet)
- Müşterinin sepetini temsil eden bir entity sınıfıdır.
- Müşteriye ait sepetin durumu (cartStatus) bulunur.
- Sepet içeriği (cartItems) olarak adlandırılan ürünlerin listesini içerir.

### 3. CartItem (Sepet İçeriği)
- Sepet içeriğini temsil eden bir entity sınıfıdır.
- Bir ürünün sepet içerisindeki miktarı (quantity) ve birim fiyatı (unitPrice) gibi bilgileri içerir.

### 4. Order (Sipariş)
- Müşterinin verdiği siparişi temsil eden bir entity sınıfıdır.
- Bir müşterinin birden fazla sepeti (cart) ve siparişi olabilir.

### 5. OrderHistory (Sipariş Geçmişi)
- Müşterinin geçmiş siparişlerini ve bu siparişlere ait ürünleri temsil eden bir entity sınıfıdır.
- Bir siparişin içeriğindeki ürünlerin geçmiş fiyatlarını ve miktarlarını içerir.

### 6. Product (Ürün)
- Satışa sunulan ürünleri temsil eden bir entity sınıfıdır.
- Ürünün adı, açıklaması, fiyatı ve stoku gibi bilgileri içerir.

## Teknolojiler

- Java
- Spring Boot
- PostgreSQL
- Docker

## Kurulum

1. **Projeyi İndirin:**
   ```bash
   git clone https://github.com/sizin_kullanici_adi/sizin_proje_adi.git


# PostgreSQL Veritabanı Ayarları:

PostgreSQL veritabanı oluşturun veya mevcut bir veritabanını kullanın.
`application.properties` dosyasında PostgreSQL bağlantı ayarlarını yapılandırın.

# Uygulamayı Başlatın:

```sh
./mvnw spring-boot:run
```

# Uygulamayı Test Edin:
Tarayıcınızda http://localhost:8080/swagger-ui.html adresine giderek Swagger UI aracılığıyla uygulamayı test edebilirsiniz.

# Swagger
![image](https://github.com/dogusyasayan/caseEnoca/assets/79644280/300ddca5-0f9d-4b5b-b8f0-529eddc8b2cd)




