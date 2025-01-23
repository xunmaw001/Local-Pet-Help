package com.dao;

import com.entity.HeimingdanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.HeimingdanView;

/**
 * 黑名单 Dao 接口
 *
 * @author 
 */
public interface HeimingdanDao extends BaseMapper<HeimingdanEntity> {

   List<HeimingdanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
