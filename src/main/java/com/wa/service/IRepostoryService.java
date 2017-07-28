package com.wa.service;

import com.github.pagehelper.PageInfo;
import com.wa.common.ServerResponse;
import com.wa.vo.MapDataVo;

public interface IRepostoryService {

    ServerResponse<PageInfo> queryData(int pagenum, int pagesize);
    ServerResponse<MapDataVo> query();
}
