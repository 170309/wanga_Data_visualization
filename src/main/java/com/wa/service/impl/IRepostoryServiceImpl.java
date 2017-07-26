package com.wa.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.wa.common.ServerResponse;
import com.wa.dao.ConsoledMapper;
import com.wa.dao.CountryMapper;
import com.wa.dao.WormMapper;
import com.wa.pojo.DataMap;
import com.wa.service.IRepostoryService;
import com.wa.vo.MapDataVo;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("iRepostoryService")
public class IRepostoryServiceImpl implements IRepostoryService {


    @Autowired
    private ConsoledMapper consoledMapper;

    @Autowired
    private CountryMapper countryMapper;

    @Autowired
    private WormMapper wormMapper;

    public ServerResponse<PageInfo> queryData(int pagenum,int pagesize){
        PageHelper.startPage(pagenum, pagesize);
        List<DataMap> consoled = consoledMapper.queryMapData();
        List<DataMap> control = countryMapper.queryMapData();
        List<DataMap> worm = wormMapper.queryMapData();

        if(CollectionUtils.isEmpty(consoled)){
            return ServerResponse.createByError("没有查询到受控数据");
        }else if(CollectionUtils.isEmpty(control)){
            return ServerResponse.createByError("没有查询到主控数据");
        }else if(CollectionUtils.isEmpty(worm)){
            return ServerResponse.createByError("没有查询到蠕虫相关数据");
        }

        List<MapDataVo> mapDataVoList = Lists.newArrayList();

        MapDataVo mapDataVo = new MapDataVo();

        mapDataVo.setConsoledtitle("木马受控数据");
        mapDataVo.setConsoled(consoled);

        mapDataVo.setControl(control);
        mapDataVo.setControltitle("木马主控数据");

        mapDataVo.setWorm(worm);
        mapDataVo.setWormtitle("蠕虫感染数据");

        mapDataVoList.add(mapDataVo);


        PageInfo pageInfo = new PageInfo(mapDataVoList);
        return ServerResponse.createBySuccess(pageInfo);














    }
}
