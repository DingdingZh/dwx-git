package com.jsc.stationinfoweb.service;

import com.jsc.stationinfoweb.datamodel.CellInfo;
import com.jsc.stationinfoweb.datamodel.CellInfoKey;

public interface CellInfoMngmService {
    public CellInfo getCellInfoByPrimaryKey(CellInfoKey cellInfoKey);
}
