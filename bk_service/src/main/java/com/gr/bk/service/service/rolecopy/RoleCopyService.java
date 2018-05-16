package com.gr.bk.service.service.rolecopy;


import com.baomidou.mybatisplus.service.IService;
import com.gr.bk.common.domain.RoleCopyDomain;

import java.util.List;

public interface RoleCopyService extends IService<RoleCopyDomain>{

    List<RoleCopyDomain> queryAll();

}
