package com.service.impl;

import com.utils.StringUtil;
import com.service.DictionaryService;
import com.utils.ClazzDiff;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import com.dao.HeimingdanDao;
import com.entity.HeimingdanEntity;
import com.service.HeimingdanService;
import com.entity.view.HeimingdanView;

/**
 * 黑名单 服务实现类
 */
@Service("heimingdanService")
@Transactional
public class HeimingdanServiceImpl extends ServiceImpl<HeimingdanDao, HeimingdanEntity> implements HeimingdanService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        Page<HeimingdanView> page =new Query<HeimingdanView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
