<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
    <meta charset="utf-8" />
    <script type="text/javascript" src="lufylegend-1.9.9.min.js"></script> 
    <script type="text/javascript" src="jquery.js"></script>
</head>



<body>
<img src="up.png" onclick="loadImage('pic.jpg')">

<button onclick="savePic()" >保存作品</button>
<button onclick="downUp()" >上下反转</button>
<button onclick="leftRight()" >左右反转</button>

<div id="mylegend">loading...</div>


<script type="text/javascript">
var loader;  

var imgData = new Array();
var imglist = {};
var layer = {};
var bitmap = {};
var imgnow;
var scaflag = 0;

var loadIndex = 0; 
var Container;
var oldx, oldy, newx, newy;
var nowobj;

var imgGraphics=[];
var paths=[];
var centx=[];
var centy=[];
var scalexx=[];
var scaleyy=[];
var rotates=[];

var whichDown=[];

 var info="[";

  var infoObj=function(){
	this.paths=paths;
	this.centx=centx;
	this.centy=centy;
	this.scalexx=scalexx;
	this.scaleyy=scaleyy;
	this.rotates=rotates;
	
	}


init(50,"mylegend",800,600,main);
//init(50,"mylegend2",800,600,main);

function savePic(){
    for(var i=0;i<loadIndex;i++){
        centx[i]=Container.getChildAt(i).x;
        centy[i]=Container.getChildAt(i).y;
        scalexx[i]=Container.getChildAt(i).scaleX;
        scaleyy[i]=Container.getChildAt(i).scaleY;
        rotates[i]=Container.getChildAt(i).rotate;
         if(i==loadIndex-1){
          info=info+"{num:"+i+",src:"+paths[i]+",x:"+centx+",y:"+centy+",scaleX:"+scalexx[i]+",scaleY:"
      +scaleyy[i]+",rotate:"+rotates[i]+"}]"; 
      }
      else{
      info=info+"{num:"+i+",src:"+paths[i]+",x:"+centx+",y:"+centy+",scaleX:"+scalexx[i]+",scaleY:"
      +scaleyy[i]+",rotate:"+rotates[i]+"},"; 
      }
     
    }
     var infoo=new infoObj();
       //console.log("==============="+info);
        
   // console.log(info);
    postSimpleData(infoo);
}
function postSimpleData( info) {

		//var string_to_json = JSON.parse(info);
		//console.log("json===="+string_to_json[0].src);
	
        $.ajax({
            type: "POST",
            url: "ggoods_ajax.action",
            contentType: "application/json", //å¿é¡»æ
            dataType: "json", //è¡¨ç¤ºè¿åå¼ç±»åï¼ä¸å¿é¡»
           // data: JSON.stringify("{list:"+info+"}"), 
             data: JSON.stringify(info), //ç¸å½äº //data: "{'str1':'foovalue', 'str2':'barvalue'}",
            success: function (jsonResult) {
           	alert(jsonResult.demoData);
               alert(JSON.stringify(jsonResult));
            },
            error:function(e) {
				alert("cucouco");
				}
        });
			console.log("_____________________"+JSON.stringify(info));
			var string='{"paths":["face.jpg","pic.jpg","pic.jpg","pic.jpg"],"centx":[300,350,469,242],"centy":[300,169,301,207],"scalexx":[1,1,1,1],"scaleyy":[1,1,1,1],"rotates":[0,0,0,0]}';
			console.log("+++++++++++++++++++"+JSON.parse(string).paths[2]);
    }
