package com.jzc.spring.cloud.dao.mongo;

import com.alibaba.fastjson.JSON;
import com.jzc.spring.cloud.entity.GenericEntity;
import com.jzc.spring.cloud.entity.PageList;
import com.mongodb.WriteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class MongodbComponent<T extends GenericEntity> {

    @Autowired
    private MongoTemplate mongoTemplate;

    public long count(Query query, Class<T> t) {
        return mongoTemplate.count(query, t);
    }

    public List<T> findPage(Integer currentPage, Integer pageSize, Query query, Class<T> t) {
        query.skip((currentPage - 1) * pageSize).limit(pageSize);
        return mongoTemplate.find(query, t);
    }

    public T selectById(Class<T> t, Long id) {
        return mongoTemplate.findOne(new Query(Criteria.where("kid").in(id)), t);
    }

    public void insert(T t) {
        mongoTemplate.insert(t);
    }

    public int updateById(T t) {
        if(t == null){
            return 0;
        }
        Update update = new Update();
        String json = JSON.toJSONString(t);
        Map<String, Object> map = JSON.parseObject(json, HashMap.class);
        for(Map.Entry<String, Object> entry : map.entrySet()){
            update.set(entry.getKey(), entry.getValue());
        }
        WriteResult writeResult = mongoTemplate.updateMulti(new Query(Criteria.where("kid").in(t.getKid())), update, t.getClass());
        if(writeResult != null) {
            return writeResult.getN();
        }

        return 0;
    }

    public int update(Query query, Update update, Class<T> t) {
        WriteResult writeResult = mongoTemplate.updateMulti(query, update, t);
        if(writeResult != null) {
            return writeResult.getN();
        }

        return 0;
    }

    public int deleteById(Class<T> t, Long id) {
        WriteResult writeResult = mongoTemplate.remove(new Query(Criteria.where("kid").in(id)), t);
        if(writeResult != null) {
            return writeResult.getN();
        }

        return 0;
    }

//    public List<T> findPage() {}

    public MongoTemplate getMongoTemplate() {
        return mongoTemplate;
    }

}
