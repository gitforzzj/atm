package atm27.utils;

import atm27.domain.ATM;
import atm27.domain.Session;
/**
 * 工具类，生成单例ATM
 * @author zheng
 *
 */
public class ATMUtils {
	private final static ATM atm=null;
	
	public static ATM getATM(){
		if(atm==null){
			return new ATM();
		}else{
			return atm;
		}
	} 
	
}
