/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alodiga.hsm.client.connection;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import com.alodiga.hsm.client.request.ParameterRequest;
import com.alodiga.hsm.client.response.ARPCResponse;
import com.alodiga.hsm.client.response.VerifyPinUsingIBMMethodResponse;
import com.alodiga.hsm.client.utils.GsonDateFormatter;
import com.alodiga.hsm.client.utils.LoadProperties;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author YAlmea
 */
public class HSMClient {
    

    public String consumeRest(String urlRest, String params) {
        String respose = "";
        try {
            
            URL url = new URL(urlRest);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Length", "" + params.length());
            
            conn.connect();
            // send the parameters
            OutputStream os = conn.getOutputStream();
            os.write(params.getBytes("UTF-8"));
            os.close();

            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            String output = null;
            while ((output = br.readLine()) != null) {
                respose = respose.concat(output);
                System.out.println(output);
            }

            conn.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();

        }
        return respose;
    }

    public static Object getResponse(String metod, String params, Class clazz) {
        try {
            HSMClient rest = new HSMClient();
            LoadProperties lp= LoadProperties.getIntance();
            String path = lp.getProperties("prop.path");
            String jsonComplejo = rest.consumeRest(path + metod, params);
            Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new GsonDateFormatter()).create();
            Object response = gson.fromJson(jsonComplejo, clazz);
            return response;
        } catch (Exception ex) {
            Logger.getLogger(HSMClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
        try {
            //Ejmplos de llamada a servicios
            ParameterRequest  request = new ParameterRequest();
            LoadProperties lp= LoadProperties.getIntance();
            String metod = lp.getProperties("prop.validateQRQC");
            String params = request.getARPCRequest("0001", "1", "Mchip", "6281555895200000001", "001", "0034", "29374F74", "66666666", "D1F0F7A573EA20B9");
            ARPCResponse arpcResponse = (ARPCResponse) getResponse(metod, params, ARPCResponse.class);
            System.out.println("ARPC:" + arpcResponse.getResponseCode() + " " + arpcResponse.getResponseMessage()+" "+arpcResponse.getArpc());
            
            metod = lp.getProperties("prop.verifyPINUsingIBMMethod");
            params = request.getVerifyPinUsingIBMMethodRequest("TD180", "ABC1234567BCD98A", "6281555895200000001", "0475");
            VerifyPinUsingIBMMethodResponse response = (VerifyPinUsingIBMMethodResponse) getResponse(metod, params, VerifyPinUsingIBMMethodResponse.class);
            System.out.println("IBM:" + response.getResponseCode() + " " + response.getResponseMessage()+" "+response.getVerificationValue());
        } catch (Exception ex) {
            Logger.getLogger(HSMClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    


}
