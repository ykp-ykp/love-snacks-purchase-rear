package com.ykp.snacks.Service.Impl;

import com.ykp.snacks.Dao.CollectionDao;
import com.ykp.snacks.Service.CollectionService;
import com.ykp.snacks.domain.collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectionServiceImpl implements CollectionService {

    @Autowired
    private CollectionDao collectionDao;

    @Override
    public List<collection> getByOpenid(String openid) {
        return collectionDao.getByOpenid(openid);
    }

    @Override
    public void addCollection(collection collection) {
        collectionDao.addCollection(collection);
    }

    @Override
    public void deleteOneCollection(String openid,String goodsName){
        collectionDao.deleteOneCollection(openid,goodsName );
    }
}
