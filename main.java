//已经是从冷雨脚本的主脚本中拆出来的功能 你可以搬方法 请留名 不留名/二改此脚本 你没(  )

//哎呦我去，你看集贸啊
//给你一拳


//愿你历经冷雨，终与温晴相逢。
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;
import java.lang.*;
import java.io.File;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import android.os.Environment;
long firstLoadTime = System.currentTimeMillis();
import java.lang.reflect.Method;
import java.lang.reflect.*;
import android.content.Context;
String QQ_PackageName = context.getPackageName();
String versionName=context.getPackageManager().getPackageInfo(QQ_PackageName, 0).versionName.replace(".","");
int QQ_versionName;
String CurrentApp="";
if(versionName.length()==3) QQ_versionName=Integer.parseInt(versionName+"0");else QQ_versionName=Integer.parseInt(versionName);

if(QQ_PackageName.equals("com.tencent.mobileqq")) CurrentApp="QQ";else if(QQ_PackageName.equals("com.tencent.tim")) CurrentApp="TIM";
if((QQ_versionName>9080&&CurrentApp.equals("QQ"))||CurrentApp.equals("TIM")){
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
}else{
import com.tencent.qqnt.kernel.nativeinterface.Contact;
}
public String getLocalPath(){
    return Environment.getExternalStorageDirectory().getPath()+"/";
}
String LocalPath=getLocalPath();
String ColdRainPath=LocalPath+"Android/media/"+QQ_PackageName+"/空间Java/";//Java数据储存目录
public String LYgetPskey(String type){
    return getPskey(type);
}
String qzone="";
String docs="";
String qunpskey="";
String cltpskey="";
String vippskey="";
String qqweb="";
String tipskey="";
String tenpay="";
String tupskey="";
String ypskey="";
String mppskey="";
String skey=getSkey();
new Thread(new Runnable(){
public void run(){
while(true){
String uins=BaseApplicationImpl.getApplication().getRuntime().getCurrentUin();
if(uins.equals(myUin)){
}else{
myUin=uins;
qzone=LYgetPskey("qzone.qq.com");
docs=LYgetPskey("docs.qq.com");
qunpskey=LYgetPskey("qun.qq.com");
cltpskey=LYgetPskey("clt.qq.com");
vippskey=LYgetPskey("vip.qq.com");
qqweb=LYgetPskey("qqweb.qq.com");
tipskey=LYgetPskey("ti.qq.com");
tenpay=LYgetPskey("tenpay.com");
tupskey=LYgetPskey("tu.qq.com");
ypskey=LYgetPskey("y.qq.com");
mppskey=LYgetPskey("mp.qq.com");
skey=getSkey();
Toast("空间Java:检测到QQ已切换，已刷新用户信息");
}
}
}
}).start();

new Thread(new Runnable(){
public void run(){
while(true){
qzone=LYgetPskey("qzone.qq.com");
docs=LYgetPskey("docs.qq.com");
qunpskey=LYgetPskey("qun.qq.com");
cltpskey=LYgetPskey("clt.qq.com");
vippskey=LYgetPskey("vip.qq.com");
qqweb=LYgetPskey("qqweb.qq.com");
tipskey=LYgetPskey("ti.qq.com");
tenpay=LYgetPskey("tenpay.com");
tupskey=LYgetPskey("tu.qq.com");
ypskey=LYgetPskey("y.qq.com");
mppskey=LYgetPskey("mp.qq.com");
skey=getSkey();
Thread.sleep(10000);
}
}
}).start();
public String judge(){
String AppPath=AppPath+"";
   if(AppPath.equals("void"))
   {
      return "Serendipity";
   }
   else
   {
      return "QStory";
   }
}
//获取uid/uin
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
public String getUidFromUin(String uin)
{
    String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(uin);
return uidFromUin;
}
public String getUinFromUid(String uid)
{
    String UinFromUid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUinFromUid(uid);
return UinFromUid;
}
public String getFriendUidFromUin(String uin)
{
    String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getFriendUidFromUin(uin);
return uidFromUin;
}

public class Data{

    public final String quntext;
    public final String uin;
    public final String qun;
    public final int mtype;
    public final int msgtype;
    public final long msgid;
    public final long time;
    public final Object originMsg;
    public final Object ModuleMsg;
    public final List atList;
    public final String username;

