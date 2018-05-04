$(function(){
		
			$("#depositstForm").bootstrapValidator({
				message: '该值无效,请重新输入',
				feedbackIcons: { /*输入框不同状态，显示图片的样式*/
						valid: 'glyphicon glyphicon-ok',
						invalid: 'glyphicon glyphicon-remove',
						validating: 'glyphicon glyphicon-refresh'
					},
			    
				fields: {
						deposits: {
							validators: {
								notEmpty: { /*非空提示*/
									message: '输入金额不能为空'
								}
								
								,
								regexp: {
									regexp: /^[1-9]\d*00$/,
									message: '输入的金额只能是100或者100的整数倍'
								}
							}
						}

				}
				
			});
			
			
			$("#withdrawtForm").bootstrapValidator({
				message: '该值无效,请重新输入',
				feedbackIcons: { /*输入框不同状态，显示图片的样式*/
						valid: 'glyphicon glyphicon-ok',
						invalid: 'glyphicon glyphicon-remove',
						validating: 'glyphicon glyphicon-refresh'
					},
			    fields: {
						withdraw: {
							validators: {
								notEmpty: { /*非空提示*/
									message: '输入金额不能为空'
								}
								
								,
								regexp: {
									regexp: /^[1-9]\d*00$/,
									message: '输入的金额只能是100或者100的整数倍'
								}
							}
						}

				}
		});
		
		$("#transfertForm").bootstrapValidator({
				message: '该值无效,请重新输入',
				feedbackIcons: { /*输入框不同状态，显示图片的样式*/
						valid: 'glyphicon glyphicon-ok',
						invalid: 'glyphicon glyphicon-remove',
						validating: 'glyphicon glyphicon-refresh'
					},
			    fields: {
						transfer: {
							validators: {
								notEmpty: { /*非空提示*/
									message: '输入金额不能为空'
								}
								
								,
								regexp: {
									regexp: /^[1-9]\d*00$/,
									message: '输入的金额只能是100或者100的整数倍'
								}
							}
						},
						aId:{
							validators: {
								notEmpty: { /*非空提示*/
									message: '输入卡号不能为空'
								},
								regexp: {
									regexp: /^\d{8}$/,
									message: '卡号必须是8位有效数字'
								}
						}
						}

				}
		});
		
		
		
		
		
		$("#passwordtForm").bootstrapValidator({
				message: '该值无效,请重新输入',
				feedbackIcons: { /*输入框不同状态，显示图片的样式*/
						valid: 'glyphicon glyphicon-ok',
						invalid: 'glyphicon glyphicon-remove',
						validating: 'glyphicon glyphicon-refresh'
					},
			    fields: {	
			    	password: {
							validators: {
								notEmpty: { /*非空提示*/
									message: '输入密码不能为空'
								},
								stringLength:{
									min: 6,
									max: 6,
									message:'密码长度为6位'
								},
								regexp: {
									regexp: /^[0-9]*$/,
									message: '密码只能是数字'
								}
							}
						},
		
						repassword:{
							validators: {
								notEmpty: { /*非空提示*/
									message: '输入密码不能为空'
								},
								stringLength:{
									min:6,
									max:6,
									message:'密码长度为6位'
								},
								identical: {//相同
                            		field: 'password',
                            		message: '两次密码不一致'
                        		},
								regexp: {
									regexp: /^[0-9]*$/,
									message: '密码只能是数字'
								}
						}

						}
						}
		});
	
		

});	
	