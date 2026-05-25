# Öğrenci Rehberi (Student Directory) - Yönetim Sistemi

Bu proje, üniversite öğrencilerini listelemek ve yeni öğrencileri kayıt altına almak amacıyla geliştirilmiş bir **REST API** uygulamasıdır.

## Kullanılan Teknolojiler
* **Java 17** & **Spring Boot 3.x**
* **Spring Data JPA** (Veri tabanı işlemleri ve **Derived Query Methods** kullanımı için)
* **H2 Database** (Bellek içi test veri tabanı)
* **Spring Security** (**Role-Based Access Control - RBAC** mekanizması için)
* **Validation** (**DTO** üzerinden veri doğrulama işlemleri için)

## Mimari Katmanlar
Proje 4 ana katmandan oluşmaktadır:
1. **Model (Entity)**: Veri tabanı tablolarını temsil eder.
2. **Repository**: **CRUD** işlemleri ve türetilmiş sorgular (Örn: `findByDepartment`) burada yer alır.
3. **Service**: İş mantığının, kuralların (**Transaction** / **Rollback**) ve **Exception** kontrollerinin yapıldığı kısımdır.
4. **Controller**: Dışarıdan gelen **HTTP requests**'in karşılandığı alandır.

## Kurulum ve Çalıştırma
1. Projeyi bilgisayarınıza indirin (`git clone`).
2. **IntelliJ IDEA** veya herhangi bir **IDE** ile projeyi açın.
3. **Maven** bağımlılıklarının yüklenmesini bekleyin ve `OgrenciRehberiApplication.java` dosyasını çalıştırın.
4. Proje `http://localhost:8082` portunda ayağa kalkacaktır.
5. Veri tabanı paneline erişmek için tarayıcıda `http://localhost:8082/h2-console` adresine gidin. (JDBC URL: `jdbc:h2:mem:rehberdb`, User: `kaan`, Şifre: kaan123).
6. **API** erişimleri için `admin` ve `123456` şifresiyle **Basic Auth** kullanılmalıdır.
7. Shopify benzeri websitesine gitme içinse http://localhost:8082 adresini kullanıp admin:123456 kullanıcı adıyla şifresini gireceksiniz.