function main(){ 
    //Container是一个LSprite对象，这个对象是一个图层，把它作为最底层，其它所有的图片被各自的层包装之后放到这一层里面。
    Container = new LSprite();
    //addChild之后Container以及其上面所有的东西都能够在浏览器上显示了。
    addChild(Container);
    //给Container增加一个放开鼠标的监听器，用于图像放缩。(单个图像的监听器捕获不到在图像外鼠标移动的消息，所以要放在最外面)
    Container.addEventListener(LMouseEvent.MOUSE_UP,conup);
    //调试用，可删除。
    Container.addEventListener(LMouseEvent.MOUSE_DOWN,condown);
    //创建一个LStage，覆盖整个Container,因为Container中如果没东西的话是捕获不到鼠标消息的，加了这个就能够在任意地方捕获到了。
    Container.graphics.drawRect(5,"dimgray",[0, 0, LStage.width, LStage.height],true,"white");
    //加载图片
    loadImage("face.jpg");
}  
function loadImage(path) {
    //加载图片常规步骤
    imgnow = path;
    paths[loadIndex]=path;
    loader = new LLoader();
    //监听器，当loader.load(path,"bitmapData")完成之后自动执行loadBitmapdata函数
    loader.addEventListener(LEvent.COMPLETE,loadBitmapdata);  
    loader.load(path,"bitmapData");  
}
function loadBitmapdata(event) {
    //imglist保存图像实体，便于之后的保存画布？
    imglist[loadIndex] = loader.content;
    //显示图像的一般步骤，新建了一个LBitmap对象保存图像内容，把图像放到layer里面，每个图像和四周的小方框放在同一个层，这样操作方便一点
    var bitmapdata = new LBitmapData(loader.content);
    
    bitmap[loadIndex] = new LBitmap(bitmapdata);
    
    //console.log("bitmap[loadIndex].getWidth()="+bitmap[loadIndex].getWidth());
   
    layer[loadIndex] = new LSprite();
    //把图像的层放到Container里面，让它在浏览器里显示
    Container.addChild(layer[loadIndex]);
    //设置旋转中心为0,0（其实就是把图像的位置变了一下，使用了 ：layer的旋转中心为（0，0）这一性质）
    //是不是就是把图想坐标系原点由左顶点置为图像中心？
    //console.log("bitmap[loadIndex].x="+bitmap[loadIndex].x);
    bitmap[loadIndex].x = -bitmap[loadIndex].getWidth()*0.5;
    bitmap[loadIndex].y = -bitmap[loadIndex].getHeight()*0.5;
    //console.log("bitmap[loadIndex].x="+bitmap[loadIndex].x);
    //把图片放到layer，这样就能够显示出图片
    layer[loadIndex].addChild(bitmap[loadIndex]);


    //绘图类，画方框用

     imgGraphics[loadIndex] = new LGraphics();
    imgGraphics[loadIndex].drawRect(1,'#000000',[-bitmap[loadIndex].getHeight()*0.5,-bitmap[loadIndex].getWidth()*0.5,bitmap[loadIndex].getHeight() ,bitmap[loadIndex].getWidth()]);
    //graphics.drawRect(1,'#000000',[0,0,bitmap[loadIndex].getHeight()+5 ,bitmap[loadIndex].getWidth() + 5]);
    imgGraphics[loadIndex].drawRect(1,'#000000',[bitmap[loadIndex].getHeight()*0.5-2.5,bitmap[loadIndex].getWidth()*0.5-2.5,5,5],true,"white");
    imgGraphics[loadIndex].drawRect(1,'#000000',[bitmap[loadIndex].getHeight()*0.5-2.5,-bitmap[loadIndex].getWidth()*0.5-2.5,5,5],true,"white");
    imgGraphics[loadIndex].drawRect(1,'#000000',[-bitmap[loadIndex].getHeight()*0.5-2.5,bitmap[loadIndex].getWidth()*0.5-2.5,5,5],true,"white");
    imgGraphics[loadIndex].drawRect(1,'#000000',[-bitmap[loadIndex].getHeight()*0.5-2.5,-bitmap[loadIndex].getWidth()*0.5-2.5,5,5],true,"white");
    //graphics.drawRect(1,'#000000',[0,-bitmap[loadIndex].getWidth()*0.5-2.5,5,5],true,"white");
    imgGraphics[loadIndex].drawArc(1,'#000000',[0,-bitmap[loadIndex].getHeight()*0.5-10,5,0,2*Math.PI],true,"white");
   // backLayer.graphics.drawArc(2,"#ff0000",[100,100,50,0,2*Math.PI],true,"#888000");
    //把绘图类放到图像的同一层
   // console.log("imgGraphics[loadIndex]=111111111"+imgGraphics[loadIndex]);
   // layer[loadIndex].addChild(imgGraphics[loadIndex]);
    //layer[loadIndex].removeChild(graphics);
    //设置初始为位置,即图中心点的全局坐标初始为（300,300)
    layer[loadIndex].x = 300;
    layer[loadIndex].y = 300;
    //（调试用）
    nowobj = layer[loadIndex];
    //给每个图层增加鼠标点击和放开的监听器，处理图像放缩和旋转，最后一个参数为绑定的函数
    layer[loadIndex].addEventListener(LMouseEvent.MOUSE_DOWN,ondown);
    layer[loadIndex].addEventListener(LMouseEvent.MOUSE_UP,onup);
    //序号。
    loadIndex ++;

}
function ondown(event,object) {
   //console.log("-------------"+object.x);
    //如果Container已经有监听器了就把那个监听器删除，保证每次只有一个监听器
    if(Container.hasEventListener(LMouseEvent.MOUSE_MOVE)) {
        Container.removeEventListener(LMouseEvent.MOUSE_MOVE,onmove);
       //console.log("================");
    }
    //console.log("删除之后imgGraphics[loadIndex]="+imgGraphics[0]);

    for(var i=0;i<loadIndex;i++){
         console.log(Container.getChildAt(i));
         if(Container.getChildAt(i)==object){ 
                Container.setChildIndex(object,loadIndex-1);
                var graptemp=imgGraphics[i];
                var pathtemp=paths[i];
                for(var j=i;j<loadIndex-1;j++){
                   imgGraphics[j]=imgGraphics[j+1];
                   paths[j]=paths[j+1];
                }
                imgGraphics[loadIndex-1]=graptemp;
                paths[loadIndex-1]=pathtemp;

               

            console.log(Container.getChildAt(i));
            console.log(object);
            object.addChild(imgGraphics[loadIndex-1]);
            console.log("===========ondown_i="+i);whichDown[loadIndex-1]="ondown";
        }
    }
    //object.addChild(imgGraphics[0]);

    //console.log("object="+object.);
    //除了getWidth之类是放大的，其它是不放大的。
    //originx和originy为原始的图片的宽和长的一半
    var originx = (object.getWidth() / object.scaleX) / 2;
    var originy = (object.getHeight() / object.scaleY) / 2;
    //len1为原始图的对角线长的一半（主要是因为旋转中心是0,0，所以只取对角线一半比较）
    var len1 = Math.sqrt(originx * originx + originy * originy);
    //len2为鼠标点击位置距离0,0的长度，event.selfX是对于层的x，event.offsetX是对于Container的X,两者都不随放大而变化
    var len2 = Math.sqrt(event.selfX * event.selfX + event.selfY * event.selfY);
    //ang是图片倾斜角度,顺时针从0度到360度，和时钟一致
    var ang = - Math.atan2(event.selfX,event.selfY) / Math.PI * 180 + 180;

    //如果len1和len2足够相近，则表示目前鼠标在是四个角的其中一个，放大操作。
    if(Math.sqrt(Math.abs(len1 - len2)) < len1*0.02) {
        //放大标记
        scaflag = 1;
        //nowobj为全局对象，指操作的对象
        nowobj = object;
        //给Container增加监听器，主要是鼠标在图片外面获取不到消息，所以要放在最外层
        Container.addEventListener(LMouseEvent.MOUSE_MOVE,onmove);
    //判断鼠标是否在图片正上方那一点。（根据距离和角度判断）
    } else if(Math.abs(len2 - originy-10) < 10 && (Math.abs(object.rotate - ang) < 10||Math.abs(object.rotate - ang+360) < 10) && (((object.rotate <= 90 || object.rotate >= 270) && event.selfY < 0) || ((object.rotate >=90 && object.rotate<=270) && event.selfY > 0)))  {
        //旋转标记
        scaflag = 2;
        //全局操作对象
        nowobj = object;
        //同放大，增加一个鼠标移动监听器
        Container.addEventListener(LMouseEvent.MOUSE_MOVE,onmove);
    } else {
        //没有操作，纯拖动
        scaflag = 0;
        //把当前点击的对象弄到顶层

    //     for(var i=0;i<loadIndex;i++){
    //      //console.log(Container.getChildAt(i));
    //      if(Container.getChildAt(i)==object){ 
    //         var temp=imgGraphics[0];
    //         imgGraphics[0]=imgGraphics[i];
    //         imgGraphics[i]=temp;
    //         console.log("=====================================");
    //     }
    // }
    //     Container.setChildIndex(object, 0);
       // var temp=imgGraphics[0]
        //使对象能拖动
        object.startDrag(object.touchPointID);
    }

}

