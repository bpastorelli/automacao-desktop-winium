package br.com.b3.sinacor.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import br.com.b3.sinacor.commons.SetupEnviroment;
import br.com.b3.sinacor.reports.LogReport;

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
    
    public static String getSystemVersion() {
    	
        Runtime rt; 
        Process pr; 
        BufferedReader in;
        String line = "";
        String edition = "";
        String fullOSName = "";
        final String   SEARCH_TERM = "OS Name:";
        final String[] EDITIONS = { "Basic", "Home", 
                                    "Professional", "Enterprise" };

        try
        {
           rt = Runtime.getRuntime();
           pr = rt.exec("SYSTEMINFO");
           in = new BufferedReader(new InputStreamReader(pr.getInputStream()));

           //add all the lines into a variable
           while((line=in.readLine()) != null)
           {
              if(line.contains(SEARCH_TERM)) //found the OS you are using
              {
               //extract the full os name
                 fullOSName = line.substring(line.lastIndexOf(SEARCH_TERM) 
                 + SEARCH_TERM.length(), line.length()-1);
                 break;
              } 
           }

           //extract the edition of windows
           for(String s : EDITIONS)
           {
              if(fullOSName.trim().contains(s))
              {
                 edition = s;
              }
           }

        } catch(IOException ioe) {   
             System.err.println(ioe.getMessage());
        }
        
        return edition;
    }
    
    public static URI getFilePath(String file) {
    	
    	URI path = null;
    	
    	try {
			return Thread.currentThread().getContextClassLoader().getResource(file).toURI();
		} catch (URISyntaxException e) {
			LogReport.fail("Falha ao obter o path para o arquivo " + file);
		}
    	return path;
    }
    
}
