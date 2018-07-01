package com.jsc.stationinfoweb.controller;

import com.jsc.stationinfoweb.datamodel.CellInfo;
import com.jsc.stationinfoweb.datamodel.CellInfoKey;
import com.jsc.stationinfoweb.service.CellInfoMngmService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/api/v1/stationinfo")
@Api(value = "station info",description = "基站信息查询")
public class StationInfoController {

    @Autowired
    private CellInfoMngmService cellInfoMngmService;

    @RequestMapping(value = "/cellinfo/{userkey}",method = {RequestMethod.GET})
    @ApiOperation(value = "根据mnc,lac,cell查询基站信息，移动联动基站mnc字段值为0，电信基站mnc字段值为sid")
    public CellInfo queryCellInfoByPrimaryKey(@PathVariable String userkey, CellInfoKey key){
        if(userkey == null || userkey.isEmpty())
            return null;
        return cellInfoMngmService.getCellInfoByPrimaryKey(key);
    }

    @RequestMapping(value = "/cellinfo/{userkey}/{mnc}/{lac}/{ci}",method = {RequestMethod.GET})
    @ApiOperation(value = "根据mnc,lac,cell查询基站信息，移动联动基站mnc字段值为0，电信基站mnc字段值为sid")
    public CellInfo queryCellInfoByPrimaryKey2(@PathVariable String userkey,
                                               @PathVariable int mnc,
                                               @PathVariable int lac,
                                               @PathVariable int ci){
        if(userkey == null || userkey.isEmpty() || !userkey.equals("ee1ff139-7cd1-11e8-84d9-dc0ea1d02564"))
            return null;
        CellInfoKey cellInfoKey = new CellInfoKey();
        cellInfoKey.setMnc(mnc);
        cellInfoKey.setLac(lac);
        cellInfoKey.setCi(ci);
        return cellInfoMngmService.getCellInfoByPrimaryKey(cellInfoKey);
    }

}