function onmove(event, object) {
    //console.log(scaflag);
    if(scaflag == 1) {
        //console.log("nowobj.x="+nowobj.x);
        //nowobj.x表示图片中心点的绝对坐标，根据图片中心点，倾斜角和高度的一般来计算图片正上方的那个点，坐标为（nowx,nowy）
        //因为有一个是负的，所以nowy要用减号
        var nowx = nowobj.x + nowobj.getHeight()/nowobj.scaleY/2 * Math.sin(nowobj.rotate/180*Math.PI);
        var nowy = nowobj.y - nowobj.getHeight()/nowobj.scaleY/2 * Math.cos(nowobj.rotate/180*Math.PI);
        //DistanceToLine有三个参数，按顺序分别为P,A,B,返回点P到直线AB的距离
        var lenx = DistanceToLine({x:event.offsetX,y:event.offsetY},{x:nowobj.x,y:nowobj.y},{x:nowx,y:nowy});
        //根据lenx和宽度一般来推算放大倍数，X和Y放大倍数一致。（如果不一致会出现坐标不准的现象，应该是bug）
        nowobj.scaleX = lenx / (nowobj.getWidth() / nowobj.scaleX / 2) ;
        nowobj.scaleY = lenx / (nowobj.getWidth() / nowobj.scaleX / 2) ;
        
    } else if(scaflag == 2) {
        //根据鼠标和图片中心计算倾斜角。offsetx是鼠标绝对坐标，nowobj.x是图片中心绝对坐标，ang为角度
        var ang = - Math.atan2(event.offsetX - nowobj.x,event.offsetY - nowobj.y) / Math.PI * 180 + 180;
        //设置图片偏移角
        nowobj.rotate = ang;
       // console.log("ang="+ang);
    }
    
}

