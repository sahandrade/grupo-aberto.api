
package com.heroku.java.repository;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;

import com.heroku.java.model.Aluno;

public class ContaRepository<Conta> {
    // private final Class<Conta> entityType;
    // private final String collectionName;
    // private final MongoDbConfig mb = new MongoDbConfig();
    // private final MongoTemplate mongoTemplate = new MongoTemplate(mb.mongoClient(), "Biblioteca");


    // @Override
    // public List<T> getAll() {
    //     System.out.println(collectionName);
    //     return mongoTemplate.findAll(entityType, collectionName);
    // }

    // @Override
    // public T getById(String id) {
    //     Query query = new Query();
    //     query.addCriteria(Criteria.where("id").is(id));
    //     return mongoTemplate.findOne(query, entityType, collectionName);
    // }

    // @Override
    // public T getByKey(String key, String value) {
    //     Query query = new Query();
    //     query.addCriteria(Criteria.where(key).is(value));
    //     return mongoTemplate.findOne(query, entityType, collectionName);
    // }

    // @Override
    // public T addNew(T entity) {
    //     mongoTemplate.save(entity, collectionName);
    //     return entity;
    // }

    // @Override
    // public void update(String id, T entity) {
    //     Query query = new Query();
    //     query.addCriteria(Criteria.where("id").is(id));
    //     mongoTemplate.findAndReplace(query, entity, collectionName);
    // }

    // @Override
    // public void delete(String id) {
    //     Query query = new Query();
    //     query.addCriteria(Criteria.where("id").is(id));
    //     mongoTemplate.remove(query, entityType, collectionName);
    // }
    
 
    // @Override
    // public Object getAllUserSettings(String key, String value) {
    //     Query query = new Query();
    //     query.addCriteria(Criteria.where(key).is(value));
    //     T entity = mongoTemplate.findOne(query, entityType, collectionName);
    //     if (entity != null) {
    //         try {
    //             Field userSettingsField = entity.getClass().getDeclaredField("userSettings");
    //             userSettingsField.setAccessible(true);
    //             return userSettingsField.get(entity);
    //         } catch (NoSuchFieldException | IllegalAccessException e) {
    //             e.printStackTrace();
    //         }
    //     }
    //     return "User not found.";
    // }

    // @Override
    // public String getUserSetting(String id, String key) {
    //     Query query = new Query();
    //     query.fields().include("userSettings");
    //     query.addCriteria(Criteria.where("id").is(id).andOperator(Criteria.where("userSettings." + key).exists(true)));
    //     T entity = mongoTemplate.findOne(query, entityType, collectionName);
    //     if (entity != null) {
    //         try {
    //             Field userSettingsField = entity.getClass().getDeclaredField("userSettings");
    //             userSettingsField.setAccessible(true);
    //             Object userSettings = userSettingsField.get(entity);
    //             if (userSettings instanceof java.util.Map) {
    //                 Object value = ((java.util.Map<?, ?>) userSettings).get(key);
    //                 return value != null ? value.toString() : "Not found.";
    //             }
    //         } catch (NoSuchFieldException | IllegalAccessException e) {
    //             e.printStackTrace();
    //         }
    //     }
    //     return "Not found.";
    // }


    // @Override
    // public String addUserSetting(String userId, String key, String value) {
    //     Query query = new Query();
    //     query.addCriteria(Criteria.where("userId").is(userId));
    //     T entity = mongoTemplate.findOne(query, entityType, collectionName);
    //     if (entity != null) {
    //         try {
    //             Field userSettingsField = entity.getClass().getDeclaredField("userSettings");
    //             userSettingsField.setAccessible(true);
    //             Object userSettings = userSettingsField.get(entity);
    //             if (userSettings instanceof java.util.Map) {
    //                 ((java.util.Map<String, String>) userSettings).put(key, value);
    //                 mongoTemplate.save(entity);
    //                 return "Key added.";
    //             }
    //         } catch (NoSuchFieldException | IllegalAccessException e) {
    //             e.printStackTrace();
    //         }
    //     }
    //     return "User not found.";
    // }
}


