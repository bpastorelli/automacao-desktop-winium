package br.com.b3.sinacor.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import br.com.b3.sinacor.commons.SetupEnviroment;

public class Utils {
    
    public static String formatarNomeLog(String strLog) {
    	
    	LocalDateTime dataHoraAgora = LocalDateTime.now();
    	DateTimeFormatter formatoDataHora = DateTimeFormatter.ofPattern("dd_MM_yy_HH_mm_ss");
    	String strLogFormatado = strLog.replace(" ", "_") + "_" + dataHoraAgora.format(formatoDataHora);
    	return strLogFormatado;
    }
    
    public static void wait(int segundos) {
    
    	try {
    		synchronized(SetupEnviroment.driver) {
    			SetupEnviroment.driver.wait(segundos * 1000);
    		}
    	}catch (InterruptedException e) {
    		e.printStackTrace();
    	}
    }
    
}
