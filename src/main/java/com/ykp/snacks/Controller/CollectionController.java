package com.ykp.snacks.Controller;


import com.ykp.snacks.Service.Impl.CollectionServiceImpl;
import com.ykp.snacks.domain.collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path="/CollectionController")
public class CollectionController {

    @Autowired
    private CollectionServiceImpl collectionService;

    @ResponseBody
    @PostMapping(path="/getByOpenid")
    public List<collection> getByOpenid(String openid) {
        return collectionService.getByOpenid(openid);
    }

    @ResponseBody
    @PostMapping(path="/addCollection")
    public void addCollection(collection collection) {
        collectionService.addCollection(collection);
    }

    @ResponseBody
    @PostMapping(path="/deleteOneCollection")
    public void deleteOneCollection(String openid,String goodsName){
        collectionService.deleteOneCollection(openid,goodsName );
    }
}
