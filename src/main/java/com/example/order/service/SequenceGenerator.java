package com.example.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.example.order.entity.Sequence;

@Service
public class SequenceGenerator {
	
	@Autowired
	private MongoOperations mongo;
	
	public int generateNextOrderId() {
		
		 Sequence counter =	mongo.findAndModify( Query.query(Criteria.where("_id").is("sequence")),
                new Update().inc("sequence", 1),
               FindAndModifyOptions.options().returnNew(true).upsert(true),
                Sequence.class);
		
		 return counter.getSequence();
	}
}
