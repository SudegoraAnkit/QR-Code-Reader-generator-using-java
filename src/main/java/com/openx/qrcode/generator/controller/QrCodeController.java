package com.openx.qrcode.generator.controller;

import com.openx.qrcode.generator.service.QrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QrCodeController {
    @Autowired
    private QrService qrService;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @PostMapping("/generate")
    public String generateQrCode(@RequestParam("type") String type, @RequestParam("data") String data,
                                 @RequestParam("filename") String filename, Model model){
        try{
            String filePath="Qr_Code/"+filename+".png";
            qrService.generateQrCode(type, data, filePath);
            model.addAttribute("Message","QR Code generated successfully: "+filePath);

        }catch(Exception e){
            model.addAttribute("Message","Error generating QR Code: "+e.getMessage());
        }
        return "index";

    }

    @GetMapping("/history")
    public String history(Model model) {
        model.addAttribute("historyList", qrService.getHistory());
        return "history";
    }
}
