var vm = new Vue({
	el: "#loginForm",
	data: {
		account: {
			aid: "",
			password: ""
		}
	},
	methods: {
		signIn: function() {
			console.log("=======================");
			console.log(vm.account.aid);
			$("#loginForm").bootstrapValidator('validate');
			if($("#loginForm").data('bootstrapValidator').isValid()) 
			{
				$.ajax({
					type: "POST",
					url: "/Sign_in",
					contentType: "application/json",
					data: JSON.stringify(vm.account),
					success: function(data) {
						if(data.code == 0)
							
							window.location.href = '/home';
						else {

							layer.msg(data.msg, { icon: 2 });
						}
					}
				});
			}

		}
	}
});

/*var vm1 = new Vue({
	el: "#register",
	data: {
		ite:"",
		cards:[],
		account: {
			cardid: "",
			password: "",
			user: {
				username: "",
				identityCard: "",
				sex: "",
				birth: "",
				address:"",
				phone: ""
			}
		}
	},
	created:function()
	{
		var _self=this;
		_self.getCards();
		
	},
	watch:{
		ite:function(val){ 
		
			this.getL();
		}
	},
	computed:{
		
		
		
	},
	methods: {
		
		indexSelect:function(event)
		{
			this.account.cardid=event.target.value;//获取value的值
			
		},
		
		getCards:function()
		{
			var _self=this;
			$.ajax({
				type:"POST",
				url:"/listCard",
				//contentType: "application/json",
				dataType:"json",
				success:function(data)
				{
					_self.cards=data;
				},
				error:function(data)
				{
					layer.msg("加载卡类型失败", { icon: 2});
				}

			});
		},
		submitRegister: function() {
            
			var app=this;
			console.log("=======================");
			$("#registerForm").bootstrapValidator('validate');
			if($("#registerForm").data('bootstrapValidator').isValid()) 
			{
				
				
				$.ajax({
					type: "POST",
					url: "/saveAccount",
					contentType: "application/json",
					data: JSON.stringify(vm1.account),
					success: function(data) {
						if(data.code == 0) {

							layer.msg("注册成功", { icon: 1});
							window.location.href = '/login.jhtml';
						} else {

							layer.msg(data.msg, { icon: 2 });
						}
					}
				});

			}

		},
		
		getL:function()
		{
			var _self=this;
			_self.$emit('getL');
			//子组件使用$emit触发,父组件在实例中v-on自定义事件监听

		}

	}

});*/

