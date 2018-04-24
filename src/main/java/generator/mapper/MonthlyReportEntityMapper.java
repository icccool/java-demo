package mapper;

import entity.MonthlyReportEntity;
import entity.MonthlyReportEntityWithBLOBs;

public interface MonthlyReportEntityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MonthlyReportEntityWithBLOBs record);

    int insertSelective(MonthlyReportEntityWithBLOBs record);

    MonthlyReportEntityWithBLOBs selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MonthlyReportEntityWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(MonthlyReportEntityWithBLOBs record);

    int updateByPrimaryKey(MonthlyReportEntity record);
}