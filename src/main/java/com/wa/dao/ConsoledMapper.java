package com.wa.dao;

import com.wa.pojo.Consoled;
import com.wa.pojo.DataMap;

import java.util.List;

public interface ConsoledMapper {
    int insert(Consoled record);

    int insertSelective(Consoled record);

    List<DataMap> queryMapData();
}