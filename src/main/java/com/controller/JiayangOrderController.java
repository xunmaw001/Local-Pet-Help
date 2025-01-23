
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
 * 家养宠物领养
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jiayangOrder")
public class JiayangOrderController {
    private static final Logger logger = LoggerFactory.getLogger(JiayangOrderController.class);

    private static final String TABLE_NAME = "jiayangOrder";

    @Autowired
    private JiayangOrderService jiayangOrderService;


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
        CommonUtil.checkMap(params);
        PageUtils page = jiayangOrderService.queryPage(params);

        //字典表数据转换
        List<JiayangOrderView> list =(List<JiayangOrderView>)page.getList();
        for(JiayangOrderView c:list){
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
        JiayangOrderEntity jiayangOrder = jiayangOrderService.selectById(id);
        if(jiayangOrder !=null){
            //entity转view
            JiayangOrderView view = new JiayangOrderView();
            BeanUtils.copyProperties( jiayangOrder , view );//把实体数据重构到view中
            //级联表 家养宠物
            //级联表
            JiayangEntity jiayang = jiayangService.selectById(jiayangOrder.getJiayangId());
            if(jiayang != null){
            BeanUtils.copyProperties( jiayang , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setJiayangId(jiayang.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(jiayangOrder.getYonghuId());
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
    public R save(@RequestBody JiayangOrderEntity jiayangOrder, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jiayangOrder:{}",this.getClass().getName(),jiayangOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            jiayangOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        jiayangOrder.setCreateTime(new Date());
        jiayangOrder.setInsertTime(new Date());
        jiayangOrderService.insert(jiayangOrder);

        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JiayangOrderEntity jiayangOrder, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,jiayangOrder:{}",this.getClass().getName(),jiayangOrder.toString());
        JiayangOrderEntity oldJiayangOrderEntity = jiayangOrderService.selectById(jiayangOrder.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            jiayangOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            jiayangOrderService.updateById(jiayangOrder);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<JiayangOrderEntity> oldJiayangOrderList =jiayangOrderService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        jiayangOrderService.deleteBatchIds(Arrays.asList(ids));

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
            List<JiayangOrderEntity> jiayangOrderList = new ArrayList<>();//上传的东西
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
                            JiayangOrderEntity jiayangOrderEntity = new JiayangOrderEntity();
//                            jiayangOrderEntity.setJiayangOrderUuidNumber(data.get(0));                    //订单编号 要改的
//                            jiayangOrderEntity.setJiayangId(Integer.valueOf(data.get(0)));   //家养宠物 要改的
//                            jiayangOrderEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            jiayangOrderEntity.setJiayangOrderTypes(Integer.valueOf(data.get(0)));   //领养类型 要改的
//                            jiayangOrderEntity.setInsertTime(date);//时间
//                            jiayangOrderEntity.setCreateTime(date);//时间
                            jiayangOrderList.add(jiayangOrderEntity);


                            //把要查询是否重复的字段放入map中
                                //订单编号
                                if(seachFields.containsKey("jiayangOrderUuidNumber")){
                                    List<String> jiayangOrderUuidNumber = seachFields.get("jiayangOrderUuidNumber");
                                    jiayangOrderUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> jiayangOrderUuidNumber = new ArrayList<>();
                                    jiayangOrderUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("jiayangOrderUuidNumber",jiayangOrderUuidNumber);
                                }
                        }

                        //查询是否重复
                         //订单编号
                        List<JiayangOrderEntity> jiayangOrderEntities_jiayangOrderUuidNumber = jiayangOrderService.selectList(new EntityWrapper<JiayangOrderEntity>().in("jiayang_order_uuid_number", seachFields.get("jiayangOrderUuidNumber")));
                        if(jiayangOrderEntities_jiayangOrderUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(JiayangOrderEntity s:jiayangOrderEntities_jiayangOrderUuidNumber){
                                repeatFields.add(s.getJiayangOrderUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [订单编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        jiayangOrderService.insertBatch(jiayangOrderList);
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
        PageUtils page = jiayangOrderService.queryPage(params);

        //字典表数据转换
        List<JiayangOrderView> list =(List<JiayangOrderView>)page.getList();
        for(JiayangOrderView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JiayangOrderEntity jiayangOrder = jiayangOrderService.selectById(id);
            if(jiayangOrder !=null){


                //entity转view
                JiayangOrderView view = new JiayangOrderView();
                BeanUtils.copyProperties( jiayangOrder , view );//把实体数据重构到view中

                //级联表
                    JiayangEntity jiayang = jiayangService.selectById(jiayangOrder.getJiayangId());
                if(jiayang != null){
                    BeanUtils.copyProperties( jiayang , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setJiayangId(jiayang.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(jiayangOrder.getYonghuId());
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
    public R add(@RequestBody JiayangOrderEntity jiayangOrder, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,jiayangOrder:{}",this.getClass().getName(),jiayangOrder.toString());
            JiayangEntity jiayangEntity = jiayangService.selectById(jiayangOrder.getJiayangId());
            if(jiayangEntity == null){
                return R.error(511,"查不到该家养宠物");
            }
            // Double jiayangNewMoney = jiayangEntity.getJiayangNewMoney();

            if(false){
            }

            //计算所获得积分
            Double buyJifen =0.0;
            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            jiayangOrder.setJiayangOrderTypes(101); //设置订单状态为已申请代养
            jiayangOrder.setYonghuId(userId); //设置订单支付人id
            jiayangOrder.setJiayangOrderUuidNumber(String.valueOf(new Date().getTime()));
            jiayangOrder.setInsertTime(new Date());
            jiayangOrder.setCreateTime(new Date());
                jiayangOrderService.insert(jiayangOrder);//新增订单

//            YonghuEntity yonghuEntity = yonghuService.selectById(jiayangEntity.getYonghuId());
//            yonghuEntity.setNewMoney(yonghuEntity.getNewMoney()+jiayangOrder.getJiayangOrderTruePrice());//动态计算金额
            yonghuService.updateById(yonghuEntity);

            return R.ok();
    }


    /**
    * 取消申请
    */
    @RequestMapping("/refund")
    public R refund(Integer id, HttpServletRequest request){
        logger.debug("refund方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        String role = String.valueOf(request.getSession().getAttribute("role"));

            JiayangOrderEntity jiayangOrder = jiayangOrderService.selectById(id);//当前表service
            Integer jiayangId = jiayangOrder.getJiayangId();
            if(jiayangId == null)
                return R.error(511,"查不到该家养宠物");
            JiayangEntity jiayangEntity = jiayangService.selectById(jiayangId);
            if(jiayangEntity == null)
                return R.error(511,"查不到该家养宠物");

            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            Double zhekou = 1.0;

                //计算金额
//                Double money = jiayangEntity.getJiayangNewMoney() * buyNumber  * zhekou;
                //计算所获得积分
                Double buyJifen = 0.0;





            jiayangOrder.setJiayangOrderTypes(102);//设置订单状态为已取消申请
            jiayangOrderService.updateById(jiayangOrder);//根据id更新
            yonghuService.updateById(yonghuEntity);//更新用户信息
            jiayangService.updateById(jiayangEntity);//更新订单中家养宠物的信息

            return R.ok();
    }

    /**
     * 同意代养
     */
    @RequestMapping("/deliver")
    public R deliver(Integer id  , HttpServletRequest request){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        JiayangOrderEntity  jiayangOrderEntity = jiayangOrderService.selectById(id);
        jiayangOrderEntity.setJiayangOrderTypes(103);//设置订单状态为已同意代养
        jiayangOrderService.updateById( jiayangOrderEntity);

        return R.ok();
    }


    /**
     * 代养
     */
    @RequestMapping("/receiving")
    public R receiving(Integer id , HttpServletRequest request){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        JiayangOrderEntity  jiayangOrderEntity = jiayangOrderService.selectById(id);
        jiayangOrderEntity.setJiayangOrderTypes(104);//设置订单状态为代养
        jiayangOrderService.updateById( jiayangOrderEntity);
        return R.ok();
    }

}
