package com.dao;

import com.entity.JiayangOrderEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JiayangOrderView;

/**
 * 家养宠物领养 Dao 接口
 *
 * @author 
 */
public interface JiayangOrderDao extends BaseMapper<JiayangOrderEntity> {

   List<JiayangOrderView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
