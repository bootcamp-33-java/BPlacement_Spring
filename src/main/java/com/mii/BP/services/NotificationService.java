/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.BP.services;

import com.mii.BP.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 *
 * @author aqira
 */
@Service
public class NotificationService {

    private JavaMailSender javaMailSender;

    @Autowired
    public NotificationService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendNotification(User user) throws MailException {
        //send email
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(user.getEmailAddress());

        //pengirimnya
        mail.setFrom("dummy.aqira@gmail.com");

        //subject emailnya
        mail.setSubject("Interview Adira " + user.getName() + " di " + user.getDivisi());

        //isi emailnya
        mail.setText("Dear " + user.getName() + "," + "\n"
                + "\n"
                + "Diadakan Interview Pada : \n"
                + "\n"
                + "Alamat : "+ user.getAlamat() + "\n"
                + "Divisi : "+ user.getDivisi() + "\n"
                + "Team : "+ user.getTeam() + "\n"
                + "\n"
                + "Bertemu dengan : "+ user.getInterviewer() + "\n"
                + "\n"
                + "Pada Waktu : "+ user.getTanggal() + "\n"
                + "Dimohon kerjasamanya untuk hadir pada tepat waktu. \n"
                + "\n"
                + "Terima Kasih.\n"
                + "\n"
                + "Team Bootcamp Placement Mitra Informatika Integrasi"
        );
        javaMailSender.send(mail);
    }
}
