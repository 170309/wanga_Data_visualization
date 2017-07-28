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
import org.apache.commons.lang3.StringUtils;
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

        str(consoled);
        str(control);
        str(worm);

        if(CollectionUtils.isEmpty(consoled)){
            return ServerResponse.createByError("没有查询到受控数据");
        }else if(CollectionUtils.isEmpty(control)){
            return ServerResponse.createByError("没有查询到主控数据");
        }else if(CollectionUtils.isEmpty(worm)){
            return ServerResponse.createByError("没有查询到蠕虫相关数据");
        }

        List<MapDataVo> mapDataVoList = Lists.newArrayList();

        MapDataVo mapDataVo = new MapDataVo();

        mapDataVo.setConsoledtitle("2017年4月木马受控数据");
        mapDataVo.setConsoled(consoled);

        mapDataVo.setControl(control);
        mapDataVo.setControltitle("2017年4月木马主控数据");

        mapDataVo.setWorm(worm);
        mapDataVo.setWormtitle("2017年4月蠕虫感染数据");

        mapDataVoList.add(mapDataVo);


        PageInfo pageInfo = new PageInfo(mapDataVoList);
        return ServerResponse.createBySuccess(pageInfo);

    }

    public List<DataMap> str(List<DataMap> list){
        List<DataMap> newlist = Lists.newArrayList();
        for(DataMap dataMap : list){
            dataMap.setName(StringUtils.trim(dataMap.getName()));
            switch (dataMap.getName()){
                case "乌鲁木齐":dataMap.setName("乌鲁木齐市");
                    break;
                case "伊犁":dataMap.setName("伊犁州");
                    break;
                case "巴音郭楞":dataMap.setName("巴州");
                    break;
                case "昌吉":dataMap.setName("昌吉州");
                    break;
                case "克孜勒苏":dataMap.setName("克州");
                    break;
                case "博尔塔拉":dataMap.setName("博州");
                    break;
            }
        }

        Object obj = new Object();
        int size = list.size();
        for(int i = 0 ;i < size -1 ; i++){
            for(int j = 0 ; j< size -i -1;j++){
                if(list.get(j).getValue()<list.get(j+1).getValue()){
                    obj = list.get(j);
                    list.set(j,list.get(j+1));
                    list.set(j+1, (DataMap) obj);
                }
            }
        }

        return list;

    }

    public ServerResponse<MapDataVo> query(){
        List<DataMap> consoled = consoledMapper.queryMapData();
        List<DataMap> control = countryMapper.queryMapData();
        List<DataMap> worm = wormMapper.queryMapData();

        str(consoled);
        str(control);
        str(worm);

        if(CollectionUtils.isEmpty(consoled)){
            return ServerResponse.createByError("没有查询到受控数据");
        }else if(CollectionUtils.isEmpty(control)){
            return ServerResponse.createByError("没有查询到主控数据");
        }else if(CollectionUtils.isEmpty(worm)){
            return ServerResponse.createByError("没有查询到蠕虫相关数据");
        }
        MapDataVo mapDataVo = new MapDataVo();

        mapDataVo.setConsoledtitle("2017年4月木马受控数据");
        mapDataVo.setConsoled(consoled);

        mapDataVo.setControl(control);
        mapDataVo.setControltitle("2017年4月木马主控数据");

        mapDataVo.setWorm(worm);
        mapDataVo.setWormtitle("2017年4月蠕虫感染数据");

        return ServerResponse.createBySuccess(mapDataVo);


    }
}
