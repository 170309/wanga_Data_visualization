package com.wa.dao;

import com.wa.pojo.Worm;

public interface WormMapper {
    int insert(Worm record);

    int insertSelective(Worm record);
}