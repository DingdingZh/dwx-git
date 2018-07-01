package com.jsc.stationinfoweb.service.Impl;

import com.jsc.stationinfoweb.dao.CellInfoDao;
import com.jsc.stationinfoweb.datamodel.CellInfo;
import com.jsc.stationinfoweb.datamodel.CellInfoKey;
import com.jsc.stationinfoweb.service.CellInfoMngmService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("cellInfoService")
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
public class CellInfoMngmServiceImpl implements CellInfoMngmService {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(CellInfoMngmServiceImpl.class);

    @Autowired
    private CellInfoDao cellInfoDao;

    @Override
    public CellInfo getCellInfoByPrimaryKey(CellInfoKey cellInfoKey) {
        if(cellInfoKey == null)
            return null;
        return cellInfoDao.selectByPrimaryKey(cellInfoKey);
    }
}
