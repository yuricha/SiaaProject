package pe.infounsa.siaa.business.impl.seguridad;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptMD5 {

	public String cryptMD5(String value){
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        md.update(value.getBytes());
        byte[] bytes = md.digest();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< bytes.length ;i++)
        {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        
		return sb.toString();
	}
}
