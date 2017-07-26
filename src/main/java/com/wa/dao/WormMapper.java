package com.wa.dao;

import com.wa.pojo.DataMap;
import com.wa.pojo.Worm;

import java.util.List;

public interface WormMapper {
    int insert(Worm record);

    int insertSelective(Worm record);

    List<DataMap> queryMapData();
}