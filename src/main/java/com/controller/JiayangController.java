
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
 * 家养宠物
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jiayang")
public class JiayangController {
    private static final Logger logger = LoggerFactory.getLogger(JiayangController.class);

    private static final String TABLE_NAME = "jiayang";

    @Autowired
    private JiayangService jiayangService;


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
        params.put("jiayangDeleteStart",1);params.put("jiayangDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = jiayangService.queryPage(params);

        //字典表数据转换
        List<JiayangView> list =(List<JiayangView>)page.getList();
        for(JiayangView c:list){
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
        JiayangEntity jiayang = jiayangService.selectById(id);
        if(jiayang !=null){
            //entity转view
            JiayangView view = new JiayangView();
            BeanUtils.copyProperties( jiayang , view );//把实体数据重构到view中
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(jiayang.getYonghuId());
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
    public R save(@RequestBody JiayangEntity jiayang, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jiayang:{}",this.getClass().getName(),jiayang.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            jiayang.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<JiayangEntity> queryWrapper = new EntityWrapper<JiayangEntity>()
            .eq("yonghu_id", jiayang.getYonghuId())
            .eq("jiayang_name", jiayang.getJiayangName())
            .eq("jiayang_zhuren", jiayang.getJiayangZhuren())
            .eq("jiayang_phone", jiayang.getJiayangPhone())
            .eq("jiayang_address", jiayang.getJiayangAddress())
            .eq("jiayang_types", jiayang.getJiayangTypes())
            .eq("jiayang_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiayangEntity jiayangEntity = jiayangService.selectOne(queryWrapper);
        if(jiayangEntity==null){
            jiayang.setJiayangDelete(1);
            jiayang.setInsertTime(new Date());
            jiayang.setCreateTime(new Date());
            jiayangService.insert(jiayang);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JiayangEntity jiayang, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,jiayang:{}",this.getClass().getName(),jiayang.toString());
        JiayangEntity oldJiayangEntity = jiayangService.selectById(jiayang.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            jiayang.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(jiayang.getJiayangPhoto()) || "null".equals(jiayang.getJiayangPhoto())){
                jiayang.setJiayangPhoto(null);
        }

            jiayangService.updateById(jiayang);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<JiayangEntity> oldJiayangList =jiayangService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<JiayangEntity> list = new ArrayList<>();
        for(Integer id:ids){
            JiayangEntity jiayangEntity = new JiayangEntity();
            jiayangEntity.setId(id);
            jiayangEntity.setJiayangDelete(2);
            list.add(jiayangEntity);
        }
        if(list != null && list.size() >0){
            jiayangService.updateBatchById(list);
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
            List<JiayangEntity> jiayangList = new ArrayList<>();//上传的东西
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
                            JiayangEntity jiayangEntity = new JiayangEntity();
//                            jiayangEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            jiayangEntity.setJiayangName(data.get(0));                    //家养宠物名称 要改的
//                            jiayangEntity.setJiayangUuidNumber(data.get(0));                    //家养宠物编号 要改的
//                            jiayangEntity.setJiayangPhoto("");//详情和图片
//                            jiayangEntity.setJiayangZhuren(data.get(0));                    //家养宠物主人 要改的
//                            jiayangEntity.setJiayangPhone(data.get(0));                    //宠物主人联系方式 要改的
//                            jiayangEntity.setJiayangAddress(data.get(0));                    //家养宠物地点 要改的
//                            jiayangEntity.setJiayangTypes(Integer.valueOf(data.get(0)));   //家养宠物类型 要改的
//                            jiayangEntity.setJiayangContent("");//详情和图片
//                            jiayangEntity.setJiayangDelete(1);//逻辑删除字段
//                            jiayangEntity.setInsertTime(date);//时间
//                            jiayangEntity.setCreateTime(date);//时间
                            jiayangList.add(jiayangEntity);


                            //把要查询是否重复的字段放入map中
                                //家养宠物编号
                                if(seachFields.containsKey("jiayangUuidNumber")){
                                    List<String> jiayangUuidNumber = seachFields.get("jiayangUuidNumber");
                                    jiayangUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> jiayangUuidNumber = new ArrayList<>();
                                    jiayangUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("jiayangUuidNumber",jiayangUuidNumber);
                                }
                                //宠物主人联系方式
                                if(seachFields.containsKey("jiayangPhone")){
                                    List<String> jiayangPhone = seachFields.get("jiayangPhone");
                                    jiayangPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> jiayangPhone = new ArrayList<>();
                                    jiayangPhone.add(data.get(0));//要改的
                                    seachFields.put("jiayangPhone",jiayangPhone);
                                }
                        }

                        //查询是否重复
                         //家养宠物编号
                        List<JiayangEntity> jiayangEntities_jiayangUuidNumber = jiayangService.selectList(new EntityWrapper<JiayangEntity>().in("jiayang_uuid_number", seachFields.get("jiayangUuidNumber")).eq("jiayang_delete", 1));
                        if(jiayangEntities_jiayangUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(JiayangEntity s:jiayangEntities_jiayangUuidNumber){
                                repeatFields.add(s.getJiayangUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [家养宠物编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //宠物主人联系方式
                        List<JiayangEntity> jiayangEntities_jiayangPhone = jiayangService.selectList(new EntityWrapper<JiayangEntity>().in("jiayang_phone", seachFields.get("jiayangPhone")).eq("jiayang_delete", 1));
                        if(jiayangEntities_jiayangPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(JiayangEntity s:jiayangEntities_jiayangPhone){
                                repeatFields.add(s.getJiayangPhone());
                            }
                            return R.error(511,"数据库的该表中的 [宠物主人联系方式] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        jiayangService.insertBatch(jiayangList);
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
    * 个性推荐
    */
    @IgnoreAuth
    @RequestMapping("/gexingtuijian")
    public R gexingtuijian(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("gexingtuijian方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CommonUtil.checkMap(params);
        List<JiayangView> returnJiayangViewList = new ArrayList<>();

        //查询订单
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        PageUtils pageUtils = jiayangOrderService.queryPage(params1);
        List<JiayangOrderView> orderViewsList =(List<JiayangOrderView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(JiayangOrderView orderView:orderViewsList){
            Integer jiayangTypes = orderView.getJiayangTypes();
            if(typeMap.containsKey(jiayangTypes)){
                typeMap.put(jiayangTypes,typeMap.get(jiayangTypes)+1);
            }else{
                typeMap.put(jiayangTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("jiayangTypes",type);
            PageUtils pageUtils1 = jiayangService.queryPage(params2);
            List<JiayangView> jiayangViewList =(List<JiayangView>)pageUtils1.getList();
            returnJiayangViewList.addAll(jiayangViewList);
            if(returnJiayangViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = jiayangService.queryPage(params);
        if(returnJiayangViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnJiayangViewList.size();//要添加的数量
            List<JiayangView> jiayangViewList =(List<JiayangView>)page.getList();
            for(JiayangView jiayangView:jiayangViewList){
                Boolean addFlag = true;
                for(JiayangView returnJiayangView:returnJiayangViewList){
                    if(returnJiayangView.getId().intValue() ==jiayangView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnJiayangViewList.add(jiayangView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnJiayangViewList = returnJiayangViewList.subList(0, limit);
        }

        for(JiayangView c:returnJiayangViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnJiayangViewList);
        return R.ok().put("data", page);
    }

    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = jiayangService.queryPage(params);

        //字典表数据转换
        List<JiayangView> list =(List<JiayangView>)page.getList();
        for(JiayangView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JiayangEntity jiayang = jiayangService.selectById(id);
            if(jiayang !=null){


                //entity转view
                JiayangView view = new JiayangView();
                BeanUtils.copyProperties( jiayang , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(jiayang.getYonghuId());
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
    public R add(@RequestBody JiayangEntity jiayang, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,jiayang:{}",this.getClass().getName(),jiayang.toString());
        Wrapper<JiayangEntity> queryWrapper = new EntityWrapper<JiayangEntity>()
            .eq("yonghu_id", jiayang.getYonghuId())
            .eq("jiayang_name", jiayang.getJiayangName())
            .eq("jiayang_uuid_number", jiayang.getJiayangUuidNumber())
            .eq("jiayang_zhuren", jiayang.getJiayangZhuren())
            .eq("jiayang_phone", jiayang.getJiayangPhone())
            .eq("jiayang_address", jiayang.getJiayangAddress())
            .eq("jiayang_types", jiayang.getJiayangTypes())
            .eq("jiayang_delete", jiayang.getJiayangDelete())
//            .notIn("jiayang_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiayangEntity jiayangEntity = jiayangService.selectOne(queryWrapper);
        if(jiayangEntity==null){
            jiayang.setJiayangDelete(1);
            jiayang.setInsertTime(new Date());
            jiayang.setCreateTime(new Date());
        jiayangService.insert(jiayang);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

