package br.com.b3.sinacor.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import br.com.b3.sinacor.commons.SetupEnviroment;

public class Utils {
	
	private static SetupEnviroment setup = new SetupEnviroment();
    
    public static String formatarNomeLog(String strLog) {
    	
    	LocalDateTime dataHoraAgora = LocalDateTime.now();
    	DateTimeFormatter formatoDataHora = DateTimeFormatter.ofPattern("dd_MM_yy_HH_mm_ss");
    	String strLogFormatado = strLog.replace(" ", "_") + "_" + dataHoraAgora.format(formatoDataHora);
    	return strLogFormatado;
    }
    
    public static void wait(int segundos) {
    
    	try {
    		synchronized(setup.getDriver()) {
    			setup.getDriver().wait(segundos * 1000);
    		}
    	}catch (InterruptedException e) {
    		e.printStackTrace();
    	}
    }
    
    public static String convertNumeroToNome(String numero) {
    	
    	String nome = null;
    	
    	switch(numero) {
    		case "0":
    			nome = "Zero";
    			break;
	    	case "1":
	    		nome = "Um";
	    		break;
	    	case "2":
	    		nome = "Dois";
	    		break;	
	    	case "3":
	    		nome = "Três";
	    		break;
	    	case "4":
	    		nome = "Quatro";
	    		break;
	    	case "5":
	    		nome = "Cinco";
	    		break;
	    	case "6":
	    		nome = "Seis";
	    		break;
	    	case "7":
	    		nome = "Sete";
	    		break;
	    	case "8":
	    		nome = "Oito";
	    		break;
	    	case "9":
	    		nome = "Nove";
	    		break;
    	}
    	
    	return nome;
    }
}
