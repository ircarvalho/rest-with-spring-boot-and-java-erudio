package br.com.sitesoft;

//import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.sitesoft.exceptions.UnsupportedMathOperationExcetion;

@RestController
public class MathController {
	
//	private static final AtomicLong counter = new AtomicLong();	
	
	@RequestMapping(value = "/sum/{nOne}/{nTwo}", method=RequestMethod.GET)
	public Double sum(@PathVariable(value = "nOne") String nOne ,	
			          @PathVariable(value = "nTwo") String nTwo ) throws Exception {
		if(!isNumeric(nOne) || !isNumeric(nTwo)) {
			throw new UnsupportedMathOperationExcetion("insira um numero"); 
		}
		
		return convertToDouble(nOne) + convertToDouble(nTwo) ;
		
	}
	
	@RequestMapping(value = "/sub/{nOne}/{nTwo}", method=RequestMethod.GET)
	public Double sub(@PathVariable(value = "nOne") String nOne ,	
	          		  @PathVariable(value = "nTwo") String nTwo ) throws Exception {
		
		if(!isNumeric(nOne) || !isNumeric(nTwo)) {
			throw new UnsupportedMathOperationExcetion("insira um numero"); 
		}
		
		return convertToDouble(nOne) - convertToDouble(nTwo) ;		
		
	}

	/**
	 * Divisão 
	 * @param nOne
	 * @param nTwo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/div/{nOne}/{nTwo}", method=RequestMethod.GET)
	public Double div(@PathVariable(value = "nOne") String nOne ,	
	          		  @PathVariable(value = "nTwo") String nTwo ) throws Exception {
		
		if(!isNumeric(nOne) || !isNumeric(nTwo)) {
			throw new UnsupportedMathOperationExcetion("insira um numero"); 
		}
		
		return convertToDouble(nOne) / convertToDouble(nTwo) ;		
		
	}
	
	@RequestMapping(value = "/mul/{nOne}/{nTwo}", method=RequestMethod.GET)
	public Double mul(@PathVariable(value = "nOne") String nOne ,	
	          		  @PathVariable(value = "nTwo") String nTwo ) throws Exception {
		
		if(!isNumeric(nOne) || !isNumeric(nTwo)) {
			throw new UnsupportedMathOperationExcetion("insira um numero"); 
		}
		
		return convertToDouble(nOne) * convertToDouble(nTwo) ;		
		
	}	

	@RequestMapping(value = "/med/{nOne}/{nTwo}", method=RequestMethod.GET)
	public Double med(@PathVariable(value = "nOne") String nOne ,	
	          		  @PathVariable(value = "nTwo") String nTwo ) throws Exception {
		
		if(!isNumeric(nOne) || !isNumeric(nTwo)) {
			throw new UnsupportedMathOperationExcetion("insira um numero"); 
		}
		
			
		return (convertToDouble(nOne) + convertToDouble(nTwo)) / 2 ;		
		
	}	
	
	
	@RequestMapping(value = "/raiz/{nOne}", method=RequestMethod.GET)
	public Double raiz(@PathVariable(value = "nOne") String nOne)  throws Exception {
		
		if(!isNumeric(nOne)) {
			throw new UnsupportedMathOperationExcetion("insira um numero"); 
		}
		
		return Math.sqrt(convertToDouble(nOne));
		
	}	
	
	
	
	/**
	 * 
	 * @param strNum
	 * @return
	 */
	public static Double convertToDouble(String strNum) {
		
		if(strNum == null) return 0D;
		
		String number = strNum.replaceAll(",", ".");
		if(isNumeric(number)) return Double.parseDouble(number);
		
		return 0D; 
	}

	/**
	 * 
	 * @param strNum
	 * @return
	 */
	public static boolean isNumeric(String strNum) {
		
		if(strNum == null) return false;
		String number = strNum.replaceAll(",", ".");		
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}


}
