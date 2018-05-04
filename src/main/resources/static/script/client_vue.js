
var PrintOrder= function (str)
{
	var bodyHtml = document.body.innerHTML;
	document.body.innerHTML=str;
	window.print();
	document.body.innerHTML = bodyHtml;

}


var clear=function(str)
{
	str = str.replace(/,/g, "");//取消字符串中出现的所有逗号 
	str=parseInt(str);
	return str; 

};

/**
 * 全局变量
 */
var aid =clear($("#userId").val());

/**
 * 余额
 */

var ba =new Vue({
	
	el:"#balancetForm",
	data:{
		account:
		{
			aid:aid,
			money:""
		}
	},
	methods:{
		selectBalance:function()
		{
			var app=this;
			
			
            
			$.ajax({
				
				type:"GET",
				url:"/account/info/"+aid,
				success:function(data)
				{
					
					if(data.code==0)
					{
						app.account.money=data.account.money;
						
	
					}
					else
					{
						layer.msg("查询余额失败",{icon:2});
					}
				}
				
			});
		}
	}
	
});
/**
 * 存款的Vue
 */
var de=new Vue({
	el:"#depositstForm",
	data:{
		deposit:{	
		aid:aid,
		saveMoney:"",
		saveTime:""
		}
		
	},
	methods:{
		
		judgeDeposit:function()
		{
			var app =this;
			var money =app.deposit.saveMoney;
			
			
		},
		
		submitDepositst:function()
		{
			
			var app =this;
			app.deposit.saveTime=de.getSavetime;
			layer.confirm('你确定要存款？',{btn:['确定','取消']},
			function ()
			{
				layer.closeAll('dialog');
				$.ajax({
					url:"/deposit/save",
					type:"POST",
					data:JSON.stringify(app.deposit),
				    contentType:"application/json;chartset=utf-8",
				    dataType:"json",
				    success:function(data)
				    {
				    	if(data.code==0)
				    	{
				    		layer.msg("存款成功",{icon:1});
				    	}
				    	else
				    	{
				    		layer.msg(data.msg,{icon:2});
				    	}
				    }

				});
				
			}
			)

		},
		printDepositst:function()
		{
			var app =this;
			var str ="当前你的账号："+app.deposit.aid+"<br/>存款金额：￥"+app.deposit.saveMoney+"<br/>存款时间："+app.deposit.saveTime;
			PrintOrder(str);
		},
		clickDepositst:function()
		{
			var tbody="";
			$("#depositstRecord").html("");
			$.ajax({
				type:"GET",
				url:"/deposit/listTop/"+aid,
				success:function (data)
				{
					i=0;
					var app =data.lists;
					
					 tbody="<tr><td>存款编号&nbsp;&nbsp;&nbsp;</td><td >存款金额&nbsp;&nbsp;&nbsp;</td><td >存款时间 </td></tr>";
					
					$.each(app,function(n,value)
					{
						
						var trs="";
						i++;
						trs+="<tr><td>"+i+"</td><td>￥"+value.saveMoney+"</td><td>"+moment(value.saveTime).format('YYYY-MM-DD HH:mm:ss')+"</td></tr>";
			         	tbody+=trs;
					});
					$("#depositstRecord").append(tbody);
					tbody="";
				}
			})
		}
	},
	computed:{
		
		getSavetime:function()
		{
			var time = moment().format('YYYY-MM-DD HH:mm:ss');
			//console.log(time);
			return time;
			
		}
	}
	
});

/**
 * 取款
 */
var wi=new Vue({
	el:"#withdrawtForm",
	data:{
		withdraw:{	
		aid:aid,
		takeMoney:"",
		takeTime:""
		}
		
	},
	methods:{
		submitWithdraw:function()
		{
			
			var app =this;
			app.withdraw.takeTime =wi.getTaketime;
			console.log(app.withdraw);
			layer.confirm('你确定要取款？',{btn:['确定','取消']},
			function ()
			{
						layer.closeAll('dialog');
			$.ajax({
				url:"/withdraw/save",
				type:"POST",				
			    contentType:"application/json",	
			    data:JSON.stringify(app.withdraw),
			    success:function(data)
			    {
			    	
			    	if(data.code==0)
			    	{
			    		layer.msg("取款成功",{icon:1});
			    	}
			    	else
			    	{
			    		
			    		layer.msg(data.msg,{icon:2});
			    	}
			    }

			});
					}
			)
		},
		printWithdraw:function()
		{
			var app =this;
			var str ="当前你的账号："+app.withdraw.aid+"<br/>取款金额：￥"+app.withdraw.takeMoney+"<br/>取款时间："+app.withdraw.takeTime;
			PrintOrder(str);
		},
		clickWithdraw:function()
		{
			var tbody="";
			$("#withdrawRecord").html("");
			$.ajax({
				type:"GET",
				url:"/withdraw/listTop/"+aid,
				success:function (data)
				{
					i=0;
					var app =data.lists;
					
					
					 tbody="<tr><td>取款编号&nbsp;&nbsp;&nbsp;</td><td >取款金额&nbsp;&nbsp;&nbsp;</td><td >取款时间 </td></tr>";
					
					$.each(app,function(n,value)
					{
						
						var trs="";
						i++;
						trs+="<tr><td>"+i+"</td><td>￥"+value.takeMoney+"</td><td>"+moment(value.takeTime).format('YYYY-MM-DD HH:mm:ss')+"</td></tr>";
			         	tbody+=trs;
					});
					$("#withdrawRecord").append(tbody);
				
					
				}
			})
		}
	},
	computed:{
		getTaketime:function()
		{
			var time = moment().format('YYYY-MM-DD HH:mm:ss');
			//console.log(time);
			return time;
			
		}
	}
});


