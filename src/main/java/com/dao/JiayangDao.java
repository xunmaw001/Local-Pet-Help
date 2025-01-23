package com.dao;

import com.entity.JiayangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JiayangView;

/**
 * 家养宠物 Dao 接口
 *
 * @author 
 */
public interface JiayangDao extends BaseMapper<JiayangEntity> {

   List<JiayangView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
