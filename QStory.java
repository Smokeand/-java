String myUin=MyUin+"";
String pluginID=PluginID+"";

public void loadJava(String str){
    load(str);
}
public String readprop(String file, String name2)
{
  String PropFile = file;
  String text = 读(PropFile);
  Properties props = new Properties();
  props.load(new StringReader(text));
  String name = props.getProperty(name2);
  return name;
}
public void sendCard(String str,String str2,int type){
    if(type==1)sendCard("",str,str2);else if(type==2)sendCard(str,"",str2);
}

public void sendMsg(String str,String str2,int type){
String str2=str2.replace("atUin=","AtQQ=").replace("pic=","PicUrl=");
    if(type==1)sendMsg("",str,str2);else if(type==2)sendMsg(str,"",str2);
}

public addItem(String str,String str2){
    AddItem(str,str2);
}

public void sendFile(String qun,String text,int mtype){//发送文件
String qr="";
    if(mtype==1) qr=getUidFromUin(qun);else if(mtype==2) qr=qun;
    Contact contact = new Contact(mtype, qr, "");
    MsgElement msgElement=QRoute.api(IMsgUtilApi.class).createFileElement(text);
    ArrayList MsgList=new ArrayList();
    MsgList.add(msgElement);
//IOperateCallback iOperateCallback=new IOperateCallback();
    ((IMsgService) QRoute.api(IMsgService.class)).sendMsg(contact,MsgList,null);
}

public void recallMsg(int mtype,String qun,List list){//撤回消息
String qr="";
    if(mtype==1) qr=getUidFromUin(qun);else if(mtype==2) qr=qun;
    for(long msgid:list){
        Contact contact = new Contact(mtype, qr, "");
        ((IMsgService) QRoute.api(IMsgService.class)).recallMsg(contact,msgid,null);//撤回消息
    }
}
public void sendReply(Object data,String menu){
    sendReply(data.GroupUin,data,menu);
}


public void shutUp(String str,String str2,int i){
    Forbidden(str,str2,i);
}

public void setGroupMemberTitle(String str,String str2,String str3){
    setTitle(str,str2,str3);
}


import com.tencent.mobileqq.troop.clockin.handler.TroopClockInHandler;
public void groupClockIn(String qun,String uin){
TroopClockInHandler inHandler;
    try{
        inHandler = new TroopClockInHandler(app);
    }catch(e){
        inHandler = new TroopClockInHandler();
    }
Method method;
Class clazz = TroopClockInHandler.class;
Class[] ParamTYPE = new Class[]{String.class,String.class,int.class,boolean.class};
Method[] methods = clazz.getDeclaredMethods();
    for (Method m : methods) {
        if (m.getParameterCount() == ParamTYPE.length ) {
            Class[] params = m.getParameterTypes();
            boolean match = true;
            for (int i = 0; i < ParamTYPE.length; i++) {
                if (!params[i].equals(ParamTYPE[i])) {
                    match = false;
                    break;
                }
            }
            if (match) {
                // 调用匹配的方法
                m.setAccessible(true);
                m.invoke(inHandler,new Object[]{qun,uin,0,true});
                break; // 找到匹配的方法后，跳出循环
            }
        }
    }
          }
