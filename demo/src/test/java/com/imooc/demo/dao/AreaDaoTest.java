package com.imooc.demo.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.imooc.demo.entity.Area;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING) // 按方法名大小升序执行
public class AreaDaoTest {
    //通过spring容器注入Dao的实现类
    @Autowired
    private AreaDao areaDao;

    @Test
    @Ignore
    public void QueryArea() {
        List<Area> areaList = areaDao.queryArea();
        // 验证预期值和实际值是否相符
        assertEquals(4, areaList.size());
    }

    @Test
    @Ignore
    public void InsertArea() {
        Area area = new Area();
        area.setAreaName("大苑");
        area.setPriority(1);
        int effectedNum = areaDao.insertArea(area);
        assertEquals(1,effectedNum);
    }

    @Test
    @Ignore
    public void QueryAreaById() {
        Area area = areaDao.queryAreaById(1);
        assertEquals("东园",area.getAreaName());
    }

    @Test
    @Ignore
    public void UpdateArea() {
        Area area = new Area();
        area.setAreaName("来苑");
        area.setAreaId(3);
        area.setLastEditTime(new Date());
        int effectedNum = areaDao.updateArea(area);
        assertEquals(1,effectedNum);
    }

    @Test
    public void DeleteArea() {
      int effectNum = areaDao.deleteArea(3);
      assertEquals(1,effectNum);
    }
}
