public void onMsg(Object msg)
{
new Thread(new Runnable(){
public void run(){
Data data = new Data();
data.put(msg,""+judge());

String quntext = data.quntext;
String qun = data.qun;
String uin = data.uin;
String qq=myUin;
int mtype=data.mtype;
long msgid=data.msgid;
if(qq.equals(uin)){
if(quntext.equals("开启空间秒赞")){
写("0","空间秒赞","开关",1);
String menu="已开启空间秒赞\n请重载Java以开启";
sendMsg(data.qun,menu,data.mtype);
}

if(quntext.equals("关闭空间秒赞")){
写("0","空间秒赞","开关",0);
String menu="已关闭空间秒赞\n请重载Java以关闭";
sendMsg(data.qun,menu,data.mtype);
}

if(quntext.equals("开启空间秒评")){
写("0","空间秒评","开关",1);
String menu="已开启空间秒评\n请重载Java以开启";
sendMsg(data.qun,menu,data.mtype);
}

if(quntext.equals("关闭空间秒评")){
写("0","空间秒评","开关",0);
String menu="已关闭空间秒评\n请重载Java以关闭";
sendMsg(data.qun,menu,data.mtype);
}

if(quntext.startsWith("设置空间秒评")){
写("0","空间秒评","内容",quntext.substring(6));
String menu="设置成功";
sendMsg(data.qun,menu,data.mtype);
}

if(quntext.startsWith("查看空间秒评")){
String msg=文字("0","空间秒评","内容");
if(msg.equals("")) msg="我来暖说说啦！ ";else msg=msg;
String menu="已设置的空间秒评为:"+msg;
sendMsg(data.qun,menu,data.mtype);
}

if(quntext.equals("特别关心")){
String menu=getSpecialCare();
sendMsg(data.qun,menu,data.mtype);
}

if(quntext.matches("访问空间[0-9]+")){
String menu=visitQzone(u);
sendMsg(data.qun,menu,data.mtype);
}

if(quntext.startsWith("访问空间@")){
String menu="";
for(String u : data.atList){
menu+=visitQzone(u);
}
if(menu.isEmpty()){
String menu="访问空间失败，请真实艾特某人";
sendMsg(data.qun,menu,data.mtype);
}else{
sendMsg(data.qun,menu,data.mtype);
}
}

if(quntext.equals("空间菜单")){
String menu="空间菜单:\n开启/关闭空间秒赞\n开启/关闭空间秒评\n设置空间秒评+内容\n查看空间秒评\n特别关心\n访问空间+QQ/@QQ";
sendMsg(data.qun,menu,data.mtype);
}

}
}}).start();
}
public String qzoneGet(String url, String cookie)
{
  StringBuffer buffer = new StringBuffer();
  InputStreamReader isr = null;
  try
  {
    URL urlObj = new URL(url);
    URLConnection uc = urlObj.openConnection();
    uc.setRequestProperty("Content-Type", "text/html; charset=UTF-8");
    uc.setRequestProperty("Host", "h5.qzone.qq.com");
    uc.setRequestProperty("Cookie", cookie);
    uc.setRequestProperty("user-agent", "Mozilla/5.0 (Linux; Android 12; V2055A Build/SP1A.210812.003; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/89.0.4389.72 MQQBrowser/6.2 TBS/046209 Mobile Safari/537.36 V1_AND_SQ_8.9.5_3176_YYB_D A_8090500 QQ/8.9.5.8845 NetType/WIFI WebP/0.3.0 Pixel/1080 StatusBarHeight/85 SimpleUISwitch/0 QQTheme/1000 InMagicWin/0 StudyMode/0 CurrentMode/0 CurrentFontScale/0.87 GlobalDensityScale/0.90000004 AppId/537129734");
    uc.setConnectTimeout(10000);
    uc.setReadTimeout(10000);
    isr = new InputStreamReader(uc.getInputStream(), "utf-8");
    BufferedReader reader = new BufferedReader(isr);
    String line;
    while((line = reader.readLine()) != null)
    {
      buffer.append(line + "\n");
    }
  }
  catch(Exception e)
  {
    e.printStackTrace();
  }
  finally
  {
    try
    {
      if(null != isr)
      {
        isr.close();
      }
    }
    catch(IOException e)
    {
      e.printStackTrace();
    }
  }
  if(buffer.length() == 0) return buffer.toString();
  buffer.delete(buffer.length() - 1, buffer.length());
  return buffer.toString();
}
if(读("0","空间秒赞","开关")==1||读("0","空间秒评","开关")==1){
new Thread(new Runnable()
{
    public void run()
    {
    try{
        while(true)
        {
String url=qzoneGet("https://h5.qzone.qq.com/webapp/json/mqzone_feeds/getActiveFeeds?g_tk="+GetGTK(LYgetPskey("qzone.qq.com"))+"&res_type=0&refresh_type=1&format=json","uin=o"+myUin+";skey="+getSkey()+";p_uin=o"+myUin+";p_skey="+LYgetPskey("qzone.qq.com"));
if(url.contains("系统繁忙")&&!url.contains("\"code\":0")&&!url.contains("\"ret\":0")){
Thread.sleep(20000);//20秒后重新访问
url=qzoneGet("https://h5.qzone.qq.com/webapp/json/mqzone_feeds/getActiveFeeds?g_tk="+GetGTK(LYgetPskey("qzone.qq.com"))+"&res_type=0&refresh_type=1&format=json","uin=o"+myUin+";skey="+getSkey()+";p_uin=o"+myUin+";p_skey="+LYgetPskey("qzone.qq.com"));
}
JSONObject json=new JSONObject(url);
int code=json.getInt("code");
if(code==0){
JSONObject dataMsg=json.getJSONObject("data");
JSONArray infos=dataMsg.getJSONArray("vFeeds");
		for(int qqq=0;qqq<infos.length();qqq++){
        JSONObject List=infos.get(qqq);
        String orglikekey=List.getJSONObject("comm").getString("orglikekey");
        String curlikekey=List.getJSONObject("comm").getString("curlikekey");
        String user=List.getJSONObject("userinfo").getJSONObject("user").getString("uin");
        sendQzoneZan(orglikekey,curlikekey);
        sendQzoneComment(orglikekey,curlikekey,user);
        }
        Thread.sleep(20000);//休息20秒
        }else{
        sendMsg(myUin,e+"\n空间秒赞失败:"+json.getString("message"),1);
        }
     }
   }catch(e){sendMsg(myUin,e+"\n空间秒赞失败，秒赞已停止，请重启Java开启",1);}
}
}).start();
}
public void sendQzoneZan(String orglikekey,String curlikekey){
    if(读("0","空间秒赞","开关")==1){
        if(!isSetedQzoneKey(orglikekey,"like")){
        String url2=httppost1("https://h5.qzone.qq.com/proxy/domain/w.qzone.qq.com/cgi-bin/likes/internal_dolike_app?g_tk="+GetGTK(LYgetPskey("qzone.qq.com")),"uin=o"+myUin+";skey="+getSkey()+";p_uin=o"+myUin+";p_skey="+LYgetPskey("qzone.qq.com"),"opuin="+myUin+"&unikey="+URL(orglikekey,1)+"&curkey="+URL(curlikekey,1)+"&appid=311&opr_type=like&format=purejson");
        JSONObject jsons=new JSONObject(url2);
        int ret=jsons.getInt("ret");
        if(ret==0){
        }else{
        sendMsg(myUin,curlikekey+"\n空间秒赞失败\n返回数据"+url2,1);
        }
            addQzoneKey(orglikekey,"like");//如果已点赞就不处理
            }
                
    }
}

