package domaci.coupon;

import domaci.shop.ShopEntity;
import lombok.Data;

import java.util.Date;

/**
 * Model kupona cemo koristiti kao jedinicu transporta informacija
 * izmedju Web Aplikacije i Baze.
 *
 * Podaci iz baze (MySQL, Mongo, Text fajl) ce se mapirati na polja
 * instance ove klase ako su vezani za ovaj domen (Kupon).
 */
@Data
public class CouponEntity {

    private Long id;
    private ShopEntity shop;
    private String productName;
    private Float newPrice;
    private Float oldPrice;
    private Date validFrom;
    private Date validTo;
}
