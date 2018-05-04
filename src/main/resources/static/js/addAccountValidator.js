$(function(){
	

$("#addAccount").bootstrapValidator({
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
						},
						money:{
							validators: {
								notEmpty: { /*非空提示*/
									message: '输入余额不能为空'
								},
								regexp: {
									regexp: /^[0-9]*$/,
									message: '余额只能是数字'
								}
							}
						},
						creditLevel:{
							validators: {
								notEmpty: { /*非空提示*/
									message: '输入信用等级不能为空'
								},
								regexp: {
									regexp: /^[0-9]*$/,
									message: '信用等级只能是数字'
								}
							}
						},
						integral:{
							validators: {
								notEmpty: { /*非空提示*/
									message: '输入积分不能为空'
								},
								regexp: {
									regexp: /^[0-9]*$/,
									message: '积分只能是数字'
								}
							}
						}

				}
		});
		
		
});
