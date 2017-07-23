package com.wa.dao;

import com.wa.pojo.Consoled;

public interface ConsoledMapper {
    int insert(Consoled record);

    int insertSelective(Consoled record);
}