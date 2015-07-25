<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
    <meta charset="utf-8" />
    <script type="text/javascript" src="lufylegend-1.9.9.min.js"></script> 
     <!--   bootstrap -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>index</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css">
 
    <!-- 可选的Bootstrap主题文件（一般不用引入） -->
    <!-- <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap-theme.min.css"> -->
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="http://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <!-- Custom styles for this template -->
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<img src="up.png" onclick="loadImage('up.png')">

<button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-lg" onclick="cut_canvas_init()">Large modal</button>

<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
      </div>
      <img src="up.png" onclick="canvas_restore()">
      <img src="up.png" onclick="convertCanvasToImage()">
      <div class="modal-body">
        
        <canvas id="myCanvas" width="240" height="240">
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" onclick="load_url()">Save changes</button>
      </div>
    </div>
  </div>
</div>

<button onclick="savePic()" >保存作品</button>
<button onclick="downUp()" >上下反转</button>
<button onclick="leftRight()" >左右反转</button>
<button onclick="deletePic()" >删除</button>
<button onclick="copyPic()" >复制</button>
<button onclick="repeal()" >撤销</button>
<div id="mylegend">loading...</div>


<script type="text/JavaScript">
var start = {x:0,y:0};
var oldp = {x:0,y:0};
var nowp = {x:0,y:0};
var points=[];
var point_pos = 0;
var c, ctx, img;
var is_on = 0;
var is_first = 0;
var url;
function canvas_restore() {
    ctx.restore();
    ctx.save();
    ctx.clearRect(0,0,400,400);
    is_on = 0;
    point_pos = 0;
    img = new Image();
    img.src = "face.jpg";
    ctx.drawImage(img,10,10);

}

function load_url() {
    url = ctx.canvas.toDataURL("image/png");
    loadImage(url);
}

function convertCanvasToImage() {
    //var image = new Image();
    //image.crossOrigin = '';
    url = ctx.canvas.toDataURL("image/png");
    console.log(url);
    window.open(url);  
}

function cut_canvas_init() {
    c=document.getElementById("myCanvas");
    ctx=c.getContext("2d");
    if(is_first == 0) {
        is_first ++;
        console.log(111);
        ctx.save();
    } else {
        console.log(222);
        ctx.restore();
        ctx.save();
    }
    ctx.clearRect(0,0,400,400);
    is_on = 0;
    point_pos = 0;
    img = new Image();
    //img.crossOrigin = '';
    //img.crossOrigin = "Anonymous";
    img.src = "face.jpg";
    ctx.drawImage(img,10,10);
    console.log("init");

    c.addEventListener("mousedown", doMouseDown, false);
    //
}

function doMouseMove(event) {
    //console.log(points);
    ctx.clearRect(0,0,400,400);
    img.src = "face.jpg";
    ctx.drawImage(img,10,10);
    nowp.x = event.offsetX; nowp.y = event.offsetY;
    points[point_pos] = nowp;
    ctx.beginPath();
    ctx.lineWidth="5";
    ctx.strokeStyle="red"; // 红色路径
    ctx.moveTo(points[0].x,points[0].y);
    for(var i = 1; i <= point_pos; i = i + 1) {
        //console.log(i);
        ctx.lineTo(points[i].x, points[i].y);
        //console.log(points[i].x   + " +" + points[i].y);
        //ctx.stroke();
        //ctx.moveTo(points[i].x,points[i].y);
    }
    ctx.stroke();
}