function onup(event,object) {
    //消除标记
    scaflag = 0;
    //去除Container监听器
    if(Container.hasEventListener(LMouseEvent.MOUSE_MOVE)) {
        Container.removeEventListener(LMouseEvent.MOUSE_MOVE,onmove);
    }
    // if(Container.hasEventListener(LMouseEvent.MOUSE_MOVE)) {
    //     Container.removeEventListener(LMouseEvent.MOUSE_UP,conup);
    //     //console.log("执行onup");
    // }
    //object.removeEventListener(LMouseEvent.MOUSE_MOVE,onmove);
    //停止可拖动状态
    object.stopDrag();
}

function conup(event,object) {
    scaflag = 0;
    // if(object.getChildAt(0).hasEventListener(LMouseEvent.MOUSE_UP)){
    //     console.log("11111111");
    //     }
    // console.log("执行conup");
    //去除监听器
    if(Container.hasEventListener(LMouseEvent.MOUSE_MOVE)) {
        Container.removeEventListener(LMouseEvent.MOUSE_MOVE,onmove);
    }

    
    for(var i=0;i<loadIndex;i++){
        if(whichDown[i]=="ondown"){whichDown[i]=null; console.log("i="+i+"ondown")}
        else{ object.getChildAt(i).removeChild(imgGraphics[i]); console.log("i="+i+"删除矩形");
    }
       
       
    }
    
    //console.log(object.getChildAt(0)+"=====");
   // console.log("loadIndex="+loadIndex);
   // console.log("imgGraphics[loadIndex]="+imgGraphics[0]);
}

function condown(event,object) {
    //调试用
   // console.log("鼠标点击的全局坐标="+event.offsetX,event.offsetY);
    //removeChild(object.getChildAt(0).getChildAt(1));
    // alert("1111");
    // var aa;//aa未某个值
    // document.form1.hide.value="11";
    // alert("222");
    // document.form1.hide.value="hello";
    //console.log("===============pricktype_org"+pricktype_org);

}
//叉积
function Cross(A, B) {
    return A.x*B.y - A.y*B.x;
}
//点积
function Dot(A) {
    return A.x * A.x + A.y * A.y;
}
//length
function Length(A) {
    return Math.sqrt(Dot(A));
}
//点到直线距离，P到直线AB距离
function DistanceToLine(P, A, B) {
    var v1 = {x:B.x-A.x, y:B.y-A.y};
    var v2 = {x:P.x-A.x, y:P.y-A.y};
    return Math.abs(Cross(v1,v2)) / Length(v1);
}



</script>

    
</body>
</html>