package personalBlogDeom.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.codehaus.groovy.util.StringUtil;
import org.junit.Test;
import org.springframework.util.StringUtils;



public class testDeom {

	@Test
	public void test1() {
		long tims = System.currentTimeMillis();
		String timString = String.valueOf(tims);
		
		
		String format = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(format);  
		String times = sdf.format(new Date(Long.valueOf(timString))); 
		System.out.println(timString + "\n" + times);
		
	}
	
	@Test
	public void test2() {
		SimpleDateFormat formDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		System.out.println(formDate.format(new Date()));
		
		System.out.println("jkl\"");
	}
	
	
	@Test
	public void test3() {
		String content = "<h1 style=\"text-align: center;\">个人博客测试</h1><p>&nbsp;个人博客测试:</p><p style=\"margin-left: 40px;\">图片上传:</p><p style=\"margin-left: 40px; text-align: center;\"><img alt=\"gratisography-mountain-peaks.jpg\" class=\"\" src=\"C:/test/1548321621877_gratisography-mountain-peaks.jpg\" width=\"300\" height=\"198\" data-image-size=\"5760,3840\"></p><p style=\"margin-left: 40px;\">ok;</p><p style=\"margin-left: 40px;\">样式测试:<u>&nbsp;</u></p><p style=\"margin-left: 40px;\"><u>&nbsp;今天天气有点阴,买的年货<strike>到了,还不错,</strike></u></p><p style=\"margin-left: 40px;\"><u><strike><span style=\"color: rgb(226, 139, 65);\">今天的<i>跨域问题<b>是真的恶心,,,</b></i></span><br></strike></u></p><p style=\"margin-left: 40px;\"><u><strike><span style=\"color: rgb(226, 139, 65);\"><i><b>ok.</b></i></span></strike></u></p><p style=\"margin-left: 40px;\"><u><strike><span style=\"color: rgb(226, 139, 65);\"><i><b><br></b></i></span></strike></u></p><div class=\"simditor-table\"><table><colgroup><col width=\"33.25242718446602%\"><col width=\"33.25242718446602%\"><col width=\"33.49514563106796%\"></colgroup><thead><tr><th class=\"\">tible</th><th class=\"\"><i>表格样式</i></th><th class=\"\"><span style=\"color: rgb(153, 153, 153);\">不错</span><br></th></tr></thead><tbody><tr><td class=\"\"><b>随机</b></td><td class=\"\"><span style=\"font-size: 1.5em;\">2019年1月24日17:24:32</span></td><td class=\"\">2019年1月24日</td></tr><tr><td class=\"\"><br></td><td><br></td><td><br></td></tr><tr><td><br></td><td><br></td><td><br></td></tr></tbody></table><div class=\"simditor-resize-handle\" contenteditable=\"false\" style=\"left: 543.4px; display: none;\"><br></div></div><p style=\"text-align: right;\"><br></p><p style=\"text-align: right;\"><br></p><p style=\"text-align: right;\">保存;ok</p><p><br></p>";
		int indexOf1 = content.indexOf("<h");
		int indexOf2 = content.indexOf(">", indexOf1);
		int indexOf3 = content.indexOf("</");
		String substring = content.substring(indexOf2 + 1, indexOf3);
		
		int img1 = content.indexOf("<img");
		int img2 = content.indexOf("src=\"", img1);
		int img3 = content.indexOf("\"", img2+5);
		String substring2 = content.substring(img2+5, img3);
		
		System.out.println(substring+"\n"+substring2);
	}

	
	@Test
	public void getRoleList() {
		String userRoleId = "1,2,3,4";
		List<String> roleList = new ArrayList<String>();
		int fleg = 0;
		System.out.println(fleg != 0);
		if(userRoleId != null) {
			while (true) {
				int indexOf = userRoleId.indexOf(",",fleg);
				System.out.println("fleg:"+fleg+"\nindexof:"+indexOf);
				if(indexOf != -1) {
					roleList.add(userRoleId.substring(fleg, indexOf));
					fleg = indexOf + 1;
				}else {
					break;
				}
			}
		}
		System.out.println(roleList.toString());
	}
	
	
	@Test
	public void test5() {
		String userRoleId = "1,2,3,4";
		List<String> roleList = new ArrayList<String>();
		int fleg = 0;
//		while(true) {
			String[] split = userRoleId.split(",");
			System.out.println(split[0]+split[1]+split[2]+split[3]);
			System.out.println(Arrays.toString(split));
//		}
		
	}

	
	@Test
	public void test6() {
		String s = "1";
		
		System.out.println(StringUtils.isEmpty(s));
		
	}
	
	
}