function doMouseDown(event) {

    if(is_on == 0) {
        is_on = 1;
        point_pos = 0;
        // ctx.beginPath();
        // ctx.lineWidth="5";
        // ctx.strokeStyle="red"; // 红色路径
        // ctx.moveTo(event.offsetX,event.offsetY);
        start.x = event.offsetX;
        start.y = event.offsetY;
        oldp.x = start.x;
        oldp.y = start.y;
        points[point_pos ++] = start;
        //c.addEventListener("mousedown", doMouseDown, false);
        c.addEventListener("mousemove", doMouseMove, true);

    } else {
        if(Math.abs(event.offsetX - start.x) < 10 && Math.abs(event.offsetY - start.y) < 10) {
            c.removeEventListener("mousemove", doMouseMove, true);
            ctx.clearRect(0,0,400,400);
            nowp.x = event.offsetX; nowp.y = event.offsetY;
            points[point_pos] = nowp;
            ctx.beginPath();
            ctx.lineWidth="5";
            ctx.strokeStyle="white"; // 红色路径
            ctx.moveTo(points[0].x,points[0].y);
            for(var i = 1; i <= point_pos; i = i + 1) {
                //console.log(i);
                ctx.lineTo(points[i].x, points[i].y);
                //console.log(points[i].x   + " +" + points[i].y);
                //ctx.stroke();
                //ctx.moveTo(points[i].x,points[i].y);
            }
            ctx.stroke();
            ctx.clip();
            //ctx.width = 200;
            //ctx.height = 200;


            //ctx.clearRect(0,0,400,400);
            img.src = "face.jpg";
            ctx.drawImage(img,10,10);
            //document.getElementById("myCanvas").width /=2;document.getElementById("myCanvas").height /=2;

            //ctx.fillStyle="green";
            //ctx.fillRect(0,0,400,400);
            is_on = 0;
            return ;
        }
        //oldp.x = event.offsetX;
        //oldp.y = event.offsetY;
        //console.log(event.offsetX + "    " + event.offsetY);
        points[point_pos ++] = {x:event.offsetX,y:event.offsetY};

        /*ctx.lineTo(event.offsetX,event.offsetY);
        ctx.stroke();
        oldp.x = event.offsetX;
        oldp.y = event.offsetY;*/
    }
}

</script>

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


//实现撤销
var vernier=0;//整体状态游标
var record=[];
for(var i=0;i<50;i++){

    record[i]=[];
    
}
var recordObj=function(centx,centy,scaleX,scaleY,rotate,visible){
    this.centx=centx;
    this.centy=centy;
    this.scaleX=scaleX;
    this.scaleY=scaleY;
    this.rotate=rotate;
    this.visible=visible;
}

//保存作品
  
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
            //console.log("_____________________"+JSON.stringify(info));
            var string='{"paths":["face.jpg","pic.jpg","pic.jpg","pic.jpg"],"centx":[300,350,469,242],"centy":[300,169,301,207],"scalexx":[1,1,1,1],"scaleyy":[1,1,1,1],"rotates":[0,0,0,0]}';
            //console.log("+++++++++++++++++++"+JSON.parse(string).paths[2]);
    }
