package mapper;

import entity.adCouponCode;

public interface adCouponCodeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(adCouponCode record);

    int insertSelective(adCouponCode record);

    adCouponCode selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(adCouponCode record);

    int updateByPrimaryKey(adCouponCode record);
}