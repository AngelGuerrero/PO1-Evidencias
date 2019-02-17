$(document).ready(function(){

    var _class = "animated shake";

    $(".startContainer ul li").hover(function(){
       $(this).addClass(_class);
    });
    $(".startContainer ul li").mouseleave(function(){
        $(this).removeClass(_class);
    });
});