function main(){ 
    //console.log(record);
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
    imgGraphics[loadIndex].drawRect(1,'#000000',[-bitmap[loadIndex].getWidth()*0.5,-bitmap[loadIndex].getHeight()*0.5,bitmap[loadIndex].getWidth() ,bitmap[loadIndex].getHeight()]);
    //graphics.drawRect(1,'#000000',[0,0,bitmap[loadIndex].getHeight()+5 ,bitmap[loadIndex].getWidth() + 5]);
    imgGraphics[loadIndex].drawRect(1,'#000000',[bitmap[loadIndex].getWidth()*0.5-2.5,bitmap[loadIndex].getHeight()*0.5-2.5,5,5],true,"white");
    imgGraphics[loadIndex].drawRect(1,'#000000',[bitmap[loadIndex].getWidth()*0.5-2.5,-bitmap[loadIndex].getHeight()*0.5-2.5,5,5],true,"white");
    imgGraphics[loadIndex].drawRect(1,'#000000',[-bitmap[loadIndex].getWidth()*0.5-2.5,bitmap[loadIndex].getHeight()*0.5-2.5,5,5],true,"white");
    imgGraphics[loadIndex].drawRect(1,'#000000',[-bitmap[loadIndex].getWidth()*0.5-2.5,-bitmap[loadIndex].getHeight()*0.5-2.5,5,5],true,"white");
    //graphics.drawRect(1,'#000000',[0,-bitmap[loadIndex].getWidth()*0.5-2.5,5,5],true,"white");
    imgGraphics[loadIndex].drawArc(1,'#000000',[0,-bitmap[loadIndex].getWidth()*0.5-10,5,0,2*Math.PI],true,"white");
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
    nowobj=layer[loadIndex];
    //保存图一开始的状态
     loadIndex ++;
    /*for(var i=0;i<loadIndex;i++){
    var obj=new recordObj(layer[i].x,layer[i].y,layer[i].scaleX,layer[i].scaleY,layer[i].rotate,layer[i].visible);
        record[vernier].push(obj);
    }*/
    for(var i=0;i<loadIndex;i++){
    var obj=new recordObj(Container.getChildAt(i).x,Container.getChildAt(i).y,Container.getChildAt(i).scaleX,Container.getChildAt(i).scaleY,Container.getChildAt(i).rotate,Container.getChildAt(i).visible);
        record[vernier].push(obj);
    }
   // console.log(record[loadIndex][0])+"///////////////////";
   
    vernier++;

}
function ondown(event,object) {
  // console.log("-------------"+object);
    //如果Container已经有监听器了就把那个监听器删除，保证每次只有一个监听器
    if(Container.hasEventListener(LMouseEvent.MOUSE_MOVE)) {
        Container.removeEventListener(LMouseEvent.MOUSE_MOVE,onmove);
       //console.log("================");
    }
    nowobj = object;
    //console.log("删除之后imgGraphics[loadIndex]="+imgGraphics[0]);
    //console.log(record);
    for(var i=0;i<loadIndex;i++){
         //console.log(Container.getChildAt(i));
         if(Container.getChildAt(i)==object){ 
                Container.setChildIndex(object,loadIndex-1);
                var graptemp=imgGraphics[i];
                var pathtemp=paths[i];
               // var recordtemp=record[i];
                for(var j=i;j<loadIndex-1;j++){
                   imgGraphics[j]=imgGraphics[j+1];
                   paths[j]=paths[j+1];
                  //record[j]=record[j+1];
                }
                imgGraphics[loadIndex-1]=graptemp;
                paths[loadIndex-1]=pathtemp;

                // //record[loadIndex-1]=recordtemp;
                for(var a=0;a<vernier;a++){
                     var recordtemp=record[a][i];
                   
                    for(var b=i;b<loadIndex-1;b++){
                        record[a][b]=record[a][b+1];
                    }
                    record[a][loadIndex-1]=recordtemp;
                }

               

            //console.log(Container.getChildAt(i));
            //console.log(object);
            object.addChild(imgGraphics[loadIndex-1]);
            //console.log("===========ondown_i="+i);
            whichDown[loadIndex-1]="ondown";
        }
    }
    //console.log(record);
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
    //console.log("onup");
    scaflag = 0;
    //去除Container监听器
    if(Container.hasEventListener(LMouseEvent.MOUSE_MOVE)) {
        Container.removeEventListener(LMouseEvent.MOUSE_MOVE,onmove);

    }

    if(Container == object) {
        console.log("TRUE");
    }
    // if(Container.hasEventListener(LMouseEvent.MOUSE_MOVE)) {
    //     Container.removeEventListener(LMouseEvent.MOUSE_UP,conup);
    //     //console.log("执行onup");
    // }
    //object.removeEventListener(LMouseEvent.MOUSE_MOVE,onmove);
    //停止可拖动状态

    for(var i=0;i<loadIndex;i++){
        var obj=new recordObj(Container.getChildAt(i).x,Container.getChildAt(i).y,Container.getChildAt(i).scaleX,Container.getChildAt(i).scaleY,Container.getChildAt(i).rotate,Container.getChildAt(i).visible);
            record[vernier].push(obj);
        }
       // console.log(record[loadIndex][0])+"///////////////////";
       
        vernier++;
     

     // for(var i=0;i<loadIndex;i++){
        
     //     if(Container.getChildAt(i)==object){ 

     //     // var obj=new recordObj(object.x,object.y,object.scaleX,object.scaleY,object.rotate,object.visible);
     //     // record[i].push(obj);
     //        }

     //    }
    object.stopDrag();
}

