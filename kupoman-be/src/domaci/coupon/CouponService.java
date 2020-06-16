package domaci.coupon;

import domaci.shop.ShopEntity;
import domaci.shop.ShopRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Ovde se nalazi nasa "biznis logika".
 */
public class CouponService {

    private final CouponMapper couponMapper;

    public CouponService() {
        couponMapper = new CouponMapper();
    }

    public List<Coupon> getCoupons() {
        return couponMapper.mapToModelList(CouponRepository.getCoupons());
    }

    /**
     * Obratiti paznju kako tretiram pristigli kupon. Ovaj kupon
     * je Jersey inicijalizovao i popunio podacima iz JSON-a.
     *
     * Posto ovaj kupon ima Shop, Jersey je takodje inicijalizovao Shop
     * i popunio ga sa podacima iz JSON-a.
     *
     * Ono sto je jako bitno napomenuti da referenca na Shop nije ista
     * kao u bazi iako su svi podaci isti. Zato pre nego sto snimim ovaj
     * entitet prvo dohvatim adekvatnu referencu Shop-a.
     *
     * @param c
     * @return
     */
    public Coupon addCoupon(Coupon c) {
        CouponEntity couponEntity = couponMapper.mapToEntity(c);

        ShopEntity shopEntity = ShopRepository.getShopById(c.getShop().getId());
        couponEntity.setShop(shopEntity);

        return couponMapper.mapToModel(CouponRepository.addCoupon(couponEntity));
    }

    public void deleteCoupon(int i) {
        CouponRepository.deleteCoupon(i);
    }

    public void deleteCouponsForShop(long i) {
        CouponRepository.deleteCouponsForShop(i);
    }

    public List<Coupon> getFiltered(){
        List<Coupon> lista = couponMapper.mapToModelList(CouponRepository.getCoupons());
        List<Coupon> pomocna = new ArrayList<>();
        Date date = new Date();

        for(Coupon c : lista){
            //TODO proveri sta se ovde desava sa date, zasto ne vraca listu coupon-a
            if(c.getValidFrom().after(date) && c.getValidTo().before(date)){
                pomocna.add(c);
            }

        }

        return pomocna;


    }

    public List<Coupon> getCouponsForShop(String shopName){
        List<Coupon> lista = couponMapper.mapToModelList(CouponRepository.getCoupons());
        List<Coupon> pomocna = new ArrayList<>();

        for(Coupon c:lista){
            if(c.getShop().getName().equals(shopName)){
                pomocna.add(c);
            }
        }
        return pomocna;
    }
}