public void sendQzoneComment(String orglikekey,String curlikekey,String user){
    if(读("0","空间秒评","开关")==1){
        if(!isSetedQzoneKey(orglikekey,"comment")){
        String text=文字("0","空间秒评","内容");
            if(text==null||text.isEmpty()){
            text="我来暖说说啦！";
            }
            String id="";
            if(orglikekey.contains("user.qzone.qq.com/"+user+"/")){
            id=orglikekey.substring(orglikekey.lastIndexOf("/")+1);
            }else{
            id=curlikekey;
            }
        String url2=httppost1("https://h5.qzone.qq.com/webapp/json/qzoneOperation/addComment?g_tk="+GetGTK(LYgetPskey("qzone.qq.com")),"uin=o"+myUin+";skey="+getSkey()+";p_uin=o"+myUin+";p_skey="+LYgetPskey("qzone.qq.com"),"{\"appid\":311,\"uin\":"+myUin+",\"ownuin\":\""+user+"\",\"srcId\":\""+id+"\",\"content\":\""+text+"\",\"isPrivateComment\":0,\"busi_param\":{},\"bypass_param\":{}}");
        JSONObject jsons=new JSONObject(url2);
        int ret=jsons.getInt("ret");
        if(ret==0){
        }else{
        sendMsg(myUin,orglikekey+"\n空间秒评失败\n返回数据"+url2,1);
        }
            addQzoneKey(orglikekey,"comment");//如果已评论就不处理
            }
                
    }
}

