var error_name = false;
var error_password = false;
var error_check_password = false;
var error_phone = false;
var error_check = false;

//下面是已添加蔬菜或修改蔬菜信息时候用到的判断
var error_goodsName = false;
var error_price = false;
var error_surplus = false;
var error_image = false;
var error_discount = false;
var error_type = false;
var error_address= false;

//页面加载完成后会执行
$(function(){

    // $('#user_name') 是id选择器
    //当元素失去焦点时发生 blur 事件
    $('#user_name').blur(function() {
        check_user_name();
    });

    $('#pwd').blur(function() {
        check_pwd();
    });

    $('#cpwd').blur(function() {
        check_cpwd();
    });

    $('#phone').blur(function() {
        check_phone();
    });

    $('#address').blur(function() {
        check_address();
    });

    $('#allow').click(function() {
        if($(this).is(':checked'))
        {
            error_check = false;
            $(this).siblings('span').hide();
        }
        else
        {
            error_check = true;
            $(this).siblings('span').html('请勾选同意');
            $(this).siblings('span').show();
        }
    });


    //针对蔬菜的功能
    $('#goodsName').blur(function() {
        check_goodsName();
    });

    $('#price').blur(function() {
        check_price();
    });

    $('#surplus').blur(function() {
        check_surplus();
    });

    $('#image').blur(function() {
        check_image();
    });

    $('#type').blur(function() {
        check_type();
    });

    $('#discount').blur(function() {
        check_discount();
    });



    function check_goodsName() {
        var len = $('#goodsName').val().length;
        if(len<1||len>20)
        {
            $('#goodsName').next().html('蔬菜名不能为空')
            $('#goodsName').next().show();
            error_goodsName = true;
        }
        else
        {
            $('#goodsName').next().hide();
            error_goodsName = false;
        }
    }

    function check_price() {
        var price = $('#price').val();
        price = parseFloat(price);
        if(price>0) {
            $('#price').next().hide();
            error_price = false;
        }
        else {
            $('#price').next().html('价格必须大于0')
            $('#price').next().show();
            error_price = true;
        }
    }

    function check_surplus() {
        var surplus = $('#surplus').val();
        surplus = parseFloat(surplus);
        if(surplus>0) {
            $('#surplus').next().hide();
            error_surplus = false;
        }
        else {
            $('#surplus').next().html('余量必须大于0')
            $('#surplus').next().show();
            error_price = true;
        }
    }

    function check_type(){
        var type = $('#type').val()
        if(type.length>0){
            $('#type').next().hide();
            error_type = false;
        }else{
            $('#type').next().html('请选择商品类型')
            $('#type').next().show();
            error_type = true;
        }
    }

    function check_discount(){
        var discount = $('#discount').val();
        discount = parseFloat(discount);
        if(discount<=1.0&&discount>0){
            $('#discount').next().hide();
            error_discount = false;
        }else{
            $('#discount').next().html('0<折扣<=1.0')
            $('#discount').next().show();
            error_discount = true;
        }
    }

    //针对蔬菜的工能-----------------end


    function check_user_name(){
        var len = $('#user_name').val().length;
        if(len<1||len>20)
        {
            $('#user_name').next().html('用户名不能为空')
            $('#user_name').next().show();
            error_name = true;
        }
        else
        {
            $('#user_name').next().hide();
            error_name = false;
        }
    }

    function check_pwd(){
        var len = $('#pwd').val().length;
        if(len<6||len>20)
        {
            $('#pwd').next().html('密码最少6位，最长20位')
            $('#pwd').next().show();
            error_password = true;
        }
        else
        {
            $('#pwd').next().hide();
            error_password = false;
        }
    }

    function check_cpwd(){
        var pass = $('#pwd').val();
        var cpass = $('#cpwd').val();

        if(pass!=cpass)
        {
            $('#cpwd').next().html('两次输入的密码不一致')
            $('#cpwd').next().show();
            error_check_password = true;
        }
        else
        {
            $('#cpwd').next().hide();
            error_check_password = false;
        }

    }

    function check_phone(){
        console.log("在检查电话号码")
        var re = /^1[3456789]\d{9}$/;
        if(re.test($('#phone').val()))
        {
            $('#phone').next().hide();
            error_phone = false;
        }
        else
        {
            $('#phone').next().html('你输入的手机号格式不正确')
            $('#phone').next().show();
            error_phone = true;
        }

    }

    function check_address(){
        console.log("在检查地址")
        var address = $('#address').val();
        if(address)
        {
            $('#address').next().hide();
            error_address = false;
        }
        else
        {
            $('#address').next().html('地址不能为空')
            $('#address').next().show();
            error_address = true;
        }

    }

})


function checkall(){
    if(error_name == false && error_password == false && error_check_password == false && error_phone == false && error_check == false)
    {
        alert("注册成功");
        return true;
    }
    else
    {
        console.log("提交失败")
        return false;
    }
}

//检查是否上传图片
function check_image() {
    var fileFlag = false;
    $("input[name='file']").each(function(){
        if($(this).val()!="") {
            fileFlag = true;
        }
    });
    if(!fileFlag) {
        $('#file').next().attr("class","error_tip");
        $('#file').next().html('未选择图片');
        $('#file').next().show();
        alert("请选择图片!");
        return true
    }
    else{
        $('#file').next().attr("class","error_tip3");
        $('#file').next().html('已选择图片');
        $('#file').next().show();
        return false;
    }
}

function admin_alter_user_checkall(){
    if( error_address == false && error_phone == false)
    {
        alert("修改成功");
        return true;
    }
    else
    {
        console.log("提交失败")
        return false;
    }
}


function admin_alter_goods_checkall(){

    if(error_price == false && error_surplus == false && error_image ==false && error_discount == false)
    {
        return true;
    }
    else
    {
        console.log("提交失败")
        return false;
    }
}

//添加蔬菜时执行
function add_goods_checkall(){
    console.log("in add_vegetable_checkall")
    var temp = check_image();
    if(error_goodsName == false && error_price == false && error_surplus == false && error_image ==false &&
        temp == false && error_type == false && error_discount == false)
    {
        return true;
    }
    else
    {
        console.log("添加失败")
        return false;
    }
}
