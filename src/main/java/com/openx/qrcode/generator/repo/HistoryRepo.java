package com.openx.qrcode.generator.repo;

import com.openx.qrcode.generator.model.History;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryRepo extends MongoRepository<History, String> {
}
