public void put(String Path, String WriteData)
{
  try
  {
    FileMemCache.put(Path, WriteData);
    File file = new File(Path);
    FileOutputStream fos = new FileOutputStream(file);
    if(!file.exists())
    {
      file.createNewFile();
    }
    byte[] bytesArray = WriteData.getBytes();
    fos.write(bytesArray);
    fos.flush();
  }
  catch(IOException ioe)
  {
    Toast("" + ioe);
  }
}
public void sc(String Path)
{
  File file = null;
  try
  {
    file = new File(Path);
    if(file.exists())
    {
      file.delete();
      FileMemCache.remove(Path);
    }
  }
  catch(Exception e)
  {
    Toast(e + "");
  }
}
HashMap FileMemCache = new HashMap();
public 写(QQUin, SetName, ItemName, data)
{
  try
  {
    新建(ColdRainPath + "data/" + QQUin);
    String UserData = 读(ColdRainPath + "data/" + QQUin + "/" + SetName + ".txt");
    JSONObject UserDataJson = null;
    if(UserData.equals(""))
    {
      UserDataJson = new JSONObject("{}");
    }
    else
    {
      UserDataJson = new JSONObject(UserData);
    }
    UserDataJson.put(ItemName, data);
    写(ColdRainPath + "data/" + QQUin + "/" + SetName + ".txt", UserDataJson.toString());
    return;
  }
  catch(Exception e)
  {
    return;
  }
}
public 清除(QQUin, SetName, ItemName)
{
  try
  {
    新建(ColdRainPath + "data/" + QQUin);
    String UserData = 读(ColdRainPath + "data/" + QQUin + "/" + SetName + ".txt");
    JSONObject UserDataJson = null;
    if(UserData.equals(""))
    {
      return;
    }
    else
    {
      UserDataJson = new JSONObject(UserData);
    }
    UserDataJson.remove(ItemName);
    写(ColdRainPath + "data/" + QQUin + "/" + SetName + ".txt", UserDataJson.toString());
    return;
  }
  catch(Exception e)
  {
    return;
  }
}
public String[] 列表(QQUin, SetName)
{
  try
  {
    String UserData = 读(ColdRainPath + "data/" + QQUin + "/" + SetName + ".txt");
    JSONObject UserDataJson = null;
    if(UserData.equals(""))
    {
      return new String[0];
    }
    else
    {
      UserDataJson = new JSONObject(UserData);
    }
    ArrayList MY_list = new ArrayList();
    for(String it : UserDataJson.keys()){
    if(读(QQUin,SetName,it)==1){
      MY_list.add(it);
      }
    }
    String[] fintext = MY_list.toArray(new String[0]);
    return fintext;
  }
  catch(Exception e)
  {
  Toast("列表()出错");
    return new String[0];
  }
}
public String 文字(QQUin, SetName, ItemName)
{
  try
  {
    String UserData = 读(ColdRainPath + "data/" + QQUin + "/" + SetName + ".txt");
    JSONObject UserDataJson = null;
    if(UserData.equals(""))
    {
      return "";
    }
    else
    {
      UserDataJson = new JSONObject(UserData);
    }
    if(!UserDataJson.has(ItemName)) return "";
    return UserDataJson.getString(ItemName);
  }
  catch(Exception e)
  {
    return "";
  }
}
public 写(QQUin, SetName, ItemName, long data)
{
  try
  {
    新建(ColdRainPath + "data/" + QQUin);
    String UserData = 读(ColdRainPath + "data/" + QQUin + "/" + SetName + ".txt");
    JSONObject UserDataJson = null;
    if(UserData.equals(""))
    {
      UserDataJson = new JSONObject("{}");
    }
    else
    {
      UserDataJson = new JSONObject(UserData);
    }
    UserDataJson.put(ItemName, String.valueOf(data));
    写(ColdRainPath + "data/" + QQUin + "/" + SetName + ".txt", UserDataJson.toString());
    return;
  }
  catch(Exception e)
  {
    Toast(e + "");
    return;
  }
}
public long 读(QQUin, SetName, ItemName)
{
  try
  {
    String UserData = 读(ColdRainPath + "data/" + QQUin + "/" + SetName + ".txt");
    JSONObject UserDataJson = null;
    if(UserData.equals(""))
    {
      return 0;
    }
    else
    {
      UserDataJson = new JSONObject(UserData);
    }
    if(!UserDataJson.has(ItemName)) return 0;
    return Long.parseLong(UserDataJson.getString(ItemName));
  }
  catch(Exception e)
  {
    return 0;
  }
}
public 删除(QQUin, SetName)
{
  删除(ColdRainPath + "data/" + QQUin + "/" + SetName + ".txt");
}
public 删除(QQUin)
{
  删除(ColdRainPath + "data/" + QQUin + "/");
}
public 读(String FilePath)
{
  try
  {
    if(FileMemCache.containsKey(FilePath))
    {
      return FileMemCache.get(FilePath);
    }
    File file = new File(FilePath);
    if(!file.exists())
    {
      file.createNewFile();
    }
    InputStreamReader inputReader = new InputStreamReader(new FileInputStream(file));
    BufferedReader bf = new BufferedReader(inputReader);
    String Text = "";
    while((str = bf.readLine()) != null)
    {
      Text = Text + "\n" + str;
    }
    if(Text.isEmpty())
    {
      return "";
    }
    FileMemCache.put(FilePath, Text.substring(1));
    return Text.substring(1);
  }
  catch(IOException ioe)
  {
    return "";
  }
}

