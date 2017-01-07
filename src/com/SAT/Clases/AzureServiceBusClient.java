/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SAT.Clases;

import com.microsoft.windowsazure.Configuration;
import com.microsoft.windowsazure.exception.ServiceException;
import com.microsoft.windowsazure.services.servicebus.ServiceBusConfiguration;
import com.microsoft.windowsazure.services.servicebus.ServiceBusContract;
import com.microsoft.windowsazure.services.servicebus.ServiceBusService;
import com.microsoft.windowsazure.services.servicebus.models.BrokeredMessage;
import com.microsoft.windowsazure.services.servicebus.models.ReceiveMessageOptions;
import com.microsoft.windowsazure.services.servicebus.models.ReceiveMode;
import com.microsoft.windowsazure.services.servicebus.models.ReceiveSubscriptionMessageResult;
import com.microsoft.windowsazure.services.servicebus.models.RuleInfo;
import com.microsoft.windowsazure.services.servicebus.models.SubscriptionInfo;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TimerTask;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tonovarela <tonovarela@live.com>
 */
public class AzureServiceBusClient extends TimerTask {

    private final String _domain = ".servicebus.windows.net";
    private ServiceBusContract _service;
    private String _nombreSuscriptor;
    private String _nameSpace;
    private String _labelAccessKey;
    private String _key;
    private String _topico;
    private Queue<String> _colaMensajes;

    public void Conectarse(String Namespace, String LabelAccessKey, String Key, String Topico, String NombreSuscriptor) {
        this._nameSpace = Namespace;
        this._labelAccessKey = LabelAccessKey;
        this._key = Key;
        this._topico = Topico;
        this._nombreSuscriptor = NombreSuscriptor;
        this._colaMensajes = new LinkedList<>();
        Configuration config = ServiceBusConfiguration.configureWithSASAuthentication(this._nameSpace, this._labelAccessKey, this._key, this._domain);
        _service = ServiceBusService.create(config);
        if (this.ExisteSuscripcion()) {
            this.BorrarSuscripcion();
        }
        this.CrearSuscripcion();

    }

    private boolean ExisteSuscripcion() {
        boolean result;
        try {
            _service.getSubscription(_topico, _nombreSuscriptor);
            result = true;

        } catch (ServiceException ex) {
            if (ex.getHttpStatusCode() == 0) {
                System.out.println("No hay red");
            }
            if (ex.getHttpStatusCode() == 404) {
                System.out.println("No esta inscrito");
            }
            result = false;
        }

        return result;
    }

    private void CrearSuscripcion() {
        String regla = "nombreEquipo='" + _nombreSuscriptor + "' or paraTodos=1";
        RuleInfo ruleInfo = new RuleInfo("Filtro");
        ruleInfo = ruleInfo.withSqlExpressionFilter(regla);
        try {
            _service.createSubscription(_topico, new SubscriptionInfo(_nombreSuscriptor));
            _service.createRule(this._topico, _nombreSuscriptor, ruleInfo);
            _service.deleteRule(this._topico, _nombreSuscriptor, "$Default");
            System.out.println("Suscrito...");

        } catch (ServiceException ex) {
            if (ex.getHttpStatusCode() == 0) {
                System.out.println("No hay red");
            }
        }
    }

    public void BorrarSuscripcion() {
        try {
            _service.deleteSubscription(_topico, _nombreSuscriptor);
        } catch (ServiceException ex) {
            if (ex.getHttpStatusCode() == 0) {
                System.out.println("No hay red");
            }
        }
    }

    public String getUltimoMensaje() {
        return _colaMensajes.poll();
    }

    public boolean hayMensajes() {
        return _colaMensajes.isEmpty();
    }

    public void run() {
        try {
            ReceiveMessageOptions opts = ReceiveMessageOptions.DEFAULT;
            opts.setReceiveMode(ReceiveMode.RECEIVE_AND_DELETE);
            ReceiveSubscriptionMessageResult resultSubMsg
                    = _service.receiveSubscriptionMessage(this._topico, _nombreSuscriptor, opts);
            BrokeredMessage message = resultSubMsg.getValue();
            if (message != null && message.getMessageId() != null) {

                byte[] b = new byte[255];
                String s = null;
                String cadena = null;
                int numRead = message.getBody().read(b);
                while (-1 != numRead) {
                    s = new String(b);
                    s = s.trim();

                    cadena = cadena + s;
                    numRead = message.getBody().read(b);
                }
                int index = cadena.indexOf("[");
                int indexfinal = cadena.lastIndexOf("]");
                // result= "[" + message.getDate().toString() + "]  Suscriptor [" + this._nombreSuscriptor + "] Mensaje  " + cadena.substring(index + 1, indexfinal);
                this._colaMensajes.add("[" + message.getDate().toString() + "]  Suscriptor [" + this._nombreSuscriptor + "] Mensaje  " + cadena.substring(index + 1, indexfinal));
            }

        } catch (ServiceException e) {
            if (e.getHttpStatusCode() == 0) {
                System.out.println("No hay red");
            }
        } catch (IOException ex) {
            Logger.getLogger(AzureServiceBusClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
