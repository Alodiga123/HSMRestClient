/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alodiga.hsm.client.utils;

import com.alodiga.hsm.client.connection.HSMClient;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author YAlmea
 */
public class LoadProperties {
    
    Properties properties = new Properties();
    private static LoadProperties instance;

    public static synchronized LoadProperties getIntance() throws Exception{
        if (instance == null) {
          instance = new LoadProperties();
        }
        return instance;
    }
    
    public static void refresh() throws Exception{
        instance = new LoadProperties();
    }
    
    private LoadProperties() throws Exception{
        try {
           InputStream ins = getClass().getResourceAsStream("prop.properties"); 
            properties.load(ins);
        } catch (IOException ex) {
            Logger.getLogger(HSMClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getProperties(String key) throws Exception{
        return properties.getProperty(key);
    }
    
    
}
