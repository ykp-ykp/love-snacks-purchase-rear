package com.ykp.snacks.Service;

import com.ykp.snacks.domain.collection;

import java.util.List;

public interface CollectionService {
    public List<collection> getByOpenid(String openid);
    public void addCollection(collection collection);
    public void deleteOneCollection(String openid,String goodsName);
}