public 写(String Path, WriteData)
{
  try
  {
    FileMemCache.put(Path, WriteData);
    File file = new File(Path);
    FileOutputStream fos = new FileOutputStream(file);
    if(!file.exists())
    {
      file.createNewFile();
    }
    byte[] bytesArray = WriteData.getBytes();
    fos.write(bytesArray);
    fos.flush();
  }
  catch(IOException ioe)
  {}
}
public 新建(String Path)
{
  File dir = null;
  try
  {
    dir = new File(Path);
    if(!dir.exists())
    {
      dir.mkdirs();
    }
  }
  catch(Exception e)
  {
    Toast("创建文件夹时发生错误,相关信息:\n" + e);
  }
}
public 删除(String Path)
{
  File file = null;
  try
  {
    file = new File(Path);
    if(file.exists())
    {
      file.delete();
      FileMemCache.remove(Path);
    }
  }
  catch(Exception e)
  {
    Toast("删除文件时发生错误,相关信息:\n" + e);
  }
}
public String[] 全局列表(SetName)
{
  try
  {
    String UserData = 读(ColdRainPath + "data/" + SetName + ".txt");
    JSONObject UserDataJson = null;
    if(UserData.equals(""))
    {
      return new String[0];
    }
    else
    {
      UserDataJson = new JSONObject(UserData);
    }
    ArrayList MY_list = new ArrayList();
    for(String it : UserDataJson.keys()){
      MY_list.add(it);
    }
    String[] fintext = MY_list.toArray(new String[0]);
    return fintext;
  }
  catch(Exception e)
  {
    return new String[0];
  }
}

public String[] 列表2(QQUin, SetName)
{
  try
  {
    String UserData = 读(ColdRainPath + "data/" + QQUin + "/" + SetName + ".txt");
    JSONObject UserDataJson = null;
    if(UserData.equals(""))
    {
      return new String[0];
    }
    else
    {
      UserDataJson = new JSONObject(UserData);
    }
    ArrayList MY_list = new ArrayList();
    for(String it : UserDataJson.keys()){
      MY_list.add(it);
    }
    String[] fintext = MY_list.toArray(new String[0]);
    return fintext;
  }
  catch(Exception e)
  {
    return new String[0];
  }
}

public long GetBkn(String skey)
{
  int hash = 5381;
  for(int i = 0, len = skey.length(); i < len; i++) hash += (hash << 5) + (int)(char) skey.charAt(i);
  return hash & 2147483647;
}

public String httpget(String url, String cookie)
{
  StringBuffer buffer = new StringBuffer();
  InputStreamReader isr = null;
  try
  {
    URL urlObj = new URL(url);
    URLConnection uc = urlObj.openConnection();
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
public String httppost1(String urlPath, String cookie, String data)
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
    uc.setRequestProperty("Content-Type", "application/json");
    uc.setRequestProperty("Cookie", cookie);
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
public long GetGTK(String key)
{
  String pskey = key + "";
  int hash = 5381;
  for(int i = 0, len = pskey.length(); i < len; i++)
  {
    hash += (hash << 5) + (int)(char) pskey.charAt(i);
  }
  return hash & 0x7fffffff;
}
public String URL(String text,int num){
    if(num==0){
    String urlStr = URLDecoder.decode(text,"UTF-8");
        return urlStr;
    }else if(num==1){
    String urlStr = URLEncoder.encode(text,"UTF-8");
        return urlStr;
    }else if(num==2){
        return URL(URL(text,0),0);
    }
}