public String getSpecialCare()
{
  String cookie = "uin=o" + myUin + "; skey=" + skey + "; p_uin=o" + myUin + "; p_skey=" + qzone;
  String url = httpget("https://user.qzone.qq.com/proxy/domain/r.qzone.qq.com/cgi-bin/tfriend/specialcare_get.cgi?uin=" + myUin + "&do=3&fupdate=1&rd=0.3731543055937272&g_tk=" + GetBkn(skey) + "&g_tk=" + GetBkn(skey), cookie);
  String url = url.replace("_Callback(", "").replace("\n);", "").replace("\n", "").replace("", "");
  JSONObject json = new JSONObject(url);
  String data1 = json.getString("data");
  JSONObject json1 = new JSONObject(data1);
  String used_count = json1.getString("used_count").replace("[", "").replace("]", "");
  String fans_count = json1.getString("fans_count").replace("[", "").replace("]", "");
  JSONObject json2 = new JSONObject(used_count);
  String used_count = json2.optString("used_count");
  JSONObject json3 = new JSONObject(fans_count);
  String fans_count = json3.optString("fans_count");
  return "我关心的:" + used_count + "\n关心我的:" + fans_count;
}

public String visitQzone(String uin)
{
    String url = "https://h5.qzone.qq.com/mqzone/profile?hostuin="+uin;
    String cookie = "p_uin=o" + myUin + ";login_type=1;uin=o" + myUin + ";skey=" + getSkey() + ";p_skey=" + qzone;
    String result=httpget(url,cookie);
        if(result.contains("说点什么吧...")){
        return "访问" + uin + "的空间成功";
        }
        else
        {
        return "访问" + uin + "的空间失败";
    }
}

public String kj_httppost(String urlPath,String data,String token)
{
  StringBuffer buffer = new StringBuffer();
  InputStreamReader isr = null;
  try
  {
    URL url = new URL(urlPath);
    uc = (HttpURLConnection) url.openConnection();
    uc.setDoInput(true);
    uc.setDoOutput(true);
    uc.setConnectTimeout(2000000);
    uc.setReadTimeout(2000000);
    uc.setRequestMethod("POST");
    uc.setRequestProperty("x-requested-with", "XMLHttpRequest");
    uc.setRequestProperty("Content-Type", "application/json");
    uc.setRequestProperty("Authorization", "Bearer "+token);
    uc.getOutputStream().write(data.getBytes("UTF-8"));
    uc.getOutputStream().flush();
    uc.getOutputStream().close();
    isr = new InputStreamReader(uc.getInputStream(), "utf-8");
    BufferedReader reader = new BufferedReader(isr);
    String line;
    while((line = reader.readLine()) != null)
    {
      buffer.append(line + "\n");
    }
  }
  catch(Exception e)
  {
    e.printStackTrace();
  }
  finally
  {
    try
    {
      if(null != isr)
      {
        isr.close();
      }
    }
    catch(IOException e)
    {
      Toast( "错误:\n" + e);
    }
  }
  if(buffer.length() == 0) return buffer.toString();
  buffer.delete(buffer.length() - 1, buffer.length());
  return buffer.toString();
}
public String kj_httppost(String urlPath,String data)
{
  StringBuffer buffer = new StringBuffer();
  InputStreamReader isr = null;
  try
  {
    URL url = new URL(urlPath);
    uc = (HttpURLConnection) url.openConnection();
    uc.setDoInput(true);
    uc.setDoOutput(true);
    uc.setConnectTimeout(2000000);
    uc.setReadTimeout(2000000);
    uc.setRequestMethod("POST");
    uc.setRequestProperty("x-requested-with", "XMLHttpRequest");
    uc.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
    uc.getOutputStream().write(data.getBytes("UTF-8"));
    uc.getOutputStream().flush();
    uc.getOutputStream().close();
    isr = new InputStreamReader(uc.getInputStream(), "utf-8");
    BufferedReader reader = new BufferedReader(isr);
    String line;
    while((line = reader.readLine()) != null)
    {
      buffer.append(line + "\n");
    }
  }
  catch(Exception e)
  {
    e.printStackTrace();
  }
  finally
  {
    try
    {
      if(null != isr)
      {
        isr.close();
      }
    }
    catch(IOException e)
    {
      Toast( "错误:\n" + e);
    }
  }
  if(buffer.length() == 0) return buffer.toString();
  buffer.delete(buffer.length() - 1, buffer.length());
  return buffer.toString();
}

