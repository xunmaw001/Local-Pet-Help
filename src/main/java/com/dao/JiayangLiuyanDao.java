package com.dao;

import com.entity.JiayangLiuyanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JiayangLiuyanView;

/**
 * 家养宠物留言 Dao 接口
 *
 * @author 
 */
public interface JiayangLiuyanDao extends BaseMapper<JiayangLiuyanEntity> {

   List<JiayangLiuyanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