function conup(event,object) {
    //console.log("conup");
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
        else{ object.getChildAt(i).removeChild(imgGraphics[i]); console.log("i="+i+"删除矩形");}
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
    //console.log(record);
    //console.log("==="+vernier);
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
function downUp(){
    nowobj.rotate += 180;
	 for(var i=0;i<loadIndex;i++){
        
         if(Container.getChildAt(i)==nowobj){ 

         // var obj=new recordObj(nowobj.x,nowobj.y,nowobj.scaleX,nowobj.scaleY,nowobj.rotate,nowobj.visible);
         // record[i].push(obj);
            }

        }
}
function leftRight(){

    nowobj.scaleX*=-1;
	for(var i=0;i<loadIndex;i++){
        
         if(Container.getChildAt(i)==nowobj){ 

         // var obj=new recordObj(nowobj.x,nowobj.y,nowobj.scaleX,nowobj.scaleY,nowobj.rotate,nowobj.visible);
         // record[i].push(obj);
            }

        }
}
function deletePic () {

   //Container.removeChild(nowobj);
   //console.log(nowobj);
   nowobj.visible=false;
   for(var i=0;i<loadIndex;i++){
        
         if(Container.getChildAt(i)==nowobj){ 

         // var obj=new recordObj(nowobj.x,nowobj.y,nowobj.scaleX,nowobj.scaleY,nowobj.rotate,nowobj.visible);
         // record[i].push(obj);
            }

        }
}
function copyPic(){
    //console.log(nowobj);
    var srcP;
     for(var i=0;i<loadIndex;i++){
        
         if(Container.getChildAt(i)==nowobj){ 
                srcP=paths[i];}
            }
            loadImage(srcP);
}

//var posi=-2;
function repeal(){
    // console.log(nowobj.getChildAt(0).x);
    // console.log(nowobj.x+"qian");
    // nowobj.x=333;
   //console.log(nowobj.x);
   // if(posi==0){return;}
   // if(posi==-2){posi=vernier-1;}
   // posi--;
   // console.log("posi="+posi);
   // console.log("vernier="+vernier);
   //console.log(record[posi][0][0].centx);
   //console.log(record.length);

    //console.log("vernier="+vernier);
   //console.log("record.length="+record.length);
   //console.log(record);
   //console.log(record[0][0][0].centx);
   console.log("vernier == " + vernier);
   if(vernier>=2){
     for(var i=0;i<loadIndex;i++){
            if(record[vernier-2][i] == undefined){
                console.log("=================="+i);
                
                Container.removeChild(Container.getChildAt(i));
                
                 // vernier--;
                 // record.splice(vernier,1);
                 imgGraphics.splice(i,1);
                 paths.splice(i,1);
                //return;

                for(var a = 0;a < vernier-2;++a) {
                    //record[vernier-2][a] = record[vernier-2][a+1];
                    record[a].splice(i,1);
                }
                loadIndex--;
                break;
            }
            else{
                if(record[vernier-2][i].visible == false) {
                    console.log("yingcang");
                }
                // console.log(record[vernier-2].length);
                // console.log("i="+i);
                Container.getChildAt(i).x=record[vernier-2][i].centx;
                //console.log(nowobj.x+"================")
                Container.getChildAt(i).y=record[vernier-2][i].centy;
                Container.getChildAt(i).scaleX=record[vernier-2][i].scaleX;
                Container.getChildAt(i).scaleY=record[vernier-2][i].scaleY;
                Container.getChildAt(i).visible=record[vernier-2][i].visible;
                Container.getChildAt(i).rotate=record[vernier-2][i].rotate;
               // record.pop();
                 //onsole.log(record[i][0].centx+"================")
                
            }
        
        }
        vernier--;
        record.splice(vernier,1);
        
     }
}

</script>

     <script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>
   
</body>
</html>
