package com.oracle.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.oracle.dto.Mongo;
public interface MongoDaoInt extends MongoRepository<Mongo, String> {
	public com.oracle.dto.Mongo findByKey(String key);
}
