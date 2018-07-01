package com.jsc.stationinfoweb.dao;

import com.jsc.stationinfoweb.datamodel.CellInfo;
import com.jsc.stationinfoweb.datamodel.CellInfoKey;

public interface CellInfoDao {
    int deleteByPrimaryKey(CellInfoKey key);

    int insert(CellInfo record);

    int insertSelective(CellInfo record);

    CellInfo selectByPrimaryKey(CellInfoKey key);

    int updateByPrimaryKeySelective(CellInfo record);

    int updateByPrimaryKey(CellInfo record);
}