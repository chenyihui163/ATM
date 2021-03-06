$(function(){
	

$("#loginForm").bootstrapValidator({
				message: '该值无效,请重新输入',
				feedbackIcons: { /*输入框不同状态，显示图片的样式*/
						valid: 'glyphicon glyphicon-ok',
						invalid: 'glyphicon glyphicon-remove',
						validating: 'glyphicon glyphicon-refresh'
					},
			    fields: {
				
						aid:{
							validators: {
								notEmpty: { /*非空提示*/
									message: '输入卡号不能为空'
								},
								regexp: {
									regexp: /^\d{8}$/,
									message: '卡号必须是8位有效数字'
								}
						}
						},
						password: {
							validators: {
								notEmpty: { /*非空提示*/
									message: '输入密码不能为空'
								},
								
								regexp: {
									regexp: /^\d{6}$/,
									message: '密码必须是6位有效数字'
								}
							}
						}

				}
		});
		
$("#registerForm").bootstrapValidator({
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
								regexp: {
									regexp: /^\d{6}$/,
									message: '密码必须是6位有效数字'
								}
							}
						},
						
						repassword:{
							validators: {
								notEmpty: { /*非空提示*/
									message: '输入密码不能为空'
								},
								
								identical: {//相同
                            		field: 'password',
                            		message: '两次密码不一致'
                        		},
                        		regexp: {
									regexp: /^\d{6}$/,
									message: '密码必须是6位有效数字'
								}
						}

						},
						
						Username:{
							validators: {
								notEmpty: { /*非空提示*/
									message: '输入姓名不能为空'
								},
								
								regexp: {
									regexp: /^[\u4e00-\u9fa5]{0,}$/,
									message: '姓名只能是中文'
								}
							}
						},
						Phone:{
							validators: {
								notEmpty: { /*非空提示*/
									message: '手机号不能为空'
								},
								
								regexp: {
									regexp: /^((1[3,5,8][0-9])|(14[5,7])|(17[0,6,7,8])|(19[7]))\d{8}$/,
									message: '输入格式不正确'
								}
							}
						},
						Identity_card:{
							validators: {
								notEmpty: { /*非空提示*/
									message: '身份证号不能为空'
								},
								
								regexp: {
									regexp: /^\d{15}|\d{18}$/,
									message: '输入格式不正确'
								}
							}
						},
						Address: {
							validators: {
								notEmpty: { /*非空提示*/
									message: '输入地址不能为空'
								},
								stringLength:{
									min: 6,
									max: 20,
									message:'地址不能超过20个字符，且不能少于6个字符'
								}
							}
						}
					

				}
		});
		
});