/**
 * 修改密码
 */
var pa=new Vue({
	
	el:"#passwordtForm",
	data:{
		account:{
			aid:aid,
			password:""
		}
	},
	methods:{
		updatePassword:function()
		{
			var app =this;
			layer.confirm('你确定要修改密码？',{btn:['确定','取消']},
			function ()
			{
				layer.closeAll('dialog');
			$.ajax({
				url:"/account/update",
				type:"POST",
				data:JSON.stringify(app.account),
			    contentType:"application/json;chartset=utf-8",
			    dataType:"json",
			    success:function(data)
			    {
			    	if(data.code==0)
			    	{
			    		layer.msg("修改密码成功",{icon:1});
			    	}
			    	else
			    	{
			    		layer.msg(data.msg,{icon:2});
			    	}
			    }

			});
			})
		}
	}
});

var tran =new Vue({
	
	el:"#transfertForm",
	data:{
		transfer:{
			senderid:aid,
			receiverid:"",
			transferMoney:"",
			transferTime:""
		}
	},
	methods:{
		submitTransfer:function()
		{
			var app =this;
			app.transfer.transferTime = tran.getTransferTime;
			
			layer.confirm('你确定要转账？',{btn:['确定','取消']},
			function ()
			{
			layer.closeAll('dialog');
			$.ajax({
				type:"post",
				url:"/transfer/toTransfer",
				data:JSON.stringify(app.transfer),
				contentType:"application/json;chartset=utf-8",
				dataType:"json",
				success:function(data)
				{
					if(data.code==0)
			    	{
			    		layer.msg("转账成功",{icon:1});
			    	}
			    	else
			    	{
			    		layer.msg(data.msg,{icon:2});
			    	}
				}
			});
			})
		},
		printTransfer:function ()
		{
			var app =this;
			var str ="当前你的账号："+app.transfer.senderid+"<br/>转账金额：￥"+app.transfer.transferMoney+"<br/>接收账号："+app.transfer.receiverid+"<br/>转账时间："+app.transfer.transferTime;
			PrintOrder(str);
		},
		clickTransfer:function ()
		{
			var tbody="";
			$("#transferRecord").html("");
			$.ajax({
				type:"GET",
				url:"/transfer/listTop/"+aid,
				success:function (data)
				{
					i=0;
					var app =data.lists;
					
					
					 tbody="<tr><td>转账编号&nbsp;&nbsp;&nbsp;</td><td>接收账号&nbsp;&nbsp;&nbsp;</td><td >&nbsp;&nbsp;&nbsp;转账金额&nbsp;&nbsp;&nbsp;</td><td >转账时间 </td></tr>";
					
					$.each(app,function(n,value)
					{
						
						var trs="";
						i++;
						trs+="<tr><td>"+i+"</td><td>"+value.receiverid+"</td><td>"+"</td><td>￥"+value.transferMoney+"</td><td>"+moment(value.transferTime).format('YYYY-MM-DD HH:mm:ss')+"</td></tr>";
			         	tbody+=trs;
					});
					$("#transferRecord").append(tbody);
				
					
				}
			})
		}
	},
	computed:{
		getTransferTime:function()
		{
			var time = moment().format('YYYY-MM-DD HH:mm:ss');
			//console.log(time);
			return time;
			
		}
	}
	
	
});


/**
 * 加载个人信息的Vue
 */
var info =new Vue({
	
	el:"#informationtForm",
	data:{
		age:"",
		account:{
			aid:aid,
			creditLevel:"",
			integral:"",
			user:{
				username:"",
				birth:"",
			    identityCard:""
			   
			}
			
		}
	},
	computed:{
		
		
		
		
	},
	created:function(){
		// 创建实例时获取未读消息
		this.getPersonInfo();
	},
	methods:{
		getPersonInfo:function()
		{
			var app=this;
            
			$.ajax({
				
				type:"GET",
				url:"/account/info/"+aid,
				success:function(data)
				{
					if(data.code==0)
					{
						app.account=data.account;
						
						
						//this.account =data.account;
						//this.account.creditLevel=data.account.creditLevel;
						app.age=info.getAge(data.account.user.birth);
					}
					else
					{
						layer.msg("加载个人信息失败",{icon:2});
					}
				}
				
			});
		},
		
		getAge:function(str1)
		{
			  var str =new Date(str1);
			  str=str.getFullYear() + '-' + (str.getMonth() + 1) + '-' + str.getDate();
			  //console.log(str);
			   var   r   =   str.match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/);     
		        if(r==null)return   false;     
		        var   d=   new   Date(r[1],   r[3]-1,   r[4]);     
		        if   (d.getFullYear()==r[1]&&(d.getMonth()+1)==r[3]&&d.getDate()==r[4])   
		        {   
		              var   Y   =   new   Date().getFullYear();   
		              return((Y-r[1]));   
		        }   
		        return("输入的日期格式错误！");   
		}
		
	}
	
});




/*var vm2=new Vue({
	el:"#withdrawtForm",
	data:{
		aid:"",
		takeMoney:"",
		takeTime:""
		
	},
	methods:{
		submitWithdrawt:function()
		{
			var take_money={
				"aid":aid,
				"takeMoney":takeMoney,
				"takeTime":takeTime
			};
			
			$.ajax({
				url:"",
				type:"post",
				data:take_money,
			    contentType:"application/json;chartset=utf-8",
			    dataType:"json",
			    success:function(data)
			    {
			    	
			    }

			})
		}
	},
	computed:{
		
		saveTime:function()
		{
			return new Date();
		}
	}
	
})*/