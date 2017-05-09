package controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import util.Constance;

@ResponseBody
@Controller
public class ValidateController {
	
	@RequestMapping(value="/validate", method=RequestMethod.GET)
	public void getValidate(OutputStream os){
		System.out.println("获取验证码");
		HttpURLConnection con = null;
        InputStream is = null;
        try {
			URL url = new URL("http://xg.zdsoft.com.cn/sys/ValidateCode.aspx");
			con = (HttpURLConnection) url.openConnection();
			System.out.println("是不是："+Constance.cookie);
//			con.setRequestProperty("Cookie", Constance.cookie);
			is = con.getInputStream();
	    	Constance.cookie = con.getHeaderField("Set-Cookie");
	    	Constance.cookie = Constance.cookie.substring(0, Constance.cookie.indexOf(";"));
	    	System.out.println(Constance.cookie);
            byte[] bs = new byte[256];
            int len;
            while ((len = is.read(bs)) != -1) {
                os.write(bs, 0, len);
            }
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
