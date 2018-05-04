$(function(){
	

$("#loginForm").bootstrapValidator({
				message: '该值无效,请重新输入',
				feedbackIcons: { /*输入框不同状态，显示图片的样式*/
						valid: 'glyphicon glyphicon-ok',
						invalid: 'glyphicon glyphicon-remove',
						validating: 'glyphicon glyphicon-refresh'
					},
			    fields: {
				
						username:{
							validators: {
								notEmpty: { /*非空提示*/
									message: '输入用户名不能为空'
								}
						    }
						},
						password: {
							validators: {
								notEmpty: { /*非空提示*/
									message: '输入密码不能为空'
								},
							}
						}

				}
		});
		
});
