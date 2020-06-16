package domaci.shop;

import domaci.coupon.Coupon;
import domaci.coupon.CouponService;

import java.util.List;

public class ShopService {

    private final ShopMapper shopMapper;
    private  CouponService couponService;

    public ShopService() {
        this.shopMapper = new ShopMapper();
        this.couponService = new CouponService();
    }

    public List<Shop> getShops() {
        return shopMapper.mapToModelList(ShopRepository.getShops());
    }

    public void deleteShop(int i) {
        Shop shop = shopMapper.mapToModel(ShopRepository.getShop(i));
        couponService.deleteCouponsForShop(shop.getId());
        ShopRepository.deleteShop(i);
    }

}
