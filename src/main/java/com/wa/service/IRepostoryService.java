package com.wa.service;

import com.github.pagehelper.PageInfo;
import com.wa.common.ServerResponse;

public interface IRepostoryService {

    ServerResponse<PageInfo> queryData(int pagenum, int pagesize);
}
