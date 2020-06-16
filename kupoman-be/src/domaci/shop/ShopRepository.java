package domaci.shop;

import java.util.ArrayList;
import java.util.List;

public class ShopRepository {

    private static List<ShopEntity> SHOP_LIST;

    static {
        SHOP_LIST = generateShops();
    }

    private static List<ShopEntity> generateShops() {
        List<ShopEntity> shops = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            ShopEntity shopEntity = new ShopEntity();
            shopEntity.setId((long) i);
            shopEntity.setName("Shop " + i);
            shops.add(shopEntity);
        }
        return shops;
    }

    public synchronized static List<ShopEntity> getShops() {
        return SHOP_LIST;
    }
    public synchronized static ShopEntity getShop(int id) {
        for(ShopEntity s:SHOP_LIST){
            if(s.getId() == id){
                return s;
            }
        }
        return null;
    }

    public synchronized static ShopEntity getShopById(Long index) {
        return SHOP_LIST.get(Math.toIntExact(index));
    }

    public synchronized static void deleteShop(int i){
        for (ShopEntity shopEntity : SHOP_LIST) {
            if (shopEntity.getId() == i) {
                SHOP_LIST.remove(shopEntity);
                break;
            }
        }

    }
}
