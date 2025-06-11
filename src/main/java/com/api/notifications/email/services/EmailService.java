package com.api.notifications.email.services;

import dto.NotificationDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {

    public void send(NotificationDTO notificacion) throws ErrorService {
        validate(notificacion);
        sendRegister(notificacion);
        generatesTemplate(notificacion);
    }

    private void validate(NotificationDTO notification) throws ErrorService{
        if(!notification.getRecipient().contains("@")){ //en este caso es simulado porque el destinatario nunca se ingresa
            throw new ErrorService("El destinatario debe ser del formato ejemplo@ejemplo");
        }
        if(notification.getRecipient() == null){ //en este caso es simulado porque el destinatario nunca se ingresa
            throw new ErrorService("El destinatario no puede ser nulo");
        }
    }


    public void generatesTemplate(NotificationDTO notification) {
        System.out.println("Destinatario: " + notification.getRecipient());
        System.out.println("Titutlo: "+ notification.getTitle());
        System.out.println("Cuerpo " + notification.getBody());
        System.out.println("Fecha de envío: "+notification.getSendDate());
    }

    public void sendRegister(NotificationDTO notification) {
        int numeroEnvio = (int) ((Math.random()*1000)+1);
        notification.setNumSend(numeroEnvio);
        notification.setSendDate(LocalDateTime.now());
    }
}
