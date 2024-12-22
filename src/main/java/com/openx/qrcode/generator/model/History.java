package com.openx.qrcode.generator.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="projectDatabase")
@Getter
@Setter
public class History {

    @Id
    private String id;
    private String type;
    private String data;
    private String timestamp;

}
