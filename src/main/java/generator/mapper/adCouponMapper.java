package mapper;

import entity.adCoupon;
import entity.adCouponWithBLOBs;

public interface adCouponMapper {
    int deleteByPrimaryKey(Long id);

    int insert(adCouponWithBLOBs record);

    int insertSelective(adCouponWithBLOBs record);

    adCouponWithBLOBs selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(adCouponWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(adCouponWithBLOBs record);

    int updateByPrimaryKey(adCoupon record);
}