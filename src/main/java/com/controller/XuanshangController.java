
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 寻找宠物
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/xuanshang")
public class XuanshangController {
    private static final Logger logger = LoggerFactory.getLogger(XuanshangController.class);

    private static final String TABLE_NAME = "xuanshang";

    @Autowired
    private XuanshangService xuanshangService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private BaikeService baikeService;//宠物百科
    @Autowired
    private ChongwuService chongwuService;//宠物
    @Autowired
    private ChongwuCollectionService chongwuCollectionService;//宠物收藏
    @Autowired
    private ChongwuLiuyanService chongwuLiuyanService;//宠物留言
    @Autowired
    private ChongwuOrderService chongwuOrderService;//宠物领养
    @Autowired
    private DakaService dakaService;//每日打卡
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private ForumService forumService;//论坛
    @Autowired
    private HeimingdanService heimingdanService;//黑名单
    @Autowired
    private JiayangService jiayangService;//家养宠物
    @Autowired
    private JiayangLiuyanService jiayangLiuyanService;//家养宠物留言
    @Autowired
    private JiayangOrderService jiayangOrderService;//家养宠物领养
    @Autowired
    private NewsService newsService;//新闻信息
    @Autowired
    private XuanshangLiuyanService xuanshangLiuyanService;//寻找宠物留言
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        params.put("xuanshangDeleteStart",1);params.put("xuanshangDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = xuanshangService.queryPage(params);

        //字典表数据转换
        List<XuanshangView> list =(List<XuanshangView>)page.getList();
        for(XuanshangView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        XuanshangEntity xuanshang = xuanshangService.selectById(id);
        if(xuanshang !=null){
            //entity转view
            XuanshangView view = new XuanshangView();
            BeanUtils.copyProperties( xuanshang , view );//把实体数据重构到view中
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(xuanshang.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody XuanshangEntity xuanshang, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,xuanshang:{}",this.getClass().getName(),xuanshang.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            xuanshang.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<XuanshangEntity> queryWrapper = new EntityWrapper<XuanshangEntity>()
            .eq("yonghu_id", xuanshang.getYonghuId())
            .eq("xuanshang_name", xuanshang.getXuanshangName())
            .eq("xuanshang_address", xuanshang.getXuanshangAddress())
            .eq("xuanshang_types", xuanshang.getXuanshangTypes())
            .eq("xuanshang_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XuanshangEntity xuanshangEntity = xuanshangService.selectOne(queryWrapper);
        if(xuanshangEntity==null){
            xuanshang.setXuanshangDelete(1);
            xuanshang.setInsertTime(new Date());
            xuanshang.setCreateTime(new Date());
            xuanshangService.insert(xuanshang);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XuanshangEntity xuanshang, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,xuanshang:{}",this.getClass().getName(),xuanshang.toString());
        XuanshangEntity oldXuanshangEntity = xuanshangService.selectById(xuanshang.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            xuanshang.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(xuanshang.getXuanshangPhoto()) || "null".equals(xuanshang.getXuanshangPhoto())){
                xuanshang.setXuanshangPhoto(null);
        }

            xuanshangService.updateById(xuanshang);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<XuanshangEntity> oldXuanshangList =xuanshangService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<XuanshangEntity> list = new ArrayList<>();
        for(Integer id:ids){
            XuanshangEntity xuanshangEntity = new XuanshangEntity();
            xuanshangEntity.setId(id);
            xuanshangEntity.setXuanshangDelete(2);
            list.add(xuanshangEntity);
        }
        if(list != null && list.size() >0){
            xuanshangService.updateBatchById(list);
        }

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<XuanshangEntity> xuanshangList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("../../upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            XuanshangEntity xuanshangEntity = new XuanshangEntity();
//                            xuanshangEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            xuanshangEntity.setXuanshangName(data.get(0));                    //寻找宠物名称 要改的
//                            xuanshangEntity.setXuanshangUuidNumber(data.get(0));                    //寻找宠物编号 要改的
//                            xuanshangEntity.setXuanshangPhoto("");//详情和图片
//                            xuanshangEntity.setXuanshangJine(data.get(0));                    //悬赏金额 要改的
//                            xuanshangEntity.setXuanshangAddress(data.get(0));                    //寻找宠物地点 要改的
//                            xuanshangEntity.setXuanshangTypes(Integer.valueOf(data.get(0)));   //寻找宠物类型 要改的
//                            xuanshangEntity.setXuanshangContent("");//详情和图片
//                            xuanshangEntity.setXuanshangDelete(1);//逻辑删除字段
//                            xuanshangEntity.setInsertTime(date);//时间
//                            xuanshangEntity.setCreateTime(date);//时间
                            xuanshangList.add(xuanshangEntity);


                            //把要查询是否重复的字段放入map中
                                //寻找宠物编号
                                if(seachFields.containsKey("xuanshangUuidNumber")){
                                    List<String> xuanshangUuidNumber = seachFields.get("xuanshangUuidNumber");
                                    xuanshangUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> xuanshangUuidNumber = new ArrayList<>();
                                    xuanshangUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("xuanshangUuidNumber",xuanshangUuidNumber);
                                }
                        }

                        //查询是否重复
                         //寻找宠物编号
                        List<XuanshangEntity> xuanshangEntities_xuanshangUuidNumber = xuanshangService.selectList(new EntityWrapper<XuanshangEntity>().in("xuanshang_uuid_number", seachFields.get("xuanshangUuidNumber")).eq("xuanshang_delete", 1));
                        if(xuanshangEntities_xuanshangUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(XuanshangEntity s:xuanshangEntities_xuanshangUuidNumber){
                                repeatFields.add(s.getXuanshangUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [寻找宠物编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        xuanshangService.insertBatch(xuanshangList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = xuanshangService.queryPage(params);

        //字典表数据转换
        List<XuanshangView> list =(List<XuanshangView>)page.getList();
        for(XuanshangView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        XuanshangEntity xuanshang = xuanshangService.selectById(id);
            if(xuanshang !=null){


                //entity转view
                XuanshangView view = new XuanshangView();
                BeanUtils.copyProperties( xuanshang , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(xuanshang.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody XuanshangEntity xuanshang, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,xuanshang:{}",this.getClass().getName(),xuanshang.toString());
        Wrapper<XuanshangEntity> queryWrapper = new EntityWrapper<XuanshangEntity>()
            .eq("yonghu_id", xuanshang.getYonghuId())
            .eq("xuanshang_name", xuanshang.getXuanshangName())
            .eq("xuanshang_uuid_number", xuanshang.getXuanshangUuidNumber())
            .eq("xuanshang_address", xuanshang.getXuanshangAddress())
            .eq("xuanshang_types", xuanshang.getXuanshangTypes())
            .eq("xuanshang_delete", xuanshang.getXuanshangDelete())
//            .notIn("xuanshang_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XuanshangEntity xuanshangEntity = xuanshangService.selectOne(queryWrapper);
        if(xuanshangEntity==null){
            xuanshang.setXuanshangDelete(1);
            xuanshang.setInsertTime(new Date());
            xuanshang.setCreateTime(new Date());
        xuanshangService.insert(xuanshang);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

