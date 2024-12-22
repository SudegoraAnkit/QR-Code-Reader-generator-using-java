package com.openx.qrcode.generator.service;

import com.openx.qrcode.generator.model.History;
import com.openx.qrcode.generator.repo.HistoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class QrService {
    @Autowired
    private HistoryRepo historyRepo;
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private GenerateQrCode qrCodeGenerator;

    public void saveHistory(String type, String data){
        History history=new History();
        history.setType(type);
        history.setData(data);
        history.setTimestamp(LocalDateTime.now().toString());
        historyRepo.save(history);

    }

    public void generateQrCode(String type, String data, String filepath){
        qrCodeGenerator.generateQrCode(data,filepath);
        saveHistory(type,data);
    }

    public Iterable<History> getHistory(){
        return historyRepo.findAll();
    }
}
