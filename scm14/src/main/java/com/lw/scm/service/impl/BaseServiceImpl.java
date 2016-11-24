package com.lw.scm.service.impl;

import com.lw.scm.bean.Page;
import com.lw.scm.dao.AccountMapper;
import com.lw.scm.dao.BaseMapper;
import com.lw.scm.dao.GoodsMapper;
import com.lw.scm.dao.SupplierMapper;
import com.lw.scm.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by lw on 2016/11/20.
 */
public class BaseServiceImpl<T> implements BaseService<T> {

    @Autowired
    protected SupplierMapper supplierMapper;
    @Autowired
    protected AccountMapper accountMapper;

    protected BaseMapper<T> baseMapper;

    @Autowired
    protected GoodsMapper goodsMapper ;

    //这个
    @PostConstruct
    private void initBaseMapper() throws Exception {
        //this关键字指对象本身，这里指的是调用此方法的实现类（子类）
        System.out.println("=======this :" + this);
        System.out.println("=======父类基本信息：" + this.getClass().getSuperclass());
        System.out.println("=======父类泛型的信息：" + this.getClass().getGenericSuperclass());

        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        //获取第一个参数的class
        Class clazz = (Class) type.getActualTypeArguments()[0];//就是T的对应实现
        System.out.println("=======class:" + clazz);//这里获取到了实体Bean的类名
        //转化为属性名（相关的Mapper子类的引用名）Supplier  supplierMapper
        String localField = clazz.getSimpleName().substring(0, 1).toLowerCase() + clazz.getSimpleName().substring(1) + "Mapper";

        System.out.println("=======localField:" + localField);
        //getDeclaredField:可以使用于包括私有、默认、受保护、公共字段，但不包括继承的字段
        Field field = this.getClass().getSuperclass().getDeclaredField(localField);
        System.out.println("=======field:" + field);
        System.out.println("=======field对应的对象:" + field.get(this));
        Field baseField = this.getClass().getSuperclass().getDeclaredField("baseMapper");

        System.out.println("=======baseField:" + baseField);
        System.out.println("=======baseField对应的对象:" + baseField.get(this));
        //field.get(this)获取当前this的field字段的值。例如：Supplier对象中，baseMapper所指向的对象为其子类型SupplierMapper对象，
        // 子类型对象已被spring实例化于容器中
        baseField.set(this, field.get(this));
        System.out.println("========baseField对应的对象:" + baseMapper);
    }

    @Override
    public int insert(T entity) throws Exception {
        return baseMapper.insert(entity);
    }

    @Override
    public int update(T entity) throws Exception {
        return baseMapper.update(entity);
    }

    @Override
    public T selectByPk(T entity) {
        return null;
    }

    @Override
    public int deleteByPk(T entity) throws Exception {
        return 0;
    }

    @Override
    public Integer deleteList(String[] pks) throws Exception {
        return baseMapper.deleteList(pks);
    }

    @Override
    public int updateByKk(T entity) throws Exception {
        return 0;
    }

    @Override
    public List<T> selectUseDyc(T entity) {
        return null;
    }

    @Override
    public Page<T> selectPage(Page<T> page) {
        page.setList(baseMapper.selectPageList(page));
        page.setTotalRecord(baseMapper.selectCount(page));
        return page;
    }

    @Override
    public Page<T> selectPageUseDyc(Page<T> page) {
        page.setList(baseMapper.selectPageListUseDyc(page));
        page.setTotalRecord(baseMapper.selectCount(page));
        return page;
    }
}
