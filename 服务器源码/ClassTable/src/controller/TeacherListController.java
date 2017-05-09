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

import pojo.TeacherInfo;
import service.TeacherListManager;
import util.Constance;

@ResponseBody
@Controller
@RequestMapping(value = "/teacherForm")
public class TeacherListController {
	@Autowired
	private TeacherListManager tManager;

	@RequestMapping(value = "/findTeacherList", method = RequestMethod.GET)
	public List<TeacherInfo> selectTeacherList() {
		List<TeacherInfo> teacherInfo = new ArrayList<TeacherInfo>();
		HttpURLConnection con = null;
		InputStream is = null;
		BufferedReader reader = null;
		teacherInfo = tManager.selectList();
		if (teacherInfo.size() == 0) {
			teacherInfo = new ArrayList<>();
			try {
				URL url = new URL("http://xg.zdsoft.com.cn/ZNPK/Private/List_JS.aspx?xnxq=20160&t=591");
				con = (HttpURLConnection) url.openConnection();
				if (!Constance.cookie.equals("")) {
					con.setRequestProperty("Cookie", Constance.cookie);
				}
				is = con.getInputStream();
				if (Constance.cookie.equals("")) {
					Constance.cookie = con.getHeaderField("Set-Cookie");
					Constance.cookie = Constance.cookie.substring(0, Constance.cookie.indexOf(";"));
				}
				reader = new BufferedReader(new InputStreamReader(is, "GB2312"));
				String lines = null;
				StringBuilder sbr = new StringBuilder("");
				while ((lines = reader.readLine()) != null) {
					sbr.append(lines);
				}
				Document doc = Jsoup.parse(sbr.toString());
				Elements items = doc.select("script");
				String html = items.html().substring(24);
				Document doc1 = Jsoup.parse(html);
				Elements items1 = doc1.select("select[name=\"Sel_JS\"] option");
				for (Element element : items1) {
					teacherInfo.add(new TeacherInfo(element.text(), element.val()));
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
			tManager.insertTeacherList(teacherInfo);
		}
		return teacherInfo;
	}

}
