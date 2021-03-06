<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="java.awt.*" %>
    <%@ page import="java.awt.image.*" %>
    <%@ page import="java.util.*" %>
    <%@ page import="javax.imageio.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>验证码的生成</title>
</head>
<body>
<%!
    Color getRandColor(int fc,int bc){
	Random random=new Random();
	if(fc>225) fc=225;
	if(bc>225) bc=225;
	int r=fc+random.nextInt(bc-fc);
	int g=fc+random.nextInt(bc-fc);
	int b=fc+random.nextInt(bc-fc);
	return new Color(r,g,b);
}
%>
<%
   response.setHeader("Pragma","NO-cache");
   response.setHeader("Cache-control","no-cache");
   response.setDateHeader("Expires", 0);
   
   int iwidth=60;
   int iheight=20;
   BufferedImage image = new  BufferedImage( iwidth, iheight,BufferedImage.TYPE_INT_RGB);
   Graphics g = image.getGraphics();
   
   Random random = new Random();
   //设置背景色
   g.setColor(getRandColor(200,250));
   //设置矩形框
   g.fillRect(0, 0, iwidth, iheight);
   //设置字体
   g.setFont(new Font("Times New Roman",Font.PLAIN,18));
  //设置干扰线 
   g.setColor(getRandColor(160,200));
   
   for(int i=0;i<155;i++){
	   int ix=random.nextInt(iwidth);
	   int iy=random.nextInt(iheight);
	   int ixl=random.nextInt(12);
	   int iyl=random.nextInt(12);
	   g.drawLine(ix, iy, ix+ixl, iy+iyl);//确定两点，随机画出一条线
   }
   
   String sRand="";
   for(int i=0;i<4;i++){
	   String rand=String.valueOf(random.nextInt(10));
	   
	   sRand+=rand;
	   
	   g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));
	   
	   g.drawString(rand,13*i+6,16);  //用指定的 Brush （画笔）和 Font 对象绘制指定的文本字符串
   }
   
   //将验证码保存到session中
   session.setAttribute("Rand", sRand);
   //图像生效
   g.dispose();
   //输出图片
   ImageIO.write(image, "JPEG", response.getOutputStream());
   
   /*
   使用以下两行代码的原因是
   jsp中 response.getWriter()和response.getOutputStream()相互冲突
   jsp里面的代码都是默认  是jspWriter输出的  他输出后 是放在response里面的getWrite流里面      
     这里就调用response.getWriter()了  然后你其他地方用了response.getOutputStream()就会爆这个异常   
   */
   out.clear();
   out=pageContext.pushBody();
%>
</body>
</html>