public String kj_get(String url,String token)
{
  StringBuffer buffer = new StringBuffer();
  InputStreamReader isr = null;
  try
  {
    URL urlObj = new URL(url);
    URLConnection uc = urlObj.openConnection();
    uc.setRequestProperty("Authorization", "Bearer "+token);
    uc.setRequestProperty("x-requested-with", "XMLHttpRequest");
    uc.setRequestProperty("user-agent", "Mozilla/5.0 (Linux; Android 12; V2055A Build/SP1A.210812.003; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/89.0.4389.72 MQQBrowser/6.2 TBS/046209 Mobile Safari/537.36 V1_AND_SQ_8.9.5_3176_YYB_D A_8090500 QQ/8.9.5.8845 NetType/WIFI WebP/0.3.0 Pixel/1080 StatusBarHeight/85 SimpleUISwitch/0 QQTheme/1000 InMagicWin/0 StudyMode/0 CurrentMode/0 CurrentFontScale/0.87 GlobalDensityScale/0.90000004 AppId/537129734");
    uc.setConnectTimeout(10000);
    uc.setReadTimeout(10000);
    isr = new InputStreamReader(uc.getInputStream(), "utf-8");
    BufferedReader reader = new BufferedReader(isr);
    String line;
    while((line = reader.readLine()) != null)
    {
      buffer.append(line + "\n");
    }
  }
  catch(Exception e)
  {
    e.printStackTrace();
  }
  finally
  {
    try
    {
      if(null != isr)
      {
        isr.close();
      }
    }
    catch(IOException e)
    {
      e.printStackTrace();
    }
  }
  if(buffer.length() == 0) return buffer.toString();
  buffer.delete(buffer.length() - 1, buffer.length());
  return buffer.toString();
}

import java.util.Base64;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public String Base64ToImage(String base64Data) {
    try {
        String outputPath = ColdRainPath + User(6) + ".png"; 
        File file = new File(outputPath);
        
        // 确保父目录存在
        File parent = file.getParentFile();
        if (parent != null && !parent.exists()) {
            parent.mkdirs();
        }
        
        FileOutputStream fos = new FileOutputStream(file);
            byte[] imageBytes = Base64.getDecoder().decode(base64Data);
            fos.write(imageBytes);
            fos.flush();
        return outputPath;
    } catch (Exception e) {
        return null;
    }
}

public void addQzoneKey(String key,String type){
String id="";
if(key.contains("user.qzone.qq.com/")){
id=key.substring(key.lastIndexOf("/")+1);
}else{
id=key;
}
String text=文字("0","空间操作",type);
JSONObject json;
if(text==null||text.isEmpty()){
json = new JSONObject();
}else{
json = new JSONObject(text);
}
json.put(id,1);
写("0","空间操作",type,json.toString());
}

public void deleteQzoneKey(String key,String type){
String id="";
if(key.contains("user.qzone.qq.com/")){
id=key.substring(key.lastIndexOf("/")+1);
}else{
id=key;
}
String text=文字("0","空间操作",type);
JSONObject json;
if(text==null||text.isEmpty()){
json = new JSONObject();
}else{
json = new JSONObject(text);
}
json.put(id,0);
写("0","空间操作",type,json.toString());
}
public boolean isSetedQzoneKey(String key,String type){
//type=like,comment
String id="";
if(key.contains("user.qzone.qq.com/")){
id=key.substring(key.lastIndexOf("/")+1);
}else{
id=key;
}
String text=文字("0","空间操作",type);
JSONObject json;
if(text==null||text.isEmpty()){
return false;
}else{
json = new JSONObject(text);
}
if(json.optString(id).equals("0")){
return false;
}else if(json.optString(id).equals("1")){
return true;
}else{
return false;
}
  }