    public void put(Object msg,String type){
    this.ModuleMsg=msg;
    try {
    if(type.equals("Serendipity")){
        this.quntext=msg.msg;
        this.uin=msg.user;
        this.qun=msg.peerUid;
        this.mtype=msg.type;
        this.msgtype=msg.msgType;
        this.msgid=msg.data.msgId;
        this.originMsg=msg.data;
        this.atList=msg.atList;
        this.time=msg.data.msgTime;
            if(msg.type==1){
            this.username=msg.data.sendNickName;
            }else{
            this.username=msg.data.sendMemberName;
        }
    }else if(type.equals("QStory")){
        this.quntext=msg.MessageContent;
        this.uin=msg.UserUin;
        this.mtype=msg.msg.chatType;
            if(msg.msg.chatType==2){
            this.qun=msg.GroupUin;
            this.username=msg.msg.sendMemberName;
            }else if(msg.msg.chatType==1){
            this.qun=msg.msg.peerUin+"";
            this.username=msg.msg.sendNickName;
            }
        this.msgtype=msg.msg.elements.get(0).elementType;
        this.msgid=msg.msg.msgId;
        this.originMsg=msg.msg;
        this.time=msg.msg.msgTime;
        this.atList=msg.mAtList;
    }else if(type.equals("OriginMsg")){
        String text="";
        if(msg==null){
        this.quntext = "";
        this.uin = "";
        this.qun = "";
        this.mtype=0;
        this.msgtype=0;
        this.originMsg=null;
        this.atList=null;
        this.msgid=0;
        this.username=null;
        this.time=0;
        }else{
            for(Object msgElement:msg.elements){
                if(msgElement.textElement!=null){
                text+=msgElement.textElement.content;
                }else if(msgElement.picElement!=null){
                text+="[图片]"+msgElement.picElement.summary;
                }else if(msgElement.pttElement!=null){
                text="[语音]"+msgElement.pttElement.md5HexStr;
                }else if(msgElement.fileElement!=null){
                text="[文件]"+msgElement.fileElement.fileMd5;
                }else if(msgElement.arkElement!=null){
                text="[应用]"+msgElement.arkElement.bytesData;
                }else if(msgElement.videoElement!=null){
                text="[视频]"+msgElement.videoElement.videoMd5;
                }else if(msgElement.replyElement!=null){
                text+="[回复]"+msgElement.replyElement.sourceMsgText+"\n";
                }else if(msgElement.avRecordElement!=null){
                text="[通话]"+msgElement.avRecordElement.text;
                }else if(msgElement.walletElement!=null){
                text="[QQ红包]"+msgElement.walletElement.receiver.title;
                }else if(msgElement.faceElement!=null){
                text+="[表情]"+msgElement.faceElement.faceText;
                }else if(msgElement.faceBubbleElement!=null){
                text="[大表情]"+msgElement.faceBubbleElement.faceSummary+" "+msgElement.faceBubbleElement.content;
            }else{
            text="";
            }
       }
        this.quntext=text;
        this.uin=getUinFromUid(""+msg.senderUid);
        this.mtype=msg.chatType;
            if(msg.chatType==2){
            this.qun=msg.peerUid+"";
            this.username=msg.sendMemberName;
            }else if(msg.chatType==1){
            this.qun=msg.peerUin+"";
            this.username=msg.sendNickName;
            }
        this.msgtype=msg.elements.get(0).elementType;
        this.msgid=msg.msgId;
        this.originMsg=msg;
        this.time=msg.msgTime;
        this.atList=null;
        }
    }
    }catch(e){
    this.quntext = "";
    this.uin = "";
    this.qun = "";
    this.mtype=0;
    this.msgtype=0;
    this.originMsg=null;
    this.atList=null;
    this.msgid=0;
    this.username=null;
    this.time=0;
    }
}

    public Data() {
    this.quntext = "";
    this.uin = "";
    this.qun = "";
    this.mtype=0;
    this.msgtype=0;
    this.originMsg=null;
    this.atList=null;
    this.msgid=0;
    this.username=null;
    this.time=0;
    }

    public String toString(){
    StringBuilder DataElement = new StringBuilder();
    DataElement.append("JavaMsgRecords{quntext=");
    DataElement.append(quntext);
    DataElement.append(",uin=");
    DataElement.append(uin);
    DataElement.append(",qun=");
    DataElement.append(qun);
    DataElement.append(",mtype=");
    DataElement.append(mtype);
    DataElement.append(",msgtype=");
    DataElement.append(msgtype);
    DataElement.append(",originMsg=");
    List originMsgList= new  ArrayList();
    originMsgList.add(originMsg);
    DataElement.append(originMsgList);
    DataElement.append(",atList=");
    DataElement.append(atList);
    DataElement.append(",msgid=");
    DataElement.append(msgid);
    DataElement.append(",username=");
    DataElement.append(username);
    DataElement.append(",time=");
    DataElement.append(time);
    DataElement.append("}");
    return DataElement.toString();
    }

}

if(judge().equals("QStory")){
    load(AppPath+"/诗.java");
    load(AppPath+"/QStory.java");
    load(AppPath+"/情.java");
    }else if(judge().equals("Serendipity")){
    loadJava(pluginPath+"诗.java");
    loadJava(pluginPath+"情.java");
}
