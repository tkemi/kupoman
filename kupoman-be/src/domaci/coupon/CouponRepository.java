package domaci.coupon;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import domaci.shop.ShopEntity;
import domaci.shop.ShopRepository;

/**
 * Repository se ovde bavi imitacijom komunikacije sa bazom.
 * Obratite paznju da cemo ovde za projekat upisivati u fajl.
 */
public class CouponRepository {

	private static List<CouponEntity> COUPON_LIST;
	private static AtomicInteger currentIndex;

    static {
    	currentIndex = new AtomicInteger(-1);
        COUPON_LIST = generateCoupons();
    }
    
	private static List<CouponEntity> generateCoupons() {
		List<CouponEntity> coupons = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			ShopEntity shopEntity = ShopRepository.getShops().get(i);
			CouponEntity coupon = new CouponEntity();
			coupon.setId((long) currentIndex.incrementAndGet());
			coupon.setShop(shopEntity);
			coupon.setProductName("Product " + i);
			coupon.setOldPrice(i * 3f);
			coupon.setNewPrice(i * 2f);
			coupon.setValidFrom(new Date());
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

			String dateString = format.format( new Date()   );
			Date   date       = null;
			try {
				date = format.parse ( "2020-12-31" );
			} catch (ParseException e) {
				e.printStackTrace();
			}
			coupon.setValidTo(date);
			coupons.add(coupon);
		}

		return coupons;
	}

    public synchronized static List<CouponEntity> getCoupons(){
        return COUPON_LIST;
    }

    public synchronized static void deleteCoupon(int i){
    	for (CouponEntity couponEntity : COUPON_LIST) {
			if (couponEntity.getId() == i) {
				COUPON_LIST.remove(couponEntity);
				System.out.println(COUPON_LIST.size());
				break;
			}
		}
        
    }
	public synchronized static void deleteCouponsForShop(long i){
		for (CouponEntity couponEntity : COUPON_LIST) {
			if (couponEntity.getId() == i) {
				COUPON_LIST.remove(couponEntity);
				System.out.println(COUPON_LIST.size());
				break;
			}
		}

	}

    public synchronized static CouponEntity addCoupon(CouponEntity couponEntity){

		couponEntity.setId((long) currentIndex.incrementAndGet());
        COUPON_LIST.add(couponEntity);
        return couponEntity;
    }

}
