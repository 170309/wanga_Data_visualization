package com.wa.dao;

import com.wa.pojo.Country;

public interface CountryMapper {
    int insert(Country record);

    int insertSelective(Country record);
}