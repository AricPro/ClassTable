package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.fasterxml.jackson.databind.ObjectMapper;

import pojo.ClassDetail;
import pojo.Course_Info;

public class GetClassTable {
	public static ClassDetail getTable(String param, String coursevalue, ClassDetail table){
	List<Course_Info> tablelist = new ArrayList<Course_Info>();
        StringBuilder sbr = new StringBuilder();
        ObjectMapper mapper = new ObjectMapper();
		String jsonList = null;
        try {
			URL url = new URL("http://xg.zdsoft.com.cn/ZNPK/KBFB_LessonSel_rpt.aspx");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			if(!Constance.cookie.equals("")){
				con.setRequestProperty("Cookie", Constance.cookie);
				System.out.println(Constance.cookie);
			}
			 con.setRequestMethod("POST");
			 con.setRequestProperty("Referer", "http://xg.zdsoft.com.cn/ZNPK/KBFB_LessonSel.aspx");
			 con.setDoOutput(true);
			 con.setDoInput(true);
			 PrintWriter writer = new PrintWriter(con.getOutputStream());
			 writer.write(param);
			 writer.flush();
			 if(con.getResponseCode() == 200){
				 System.out.println("连接成功");
			 }else{
				 System.out.println("连接失败");
			 }
		    InputStream is = con.getInputStream();
		    if(Constance.cookie.equals("")){
		    	Constance.cookie = con.getHeaderField("Set-Cookie");
		    	Constance.cookie = Constance.cookie.substring(0, Constance.cookie.indexOf(";"));
		    	System.out.println(Constance.cookie);
		    }
		    BufferedReader reader = new BufferedReader(new InputStreamReader(is,"GB2312"));
            StringBuilder result = new StringBuilder("");
            String lines;
		    while((lines=reader.readLine()) != null){
		    	result.append(lines);
		    }
            Document doc  = Jsoup.parse(result.toString(),"utf-8");
            //判断验证码是否有误
            if(doc.select("script").first().toString().contains("验证码错误")){
            	System.out.println("验证码错误");
//                return "[{\"validate\":\"Error\"}]";
            	return null;
            }
            Elements tableBar = doc.select("table[name=\"theExportData\"][border=\"0\"]");
            String tableBarStr = "";
            tableBarStr = tableBar.first().getElementsByTag("tr").html();
            Elements tableContent = doc.select("table[name=\"theExportData\"][border=\"1\"] tr");
            String tableContentStr;
            for (int i = 1; i < tableContent.size(); i++) {
                Elements item = tableContent.get(i).select("td");
                tablelist.add(new Course_Info(coursevalue,item.get(0).text(),item.get(1).text(),item.get(2).text(),item.get(3).text(),item.get(4).text(),item.get(5).text(),item.get(6).text(),item.get(7).text(),item.get(8).text()));
            }
            jsonList = mapper.writeValueAsString(tablelist);
            table = new ClassDetail(coursevalue, jsonList);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    return table;
	}
}
