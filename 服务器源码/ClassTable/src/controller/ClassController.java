package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pojo.ClassInfo;
import service.ClassManager;
import util.Constance;

@ResponseBody
@Controller
@RequestMapping(value = "/getInfo")
public class ClassController {

	@Autowired
	private ClassManager classManager;

	@RequestMapping(value = "/findCourseList", method = RequestMethod.GET)
	public List<ClassInfo> selectCourseList() {
		HttpURLConnection con = null;
		List<ClassInfo> classList = null;
		InputStream is = null;
		BufferedReader reader = null;
		classList = classManager.selectList();
		if (classList.size() == 0) {
			System.out.println("数据库没有值");
			classList = new ArrayList<>();
			try {
				URL url = new URL("http://xg.zdsoft.com.cn/ZNPK/Private/List_XNXQKC.aspx?xnxq=20160");
				con = (HttpURLConnection) url.openConnection();
				if (!Constance.cookie.equals("")) {
					con.setRequestProperty("Cookie", Constance.cookie);
				}
				is = con.getInputStream();
				if (Constance.cookie.equals("")) {
					System.out.println("echo");
					Constance.cookie = con.getHeaderField("Set-Cookie");
					Constance.cookie = Constance.cookie.substring(0, Constance.cookie.indexOf(";"));
				}
				reader = new BufferedReader(new InputStreamReader(is, "GB2312"));
				String lines = null;
				StringBuilder sbr = new StringBuilder();
				while ((lines = reader.readLine()) != null) {
					sbr.append(lines);
				}
				Document doc = Jsoup.parse(sbr.toString());
				Elements items = doc.select("script");
				String html = items.html().substring(24);
				Document doc1 = Jsoup.parse(html);
				Elements items1 = doc1.select("select[name=\"Sel_KC\"] option");
				for (Element element : items1) {
					classList.add(new ClassInfo(element.val(), element.text()));
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (reader != null)
						reader.close();
					if (is != null)
						is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				if (con != null)
					con.disconnect();
			}
			classManager.insertClassList(classList);
		}
		return classList;
	}
}
