package com.gr.bk.service.service.de.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.gr.bk.common.domain.RcAreaAddr;
import com.gr.bk.common.domain.RcAreaCode;
import com.gr.bk.service.persistence.de.RcAreaAddrMapper;
import com.gr.bk.service.service.de.RcAreaAddrService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 区域地址 服务实现类
 * </p>
 *
 * @author liuwl
 * @since 2018-03-19
 */
@Service
public class RcAreaAddrServiceImpl extends ServiceImpl<RcAreaAddrMapper, RcAreaAddr> implements RcAreaAddrService {

    @Resource
    private RcAreaAddrMapper rcAreaAddrMapper;

    @Override
    public void writeCode() {
        String content = bReader("E:/area.txt");
        List<RcAreaCode> txtAddrs = new ArrayList<>();
        txtAddrs = JSON.parseArray(content, RcAreaCode.class);
        List<RcAreaCode> areas = rcAreaAddrMapper.queryAddr();
        for(RcAreaCode ac:txtAddrs){
            for(RcAreaCode tac:areas){
                if(tac.getAreaAddr().contains(ac.getAreaAddr())){
                    ac.setAreaCode(tac.getAreaCode());
                }
            }
        }
        System.out.println(JSON.toJSON(txtAddrs));
    }

    private  static String bReader(String path) {
        StringBuilder sb = new StringBuilder();
        //创建一个字符读取流流对象，和文件关联
        try {
            FileReader rw = rw = new FileReader(path);
            //只要将需要被提高效率的流作为参数传递给缓冲区的构造函数即可
            BufferedReader brw = new BufferedReader(rw);
            String str;
            do {
                str = brw.readLine();
                if (str == null) break;
                sb.append(str);
            } while (str != null);
            brw.close();//关闭输入流对象
            System.out.println(sb.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
