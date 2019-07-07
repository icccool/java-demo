package mapper;

import entity.SalePrescription;

public interface SalePrescriptionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SalePrescription record);

    int insertSelective(SalePrescription record);

    SalePrescription selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SalePrescription record);

    int updateByPrimaryKey(SalePrescription record);
}