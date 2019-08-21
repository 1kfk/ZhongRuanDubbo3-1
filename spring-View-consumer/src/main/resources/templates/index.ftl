<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户管理</title>
<script src="jquery.min.js"></script>
<script src="jquery.EASING.1.3.js"></script>
<style type="text/css">
    table
        {
            border-collapse: collapse;
            margin: 0 auto;
            text-align: center;
        }
        table td, table th
        {
            border: 1px solid #cad9ea;
            color: #666;
            height: 30px;
        }
        table thead th
        {
            background-color: #CCE8EB;
            width: 100px;
        }
        table tr:nth-child(odd)
        {
            background: #fff;
        }
        table tr:nth-child(even)
        {
            background: #F5FAFA;
        }
        .leftd{
        margin:auto;
        width:50%;
        }
        a{
        width:100px;
        display:inline-block;
        border:1px solid red;
        border-radius:3px;
        margin-left:5px;
        color:white;
        text-decoration:none;
        background-color: red;
        text-align: center;
        }
    </style>
</head>
<body>

<div id="leftd" class="leftd">
<p align="center" style="margin: 0 auto;">用户管理</p>
<form action="view" style="position: absolute;">
<input type="text" id="findmeision" name="find">
<input type="submit" value="查找" style="background-color: red;color:white;">
</form>
<a style="margin-left: 200px;" href="javascript:void(0)" onclick="adduser()">增加</a>
<a style="margin-left: 400px;position: absolute;" href="http://127.0.0.1:9090/logout">退出登录</a>
<table width="99%" class="table" style="">
	<tr>
		<th>ID</th>
		<th>用户名</th>
		<th>密码</th>
		<th>操作</th>
	</tr>
	<#list userList as users>
		<tr>
			<td>${users.id }</td>
			<td>${users.username }</td>
			<td>${users.password }</td>
			<td><a href="javascript:void(0)" 
			onclick="edituser('${users.id}','${users.username }','${users.password }')">修改</a>
			<a href="javascript:void(0)" onclick="deleteuser(${users.id},'${users.username}')">删除</a></td>
		</tr>
	</#list>
</table>
</div>

<div id="form2" style="display:none;width:400px;height: 100px;background-color: white;position: absolute;border: 1px solid black;top:300px; left:45%;">
<form action="http://127.0.0.1:8330/add" style="position: absolute;">
<input id="id2" type="text" name="id" value=0 style="display:none;">
用户名<input id="username2" size="50" type="text" name="username"><br>
密码<input id="password2" size="50" type="text" name="password"><br>
<input type="submit" value="提交">
<input id="b2" type="button" value="取消">
</form>
</div>

<div id="form1" style="display:none;width:400px;height: 100px;background-color: white;position: absolute;border: 1px solid black;top:300px; left:45%;">
<form action="http://127.0.0.1:8330/up" style="position: absolute;">
<input id="id1" type="text" name="id" style="display:none;">
用户名<input id="username1" size="50" type="text" name="username"><br>
密码<input id="password1" size="50" type="text" name="password"><br>
<input type="submit" value="提交">
<input id="b1" type="button" value="取消">
</form>
</div>

<script type="text/javascript">
function adduser(){
	$("#form2").css("display","block");
}
function edituser(id,username,password){
	$("#id1").attr("value",id);
	$("#username1").attr("value",username);
	$("#password1").attr("value",password);
	$("#form1").css("display","block");
}
function deleteuser(id,username){
	if (confirm("确认要删除用户"+username+"吗?")) {
		var htmlObj = $.ajax({
			url : "http://127.0.0.1:8330/del/"+id+"/"+username,
			type : "get",
			async : false,
			/* data : {placename:place} */
		});
	}
		 /* var text = htmlObj.responseText;
		 console.log(text);
		var json = JSON.parse(text);
		 var msg = json.msg; */
	window.location.reload();
}
$("#b1").click(function(){
	$("#form1").css("display","none");
});
$("#b2").click(function(){
	$("#form2").css("display","none");
});
</script>
</body>
</html>