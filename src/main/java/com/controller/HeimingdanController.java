
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
 * 黑名单
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/heimingdan")
public class HeimingdanController {
    private static final Logger logger = LoggerFactory.getLogger(HeimingdanController.class);

    private static final String TABLE_NAME = "heimingdan";

    @Autowired
    private HeimingdanService heimingdanService;


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
    private JiayangService jiayangService;//家养宠物
    @Autowired
    private JiayangLiuyanService jiayangLiuyanService;//家养宠物留言
    @Autowired
    private JiayangOrderService jiayangOrderService;//家养宠物领养
    @Autowired
    private NewsService newsService;//新闻信息
    @Autowired
    private XuanshangService xuanshangService;//寻找宠物
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
        params.put("heimingdanDeleteStart",1);params.put("heimingdanDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = heimingdanService.queryPage(params);

        //字典表数据转换
        List<HeimingdanView> list =(List<HeimingdanView>)page.getList();
        for(HeimingdanView c:list){
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
        HeimingdanEntity heimingdan = heimingdanService.selectById(id);
        if(heimingdan !=null){
            //entity转view
            HeimingdanView view = new HeimingdanView();
            BeanUtils.copyProperties( heimingdan , view );//把实体数据重构到view中
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(heimingdan.getYonghuId());
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
    public R save(@RequestBody HeimingdanEntity heimingdan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,heimingdan:{}",this.getClass().getName(),heimingdan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            heimingdan.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<HeimingdanEntity> queryWrapper = new EntityWrapper<HeimingdanEntity>()
            .eq("yonghu_id", heimingdan.getYonghuId())
            .eq("heimingdan_types", heimingdan.getHeimingdanTypes())
            .eq("heimingdan_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HeimingdanEntity heimingdanEntity = heimingdanService.selectOne(queryWrapper);
        if(heimingdanEntity==null){
            heimingdan.setHeimingdanDelete(1);
            heimingdan.setInsertTime(new Date());
            heimingdan.setCreateTime(new Date());
            heimingdanService.insert(heimingdan);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody HeimingdanEntity heimingdan, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,heimingdan:{}",this.getClass().getName(),heimingdan.toString());
        HeimingdanEntity oldHeimingdanEntity = heimingdanService.selectById(heimingdan.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            heimingdan.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            heimingdanService.updateById(heimingdan);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<HeimingdanEntity> oldHeimingdanList =heimingdanService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<HeimingdanEntity> list = new ArrayList<>();
        for(Integer id:ids){
            HeimingdanEntity heimingdanEntity = new HeimingdanEntity();
            heimingdanEntity.setId(id);
            heimingdanEntity.setHeimingdanDelete(2);
            list.add(heimingdanEntity);
        }
        if(list != null && list.size() >0){
            heimingdanService.updateBatchById(list);
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
            List<HeimingdanEntity> heimingdanList = new ArrayList<>();//上传的东西
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
                            HeimingdanEntity heimingdanEntity = new HeimingdanEntity();
//                            heimingdanEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            heimingdanEntity.setHeimingdanUuidNumber(data.get(0));                    //黑名单编号 要改的
//                            heimingdanEntity.setHeimingdanTypes(Integer.valueOf(data.get(0)));   //黑名单类型 要改的
//                            heimingdanEntity.setHeimingdanContent("");//详情和图片
//                            heimingdanEntity.setHeimingdanDelete(1);//逻辑删除字段
//                            heimingdanEntity.setInsertTime(date);//时间
//                            heimingdanEntity.setCreateTime(date);//时间
                            heimingdanList.add(heimingdanEntity);


                            //把要查询是否重复的字段放入map中
                                //黑名单编号
                                if(seachFields.containsKey("heimingdanUuidNumber")){
                                    List<String> heimingdanUuidNumber = seachFields.get("heimingdanUuidNumber");
                                    heimingdanUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> heimingdanUuidNumber = new ArrayList<>();
                                    heimingdanUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("heimingdanUuidNumber",heimingdanUuidNumber);
                                }
                        }

                        //查询是否重复
                         //黑名单编号
                        List<HeimingdanEntity> heimingdanEntities_heimingdanUuidNumber = heimingdanService.selectList(new EntityWrapper<HeimingdanEntity>().in("heimingdan_uuid_number", seachFields.get("heimingdanUuidNumber")).eq("heimingdan_delete", 1));
                        if(heimingdanEntities_heimingdanUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(HeimingdanEntity s:heimingdanEntities_heimingdanUuidNumber){
                                repeatFields.add(s.getHeimingdanUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [黑名单编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        heimingdanService.insertBatch(heimingdanList);
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
        PageUtils page = heimingdanService.queryPage(params);

        //字典表数据转换
        List<HeimingdanView> list =(List<HeimingdanView>)page.getList();
        for(HeimingdanView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        HeimingdanEntity heimingdan = heimingdanService.selectById(id);
            if(heimingdan !=null){


                //entity转view
                HeimingdanView view = new HeimingdanView();
                BeanUtils.copyProperties( heimingdan , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(heimingdan.getYonghuId());
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
    public R add(@RequestBody HeimingdanEntity heimingdan, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,heimingdan:{}",this.getClass().getName(),heimingdan.toString());
        Wrapper<HeimingdanEntity> queryWrapper = new EntityWrapper<HeimingdanEntity>()
            .eq("yonghu_id", heimingdan.getYonghuId())
            .eq("heimingdan_uuid_number", heimingdan.getHeimingdanUuidNumber())
            .eq("heimingdan_types", heimingdan.getHeimingdanTypes())
            .eq("heimingdan_delete", heimingdan.getHeimingdanDelete())
//            .notIn("heimingdan_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HeimingdanEntity heimingdanEntity = heimingdanService.selectOne(queryWrapper);
        if(heimingdanEntity==null){
            heimingdan.setHeimingdanDelete(1);
            heimingdan.setInsertTime(new Date());
            heimingdan.setCreateTime(new Date());
        heimingdanService.insert(heimingdan);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

