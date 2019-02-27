$(document).ready(function(){

    $(function ()
        {
            // 创建一个上传参数变量
            var uploadOption =
                {
                    action: "fileUpload",    // 提交目标

                    name: "images",            // 服务端接收的名称

                    dataType: "json",

                    autoSubmit: true,        // 是否自动提交


                    // 开始上传文件
                    onChange: function (file, extension)
                    {
                    //播放动画
                    //     $("#wait").show();
                        $('#progressbar1').LineProgressbar({
                            percentage : 100,
                            duration : 30000
                        });

                    },

                    // 上传完成之后
                    onComplete: function (file, response)
                    {
                        window.location.reload();
                    }
                };

            // 实例化上传对象
            new AjaxUpload("#upload_button", uploadOption);



        }
    );


})

