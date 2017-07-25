package com.wa.dao;

import com.wa.pojo.Country;
import com.wa.pojo.DataMap;

import java.util.List;

public interface CountryMapper {
    int insert(Country record);

    int insertSelective(Country record);

    List<DataMap> queryMapData();
}